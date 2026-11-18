/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package Exception_Handling;

/**
 *
 * @author Gaudium
 */

class UncaughtException {
    public static void main(String[] args) {
        System.out.println(3/0);
    }
}

//a. Analisis apa yang akan terjadi ketika program di atas di eksekusi. 
    //Error karena 3 gabisa dibagi 0 jadi 
//b. Apa outputnya? 
//run:
//Exception in thread "main" java.lang.ArithmeticException: / by zero
//	at Exeption_Handling.UncaughtException.main(UncaughtException.java:14)
//C:\Users\Gaudium\AppData\Local\NetBeans\Cache\24\executor-snippets\run.xml:111: The following error occurred while executing this line:
//C:\Users\Gaudium\AppData\Local\NetBeans\Cache\24\executor-snippets\run.xml:68: Java returned: 1
//BUILD FAILED (total time: 0 seconds)