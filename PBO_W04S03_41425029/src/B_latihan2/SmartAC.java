/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package B_latihan2;

/**
 *
 * @author Gaudium
 */
public class SmartAC implements Switchable, Connectable {
    // ===== ATRIBUT (private) =====
    // Derajat suhu dalam Celsius.
    private int temperature;

    // STATE sakelar: awalnya mati.
    private boolean isOn = false;

    // Constructor: menentukan suhu AC.
    public SmartAC(int temperature) {
        this.temperature = temperature;
    }

    // ===== dari interface Switchable =====
    @Override
    public void turnOn() {
        // Ubah state menjadi menyala.
        isOn = true;
        System.out.println("[AC Pintar] Dinyalakan pada suhu " + temperature + " C");
    }

    @Override
    public void turnOff() {
        // Ubah state menjadi mati.
        isOn = false;
        System.out.println("[AC Pintar] Dimatikan.");
    }

    // ===== dari interface Connectable =====
    @Override
    public void connectToWifi(String ssid, String ipAddress) {
        // ATURAN STATE: AC yang mati tidak boleh terhubung ke WiFi.
        if (!isOn) {
            System.out.println("[AC Pintar] Error: Perangkat mati! Nyalakan dulu sebelum terhubung ke WiFi.");
            return;
        }

        // AC menyala, koneksi boleh dilakukan.
        System.out.println("[WiFi Device] Terhubung ke jaringan: " + ssid + " (IP: " + ipAddress + ")");
    }   
}
