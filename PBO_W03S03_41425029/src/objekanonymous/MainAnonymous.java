/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package objekanonymous;

/**
 *
 * @author Gaudium
 */
// Mengimpor library JavaFX
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

// Class utama harus mewarisi (extends) Application dari JavaFX
public class MainAnonymous extends Application {
    
    public static void main(String[] args) { 
        launch(args); // Memulai aplikasi JavaFX
    }

    @Override 
    public void start(Stage stage) {
        Button button = new Button("Click Me");
        
        // 1. ANONYMOUS OBJECT (Menggunakan Lambda Expression)
        // Kita tidak membuat variabel khusus untuk menangkap aksi tombol, 
        // melainkan langsung mendefinisikannya di dalam parameter.
        button.setOnAction(
            event -> System.out.println("Button clicked!") 
        ); 
        
        StackPane root = new StackPane(button);
        
        // 2. ANONYMOUS OBJECT (Membuat objek langsung di dalam parameter)
        // Kita membuat "new Scene(root, 300, 200)" langsung di dalam pemanggilan fungsi,
        // tanpa menyimpannya ke variabel seperti "Scene s = new Scene(...)"
        stage.setScene(new Scene(root, 300, 200));
        
        stage.show();
    }
}