/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Exception_Handling;

/**
 *
 * @author Gaudium
 */
public class CaughtExceptionFinally3 {
    public static void main(String args[]) {
           int n = args.length;
           try {
               if (n == 0) {
                   System.out.println(3 / n);
                   System.out.println("This won't be executed");
               } else {
                   System.out.println("This will be executed if arguments is not zero");
               }
           } catch (Exception e) {
               System.out.println("Catching exception: " + e);
           } finally {
               System.out.println("After trying or catching...");
           }
       }   
}


/*
a. Coba eksekusi program di atas tanpa arguments. Apa hasilnya?
   Hasilnya:
   Karena nggak ada argumen, nilai n jadi 0. Program nyoba ngitung 3/0, yang bikin error ArithmeticException. 
   Error ini langsung ditangkep sama blok catch, terus nampilin pesan "Catching exception: java.lang.ArithmeticException: / by zero". 
   Tulisan "This won't be executed" otomatis ke-skip. Tapi setelah itu, blok 'finally' tetep jalan dan nampilin "After trying or catching...".

b. Coba eksekusi program di atas dengan arguments. Apa hasilnya?
   Hasilnya:
   Karena ada argumen, nilai n bukan 0. Program jadi masuk ke blok else dan nampilin "This will be executed if arguments is not zero". 
   Nggak ada error sama sekali, jadi blok catch dilewatin. Tapi ujung-ujungnya, blok 'finally' tetep jalan juga dan nampilin "After trying or catching...".

c. Jelaskan kesimpulan Anda dari pertanyaan a dan b setelah menjalankan program.
   Kesimpulannya:
   Blok 'finally' itu sifatnya mutlak atau wajib jalan. Mau programnya nge-crash terus ditangkep catch (kayak di poin a), atau programnya jalan mulus tanpa error (kayak di poin b), kode yang ada di dalem 'finally' bakal selalu dieksekusi di akhir. Biasanya ini kepake banget buat nutup koneksi database atau nutup file, biar tetep aman mau error atau nggak.
*/