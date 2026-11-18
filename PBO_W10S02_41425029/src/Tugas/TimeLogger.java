/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Tugas;

/**
 *
 * @author Gaudium
 */
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

public class TimeLogger {

    public static void main(String[] args) {
        System.out.println("Program started");

        Timer timer = new Timer();

        TimerTask task = new TimerTask() {
            private int count = 0;

            @Override
            public void run() {
                System.out.println("Time started at:" + new Date());
                try {
                    Thread.sleep(5000); // selisih 5 detik antara mulai dan selesai
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
                System.out.println("Time finished at:" + new Date());

                count++;
                if (count == 3) {
                    timer.cancel();
                    System.out.println("Program cancelled");
                }
            }
        };

        // Mulai langsung (delay 0), diulang setiap 10 detik
        timer.scheduleAtFixedRate(task, 0, 10000);
    }
}