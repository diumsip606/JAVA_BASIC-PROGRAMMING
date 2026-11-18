/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Exception_Handling;

/**
 *
 * @author Gaudium
 */
public class ThrowExc7 {
    static void demoThrow() {
        try {
            System.out.println("I'm throwing an exception from demoThrow "
                    + "method");
            throw new NullPointerException("demo");
        } catch (NullPointerException e) {
            System.out.println("I'm catching the exception [" + e + "]");
            System.out.println("But I'll throw it again...\n");
            throw e; // Ini proses re-throwing (melempar kembali)
        }
    } 

    public static void main(String args[]) {
        try {
            demoThrow();
        } catch (NullPointerException e) {
            System.out.println("I'm catching the exception [" + e + "]\n"
                    + "thrown from demoThrow method");
        }
    }
}

/*
a. Jika exception e tidak dilempar (rethrown) dari method demoThrow, apakah 
   masih akan ditangkap dari dalam main function?
   Nggak bakal ketangkep lagi di fungsi 'main'. Alasannya karena errornya udah 
   beres ditangani secara penuh di dalem method 'demoThrow'. Kalo kita nggak 
   lempar lagi (perintah "throw e;" dihapus), fungsi 'main' bakal ngira semua 
   kode berjalan mulus tanpa masalah. Otomatis, blok catch yang ada di 'main' 
   bakal di-skip gitu aja.

b. Apa yang bisa Anda simpulkan dari kode program di atas?
   Kesimpulannya, di Java kita bisa nangkep error, ngelakuin suatu aksi di 
   dalam catch tersebut (misal nyetak pesan error), terus ngelempar error 
   itu lagi (re-throw) ke method yang manggilnya (dalam hal ini dilempar 
   balik ke 'main'). Teknik ini berguna banget kalo kita pengen suatu method 
   bisa ngasih notifikasi error ke method utama, biar si method utama bisa 
   ikut ambil tindakan buat nanganin error tersebut.
*/
