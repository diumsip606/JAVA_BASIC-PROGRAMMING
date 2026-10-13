/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package enkapsulasi;

/**
 *
 * @author Gaudium
 */
class GetSetDua {
    private int num;

    // Setter dengan validasi
    public void setNumber(int number) {
        if (number < 1 || number > 10) {
            throw new IllegalArgumentException();
        }
        num = number;
    }

    // Getter
    public int getNumber() { 
        return num; 
    }
}

public class MainGetSet2 {
    public static void main(String[] args) {
        GetSetDua obj = new GetSetDua();
        obj.setNumber(5);
        System.out.println(obj.getNumber());
    }
}