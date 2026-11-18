/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Exception_Handling;

/**
 *
 * @author Gaudium
 */
public class MultipleCatch {
    public static void main(String args[]) {
        int n = args.length;
        int a = 1;
        int c[] = new int[1];
        
        try {
            if (n == 0)
                a = a / (a - 1);
            else
                c[21] = 5;
        } catch (ArithmeticException e) {
            System.out.println("Ups, seem out we have an Arithmetic "
                    + "Exception here...");
        } catch (Exception e) {
            System.out.println("Let the other exception handler here...");
        }
    }
}


/*
a. Coba eksekusi program tanpa arguments. Catch statement mana yang dieksekusi?
   Catch statement yang PERTAMA (ArithmeticException) yang bakal jalan.
   Penjelasannya: Kalo nggak ada argumen, n nilainya 0. Program masuk ke blok "if" 
   dan ngitung 1 / (1-1) alias 1 dibagi 0. Ini bikin error bagi nol, makanya 
   langsung ditangkep sama catch yang khusus ArithmeticException. Outputnya bakal 
   muncul: "Ups, seem out we have an Arithmetic Exception here...".

b. Coba eksekusi program dengan sebuah argument. Catch statement mana yang dieksekusi?
   Catch statement yang KEDUA (Exception) yang bakal jalan.
   Penjelasannya: Kalo kita kasih argumen, nilai n bukan 0. Program bakal loncat ke 
   blok "else" dan nyoba ngisi array indeks ke-21 (c[21] = 5). Padahal array "c" 
   cuma dibikin buat 1 slot doang (mentok di indeks 0). Ini bikin error out of bounds. 
   Karena kita nggak bikin catch khusus buat error array itu, jadinya ditangkep 
   sama catch "Exception" yang sifatnya general (sapu jagat). Outputnya: "Let the 
   other exception handler here...".

c. Sekarang, ganti ArithmeticException dengan Exception (dibolak-balik posisinya). 
   Apa yang terjadi? Mengapa? Jelaskan.
   Yang terjadi adalah program BAKAL ERROR saat di-compile (muncul pesan error: 
   "Unreachable catch block"). 
   Penjelasannya: Ingat konsep tadi, class "Exception" itu kan general (bisa 
   nangkep error apa aja). Kalo yang general ditaruh di urutan paling atas, SEMUA 
   error udah pasti diserok duluan di situ. Akibatnya, catch "ArithmeticException" 
   yang ada di bawahnya jadi percuma dan nggak bakal pernah bisa tereksekusi. Java 
   itu pinter, dia bakal nolak dan ngasih tau kalo kodenya salah. Aturannya: kalo 
   bikin multiple catch, urutannya WAJIB dari yang paling spesifik dulu, baru turun 
   ke yang paling general.

*/