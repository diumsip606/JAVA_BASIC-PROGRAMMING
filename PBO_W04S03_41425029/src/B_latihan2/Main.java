/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package B_latihan2;

/**
 *
 * @author Gaudium
 */
public class Main {
    public static void main(String[] args) {
        // Buat lampu dengan kecerahan 80%.
        SmartLamp lampu = new SmartLamp(80);

        // Buat AC dengan suhu 22 derajat.
        SmartAC ac = new SmartAC(22);

        // --- Simulasi sesuai contoh output modul ---
        // 1) Nyalakan lampu, lalu hubungkan ke WiFi (boleh, karena sudah menyala).
        lampu.turnOn();
        lampu.connectToWifi("Rumah_Indah_5G", "192.168.1.50");

        // 2) Nyalakan AC, hubungkan ke WiFi, lalu matikan.
        ac.turnOn();
        ac.connectToWifi("Rumah_Indah_5G", "192.168.1.51");
        ac.turnOff();

        // --- Pengujian TAMBAHAN untuk aturan State (tidak ada di contoh output) ---
        // AC sekarang MATI, jadi percobaan konek WiFi ini harus menampilkan pesan error.
        ac.connectToWifi("Rumah_Indah_5G", "192.168.1.51");

        // Bonus polimorfisme: satu array bertipe interface bisa menampung lampu DAN AC.
        // Lewat array ini hanya method milik Switchable yang bisa dipanggil.
        Switchable[] semuaPerangkat = { lampu, ac };
        for (Switchable perangkat : semuaPerangkat) {
            // Setiap objek menjalankan versi turnOff miliknya sendiri.
            perangkat.turnOff();
        }
    }  
}
