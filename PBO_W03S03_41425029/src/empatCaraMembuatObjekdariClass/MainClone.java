/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package empatCaraMembuatObjekdariClass;

/**
 *
 * @author Gaudium
 */
// Class harus mengimplementasikan interface 'Cloneable' 
// agar Java mengizinkan pembuatan salinan (clone) dari objek ini
class GeeksClone implements Cloneable {
    // Atribut dasar
    String name = "GeeksForGeeks";

    // Method clone() di-override dari bawaan class Object
    // Digunakan untuk mengembalikan salinan objek yang persis sama
    @Override
    protected Object clone() throws CloneNotSupportedException {
        // super.clone() akan memanggil fungsi clone() dari parent class (Object)
        return super.clone();
    }
}

// Class utama untuk menjalankan program
public class MainClone {
    public static void main(String[] args) {
        // Membuat objek pertama (o1) menggunakan cara biasa (new)
        GeeksClone o1 = new GeeksClone();
        
        try {
            // Membuat objek kedua (o2) dengan cara menyalin (clone) dari o1
            // Hasil clone() harus di-casting (GeeksClone) agar tipe datanya sesuai
            GeeksClone o2 = (GeeksClone) o1.clone();
            
            // Mencetak atribut name dari objek hasil salinan
            // Jika berhasil, outputnya akan sama persis dengan o1 yaitu "GeeksForGeeks"
            System.out.println("Output objek hasil clone: " + o2.name);
            
        } catch (CloneNotSupportedException e) {
            // Menangkap error jika class tidak mengimplementasikan interface Cloneable
            e.printStackTrace();
        }
    }
}
