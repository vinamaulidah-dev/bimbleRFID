package com.mycompany.absensi.rfid.object;

import org.bson.codecs.pojo.annotations.BsonId;
import org.bson.types.ObjectId;

public class Siswa {
    @BsonId
    private ObjectId id; // Ini ID internal MongoDB (PENTING agar permanen)
    private String uidRfid;
    private String idSiswa;
    private String namaLengkap;
    private String departemen;

    // WAJIB: Constructor kosong
    public Siswa() {}

    // Getter dan Setter untuk id (PENTING)
    public ObjectId getId() { return id; }
    public void setId(ObjectId id) { this.id = id; }

    public String getUidRfid() { return uidRfid; }
    public void setUidRfid(String uidRfid) { this.uidRfid = uidRfid; }

    public String getIdSiswa() { return idSiswa; }
    public void setIdSiswa(String idSiswa) { this.idSiswa = idSiswa; }

    public String getNamaLengkap() { return namaLengkap; }
    public void setNamaLengkap(String namaLengkap) { this.namaLengkap = namaLengkap; }

    public String getDepartemen() { return departemen; }
    public void setDepartemen(String departemen) { this.departemen = departemen; }

}