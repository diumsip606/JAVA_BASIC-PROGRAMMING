/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Tugas;

/**
 *
 * @author Gaudium
 */
import java.util.Timer;
import java.util.TimerTask;

public class Reminder {
    private Timer timer;

    public Reminder(int seconds) {
        timer = new Timer();
        // Menjadwalkan RemindTask satu kali, setelah seconds * 1000 milidetik
        timer.schedule(new RemindTask(), seconds * 1000);
    }

    class RemindTask extends TimerTask {
        @Override
        public void run() {
            System.out.println("time's up!");
            timer.cancel(); // Menghentikan thread milik Timer agar program berakhir
        }
    }

    public static void main(String[] args) {
        new Reminder(15);
        System.out.println("Task scheduled.");
    }
}

