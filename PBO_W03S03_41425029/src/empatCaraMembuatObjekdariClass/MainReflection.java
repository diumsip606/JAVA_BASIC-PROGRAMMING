/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package empatCaraMembuatObjekdariClass;

/**
 *
 * @author Gaudium
 * 
 */

// Ini Menggunakan Reflection
class Student {
    int id;
    String n;
    
    // Default constructor (wajib ada untuk Reflection)
    public Student() {
        this.id = 654;
        this.n = "Budiman";
    }
    
    // Constructor dengan parameter
    public Student(int id, String n) {
        this.id = id;
        this.n = n;
    }
    
    @Override
    public String toString() {
        return "Student[ID=" + id + ", Nama=" + n + "]";
    }
}

public class MainReflection {
    public static void main(String[] args) {
        try {
            Class<?> c = Class.forName("empatCaraMembuatObjekdariClass.Student");
            
            // Casting yang benar: menggunakan (Student), bukan (MainReflection)
            Student s2 = (Student) c.getDeclaredConstructor().newInstance();
            
            System.out.println("Object created: " + s2);
            
        } catch (ClassNotFoundException e) {
            System.err.println("Class not found!");
        } catch (NoSuchMethodException e) {
            System.err.println("No default constructor!");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }   
}