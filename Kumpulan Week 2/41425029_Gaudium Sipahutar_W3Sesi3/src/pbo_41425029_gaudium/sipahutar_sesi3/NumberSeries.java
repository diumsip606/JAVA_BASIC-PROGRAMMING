/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pbo_41425029_gaudium.sipahutar_sesi3;

import java.util.Scanner;

/*
 * NIM : 41425029
 * Nama: Gaudium Sipahutar
 * Motto: Want be the best on my future
 */

public class NumberSeries {
    public static void main (String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Masukkan jumlah deret Fibonacci: ");
        int n = scanner.nextInt();
        
        // Generate Fibonacci series
        System.out.println("Deret Fibonacci:");
        int a = 0, b = 1;
        for(int i = 0; i < n; i++) {
            System.out.print(a  + " ");
            int next = a + b;
            a = b;
            b = next;
        }
        System.out.println();
        
//        Check prime number
        System.out.print("Masukkan bilangan untuk dicek prima: ");
        int num = scanner.nextInt();
        boolean isPrime = true;
        
        if(num <= 1) {
            isPrime = false;
        } else {
            for(int i = 2; i <= Math.sqrt(num); i++) {
                if(num % i == 0) {
                    isPrime = false;
                    break;
                }
            }
        }
        System.out.println(num + (isPrime ? " adalah bilangan prima" : " bukan bilangan prima"));
    }
}

/*
Pertanyaan Pemantik : 
Bagaimana cara mengoptimalkan algoritma Fibonacci untuk jumlah yang besar? 
tipe datanya wajib diganti dulu. Kalau pakai int seperti di kode sekarang, itu bakal error pas nyentuh deret ke 46. Jadi mending dinaikkin pakai long. 
Kalau angkanya bener bener besar, kita bisa pakai class BigInteger bawaan Java biar ga ada batas limit angkanya.
*/
    
