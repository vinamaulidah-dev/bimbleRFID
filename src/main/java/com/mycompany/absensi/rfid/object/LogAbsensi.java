/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.absensi.rfid.object;

import java.time.LocalDateTime;

/**
 * 
 */
public class LogAbsensi {
    private String idLog;
    private String uidRfid;
    private LocalDateTime waktuTap;
    private String status;

    // Constructor Kosong (Wajib ada untuk framework seperti MongoDB/JSON)
    public LogAbsensi() {
    }

    // Constructor Lengkap
    public LogAbsensi(String idLog, String uidRfid, LocalDateTime waktuTap, String status) {
        this.idLog = idLog;
        this.uidRfid = uidRfid;
        this.waktuTap = waktuTap;
        this.status = status;
    }

    // Method toString untuk memudahkan pengecekan saat print data
    @Override
    public String toString() {
        return "LogAbsensi{" + "idLog=" + idLog + ", uidRfid=" + uidRfid + ", status=" + status + '}';
    }

    // --- Getter dan Setter ---

    public String getIdLog() {
        return idLog;
    }

    public void setIdLog(String idLog) {
        this.idLog = idLog;
    }

    public String getUidRfid() {
        return uidRfid;
    }

    public void setUidRfid(String uidRfid) {
        this.uidRfid = uidRfid;
    }

    public LocalDateTime getWaktuTap() {
        return waktuTap;
    }

    public void setWaktuTap(LocalDateTime waktuTap) {
        this.waktuTap = waktuTap;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
private String namaSiswa;

public String getNamaSiswa() {
    return namaSiswa;
}

public void setNamaSiswa(String namaSiswa) {
    this.namaSiswa = namaSiswa;
}
}