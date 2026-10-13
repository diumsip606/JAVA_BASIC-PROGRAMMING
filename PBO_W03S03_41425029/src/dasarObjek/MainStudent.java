/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package dasarobjek;

public class MainStudent {
    // Method main adalah titik awal jalannya program
    public static void main(String[] args) {
        // Menginstansiasi (membuat) objek Student baru menggunakan keyword 'new'
        Student s1 = new Student(10, "Alice");
        
        // Mengakses dan mencetak nilai dari atribut id dan n milik objek s1
        System.out.println(s1.id);
        System.out.println(s1.n);
    }
}