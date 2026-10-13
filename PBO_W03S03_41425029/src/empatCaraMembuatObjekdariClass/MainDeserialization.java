/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package empatCaraMembuatObjekdariClass;

/**
 *
 * @author Gaudium
 */

// Import library Java IO yang dibutuhkan untuk membaca dan menulis file
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

// Class harus implements Serializable agar Java mengizinkan objek ini diubah menjadi file
class StudentSer implements Serializable {
    String name;

    public StudentSer(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Student: " + name; // Format output sesuai yang ada di modul
    }
}

public class MainDeserialization {
    public static void main(String[] args) {
        
        // 1. SERIALIZATION (Menyimpan objek ke file)
        try (ObjectOutputStream out = new ObjectOutputStream(
                new FileOutputStream("student.ser"))) {
            
            // Kita buat objek "Alice" dan langsung kita simpan ke file bernama student.ser
            out.writeObject(new StudentSer("Alice"));
            System.out.println("Tahap 1: Objek berhasil disimpan ke dalam file 'student.ser'");
            
        } catch (IOException e) {
            e.printStackTrace();
        }

        // 2. DESERIALIZATION (Membuat objek baru dengan membaca file)
        try (ObjectInputStream in = new ObjectInputStream(
                new FileInputStream("student.ser"))) {
            
            // Membaca file student.ser dan mengubahnya kembali menjadi objek (casting ke StudentSer)
            StudentSer s = (StudentSer) in.readObject();
            
            // Mencetak objek yang berhasil dibuat dari file
            System.out.println("Tahap 2 (Deserialization): " + s);
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
