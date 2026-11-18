/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tugas2_File_IO_Example;

import java.util.*;
import java.io.*;

public class FileIOExample {
    //   Urutan kerja:
    //   tulis data.txt -> baca data.txt -> proses ke output.txt
    public static void main(String[] args) {
        String inputFile = "data.txt";     // file sumber
        String outputFile = "output.txt";  // file hasil proses

        // 1. Tulis data awal ke data.txt
        writeToFile(inputFile);

        // 2. Baca dan tampilkan isi data.txt
        readFromFile(inputFile);

        // 3. Proses data.txt dan simpan hasilnya ke output.txt
        processFile(inputFile, outputFile);
    }

    
    // 1. writeToFile
    // Tujuan   : MENULIS 4 baris data mahasiswa ke sebuah file.
    // Parameter: filename = nama file tujuan.
    // Format tiap baris: nama,usia,jurusan (dipisah koma / format CSV).

    public static void writeToFile(String filename) {
        // try-with-resources: resource yang dibuka di dalam tanda kurung ( )
        // akan OTOMATIS di-close() saat blok selesai (normal maupun error).
        // new FileWriter(filename) membuka file untuk ditulis. Jika file sudah
        // ada, isinya DITIMPA (mode overwrite). BufferedWriter membungkusnya
        // agar penulisan lebih cepat.
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filename))) {

            // write(teks): menulis teks ke buffer (belum tentu langsung ke disk).
            // newLine()  : menulis pemisah baris, agar data berikutnya di baris baru.
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
            // Dijalankan jika terjadi error I/O (mis. disk penuh / tidak ada izin tulis).
            // e.getMessage() = keterangan error dalam bentuk teks.
            System.out.println("Error writing file: " + e.getMessage());
        }
    }


    // 2. readFromFile
    // Tujuan   : MEMBACA file baris demi baris dan menampilkannya ke layar
    //            lengkap dengan nomor baris.
    // Parameter: filename = nama file yang dibaca.
    
    public static void readFromFile(String filename) {
        System.out.println("\n=== MEMBACA FILE ===");

        // new FileReader(filename) membuka file untuk dibaca. Jika file TIDAK ADA
        // akan melempar FileNotFoundException. BufferedReader membungkusnya
        // agar bisa memakai readLine().
        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            String line;            // menampung isi satu baris
            int lineNumber = 1;     // penomoran baris, mulai dari 1

            // readLine() membaca SATU baris (tanpa karakter enter di ujungnya).
            // Jika file sudah HABIS, readLine() mengembalikan null.
            // Jadi: baca satu baris -> simpan ke 'line' -> cek apakah bukan null
            // -> kalau bukan null, ulangi. Ini pola standar membaca file.
            while ((line = reader.readLine()) != null) {
                System.out.println("Line " + lineNumber + ": " + line);
                lineNumber++;       // naik ke nomor baris berikutnya
            }

            System.out.println("File berhasil dibaca");

        } catch (FileNotFoundException e) {
            // Error KHUSUS: file tidak ditemukan.
            // Harus ditulis SEBELUM catch IOException (lihat Jawaban 2).
            System.out.println("File tidak ditemukan: " + e.getMessage());
        } catch (IOException e) {
            // Error I/O umum lainnya saat membaca.
            System.out.println("Error reading file: " + e.getMessage());
        }
    }


    // 3. processFile
    // Tujuan   : MEMBACA inputFile, mengolah tiap baris, lalu MENULIS hasilnya
    //            ke outputFile. Pengolahan:
    //              - nama diubah ke HURUF BESAR
    //              - ditambah kolom STATUS: usia > 25 = GRADUATE,
    //                selain itu UNDERGRADUATE
    // Parameter: inputFile = file sumber, outputFile = file hasil.

    public static void processFile(String inputFile, String outputFile) {
        System.out.println("\n=== MEMPROSES FILE ===");

        // Dua resource sekaligus, dipisah titik koma. Keduanya otomatis di-close.
        // reader membaca file sumber, writer menulis file hasil.
        try (BufferedReader reader = new BufferedReader(new FileReader(inputFile));
             BufferedWriter writer = new BufferedWriter(new FileWriter(outputFile))) {

            String line;

            // Tulis baris judul (header) kolom di baris pertama file hasil.
            writer.write("NAME,AGE,MAJOR,STATUS");
            writer.newLine();

            // Ulangi sampai semua baris sumber habis dibaca.
            while ((line = reader.readLine()) != null) {

                // split(","): memecah baris "Alice,25,Computer Science" menjadi array:
                //   data[0] = "Alice", data[1] = "25", data[2] = "Computer Science"
                String[] data = line.split(",");

                // trim()        : buang spasi tepi (jaga-jaga ada spasi tersisa)
                // toUpperCase() : jadikan huruf besar -> "ALICE"
                String name = data[0].trim().toUpperCase();

                // Integer.parseInt(): mengubah teks "25" menjadi angka 25 (int).
                // PERHATIAN: jika teksnya bukan angka (mis. "abc"), akan melempar
                // NumberFormatException. Di versi ini belum ditangani,
                // penanganannya ada di file Modifikasi.
                int age = Integer.parseInt(data[1].trim());

                String major = data[2].trim();

                // Operator ternary: (kondisi) ? nilaiJikaTrue : nilaiJikaFalse
                // Artinya: jika age > 25 maka "GRADUATE", jika tidak "UNDERGRADUATE".
                String status = (age > 25) ? "GRADUATE" : "UNDERGRADUATE";

                // String.format: menyusun teks dengan penampung (placeholder):
                //   %s = String, %d = bilangan bulat (int)
                String processedLine = String.format("%s,%d,%s,%s", name, age, major, status);

                // Tulis baris hasil olahan ke file output, lalu tampilkan ke layar.
                writer.write(processedLine);
                writer.newLine();
                System.out.println("Processed: " + processedLine);
            }

            System.out.println("File berhasil diproses dan disimpan sebagai " + outputFile);

        } catch (IOException e) {
            System.out.println("Error processing file: " + e.getMessage());
        }
    }

    /*
     PERTANYAAN PRAKTIKUM

       1. Apa keuntungan menggunakan try-with-resources?
          Resource (reader/writer) otomatis ditutup dengan close() saat blok
          selesai, baik berjalan normal maupun terjadi error. Keuntungannya:
          - Tidak perlu menulis blok finally untuk menutup resource secara manual.
          - Kode lebih singkat dan rapi.
          - Mencegah kebocoran resource (file tetap terkunci) dan data buffer
            yang belum tertulis ke disk karena lupa close().
     
       2. Mengapa FileNotFoundException dan IOException ditangani terpisah?
          FileNotFoundException adalah SUBCLASS dari IOException. Dengan
          memisahkannya kita bisa memberi penanganan/pesan yang SPESIFIK
          (mis. "file tidak ditemukan, periksa nama file") dan pesan umum untuk
          masalah I/O lain (disk penuh, tidak ada izin, dll.).
          Urutan WAJIB: subclass dulu, baru superclass. Jika dibalik (IOException            dulu), compile error karena catch FileNotFoundException tidak akan
          pernah tercapai (sudah tertangkap oleh IOException).
     
       3. Apa yang terjadi jika file data.txt sudah ada saat writeToFile dipanggil?
          new FileWriter(filename) tanpa parameter tambahan memakai mode
          OVERWRITE: isi lama dihapus dan diganti isi baru. Agar data lama tidak
          hilang, gunakan mode APPEND: new FileWriter(filename, true).
     */
}