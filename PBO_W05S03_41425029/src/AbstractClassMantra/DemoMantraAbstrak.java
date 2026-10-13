/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package AbstractClassMantra;
import java.util.*;
/**
 *
 * @author Gaudium
 */
abstract class MantraAbstrak {
    private String nama;
    
    public MantraAbstrak(String nama){
        this.nama = nama;
    }
    
    // Abstract method: harus diimplementasikan oleh subclass
    public abstract void efek();
    
    // Method konkret
    public void ucapkan(){
        System.out.println("Mengucapkan mantra: " + nama);
    }
}

class Expelliarmus extends MantraAbstrak {
    public Expelliarmus(){
        super("Expelliarmus");
    }
    
    @Override
    public void efek() {
        System.out.println("Efek: Melucuti senjata lawan.");
    }
}

class ExpectoPatronum extends MantraAbstrak {
    public ExpectoPatronum() {
        super("Expecto Patronum");
    }

    @Override
    public void efek() {
        System.out.println("Efek: Memanggil Patronus untuk melawan Dementor.");
    }
}

class Lumos extends MantraAbstrak {
    public Lumos() {
        super("Lumos");
    }

    @Override
    public void efek() {
        System.out.println("Efek: Menerangi ujung tongkat.");
    }
}
public class DemoMantraAbstrak {
    public static void main(String[] args) {
        // Variabel bertipe abstract class, objeknya dari subclass konkret
        MantraAbstrak mantra1 = new Expelliarmus();
        MantraAbstrak mantra2 = new ExpectoPatronum();
        MantraAbstrak mantra3 = new Lumos();

        mantra1.ucapkan();
        mantra1.efek();

        mantra2.ucapkan();
        mantra2.efek();

        mantra3.ucapkan();
        mantra3.efek();

        // Baris di bawah ini ERROR
//        MantraAbstrak mantra4 = new MantraAbstrak("Test");
    }
}

/*
    Pertanyaan Abstract Class
    1. Apa yang terjadi jika kita mencoba membuat objek dari MantraAbstrak langsung?
    Coba dan jelaskan errornya.
    Programnya error dan tidak bisa dijalankan. Kalau kita tulis:
    MantraAbstrak mantra4 = new MantraAbstrak("Test");
    muncul pesan error:
    MantraAbstrak is abstract; cannot be instantiated

    Artinya: MantraAbstrak adalah abstract class, jadi tidak boleh dibuat objeknya
    langsung. Alasannya, class ini belum lengkap karena masih punya method efek()
    yang belum ada isinya. Kita tidak tahu apa efek dari "mantra umum". Yang boleh
    dibuat objeknya adalah subclass yang sudah mengisi efek(), misalnya
    Expelliarmus, ExpectoPatronum, atau Lumos.

    2. Mengapa kita perlu membuat abstract class? Apa keuntungannya?
    - Memaksa semua subclass punya method yang wajib ada. Setiap mantra baru harus
      mengisi efek(), jadi tidak ada mantra yang lupa punya efek.
    - Menghemat kode. Hal yang sama untuk semua mantra (atribut nama dan method
      ucapkan()) cukup ditulis sekali di abstract class.
    - Mencegah objek yang tidak masuk akal. "Mantra umum" yang tidak punya efek
      jelas tidak boleh dibuat.
    - Semua mantra bisa diperlakukan lewat satu tipe, yaitu MantraAbstrak, jadi
      gampang dipakai bersama polymorphism.
*/