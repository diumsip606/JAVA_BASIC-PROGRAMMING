/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package enkapsulasi;

/**
 *
 * @author Gaudium
 */
class GetSetSatu {
    private String name;

    // Getter
    public String getName() { 
        return name; 
    }

    // Setter
    public void setName(String N) {
        this.name = N;
    }
}

public class MainGetSet1 {
    public static void main(String[] args) {
        GetSetSatu obj = new GetSetSatu();
        obj.setName("Geeks for Geeks");
        System.out.println(obj.getName());
    }
}