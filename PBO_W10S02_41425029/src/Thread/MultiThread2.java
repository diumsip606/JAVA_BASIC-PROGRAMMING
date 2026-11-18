/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Thread;

/**
 *
 * @author Gaudium
 */
package multithread;

class PrintNameThread2 implements Runnable {
    private Thread thread;
    private String symbol;
    private int printCount;
    private int delay;

    PrintNameThread2(String symbol, int printCount, int delay) {
        this.symbol = symbol;
        this.printCount = printCount;
        this.delay = delay;
        thread = new Thread(this, "Thread-" + symbol);
        System.out.println("Membuat " + thread.getName());
        thread.start();
    }

    // Ditambahkan: tidak ada di PDF, tapi dipanggil oleh Multithread2
    public void waitForCompletion() throws InterruptedException {
        thread.join();
    }

    public void run() {
        System.out.println(thread.getName() + " memulai eksekusi...");
        for (int i = 1; i <= printCount; i++) {
            System.out.print(symbol);
            // Menampilkan angka setiap 10 kali cetak
            if (i % 10 == 0) {
                System.out.print("[" + i + "]");
            }
            try {
                Thread.sleep(delay);
            } catch (InterruptedException e) {
                System.out.println("\n" + thread.getName() + " terinterupsi!");
                return;
            }
        }
        System.out.println("\n" + thread.getName() + " selesai mencetak " + printCount + " karakter!");
    }
}

public class Multithread2 {
    public static void main(String[] args) {
        System.out.println("---------------- PROGRAM MULTI-THREADING DENGAN RUNNABLE ----------------");
        System.out.println("-------------------------------------------------------------------------\n");

        // Membuat thread dengan karakter, jumlah cetakan, dan delay yang berbeda
        PrintNameThread2[] threads = {
            new PrintNameThread2("A", 25, 50),   // A dengan delay pendek
            new PrintNameThread2("B", 20, 80),   // B dengan delay sedang
            new PrintNameThread2("C", 30, 40),   // C dengan delay sangat pendek
            new PrintNameThread2("D", 15, 120),  // D dengan delay panjang
            new PrintNameThread2("E", 10, 150)   // E dengan delay paling panjang
        };

        System.out.println("\nMenunggu semua thread selesai...\n");

        // Menunggu semua thread selesai
        try {
            for (PrintNameThread2 thread : threads) {
                thread.waitForCompletion();
            }
        } catch (InterruptedException e) {
            System.out.println("Main thread terinterupsi!");
        }

        // Menampilkan statistik
        System.out.println("\n" + "=".repeat(50));
        System.out.println("STATISTIK EKSEKUSI THREAD");
        System.out.println("=".repeat(50));
        System.out.println("Jumlah thread yang dijalankan: " + threads.length);
        System.out.println("Total semua thread telah menyelesaikan tugasnya!");
        System.out.println("\nPROGRAM SELESAI DENGAN SUKSES!");

        // Animasi akhir yang menarik
        System.out.println("\nAnimasi selesai:");
        for (int i = 0; i < 3; i++) {
            System.out.print("Hore.. ");
            try {
                Thread.sleep(300);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
        System.out.println();
    }
}