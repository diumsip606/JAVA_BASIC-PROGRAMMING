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
public class TextProcessorModifikasi {
        public static void main(String[] args) {
        String sourceFile = "source_ModifTugas3.txt";
        String processedFile = "processed_ModifTugas3.txt";
        String reportFile = "report_ModifTugas3.txt";

        createSampleFile(sourceFile);
        processTextFile(sourceFile, processedFile, reportFile);
        displayReport(reportFile);
    }

    // createSampleFile: membuat file contoh 5 baris (sama dengan praktikum)
    public static void createSampleFile(String filename) {
        String[] sampleText = {
            "Java programming is fun and powerful.",
            "Streams and Files are important concepts.",
            "Exception handling makes code robust.",
            "String manipulation is frequently used.",
            "Practice makes perfect in programming."
        };
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filename))) {
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
    // processTextFile (versi modifikasi)
    // Bagian yang DITAMBAHKAN dari praktikum ditandai MODIFIKASI MUDAH / SEDANG.
    // ============================================================
    public static void processTextFile(String inputFile, String outputFile, String reportFile) {
        try (BufferedReader reader = new BufferedReader(new FileReader(inputFile));
             BufferedWriter writer = new BufferedWriter(new FileWriter(outputFile));
             BufferedWriter reportWriter = new BufferedWriter(new FileWriter(reportFile))) {

            String line;
            int totalLines = 0;
            int totalWords = 0;
            int totalChars = 0;

            // MODIFIKASI MUDAH: penghitung jumlah kalimat
            int totalSentences = 0;

            Map<Character, Integer> charFrequency = new HashMap<>();   // huruf -> jumlah

            // MODIFIKASI SEDANG: HashMap baru untuk frekuensi KATA (kata -> jumlah).
            // Konsepnya sama dengan charFrequency, hanya key-nya String (kata), bukan char.
            Map<String, Integer> wordFrequency = new HashMap<>();

            while ((line = reader.readLine()) != null) {
                totalLines++;

                writer.write(line.toUpperCase());     // versi huruf besar
                writer.newLine();

                String trimmed = line.trim();
                if (!trimmed.isEmpty()) {
                    totalWords += trimmed.split("\\s+").length;
                }
                totalChars += line.length();

                // ---------- MODIFIKASI MUDAH: hitung kalimat ----------
                // Asumsi: satu kalimat diakhiri satu tanda titik '.'.
                // Setiap karakter di baris diperiksa; jika '.', jumlah kalimat bertambah 1.
                // Keterbatasan: singkatan ("e.g.") atau angka desimal ikut terhitung.
                for (char c : line.toCharArray()) {
                    if (c == '.') {
                        totalSentences++;
                    }
                }

                // ---------- MODIFIKASI SEDANG: hitung frekuensi kata ----------
                // 1. toLowerCase()  : "Java" dan "java" dianggap kata yang sama
                // 2. split("\\s+")  : pecah baris jadi kata-kata
                for (String w : line.toLowerCase().split("\\s+")) {

                    // 3. replaceAll("[^a-z]", ""): hapus semua karakter yang BUKAN huruf a-z
                    //    sehingga "powerful." menjadi "powerful" (titik ikut terhapus).
                    String clean = w.replaceAll("[^a-z]", "");

                    // 4. Abaikan hasil kosong (mis. elemen yang hanya berisi tanda baca),
                    //    lalu catat frekuensinya dengan pola getOrDefault + 1.
                    if (!clean.isEmpty()) {
                        wordFrequency.put(clean, wordFrequency.getOrDefault(clean, 0) + 1);
                    }
                }

                // Frekuensi huruf (sama dengan praktikum)
                for (char c : line.toLowerCase().toCharArray()) {
                    if (Character.isLetter(c)) {
                        charFrequency.put(c, charFrequency.getOrDefault(c, 0) + 1);
                    }
                }
            }

            // ---------- Tulis laporan ----------
            reportWriter.write("=== TEXT PROCESSING REPORT ===");
            reportWriter.newLine();
            reportWriter.write("Total Lines: " + totalLines);
            reportWriter.newLine();
            reportWriter.write("Total Words: " + totalWords);
            reportWriter.newLine();
            reportWriter.write("Total Characters: " + totalChars);
            reportWriter.newLine();

            // MODIFIKASI MUDAH: tulis jumlah kalimat ke laporan
            reportWriter.write("Total Sentences: " + totalSentences);
            reportWriter.newLine();

            double avgWords = (totalLines == 0) ? 0 : (double) totalWords / totalLines;
            reportWriter.write("Average Words per Line: " + avgWords);
            reportWriter.newLine();
            reportWriter.newLine();

            // ---------- MODIFIKASI SEDANG: laporan kata paling sering ----------
            // Pindahkan isi HashMap ke List agar bisa diurutkan (HashMap tidak berurutan).
            List<Map.Entry<String, Integer>> sortedWords = new ArrayList<>(wordFrequency.entrySet());

            // Urut: frekuensi terbanyak dulu; jika sama, urut abjad (agar hasil konsisten).
            sortedWords.sort((a, b) -> {
                int cmp = b.getValue().compareTo(a.getValue());
                return (cmp != 0) ? cmp : a.getKey().compareTo(b.getKey());
            });

            // Setelah diurutkan, elemen pertama pasti punya frekuensi tertinggi.
            // Cek isEmpty() agar tidak error jika file tidak berisi kata.
            if (!sortedWords.isEmpty()) {
                int maxCount = sortedWords.get(0).getValue();   // frekuensi tertinggi

                // Bisa ada BEBERAPA kata yang seri di frekuensi tertinggi, jadi kita
                // kumpulkan semuanya (bukan hanya satu) memakai StringBuilder.
                StringBuilder top = new StringBuilder();
                for (Map.Entry<String, Integer> entry : sortedWords) {
                    if (entry.getValue() == maxCount) {
                        if (top.length() > 0) top.append(", ");   // pemisah antar kata
                        top.append(entry.getKey());
                    }
                }
                reportWriter.write("MOST FREQUENT WORD(S) (" + maxCount + "x): " + top);
                reportWriter.newLine();

                // Tampilkan juga 5 kata teratas. Math.min mencegah error bila
                // jumlah kata unik kurang dari 5.
                reportWriter.write("TOP 5 WORDS:");
                reportWriter.newLine();
                for (int i = 0; i < Math.min(5, sortedWords.size()); i++) {
                    reportWriter.write("  " + sortedWords.get(i).getKey() + ": " + sortedWords.get(i).getValue());
                    reportWriter.newLine();
                }
                reportWriter.newLine();
            }

            // ---------- Frekuensi huruf (sama dengan praktikum) ----------
            reportWriter.write("CHARACTER FREQUENCY:");
            reportWriter.newLine();
            List<Map.Entry<Character, Integer>> sortedChars = new ArrayList<>(charFrequency.entrySet());
            sortedChars.sort((a, b) -> {
                int cmp = b.getValue().compareTo(a.getValue());
                return (cmp != 0) ? cmp : a.getKey().compareTo(b.getKey());
            });
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

    // displayReport: membaca file laporan dan mencetaknya ke layar
    public static void displayReport(String reportFile) {
        System.out.println("\n=== PROCESSING REPORT ===");
        try (BufferedReader reader = new BufferedReader(new FileReader(reportFile))) {
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            System.out.println("Error reading report: " + e.getMessage());
        }
    }
}
