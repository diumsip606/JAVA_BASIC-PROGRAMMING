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
public class TextProcessor {
 public static void main(String[] args) {
        String sourceFile = "source_tugas3.txt";        // file teks sumber
        String processedFile = "processed_tugas3.txt";  // hasil versi huruf besar
        String reportFile = "report_tugas3.txt";        // laporan statistik

        // Langkah 1: buat file sumber contoh
        createSampleFile(sourceFile);

        // Langkah 2: proses file (uppercase + statistik)
        processTextFile(sourceFile, processedFile, reportFile);

        // Langkah 3: tampilkan laporan ke layar
        displayReport(reportFile);
    }

    // ============================================================
    // createSampleFile
    // ------------------------------------------------------------
    // Tujuan   : membuat file contoh berisi 5 baris kalimat.
    // Parameter: filename = nama file yang dibuat.
    // ============================================================
    public static void createSampleFile(String filename) {
        // Array berisi 5 kalimat yang akan ditulis ke file
        String[] sampleText = {
            "Java programming is fun and powerful.",
            "Streams and Files are important concepts.",
            "Exception handling makes code robust.",
            "String manipulation is frequently used.",
            "Practice makes perfect in programming."
        };

        // try-with-resources: writer otomatis di-close
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filename))) {
            // for-each: ambil tiap kalimat, tulis, lalu pindah baris
            for (String line : sampleText) {
                writer.write(line);
                writer.newLine();
            }
            System.out.println("Sample file created: " + filename);
        } catch (IOException e) {
            System.out.println("Error creating sample file: " + e.getMessage());
        }
    }

    // ============================================================
    // processTextFile  (METHOD UTAMA)
    // ------------------------------------------------------------
    // Tujuan   : membaca inputFile, lalu sekaligus:
    //            (a) menulis versi UPPERCASE ke outputFile
    //            (b) menghitung statistik dan menulis laporan ke reportFile
    // Parameter: inputFile  = file sumber
    //            outputFile = file hasil uppercase
    //            reportFile = file laporan statistik
    // ============================================================
    public static void processTextFile(String inputFile, String outputFile, String reportFile) {

        // Tiga resource dibuka sekaligus (1 reader, 2 writer); semuanya otomatis di-close.
        try (BufferedReader reader = new BufferedReader(new FileReader(inputFile));
             BufferedWriter writer = new BufferedWriter(new FileWriter(outputFile));
             BufferedWriter reportWriter = new BufferedWriter(new FileWriter(reportFile))) {

            String line;
            int totalLines = 0;    // penghitung jumlah baris
            int totalWords = 0;    // penghitung jumlah kata
            int totalChars = 0;    // penghitung jumlah karakter (termasuk spasi & titik)

            // HashMap: menyimpan pasangan (huruf -> jumlah kemunculannya).
            // Key = Character (hurufnya), Value = Integer (berapa kali muncul).
            Map<Character, Integer> charFrequency = new HashMap<>();

            // Loop membaca file baris demi baris sampai habis (readLine() == null)
            while ((line = reader.readLine()) != null) {
                totalLines++;      // setiap baris terbaca, tambah 1

                // ---------- (a) Tulis versi huruf besar ----------
                String processedLine = line.toUpperCase();
                writer.write(processedLine);
                writer.newLine();

                // ---------- (b) Hitung statistik ----------

                // Hitung kata. trim() membuang spasi tepi; jika baris tidak kosong,
                // split("\\s+") memecah di satu atau lebih spasi/tab, lalu jumlah
                // elemen array = jumlah kata di baris itu.
                // Pengecekan isEmpty() penting: baris kosong jika di-split akan
                // menghasilkan 1 elemen "" sehingga terhitung 1 kata (salah).
                String trimmed = line.trim();
                if (!trimmed.isEmpty()) {
                    String[] words = trimmed.split("\\s+");
                    totalWords += words.length;
                }

                // Hitung karakter: length() = semua karakter di baris, termasuk spasi
                // dan tanda baca. (Karakter enter tidak ikut, karena readLine() membuangnya.)
                totalChars += line.length();

                // Hitung frekuensi huruf.
                // toLowerCase() dulu agar 'J' dan 'j' dihitung sebagai huruf yang sama.
                // toCharArray() memecah baris jadi array karakter agar bisa dicek satu per satu.
                for (char c : line.toLowerCase().toCharArray()) {

                    // Character.isLetter(c): true jika c adalah HURUF (a-z).
                    // Spasi, titik, dan angka diabaikan.
                    if (Character.isLetter(c)) {
                        // getOrDefault(c, 0): ambil hitungan lama huruf c; kalau belum
                        // pernah ada, pakai 0. Lalu +1 dan simpan lagi dengan put().
                        charFrequency.put(c, charFrequency.getOrDefault(c, 0) + 1);
                    }
                }
            }

            // ---------- Tulis laporan ke report.txt ----------
            reportWriter.write("=== TEXT PROCESSING REPORT ===");
            reportWriter.newLine();
            reportWriter.write("Total Lines: " + totalLines);
            reportWriter.newLine();
            reportWriter.write("Total Words: " + totalWords);
            reportWriter.newLine();
            reportWriter.write("Total Characters: " + totalChars);
            reportWriter.newLine();

            // Rata-rata kata per baris. (double) dipasang SEBELUM pembagian agar hasilnya
            // pecahan (mis. 5.4), bukan dibulatkan. Cek totalLines == 0 mencegah
            // pembagian dengan nol bila file kosong.
            double avgWords = (totalLines == 0) ? 0 : (double) totalWords / totalLines;
            reportWriter.write("Average Words per Line: " + avgWords);
            reportWriter.newLine();
            reportWriter.newLine();

            reportWriter.write("CHARACTER FREQUENCY:");
            reportWriter.newLine();

            // HashMap TIDAK menyimpan urutan, jadi untuk mengurutkan kita ubah dulu
            // isinya (entrySet) menjadi List yang bisa di-sort.
            // Setiap elemen berupa Map.Entry = satu pasangan (huruf, jumlah).
            List<Map.Entry<Character, Integer>> sortedChars = new ArrayList<>(charFrequency.entrySet());

            // sort dengan lambda (a, b): bandingkan dua pasangan.
            //  - b.getValue().compareTo(a.getValue()) => urut dari jumlah TERBANYAK ke sedikit
            //    (a dan b dibalik agar menurun).
            //  - jika jumlah sama (cmp == 0), urutkan berdasarkan abjad agar hasil konsisten.
            sortedChars.sort((a, b) -> {
                int cmp = b.getValue().compareTo(a.getValue());
                return (cmp != 0) ? cmp : a.getKey().compareTo(b.getKey());
            });

            // Tulis tiap huruf dan jumlahnya, dari yang paling sering
            for (Map.Entry<Character, Integer> entry : sortedChars) {
                reportWriter.write(entry.getKey() + ": " + entry.getValue());
                reportWriter.newLine();
            }

            System.out.println("File processing completed!");
            System.out.println("  - Input: " + inputFile);
            System.out.println("  - Output: " + outputFile);
            System.out.println("  - Report: " + reportFile);

        } catch (IOException e) {
            System.out.println("Error processing files: " + e.getMessage());
        }
    }

    // ============================================================
    // displayReport
    // ------------------------------------------------------------
    // Tujuan   : membaca file laporan lalu mencetak isinya ke layar.
    // Parameter: reportFile = file laporan yang ditampilkan.
    // ============================================================
    public static void displayReport(String reportFile) {
        System.out.println("\n=== PROCESSING REPORT ===");
        try (BufferedReader reader = new BufferedReader(new FileReader(reportFile))) {
            String line;
            // Pola baca file standar: baca satu baris, cetak, ulangi sampai null
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            System.out.println("Error reading report: " + e.getMessage());
        }
    }

    /*
     * ============================================================
     * PERTANYAAN PRAKTIKUM
     * ============================================================
     *
     * PERTANYAAN 1:
     *   Jelaskan cara kerja HashMap untuk menghitung frekuensi karakter.
     *
     * JAWABAN 1:
     *   HashMap menyimpan pasangan key-value; di sini Character (huruf) ->
     *   Integer (jumlah kemunculan). Untuk setiap huruf yang dibaca:
     *     charFrequency.put(c, charFrequency.getOrDefault(c, 0) + 1);
     *   - getOrDefault(c, 0) mengambil hitungan lama huruf c, atau 0 jika
     *     huruf itu belum pernah muncul.
     *   - ditambah 1, lalu put() menyimpan kembali (menimpa nilai lama).
     *   Key bersifat UNIK, sehingga satu huruf selalu hanya punya satu entri
     *   dan hitungannya terus bertambah. HashMap memakai hash untuk mencari
     *   key sehingga akses rata-rata sangat cepat (O(1)).
     *
     * PERTANYAAN 2:
     *   Mengapa memakai split("\\s+") dan bukan split(" ")?
     *
     * JAWABAN 2:
     *   split(" ") memecah di SETIAP satu spasi. Jika ada spasi ganda,
     *   muncul elemen kosong ("") yang ikut terhitung sebagai kata, dan
     *   tab / newline tidak ikut dipecah.
     *   "\\s+" adalah regular expression: \s = karakter spasi apa pun
     *   (spasi, tab, newline) dan + = satu atau lebih berturut-turut.
     *   Jadi spasi ganda dianggap satu pemisah dan jumlah kata menjadi akurat.
     *   (Di kode ditulis "\\s+" dengan dua backslash karena satu backslash
     *   di dalam String Java adalah karakter escape.)
     *
     * PERTANYAAN 3:
     *   Apa keuntungan memakai BufferedReader dan BufferedWriter?
     *
     * JAWABAN 3:
     *   Data dibaca/ditulis lewat BUFFER (penampung di memori), tidak per
     *   karakter langsung ke disk. Jumlah operasi akses disk jauh berkurang
     *   sehingga LEBIH CEPAT. Selain itu menyediakan method praktis:
     *   readLine() untuk membaca satu baris penuh dan newLine() untuk
     *   pemisah baris yang sesuai sistem operasi.
     */
}
