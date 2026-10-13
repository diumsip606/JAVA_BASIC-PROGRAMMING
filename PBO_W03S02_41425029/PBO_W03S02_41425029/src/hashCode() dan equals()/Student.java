/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Gaudium
 */
public class Student {
    int roll;
    
    @Override
    public int hashCode () {
        return roll;
    }
    
    @Override
    public boolean equals (Object o) {
        if (o instanceof Student) {
            return this.roll == ((Student) o).roll;
        }
        return false;
    }
    
    public static void main(String[] args) {
        Student s1 = new Student();
        s1.roll = 101;
        Student s2 = new Student();
        s2.roll = 101;
        
        System.out.println("HashCode s1: "+ s1.hashCode());
        System.out.println("s1.equals(s2): "+ s1.equals(s2));
    }
}
