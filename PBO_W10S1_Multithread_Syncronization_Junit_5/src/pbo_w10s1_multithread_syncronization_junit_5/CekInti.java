/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pbo_w10s1_multithread_syncronization_junit_5;

/**
 *
 * @author Gaudium
 */
public class CekInti {
    public static void main(String[] args) {
        int inti = Runtime.getRuntime().availableProcessors();
        System.out.println("Jumlah inti: " + inti);
    }
}
