package com.mycompany.absensi.rfid.object;

import com.mongodb.client.model.Filters;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JOptionPane;
import org.bson.conversions.Bson;
import gui.AdminPage; 

public class SiswaService {
    private final GenericDAO<Siswa> DAO;

    public SiswaService() {
        // Menggunakan koleksi "siswa" sesuai data yang ada di MongoDB Compass
        this.DAO = new GenericDAO<>("siswa", Siswa.class);
    }

    public void tambahSiswa(Siswa s) {
        DAO.save(s);
    }
    
    public void updateSiswa(Siswa s) {
        // Update berdasarkan idSiswa sebagai kunci unik
        DAO.update(Filters.eq("idSiswa", s.getIdSiswa()), s);
    }

    public void tampilSiswa(JPanel panelTarget, String key) {
        List<Siswa> daftarSiswa = key.isEmpty() ? DAO.findAll() : cariSiswa(key);
        
        panelTarget.removeAll();
        panelTarget.setLayout(new BorderLayout());

        // Panel utama untuk menampung kartu-kartu (3 kolom)
        JPanel gridPanel = new JPanel(new GridLayout(0, 3, 10, 10));
        gridPanel.setBackground(new Color(68, 114, 196));

        for (Siswa s : daftarSiswa) {
            // Membuat card satuan untuk setiap siswa
            JPanel card = new JPanel(new GridLayout(5, 1, 5, 5));
            card.setBackground(new Color(237, 125, 49)); // Warna Oranye Luxury
            
            card.add(new JLabel(" Nama: " + s.getNamaLengkap()));
            card.add(new JLabel(" ID: " + s.getIdSiswa()));
            card.add(new JLabel(" Kelas: " + s.getDepartemen()));
            
            // --- TOMBOL EDIT ---
            JButton btnEdit = new JButton("Edit");
            btnEdit.setBackground(new Color(255, 193, 7)); // Kuning
            btnEdit.addActionListener(e -> {
                // Mengisi kembali form di AdminPage untuk proses Update
                AdminPage.txtUID.setText(s.getUidRfid());
                AdminPage.txtKRID.setText(s.getIdSiswa());
                AdminPage.txtKRName.setText(s.getNamaLengkap());
                AdminPage.txtKRDept.setSelectedItem(s.getDepartemen());
                
                // Switch mode tombol: Matikan Save, Aktifkan Update
                AdminPage.btnUpdate.setEnabled(true);
                AdminPage.btnSave.setEnabled(false);
                
                // Kunci ID Siswa agar tidak diubah saat update (karena ID adalah filter primary)
                AdminPage.txtKRID.setEditable(false);
            });
            
            // --- TOMBOL HAPUS ---
            JButton btnDel = new JButton("Hapus");
            btnDel.setBackground(new Color(220, 53, 69)); // Merah
            btnDel.setForeground(Color.WHITE);
            btnDel.addActionListener(e -> {
                // Notifikasi konfirmasi sebelum benar-benar menghapus
                int confirm = JOptionPane.showConfirmDialog(
                    null, 
                    "Apakah Anda yakin ingin menghapus data " + s.getNamaLengkap() + "?", 
                    "Konfirmasi Hapus", 
                    JOptionPane.YES_NO_OPTION
                );

                if (confirm == JOptionPane.YES_OPTION) {
                    hapusSiswa(s.getIdSiswa());
                    tampilSiswa(panelTarget, ""); // Refresh tampilan otomatis
                    JOptionPane.showMessageDialog(null, "Data berhasil dihapus!");
                }
            });
            
            card.add(btnEdit);
            card.add(btnDel);
            gridPanel.add(card);
        }
        
        // Memasukkan grid ke panel target (AdminPage)
        panelTarget.add(gridPanel, BorderLayout.NORTH);
        panelTarget.revalidate();
        panelTarget.repaint();
    }

    public List<Siswa> cariSiswa(String key) {
        List<Bson> filters = new ArrayList<>();
        filters.add(Filters.regex("namaLengkap", key, "i"));
        filters.add(Filters.regex("idSiswa", key, "i"));
        filters.add(Filters.regex("departemen", key, "i"));
        
        return DAO.findMany(Filters.or(filters));
    }

    public void hapusSiswa(String id) {
        DAO.delete(Filters.eq("idSiswa", id));
    }
}