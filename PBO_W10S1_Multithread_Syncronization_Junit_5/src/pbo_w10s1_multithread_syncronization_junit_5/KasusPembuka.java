/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package pbo_w10s1_multithread_syncronization_junit_5;

/**
 *
 * @author Gaudium
 */
class Rekening {
    private double saldo;

    void setor(double jumlah) {
        saldo += jumlah;
    }

    double getSaldo() {
        return saldo;
    }
}

public class KasusPembuka {
    public static void main(String[] args) throws InterruptedException {
        Rekening r = new Rekening();
        Thread[] nasabah = new Thread[4];

        for (int k = 0; k < 4; k++) {
            nasabah[k] = new Thread(() -> {
                for (int i = 0; i < 100_000; i++) r.setor(1);
            });
            nasabah[k].start();
        }

        for (Thread t : nasabah) t.join();

        System.out.println("Saldo akhir: " + r.getSaldo());
        System.out.println("Seharusnya : 400000.0");
    }
}
