/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Gaudium
 */
// 1. Buat class Mahasiswa
class Mahasiswa {
    String nama;
    String nim;
}

// Buat class MahasiswaAktif yang mewarisi (extends) Mahasiswa
class MahasiswaAktif extends Mahasiswa {
    int semester;
    
    // Method khusus untuk MahasiswaAktif
    public void belajar() {
        System.out.println(nama + " sedang belajar di semester " + semester);
    }
}

public class Main {
    public static void main(String[] args) {
        // 2. Isi data objek MahasiswaAktif
        MahasiswaAktif mhs = new MahasiswaAktif();
        mhs.nama = "Dina";
        mhs.nim = "123456";
        mhs.semester = 5;
        
        // Menampilkan output sesuai contoh
        System.out.println("Nama: " + mhs.nama);
        System.out.println("NIM: " + mhs.nim);
        mhs.belajar();
    }
}
