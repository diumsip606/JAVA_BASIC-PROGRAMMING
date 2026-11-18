/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package studi_kasus_mini_week9;

import java.io.*;
public class UpperCaseConverter {
    public static void main(String[] args){
        try (BufferedReader br = new BufferedReader(new FileReader("input.docx"));
             BufferedWriter bw = new BufferedWriter(new FileWriter("output.docx"))){
            
                String line;
                while ((line = br.readLine()) != null) {
                    bw.write(line);// isi dari variabel line diambil buat ditulis sama fungsi write
                    bw.newLine(); // setelah selesai 1 baris, nanti buat line baru
                } 
                System.out.println("Konversi selesai!"); // setelah baris sudah kosong, maka keluar dari looping dengan terminal menampilkan konversi selesai!
        } catch (IOException e) {
            System.out.println("Terjadi error: " + e.getMessage());
        }
    }
}
