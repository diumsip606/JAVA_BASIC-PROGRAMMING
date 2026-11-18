/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tugas3_INTEGRASI_DAN_STUDIKASUS;
import java.io.*;
import java.util.*;
/**
 *
 * @author Gaudium
 */
public class CsvProcessor_ModifSulit {
     // CsvData: kelas kecil (inner class) sebagai WADAH hasil baca CSV.
    // 'static class' di dalam CsvProcessor agar bisa dipakai tanpa objek CsvProcessor.
    // Menyimpan: header (nama kolom) dan rows (semua baris data).
    // Setiap baris berupa String[] (satu elemen = satu sel).
    static class CsvData {
        String[] header;                          // contoh: [Name, Age, GPA, Major]
        List<String[]> rows = new ArrayList<>();  // daftar baris data
    }

    
    // Program Running disini
    public static void main(String[] args) {
        // Jika program dijalankan dengan argumen (java CsvProcessor file.csv),
        // pakai file itu. Jika tidak, pakai "students.csv" (dibuat otomatis).
        String csvFile = (args.length > 0) ? args[0] : "students.csv";
        String summaryFile = "csv_summary.txt";

        if (args.length == 0) {
            createSampleCsv(csvFile);             // buat data contoh
        }

        CsvData data = readCsv(csvFile);          // 1) baca & parse CSV
        if (data == null) return;                 // gagal baca -> hentikan program
        String report = buildSummary(data);       // 2) hitung statistik
        writeReport(summaryFile, report);         // 3) simpan ke file
        System.out.println(report);               // 4) tampilkan ke layar
    }


    // createSampleCsv
    // Tujuan: membuat CSV contoh. Sengaja memuat DATA KOTOR (sel kosong dan
    //         usia "abc") untuk menguji bahwa program tidak crash.
    public static void createSampleCsv(String filename) {
        String[] lines = {
            "Name,Age,GPA,Major",                 // baris pertama = header
            "Alice,25,3.8,Computer Science",
            "Bob,30,3.2,Mathematics",
            "Charlie,22,3.5,Physics",
            "Diana,28,3.9,Chemistry",
            "Eka,24,,Computer Science",           // GPA kosong  -> missing
            "Farhan,abc,3.1,Mathematics"          // Age "abc"   -> invalid
        };
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filename))) {
            for (String l : lines) {
                writer.write(l);
                writer.newLine();
            }
            System.out.println("Sample CSV created: " + filename + "\n");
        } catch (IOException e) {
            System.out.println("Error creating CSV: " + e.getMessage());
        }
    }

    // readCsv
    // Tujuan : membaca file CSV menjadi objek CsvData.
    //          Baris pertama = header, baris berikutnya = data.
    // Return : CsvData, atau null jika gagal (file tidak ada / kosong / error).
    public static CsvData readCsv(String filename) {
        CsvData data = new CsvData();
        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {

            // Baca baris pertama sebagai header. Jika null berarti file KOSONG.
            String line = reader.readLine();
            if (line == null) {
                System.out.println("File CSV kosong.");
                return null;
            }

            // split(",", -1): angka -1 berarti "pertahankan sel kosong di ujung baris".
            // Tanpa -1, "Eka,24,,CS" tetap aman, tetapi "Eka,24,3.5," akan kehilangan
            // sel kosong terakhir sehingga jumlah kolom salah.
            data.header = line.split(",", -1);

            int lineNumber = 1;   // header = baris 1
            while ((line = reader.readLine()) != null) {
                lineNumber++;

                // Lewati baris kosong (hanya spasi atau enter)
                if (line.trim().isEmpty()) continue;

                String[] fields = line.split(",", -1);

                // Validasi: jumlah kolom harus SAMA dengan header, jika tidak baris
                // dianggap rusak dan dilewati (agar index tidak error nanti).
                if (fields.length != data.header.length) {
                    System.out.println("Baris " + lineNumber + " dilewati (jumlah kolom tidak cocok)");
                    continue;
                }
                data.rows.add(fields);   // simpan baris valid
            }
        } catch (FileNotFoundException e) {      // subclass dulu: file tidak ada
            System.out.println("File tidak ditemukan: " + e.getMessage());
            return null;
        } catch (IOException e) {                // error I/O umum
            System.out.println("Error membaca CSV: " + e.getMessage());
            return null;
        }
        return data;
    }

    
    // buildSummary
    // Tujuan : menyusun teks laporan untuk SEMUA kolom.
    // Cara   : untuk setiap kolom, kumpulkan semua nilainya ke satu List,
    //          lalu serahkan ke analyzeColumn.
    // Return : teks laporan lengkap (String).
    public static String buildSummary(CsvData data) {
        // StringBuilder dipakai karena kita menambah teks berkali-kali (lebih efisien dari String +)
        StringBuilder sb = new StringBuilder();
        sb.append("=== CSV SUMMARY STATISTICS ===\n");
        sb.append("Rows: ").append(data.rows.size())
          .append(", Columns: ").append(data.header.length).append("\n");

        // Loop per KOLOM (col = nomor kolom: 0, 1, 2, ...)
        for (int col = 0; col < data.header.length; col++) {
            List<String> values = new ArrayList<>();

            // Loop per BARIS: ambil sel pada kolom ke-col dari setiap baris.
            // trim() membuang spasi tepi sel.
            for (String[] row : data.rows) {
                values.add(row[col].trim());
            }
            analyzeColumn(data.header[col].trim(), values, sb);
        }
        return sb.toString();
    }


    // analyzeColumn
    // Tujuan   : memutuskan sebuah kolom itu ANGKA atau TEKS, lalu memanggil
    //            penghitung statistik yang sesuai.
    // Parameter: name   = nama kolom
    //            values = semua isi kolom (dalam bentuk teks)
    //            sb     = tempat menulis hasil
    public static void analyzeColumn(String name, List<String> values, StringBuilder sb) {
        List<Double> numbers = new ArrayList<>();   // nilai yang berhasil jadi angka
        int missing = 0;     // jumlah sel kosong
        int invalid = 0;     // jumlah sel terisi tapi bukan angka
        int nonEmpty = 0;    // jumlah sel yang terisi

        for (String v : values) {
            if (v.isEmpty()) {          // sel kosong -> missing
                missing++;
                continue;               // lanjut ke sel berikutnya
            }
            nonEmpty++;
            try {
                // Coba ubah ke angka desimal. "25" jadi 25.0, "3.8" jadi 3.8.
                // Jika bukan angka (mis. "abc"), terjadi NumberFormatException.
                numbers.add(Double.parseDouble(v));
            } catch (NumberFormatException e) {
                invalid++;              // catat sebagai invalid, program tetap lanjut
            }
        }

        sb.append("\n[").append(name).append("] ");

        // ATURAN penentuan jenis kolom:
        // kolom = ANGKA jika ada angka dan JUMLAH ANGKA lebih dari separuh isi terisi.
        // Contoh Age: 5 angka dari 6 terisi -> 5 > 3.0 -> numerik (1 "abc" jadi invalid).
        // Contoh Name: 0 angka -> teks.
        // nonEmpty / 2.0 memakai 2.0 (double) supaya tidak dibulatkan.
        boolean numeric = !numbers.isEmpty() && numbers.size() > nonEmpty / 2.0;

        if (numeric) {
            sb.append("(numeric)\n");
            appendNumericStats(numbers, missing, invalid, sb);
        } else {
            sb.append("(categorical)\n");
            appendCategoricalStats(values, missing, sb);
        }
    }

 
    // appendNumericStats
    // Tujuan : menghitung statistik untuk kolom ANGKA.
    private static void appendNumericStats(List<Double> nums, int missing, int invalid, StringBuilder sb) {
        int n = nums.size();    // banyaknya angka valid

        // SUM, MIN, MAX dihitung dalam satu loop.
        // min diawali nilai terbesar yang mungkin, max diawali nilai terkecil,
        // supaya angka pertama pasti menggantikannya.
        double sum = 0, min = Double.MAX_VALUE, max = -Double.MAX_VALUE;
        for (double x : nums) {
            sum += x;
            if (x < min) min = x;
            if (x > max) max = x;
        }

        // MEAN (rata-rata) = jumlah / banyak data
        double mean = sum / n;

        // MEDIAN = nilai tengah setelah diurutkan.
        // Salin dulu ke list baru (sorted) supaya list asli tidak berubah.
        List<Double> sorted = new ArrayList<>(nums);
        Collections.sort(sorted);
        // n ganjil: ambil elemen tengah (indeks n/2).
        // n genap : rata-rata dua elemen tengah (indeks n/2-1 dan n/2).
        double median = (n % 2 == 1)
                ? sorted.get(n / 2)
                : (sorted.get(n / 2 - 1) + sorted.get(n / 2)) / 2.0;

        // STANDAR DEVIASI SAMPEL = akar( jumlah (x - mean)^2 / (n - 1) )
        // Mengukur seberapa menyebar data dari rata-ratanya.
        // Jika n = 1, tidak bisa dihitung (pembagi n-1 = 0) sehingga dibiarkan 0.
        double std = 0;
        if (n > 1) {
            double sq = 0;                             // jumlah kuadrat selisih
            for (double x : nums) sq += (x - mean) * (x - mean);
            std = Math.sqrt(sq / (n - 1));
        }

        // String.format: %d = bilangan bulat, %.2f = desimal 2 digit,
        // %n = pindah baris (sesuai OS). Spasi pada label hanya untuk perataan.
        sb.append(String.format("  Count   : %d (missing: %d, invalid: %d)%n", n, missing, invalid));
        sb.append(String.format("  Sum     : %.2f%n", sum));
        sb.append(String.format("  Mean    : %.2f%n", mean));
        sb.append(String.format("  Min     : %.2f%n", min));
        sb.append(String.format("  Max     : %.2f%n", max));
        sb.append(String.format("  Median  : %.2f%n", median));
        sb.append(String.format("  Std Dev : %.2f%n", std));
    }

 
    // appendCategoricalStats
    // Tujuan : statistik untuk kolom TEKS: jumlah terisi, nilai unik, nilai terbanyak.
    // Memakai HashMap (nilai -> jumlah) seperti frekuensi karakter di TextProcessor.
    private static void appendCategoricalStats(List<String> values, int missing, StringBuilder sb) {
        Map<String, Integer> freq = new HashMap<>();
        for (String v : values) {
            if (!v.isEmpty()) {   // sel kosong tidak dihitung
                freq.put(v, freq.getOrDefault(v, 0) + 1);
            }
        }

        // Cari nilai dengan jumlah terbanyak (modus).
        String topValue = "-";
        int topCount = 0;
        for (Map.Entry<String, Integer> e : freq.entrySet()) {
            // Ganti "juara" jika jumlahnya lebih besar. Jika SERI, pilih yang abjadnya
            // lebih awal agar hasil selalu konsisten (HashMap tidak punya urutan tetap).
            if (e.getValue() > topCount
                    || (e.getValue() == topCount && e.getKey().compareTo(topValue) < 0)) {
                topValue = e.getKey();
                topCount = e.getValue();
            }
        }

        // values.size() - missing = jumlah sel terisi; freq.size() = jumlah nilai UNIK
        sb.append(String.format("  Count   : %d (missing: %d)%n", values.size() - missing, missing));
        sb.append(String.format("  Unique  : %d%n", freq.size()));
        sb.append(String.format("  Top     : %s (%dx)%n", topValue, topCount));
    }


    // writeReport
    // Tujuan : menyimpan teks laporan ke sebuah file.
    public static void writeReport(String filename, String report) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filename))) {
            writer.write(report);
        } catch (IOException e) {
            System.out.println("Error menulis summary: " + e.getMessage());
        }
    }   
}
