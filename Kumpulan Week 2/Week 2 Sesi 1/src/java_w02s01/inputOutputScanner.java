/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package java_w02s01;

/**
 *
 * @author Gaudium
 */

import java.util.Scanner;
public class inputOutputScanner {
    public static void main (String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.print("Masukkan nama: ");
        String nama = sc.nextLine();
        System.out.println("Halo, " + nama);
    }
}
