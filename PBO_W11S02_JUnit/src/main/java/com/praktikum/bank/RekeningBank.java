/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.praktikum.bank;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.concurrent.atomic.AtomicLong;
/**
 *
 * @author Gaudium
 */
public class RekeningBank {
    // Penghitung ID unik untuk semua rekening (static = dipakai bersama).
    // AtomicLong dipakai agar aman jika rekening dibuat dari banyak thread.
    private static final AtomicLong PENGHITUNG_ID = new AtomicLong(0);

    // ID tidak pernah berubah (final); dipakai sebagai patokan urutan penguncian
    private final long id;
    private int saldo;
    
    public RekeningBank(int saldoAwal) {
        this.id = PENGHITUNG_ID.incrementAndGet(); // beri ID unik      
        this.saldo = saldoAwal;
    }
    
    // Buat synchronized
    public synchronized void setor(int jumlah) {
        if (jumlah <= 0) {
            throw new IllegalArgumentException("Jumlah setor harus lebih dari 0");
        }
        int saldoSementara = this.saldo;
        try{
            Thread.sleep(1);
        } catch (InterruptedException e){
            Thread.currentThread().interrupt();
        }
        this.saldo = saldoSementara + jumlah;
        
        notifyAll();
    }
    
//    // Awal code gapake synchronize
//    public void setor(int jumlah) {
//        int saldoSementara = this.saldo;
//        try{
//            Thread.sleep(1);
//        } catch (InterruptedException e){
//            Thread.currentThread().interrupt();
//        }
//        this.saldo = saldoSementara + jumlah;
//    }
    
    
    // Buat tarik saldo dengan synchronized
    public synchronized void tarikDenganTunggu(int jumlah) throws InterruptedException {
        if (jumlah <= 0) {
            throw new IllegalArgumentException("Jumlah tarik harus lebih dari 0");
        }
        
        while (this.saldo < jumlah) {
            wait();
        }
        
        this.saldo -= jumlah;
    }
    
    // Buat tarik saldo tanpa synchronized
//    public void tarik(int jumlah) {
//        if  (this.saldo >= jumlah) {
//            int saldoSementara = this.saldo;
//            try {
//                Thread.sleep(1);
//            } catch (InterruptedException e) {
//                Thread.currentThread().interrupt();
//            }
//            this.saldo = saldoSementara - jumlah;
//        }
//    }
    
    // Buat cek saldo dengan synchronized
    public synchronized int getSaldo(){
        return saldo;
    }
//    // Buat Cek saldo tanpa synchronized
//    public int getSaldo() {
//        return saldo;
//    }
    
   //   LATIHAN MANDIRI 1 
    // Transfer aman dari race condition DAN deadlock.
    public void transfer(RekeningBank tujuan, int jumlah) {
        // Validasi input sebelum mengambil kunci apa pun
        if (tujuan == null) {
            throw new IllegalArgumentException("Rekening tujuan tidak boleh null");
        }
        if (tujuan == this) {
            throw new IllegalArgumentException("Tidak bisa transfer ke rekening sendiri");
        }
        if (jumlah <= 0) {
            throw new IllegalArgumentException("Jumlah transfer harus lebih dari 0");
        }

        // LOCK ORDERING: selalu kunci rekening ber-ID kecil lebih dulu.
        // Dengan urutan yang konsisten, thread A->B dan B->A tidak bisa
        // saling menunggu (tidak ada circular wait), sehingga bebas deadlock.
        RekeningBank pertama = (this.id < tujuan.id) ? this : tujuan;
        RekeningBank kedua = (this.id < tujuan.id) ? tujuan : this;

        synchronized (pertama) {
            synchronized (kedua) {
                // Cek saldo di dalam kunci supaya "cek lalu kurangi" bersifat atomik
                if (this.saldo < jumlah) {
                    throw new IllegalStateException("Saldo tidak mencukupi untuk transfer");
                }
                this.saldo -= jumlah;     // kurangi rekening asal
                tujuan.saldo += jumlah;   // tambah rekening tujuan
                tujuan.notifyAll();       // bangunkan penarik yang menunggu di rekening tujuan
            }
        }
    }

    //  LATIHAN MANDIRI 2 
    // Tarik dana dengan batas waktu tunggu.
    public synchronized void tarikDenganTunggu(int jumlah, long timeoutMillis)
            throws InterruptedException, TimeoutException {
        if (jumlah <= 0) {
            throw new IllegalArgumentException("Jumlah tarik harus lebih dari 0");
        }
        // wait(0) berarti menunggu SELAMANYA, jadi timeout <= 0 ditolak
        if (timeoutMillis <= 0) {
            throw new IllegalArgumentException("Timeout harus lebih dari 0 ms");
        }

        // Batas waktu absolut; tetap benar walau thread terbangun lebih awal
        long batas = System.nanoTime() + TimeUnit.MILLISECONDS.toNanos(timeoutMillis);

        while (this.saldo < jumlah) {
            long sisaNano = batas - System.nanoTime();
            if (sisaNano <= 0) {
                // Waktu habis dan saldo tetap kurang
                throw new TimeoutException("Timeout: saldo tidak mencukupi untuk penarikan");
            }
            // Minimal 1 ms agar tidak pernah memanggil wait(0)
            long sisaMillis = Math.max(1, TimeUnit.NANOSECONDS.toMillis(sisaNano));
            wait(sisaMillis);
        }
        this.saldo -= jumlah;
    }
}
