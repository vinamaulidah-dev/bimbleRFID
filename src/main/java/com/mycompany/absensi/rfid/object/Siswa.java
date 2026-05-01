/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.absensi.rfid.object;

public class Siswa {

    private String uidRfid;
    private String idSiswa;
    private String namaLengkap;
    private String departemen;

    public Siswa() {
    }

    public Siswa(String uidRfid, String idKaryawan, String namaLengkap, String departemen) {
        this.uidRfid = uidRfid;
        this.idSiswa = idKaryawan;
        this.namaLengkap = namaLengkap;
        this.departemen = departemen;
    }

    

    @Override
    public String toString() {
        return "Karyawan{" + 
                "uidRfid=" + uidRfid + 
                ", idKaryawan=" + idSiswa + 
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
        return idSiswa;
    }

    public void setIdSiswa(String idKaryawan) {
        this.idSiswa = idKaryawan;
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