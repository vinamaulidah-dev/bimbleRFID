package com.mycompany.absensi.rfid.object;

import com.mongodb.MongoClientSettings;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.MongoCollection;
import org.bson.Document;
import static org.bson.codecs.configuration.CodecRegistries.fromProviders;
import static org.bson.codecs.configuration.CodecRegistries.fromRegistries;
import org.bson.codecs.configuration.CodecRegistry;
import org.bson.codecs.pojo.PojoCodecProvider;

public class MongoManager {
    private static MongoClient mongoClient;
    private static final String DATABASE_NAME = "bimble_rfid";

    /**
     * Mendapatkan koneksi ke database MongoDB dengan dukungan POJO.
     */
    public static MongoDatabase getDatabase() {
        if (mongoClient == null) {
            try {
                // 1. Buat CodecRegistry untuk Pojo (Penerjemah Objek Siswa)
                CodecRegistry pojoCodecRegistry = fromRegistries(
                    MongoClientSettings.getDefaultCodecRegistry(),
                    fromProviders(PojoCodecProvider.builder().automatic(true).build())
                );

                // 2. Konfigurasi Client Settings dengan Codec tersebut
                MongoClientSettings settings = MongoClientSettings.builder()
                    .applyConnectionString(new com.mongodb.ConnectionString("mongodb://localhost:27017"))
                    .codecRegistry(pojoCodecRegistry)
                    .build();

                mongoClient = MongoClients.create(settings);
                System.out.println("Koneksi ke MongoDB berhasil dengan POJO Support!");
            } catch (Exception e) {
                System.err.println("Gagal koneksi ke MongoDB: " + e.getMessage());
            }
        }
        return mongoClient.getDatabase(DATABASE_NAME);
    }

    /**
     * Method untuk mengambil koleksi siswa secara langsung.
     * Digunakan oleh PanelAbsensi untuk mencari data berdasarkan UID.
     */
    public MongoCollection<Document> getCollectionSiswa() {
        return getDatabase().getCollection("siswa");
    }
}