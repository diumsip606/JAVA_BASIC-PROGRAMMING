package Tugas;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Gaudium
 */
class Mahasiswa {
    String nama;
    String nim;
}

public class Main {
    public static void main(String[] args) {
        // Melengkapi instansiasi objek
        Mahasiswa m1 = new Mahasiswa(); 
        
        // Mengisi nilai atribut
        m1.nama = "Budi"; 
        m1.nim = "12345"; 
        
        // Menampilkan output
        System.out.println("Nama: " + m1.nama); 
        System.out.println("NIM: " + m1.nim); 
    }
}
