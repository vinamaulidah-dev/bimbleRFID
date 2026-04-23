
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.absensi.rfid;

// Impor class Penghuni dari package .object
import com.mycompany.absensi.rfid.object.Siswa; 

public class Myapp {

    public static void main(String[] args) {
        // Membuat objek baru dari class Penghuni
        Siswa P = new Siswa();
        
        // Pengecekan tipe objek (instanceof)
        if (P instanceof Siswa) {
            System.out.println("Objek adalah bagian dari class Penghuni");
        } else {
            System.out.println("Tipe objek tidak dikenal");
        }
    }
}
