/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tugas2_File_IO_Example;
import java.io.*;
/**
 *
 * @author Gaudium
 */
public class FileIOExampleModifikasi {
    public static void main(String[] args) {
        String inputFile = "data_ModifDua.txt";
        String outputFile = "output_ModifDua.txt";

        writeToFile(inputFile);              // siapkan data awal (4 data valid)
        readFromFile(inputFile);             // tampilkan isinya
        processFile(inputFile, outputFile);  // proses (semua data valid)

        // MODIFIKASI 2: hitung rata-rata usia dari file
        System.out.println("Rata-rata usia: " + calculateAverageAge(inputFile));

        // MODIFIKASI 3: tambah 2 data baru TANPA menghapus data lama
        System.out.println("\n=== APPEND DATA ===");
        appendToFile(inputFile, "Eka,26,Biology");       // data valid
        appendToFile(inputFile, "Farhan,abc,History");   // data TIDAK valid (usia "abc")
        readFromFile(inputFile);                         // 4 data lama + 2 data baru

        // MODIFIKASI 1 diuji di sini: baris "Farhan" harus DILEWATI, bukan membuat program crash
        processFile(inputFile, outputFile);
        System.out.println("Rata-rata usia (setelah append): " + calculateAverageAge(inputFile));
    }

    // writeToFile: menulis 4 data awal ke file (mode overwrite).
    // Sama dengan praktikum; penjelasan lengkap ada di file pertama.
    public static void writeToFile(String filename) {
        // try-with-resources: writer otomatis di-close
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filename))) {
            writer.write("Alice,25,Computer Science");
            writer.newLine();
            writer.write("Bob,30,Mathematics");
            writer.newLine();
            writer.write("Charlie,22,Physics");
            writer.newLine();
            writer.write("Diana,28,Chemistry");
            writer.newLine();
            System.out.println("Data berhasil ditulis ke " + filename);
        } catch (IOException e) {
            System.out.println("Error writing file: " + e.getMessage());
        }
    }


    // readFromFile: membaca file dan menampilkan tiap baris + nomornya.
    public static void readFromFile(String filename) {
        System.out.println("\n=== MEMBACA FILE ===");
        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            String line;
            int lineNumber = 1;
            while ((line = reader.readLine()) != null) {   // null = file habis
                System.out.println("Line " + lineNumber + ": " + line);
                lineNumber++;
            }
            System.out.println("File berhasil dibaca");
        } catch (FileNotFoundException e) {                // subclass dulu
            System.out.println("File tidak ditemukan: " + e.getMessage());
        } catch (IOException e) {                          // baru superclass
            System.out.println("Error reading file: " + e.getMessage());
        }
    }


    // MODIFIKASI 1: processFile dengan penanganan NumberFormatException
    // ------------------------------------------------------------
    // Masalah di versi praktikum: jika usia bukan angka (mis. "abc"), parseInt
    // melempar NumberFormatException dan SELURUH proses berhenti.
    // Solusi: bungkus pemrosesan SETIAP BARIS dengan try-catch sendiri
    // (di DALAM while). Jika satu baris rusak, baris itu dilewati
    // dan baris berikutnya tetap diproses.

    public static void processFile(String inputFile, String outputFile) {
        System.out.println("\n=== MEMPROSES FILE ===");
        try (BufferedReader reader = new BufferedReader(new FileReader(inputFile));
             BufferedWriter writer = new BufferedWriter(new FileWriter(outputFile))) {

            String line;
            int lineNumber = 0;                    // untuk melaporkan baris mana yang bermasalah

            writer.write("NAME,AGE,MAJOR,STATUS"); // header
            writer.newLine();

            while ((line = reader.readLine()) != null) {
                lineNumber++;

                // try-catch PER BARIS (kunci modifikasi 1)
                try {
                    String[] data = line.split(",");

                    // Validasi: baris harus punya minimal 3 kolom. Jika kurang,
                    // data[1] / data[2] akan error (ArrayIndexOutOfBounds).
                    // 'continue' = lewati sisa kode, lanjut ke baris berikutnya.
                    if (data.length < 3) {
                        System.out.println("Baris " + lineNumber + " dilewati (kolom kurang): " + line);
                        continue;
                    }

                    String name = data[0].trim().toUpperCase();

                    // Baris yang berpotensi error. Jika "abc", lompat ke catch di bawah
                    // dan baris di bawahnya (menulis ke file) TIDAK dijalankan.
                    int age = Integer.parseInt(data[1].trim());

                    String major = data[2].trim();
                    String status = (age > 25) ? "GRADUATE" : "UNDERGRADUATE";

                    String processedLine = String.format("%s,%d,%s,%s", name, age, major, status);
                    writer.write(processedLine);
                    writer.newLine();
                    System.out.println("Processed: " + processedLine);

                } catch (NumberFormatException e) {
                    // Usia bukan angka: tampilkan peringatan lalu lanjut ke baris berikutnya.
                    // Karena catch ini ada di DALAM while, loop tidak berhenti.
                    System.out.println("Baris " + lineNumber + " dilewati (usia bukan angka): " + e.getMessage());
                }
            }

            System.out.println("File berhasil diproses dan disimpan sebagai " + outputFile);

        } catch (IOException e) {
            // catch luar: untuk error I/O (file/disk), bukan error data
            System.out.println("Error processing file: " + e.getMessage());
        }
    }

    
    // MODIFIKASI 2: calculateAverageAge
    // ------------------------------------------------------------
    // Tujuan   : membaca file dan menghitung RATA-RATA usia semua data valid.
    // Parameter: filename = file yang dibaca.
    // Return   : rata-rata usia (double). Jika tidak ada data valid, return 0.
    // Rumus    : rata-rata = total usia / jumlah data valid
    public static double calculateAverageAge(String filename) {
        int total = 0;   // penjumlah seluruh usia
        int count = 0;   // banyaknya data yang valid (pembagi)

        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] data = line.split(",");

                // Lewati baris yang kolomnya kurang dari 3
                if (data.length < 3) continue;

                try {
                    total += Integer.parseInt(data[1].trim());  // tambahkan usia ke total
                    count++;                                    // hitung hanya jika parse BERHASIL
                } catch (NumberFormatException e) {
                    // Usia tidak valid: abaikan baris ini. Karena count++ berada SETELAH
                    // parseInt, baris rusak tidak ikut mempengaruhi pembagi.
                }
            }
        } catch (IOException e) {
            System.out.println("Error menghitung rata-rata: " + e.getMessage());
            return 0;
        }

        // (double) total: ubah ke double SEBELUM dibagi agar hasilnya pecahan.
        // Jika tidak, int dibagi int akan dibulatkan ke bawah (mis. 105/4 = 26, bukan 26.25).
        // Pengecekan count == 0 mencegah pembagian dengan nol.
        return (count == 0) ? 0 : (double) total / count;
    }

    // MODIFIKASI 3: appendToFile
    // ------------------------------------------------------------
    // Tujuan   : MENAMBAH satu baris ke AKHIR file tanpa menghapus isi lama.
    // Parameter: filename = file tujuan, newLine = teks baris yang ditambahkan.
    // Kuncinya : parameter kedua FileWriter = true  -> mode APPEND.
    //            (tanpa true = mode overwrite, isi lama hilang)
    public static void appendToFile(String filename, String newLine) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filename, true))) {
            writer.write(newLine);   // tulis di akhir file
            writer.newLine();        // pindah baris agar data berikutnya tidak menempel
            System.out.println("Data ditambahkan: " + newLine);
        } catch (IOException e) {
            System.out.println("Error appending file: " + e.getMessage());
        }
    } 
}
