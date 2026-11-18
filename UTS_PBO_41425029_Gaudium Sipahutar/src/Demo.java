/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Gaudium
 */
public class Demo {
    public static void main(String[] args) {
        Alat[] daftar = {
            new AlatElektronik("E1", "Multimeter", DAYA1),
            new AlatMekanik("M1", "Obeng"),
            new AlatElektronik("E1", "Osiloskop", DAYA2)
        };
        double total  = 0;
        int servis = 0;
        for (Alat a : daftar) {
            total += a.biayaSewa(2);
            if (a instanceof Dapatdiservis) servis++;
        }
        System.out.println("Total 2 hari: " + total);
        System.out.println("Dapat diservis: " + servis);
        Peminjaman p = new Anggota ("11S2600", "Sari", MAXPINJAM);
        try {
            p.pinjam(g, daftar[1], Peminjaman>MAX_HARI + 1);
        }catch (PinjamException e) {
            System.out.println("Gagal: " + e.getMessage());
        }
        try {
            System.out.println("Biaya: " + p.pinjam(g, daftar[0], 2));
        }catch (PinjamException e) {
            System.out.println("Gagal: " + e.getMessage());
        }
    }
}
