package com.mycompany.absensi.rfid.object;

import com.mongodb.client.MongoCollection;
import java.util.ArrayList;
import java.util.List;
import org.bson.conversions.Bson;

/**
 * GenericDAO yang mendukung MongoDB POJO agar sinkron dengan SiswaService.
 * Pastikan MongoManager sudah menggunakan PojoCodecProvider.
 */
public class GenericDAO<T> {
    private final MongoCollection<T> collection;
    private final Class<T> clazz;

    public GenericDAO(String collectionName, Class<T> clazz) {
        this.clazz = clazz;
        // Mengambil koneksi database dari MongoManager yang sudah mendukung POJO
        this.collection = MongoManager.getDatabase().getCollection(collectionName, clazz);
    }

    /**
     * Menyimpan data baru ke MongoDB.
     * Mengatasi error "Not supported yet".
     */
    public void save(T entity) {
        collection.insertOne(entity);
    }

    /**
     *
     */
    public void update(Bson filter, T entity) {
        collection.replaceOne(filter, entity);
    }

    /**
     * Mencari banyak data berdasarkan filter.
     * Digunakan untuk fitur pencarian real-time (txtCari).
     */
    public List<T> findMany(Bson filter) {
        return collection.find(filter).into(new ArrayList<>());
    }

    /**
     *
     */
    public List<T> findAll() {
        return collection.find().into(new ArrayList<>());
    }

    /**
     * Menghapus data berdasarkan filter.
     * Digunakan oleh tombol Delete/Hapus pada kartu.
     */
    public void delete(Bson filter) {
        collection.deleteOne(filter);
    }
}