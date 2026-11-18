/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package TransaksiMinimal;

/**
 *
 * @author Gaudium
 */
public class Rekening {
    // nilai konstan batas minimum nominal transaksi
    public static final double minimum_transaksi = 10000;
    
    private String nasabah; //pemilik rekening
    private double saldo; 
    
    // constructor untuk mengisi data awal rekening 
    public Rekening (String nasabah, double saldoAwal) {
        this.nasabah = nasabah;
        this.saldo = saldoAwal;
    }
    
    // getter nama pemilik
    public String getNasabah(){
        return nasabah;
    }
    
    // getter saldo
    public double getSaldo() {
        return saldo;
    }
    
    // informasi rekening
    public void tampilkanSaldo() {
        System.out.println("Saldo " + nasabah + " saat ini: Rp" + (long) saldo);
    }
    
    public void transfer(double nominal) throws TransaksiException {
        // Validasi 1
        if (nominal <= 0) {
            throw new IllegalArgumentException("Nominal harus lebih dari 0, input: Rp" + (long) nominal);
        }
        
        // Validasi 2
        if (nominal < minimum_transaksi) {
            // lempar exception
            throw new TransaksiException(
            "Transaksi ditolak. Nominal Rp" + (long) nominal
            + " kurang dari minimum Rp" + (long) minimum_transaksi, nominal);
        }
        
        // Validasi 3
        if (nominal > saldo) {
            throw new IllegalStateException(
            "Saldo tidak cukup. Saldo: Rp" + (long) saldo + ", nominal Rp" + (long) nominal);
        }
        
        // lolos semua validasi
        saldo -= nominal;
        System.out.println("Transfer Rp" + (long) nominal + " berhasil.");
    }
}
