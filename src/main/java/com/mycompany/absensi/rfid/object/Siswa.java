/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.absensi.rfid.object;

public class Siswa {

    private String uidRfid;
    private String idKaryawan;
    private String namaLengkap;
    private String departemen;

    public Siswa() {
    }

    public Siswa(String uidRfid, String idKaryawan, String namaLengkap, String departemen) {
        this.uidRfid = uidRfid;
        this.idKaryawan = idKaryawan;
        this.namaLengkap = namaLengkap;
        this.departemen = departemen;
    }

    

    @Override
    public String toString() {
        return "Karyawan{" + 
                "uidRfid=" + uidRfid + 
                ", idKaryawan=" + idKaryawan + 
                ", namaLengkap=" + namaLengkap + 
                ", departemen=" + departemen + '}';
    }

    public String getUidRfid() {
        return uidRfid;
    }

    public void setUidRfid(String uidRfid) {
        this.uidRfid = uidRfid;
    }

    public String getIdSiswa() {
        return idKaryawan;
    }

    public void setIdSiswa(String idKaryawan) {
        this.idKaryawan = idKaryawan;
    }

    public String getNamaLengkap() {
        return namaLengkap;
    }

    public void setNamaLengkap(String namaLengkap) {
        this.namaLengkap = namaLengkap;
    }

    public String getDepartemen() {
        return departemen;
    }

    public void setDepartemen(String departemen) {
        this.departemen = departemen;
    }
    
    

}