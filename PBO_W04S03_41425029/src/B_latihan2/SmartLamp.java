/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package B_latihan2;

/**
 *
 * @author Gaudium
 */
public class SmartLamp implements Switchable, Connectable {
    // ATRIBUT (semua private = encapsulation) =====
    // Persentase kecerahan lampu (0 - 100).
    private int brightness;

    // STATE (status sakelar): true = menyala, false = mati. Awalnya mati.
    private boolean isOn = false;

    // Constructor: menentukan kecerahan saat lampu dibuat.
    public SmartLamp(int brightness) {
        this.brightness = brightness;
    }

    // ===== dari interface Switchable =====
    @Override
    public void turnOn() {
        // Ubah state menjadi menyala. Ini yang nanti dicek oleh connectToWifi.
        isOn = true;
        System.out.println("[Lampu Pintar] Dinyalakan dengan kecerahan " + brightness + "%");
    }

    @Override
    public void turnOff() {
        // Ubah state menjadi mati.
        isOn = false;
        System.out.println("[Lampu Pintar] Dimatikan.");
    }

    // ===== dari interface Connectable =====
    @Override
    public void connectToWifi(String ssid, String ipAddress) {
        // ATURAN STATE: perangkat yang masih mati tidak boleh terhubung ke WiFi.
        if (!isOn) {
            // ! berarti "tidak": kondisi ini terpenuhi kalau isOn bernilai false (perangkat mati).
            System.out.println("[Lampu Pintar] Error: Perangkat mati! Nyalakan dulu sebelum terhubung ke WiFi.");

            // return menghentikan method, jadi baris koneksi di bawah tidak dijalankan.
            return;
        }

        // Perangkat menyala, koneksi boleh dilakukan.
        System.out.println("[WiFi Device] Terhubung ke jaringan: " + ssid + " (IP: " + ipAddress + ")");
    }    
}
