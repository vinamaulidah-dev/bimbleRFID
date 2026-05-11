
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.absensi.rfid;

// Import ini penting agar Myapp bisa memanggil LoginForm yang ada di package gui
import gui.LoginForm;

public class Myapp {

    public static void main(String[] args) {
        javax.swing.JFrame frame = new javax.swing.JFrame();
frame.add(new gui.PanelAbsensi());
frame.setSize(800, 600);
frame.setVisible(true);
        // Memanggil LoginForm agar muncul saat pertama kali aplikasi dijalankan
        java.awt.EventQueue.invokeLater(() -> {
            new LoginForm().setVisible(true);
        });
    }
}
