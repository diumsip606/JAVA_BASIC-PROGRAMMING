/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package com.praktikum.bank;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.time.Duration;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
//import org.junit.jupiter.api.AfterEach;
//import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.DisplayName;

/**
 *
 * @author Gaudium
 */
public class RekeningBankTest {
    
    private RekeningBank rekening;
    
    @BeforeEach
    void setUp() {
        rekening = new RekeningBank(0);
    }
    
    @Test
    @DisplayName("Skenario 1: Transaksi setor dan tarik normal secara sekuensial")
    void testTransaksiNormal () throws InterruptedException {
        rekening.setor(50000);
        rekening.tarikDenganTunggu(20000);
        assertEquals(30000, rekening.getSaldo(), "Saldo akhir harus tepat 30000");
    }
    
    @Test
    @DisplayName("Skenario 2: Input nominal negatif atau nol harus harus melempar Exception")
    void testInputTidakValid () {
        assertThrows(IllegalArgumentException.class, () -> {
            rekening.setor(-5000);
        }, "Setor negatif harus ditolak dengan IllegalArgumentException");
    }
    
    @Test
    @DisplayName("Skenario 3: Bebas Race Condition pada eksekusi 100 Thread bersamaan")
    void testConcurrencySetor() throws InterruptedException{
        int jumlahThread = 100;
        int nominalSetor = 1000;
        ExecutorService executor = Executors.newFixedThreadPool(20);
        CountDownLatch latch = new CountDownLatch(jumlahThread);
        
        for (int i = 0; i < jumlahThread; i++) {
            executor.submit(() -> {
                try {
                    rekening.setor(nominalSetor);
                } finally {
                    latch.countDown();
                }
            });
        }
        
        latch.await();
        executor.shutdown();
        
        assertEquals(100000, rekening.getSaldo(),
                "Saldo harus tepat 100000 tanpa kehilangan data akibat race condition");
    }
    
    @Test
    @DisplayName("Skenario 4: Koordinasi Thread menggunakan wait() dan notifyAll()")
    void testWaitNotifyTarikTunggu() {
        assertTimeoutPreemptively(Duration.ofSeconds(2), () -> {
            Thread threadPenarik = new Thread(() -> {
                try {
                    rekening.tarikDenganTunggu(50000);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            });
            
            Thread threadPenyetor = new Thread(() -> {
                try {
                    Thread.sleep(200);
                    rekening.setor(70000);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            });
            
            threadPenarik.start();
            threadPenyetor.start();
            
            threadPenarik.join();
            threadPenyetor.join();
                
            assertEquals(20000, rekening.getSaldo(),
                    "Thread penarik harus menunggu penyetor, lalu saldo tersisa 20000");
        });           
    } 
    
    // LATIHAN MANDIRI 3 
    @Test
    @DisplayName("Latihan 3a: Transfer paralel dua arah aman dari race condition & deadlock")
    void testTransferParalel() {
        RekeningBank a = new RekeningBank(100000);
        RekeningBank b = new RekeningBank(100000);

        // Timeout 5 detik: jika terjadi deadlock, tes gagal (tidak menggantung)
        assertTimeoutPreemptively(Duration.ofSeconds(5), () -> {
            ExecutorService executor = Executors.newFixedThreadPool(20);
            try {
                List<Future<?>> hasil = new ArrayList<>();
                for (int i = 0; i < 50; i++) {
                    // Dua arah sekaligus: A->B (1000) dan B->A (500)
                    hasil.add(executor.submit(() -> a.transfer(b, 1000)));
                    hasil.add(executor.submit(() -> b.transfer(a, 500)));
                }
                // get() memastikan semua selesai dan memunculkan exception jika ada
                for (Future<?> f : hasil) {
                    f.get();
                }
            } finally {
                executor.shutdownNow();
            }
        });

        // Konsistensi total: uang tidak boleh hilang atau muncul dari ketiadaan
        assertEquals(200000, a.getSaldo() + b.getSaldo(), "Total saldo harus tetap 200000");
        // A: 100000 - (50 x 1000) + (50 x 500) = 75000
        assertEquals(75000, a.getSaldo(), "Saldo A harus 75000");
        // B: 100000 + (50 x 1000) - (50 x 500) = 125000
        assertEquals(125000, b.getSaldo(), "Saldo B harus 125000");
    }

    @Test
    @DisplayName("Latihan 3b: Tarik dana melempar TimeoutException jika penyetor tidak datang")
    void testTarikTimeout() {
        long mulai = System.nanoTime();

        // Saldo 0 dan tidak ada thread penyetor -> harus timeout
        assertThrows(TimeoutException.class,
                () -> rekening.tarikDenganTunggu(50000, 300),
                "Penarikan tanpa penyetor harus berakhir TimeoutException");

        long lamaMillis = TimeUnit.NANOSECONDS.toMillis(System.nanoTime() - mulai);
        // Bukti thread benar-benar menunggu sekitar 300 ms (toleransi 50 ms)
        assertTrue(lamaMillis >= 250, "Thread harus menunggu mendekati timeout, bukan langsung gagal");
        assertTrue(lamaMillis < 2000, "Thread tidak boleh menunggu jauh melebihi timeout");
        assertEquals(0, rekening.getSaldo(), "Saldo tidak boleh berubah setelah timeout");
    }

    @Test
    @DisplayName("Latihan 3c: Tarik dengan timeout berhasil jika penyetor datang tepat waktu")
    void testTarikTimeoutBerhasil() {
        assertTimeoutPreemptively(Duration.ofSeconds(3), () -> {
            Thread penyetor = new Thread(() -> {
                try {
                    Thread.sleep(200);       // penyetor datang setelah 200 ms (< timeout 2000 ms)
                    rekening.setor(70000);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            });
            penyetor.start();

            rekening.tarikDenganTunggu(50000, 2000); // tidak boleh melempar exception
            penyetor.join();

            assertEquals(20000, rekening.getSaldo(), "Setelah setor 70000 dan tarik 50000, sisa 20000");
        });
    }

    @Test
    @DisplayName("Latihan 3d: Transfer dengan saldo kurang ditolak dan saldo tidak berubah")
    void testTransferSaldoKurang() {
        RekeningBank asal = new RekeningBank(1000);
        RekeningBank tujuan = new RekeningBank(0);

        assertThrows(IllegalStateException.class, () -> asal.transfer(tujuan, 5000),
                "Transfer melebihi saldo harus ditolak");

        // Transaksi gagal tidak boleh meninggalkan efek samping
        assertEquals(1000, asal.getSaldo(), "Saldo asal tidak boleh berubah");
        assertEquals(0, tujuan.getSaldo(), "Saldo tujuan tidak boleh berubah");
    }
}
