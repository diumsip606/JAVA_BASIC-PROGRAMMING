/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Bagian1_1_Overloading;

/**
 *
 * @author Gaudium
 */
class MesinTarif {
    private String kotaAsal;
    
    public MesinTarif(String kotaAsal) {
        this.kotaAsal = kotaAsal;
    }
    
    public double hitungOngkir(double beratKg) {
        return beratKg * 10000;
    }
    
    public double hitungOngkir(double beratKg, double nilaiBarang) {
        double biayaAsuransi = nilaiBarang * 0.01;
        return (beratKg * 10000) + biayaAsuransi;
    }
    
    public double hitungOngkir(double beratKg, boolean isExpress) {
        double total = beratKg * 10000;
        if(isExpress) {
            total += 20000;
        }
        return total;
    }
}

