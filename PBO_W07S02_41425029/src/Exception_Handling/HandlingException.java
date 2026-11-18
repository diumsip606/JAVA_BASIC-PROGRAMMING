/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Exception_Handling;

import java.util.Arrays;

/**
 *
 * @author Gaudium
 */
public class HandlingException {
    public static void main(String[] args) {
        try {
            System.out.println(3/0);
        } catch (ArithmeticException ex){
            System.out.println("Error " + ex);
        } 
            // ex.getMessage()
//        } catch (ArithmeticException ex){
//            System.out.println("Error " + ex.getMessage());
//        }

            // ex.getStackTrace()
//        } catch (ArithmeticException ex){
///*harus ada Arrays.toString dan import java.util.Arrays; untuk menjalankan fungsi (ex.getStackTrace()*/
//            System.out.println("Error " + Arrays.toString (ex.getStackTrace()));
//        }

            //  Statement ex.printStackTrace()
//        } catch (ArithmeticException ex){
//            System.out.println("Error " + ex);
//            ex.printStackTrace();
//        } 
//            // 2b. ArithmeticException diubah menjadi Exception
//        } catch (ArithmeticException ex){
//            System.out.println("Error " + ex);
//          } 
          
          

    }
}

//a. Ganti ex dengan ex.getMessage() dan ex.getStackTrace(). Coba juga untuk 
//mengeksekusi statement ex.printStackTrace() dan lihat apa hasilnya.
//   Jika diganti ex.getMessage()
//      Method ini hanya mengambil dan menampilkan pesan inti dari penyebab error tersebut. Nama kelas exception (java.lang.ArithmeticException) tidak ikut ditampilkan.

//   Jika diganti ex.getStackTrace()
//      Method ini mengembalikan data bertipe array. Karena dicetak 
//      langsung dengan System.out.println(), Java hanya mencetak referensi 
//      alamat memori dari array tersebut, bukan teks yang bisa dibaca.

//  Jika mengeksekusi ex.printStackTrace()
//      Fungsi ini bakal ngeluarin jejak errornya secara detail di console (teks merah). Enaknya pakai ini tuh infonya super lengkap, dari tipe errornya, pesannya apa, file mana, sampai baris ke berapa errornya terjadi juga dikasih tau

//b. Ganti ArithmeticException dengan Exception. Apa hasilnya? Jelaskan. 
//Errornya tetep berhasil ditangkep, karena Exception itu kan kategori error yang general, sedangkan ArithmeticException itu lebih spesifik. Otomatis catch yang general bisa nangkep semua error yang di bawahnya.
