package Exception_Handling;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Gaudium
 */
public class ThrowExe {
    public static void main(String args[]) {
        try {
            System.out.println("I'm throwing an exception from here...");
            // Sengaja melempar exception baru
            throw new NullPointerException("throw demo");
        } catch (NullPointerException e) {
            System.out.println("I'm catching an exception: [" + e + "]"
                    + "from here...");
        }
    }
}
