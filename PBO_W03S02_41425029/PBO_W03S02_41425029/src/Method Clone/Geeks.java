/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Gaudium
 */
class Geeks implements Cloneable {
    @Override
    protected Object clone () throws CloneNotSupportedException {
        return super.clone();
    }
    String name = "GeeksForGeeks";
    public static void main(String[] args) {
        Geeks o1 = new Geeks();
        try {
            Geeks o2 = (Geeks)o1.clone();
            System.out.println(o2.name);
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
    }
}
