/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Gaudium
 */
public abstract class Alat {
    private final String nama;
    private final String kode;
    private final String tersedia;

    // Constructor abstract class dipanggil subclass lewat super(...)
    public Alat(String nama, String kode, String tersedia) {
        this.nama = nama;
        this.kode = kode;
    }
    
    // GETTER
    public String getKode(){
        return kode;
    }
    public String getNama(){
        return nama;
    }
    public String isTersedia(){
        return tersedia;
    }
    
    // Boolean
    public boolean bisaMeminjam() {
        return jumlahPinjam < maxPinjam;
    }
    
    public abstract int getMaksPinjam();

    // METHOD BIASA: dipakai bersama, boleh di-override
    public void tampilkanInfo() {
        System.out.println("[" + getJenis() + "] " + nama + " (" + id + ")"
                + " | maks pinjam: " + getMaksPinjam());
    }

    // FINAL METHOD: tidak boleh di-override
    public final String getJenis() {
        return getClass().getSimpleName();
    }
}
