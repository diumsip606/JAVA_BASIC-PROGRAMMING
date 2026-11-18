/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package TransaksiMinimal;

/**
 *
 * @author Gaudium
 */
public class Main {
    public static void main(String[] args) {
        // instansiasi objek Rekening dengan saldo awal 10rb
        Rekening rekening = new Rekening("Gaudium", 10000);
        rekening.tampilkanSaldo();
        
        double[] daftarNominal = {
            50000,
            10000,
            9999,
            5000,
            -2000,
            0,
            500000
        };
        
        // kasih loop setiap kondisinya
        for (int i = 0; i < daftarNominal.length; i++) {
            double nominal = daftarNominal[i];
            System.out.println("\n--- Skenario " + (i + 1) + ": transfer Rp" + (long) nominal + "---");
            
            try {
                rekening.transfer(nominal);
     
            } catch (TransaksiException e) {
                System.out.println("[Transaksi ditolak] " + e.getMessage());
                System.out.println("[Transaksi ditolak] Nominal gagal: Rp" + (long) e.getNominal());
                
            } catch (IllegalArgumentException e) {
                System.out.println("[IllegalArgument] " + e.getMessage());
                
            } catch (IllegalStateException e) {
                System.out.println("[IllegalState] " + e.getMessage());
                
            } finally{
                System.out.println("Proses transaksi selesai. Saldo " + rekening.getNasabah()
                    + ": Rp" + (long) rekening.getSaldo());
            }
                
        }
        
        System.out.println();
        rekening.tampilkanSaldo();
    }
}
