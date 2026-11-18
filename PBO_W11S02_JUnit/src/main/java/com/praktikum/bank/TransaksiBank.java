/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.praktikum.bank;

/**
 *
 * @author Gaudium
 */
public class TransaksiBank {
    public static void main(String[] args) throws InterruptedException {
        RekeningBank rekening = new RekeningBank(0);
        Thread[] threads = new Thread[100];
        
        for (int i = 0; i < 100; i++) {
            threads[i] = new Thread(() -> rekening.setor(1000));
            threads[i].start();
        }
        
        for (Thread t : threads) {
            t.join();
        }
        
        System.out.println("Saldo Seharusnya : 100000");
        System.out.println("Saldo Aktual     : " + rekening.getSaldo());
    }
}
