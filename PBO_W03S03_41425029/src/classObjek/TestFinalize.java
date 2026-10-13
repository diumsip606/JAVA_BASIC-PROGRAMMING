/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package classObjek;

/**
 *
 * @author Gaudium
 */
public class TestFinalize {
    // Method finalize() dipanggil tepat sebelum objek dihapus oleh Garbage Collector
    @Override 
    protected void finalize() {
        System.out.println("finalize method called");
    }

    public static void main(String[] args) {
        TestFinalize t = new TestFinalize();
        System.out.println(t.hashCode());
        t = null; // Menghilangkan referensi objek[
        System.gc(); // Memanggil Garbage Collector secara manual
        System.out.println("end");
    }
}