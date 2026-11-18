/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Exception_Handling;

/**
 *
 * @author Gaudium
 */
public class ThrowsDemo {
    
    // Method ini menggunakan keyword "throws" untuk mendelegasikan exception
    static void throwOne() throws IllegalAccessException {
        System.out.println("I'm throwing a non Runtime exception that I "
                + "don't handle");
        System.out.println("Without specifying in method declaration");
        
        // Melempar exception berjenis checked exception
        throw new IllegalAccessException("demo");
    }

    public static void main(String args[]) {
        try {
            // Memanggil method yang bisa melempar exception
            throwOne();
        } catch (IllegalAccessException e) {
            System.out.println("Caught " + e);
        }
    }
}

/*
a. Apa yang akan terjadi jika kode program di atas (versi awal sebelum diperbaiki) 
   dieksekusi? Mengapa?
   Bakal langsung error pas di-compile (nggak bisa jalan). Kenapa? Karena 
   'IllegalAccessException' itu masuk kategori "Checked Exception". Aturan baku 
   di Java itu, kalo kita ngelempar checked exception di dalam method, kita wajib 
   banget nanganinnya langsung pake 'try-catch' di situ, ATAU ngasih deklarasi 
   'throws' di sebelah nama methodnya. Nah, di kode yang awal kan dua-duanya 
   nggak dilakuin, makanya compiler Java protes dan nolak kodenya. (Belum lagi 
   di kode awal ada salah ketik letak pemanggilan throwone() yang ditaruh di luar main).

b. Apa yang akan terjadi jika IllegalAccessException diganti dengan 
   ArithmeticException? Mengapa? 
   Kalo diganti jadi 'ArithmeticException', programnya bakal lolos compile dan 
   bisa jalan (walaupun nantinya bakal tetep ngeluarin error merah pas jalan 
   karena nggak ada catch-nya). 
   Kenapa bisa lolos? Karena 'ArithmeticException' itu masuk kategori 
   "Unchecked Exception" (turunan dari RuntimeException). Kalo buat exception 
   tipe ini, Java nggak strict; Java nggak mewajibkan kita buat nulis try-catch 
   atau nambahin 'throws' di deklarasi method. Jadi sah-sah aja kodenya tetep 
   di-compile.
*/
