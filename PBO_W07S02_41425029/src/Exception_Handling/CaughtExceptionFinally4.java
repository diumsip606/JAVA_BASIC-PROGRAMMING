/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Exception_Handling;

/**
 *
 * @author Gaudium
 */
class CaughtExceptionFinally4 {
    public static void main(String args[]) {
           int n = args.length; // Jalankan tanpa argument agar n = 0
           try {
               if (n == 0) {
                   System.out.println(3 / n); // Bakal memicu ArithmeticException
                   System.out.println("This won't be executed");
               } else {
                   System.out.println("This will be executed if arguments is not zero");
               }
           // JAWABAN SOAL 4: Mengganti Exception dengan CaughtExceptionFinally4
           } catch (NullPointerException e) { 
               System.out.println("Catching exception: " + e);
           } finally {
               System.out.println("After trying or catching...");
           }
       }   
}

/*
Apa hasilnya dan jelaskan apa yang terjadi jika sebuah exception 
tidak memiliki sebuah catch yang cocok?
Hasilnya:
Program bakal tetep error/crash dan ngeluarin tulisan merah bawaan Java 
(java.lang.ArithmeticException: / by zero). Tapi uniknya, sebelum programnya 
bener-bener mati (berhenti paksa), tulisan "After trying or catching..." dari 
blok 'finally' tetep sempat dicetak di console.

Waktu program nyoba ngitung 3/0, error yang muncul itu kan ArithmeticException. 
Tapi karena di blok catch kita masangnya CaughtExceptionFinally4, jadinya nggak cocok (nggak match). 
Kalau exception nggak ketemu catch yang pas, errornya bakal "lolos" alias nggak ketangkep. 
Karena nggak ada yang nanganin error tersebut, Java akhirnya milih buat ngehentiin 
program secara paksa (crash). Walaupun programnya dihentikan paksa, Java tetep 
memprioritaskan buat ngejalanin blok 'finally' dulu sebagai langkah penutup.
*/