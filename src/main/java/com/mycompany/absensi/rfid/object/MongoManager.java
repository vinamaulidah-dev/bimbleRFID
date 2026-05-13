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

    public static MongoDatabase getDatabase() {
        if (mongoClient == null) {
            try {
                CodecRegistry pojoCodecRegistry = fromRegistries(
                    MongoClientSettings.getDefaultCodecRegistry(),
                    fromProviders(PojoCodecProvider.builder().automatic(true).build())
                );

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
     * Method Instance untuk mengambil koleksi SiswaRFID.
     */
    public MongoCollection<Document> getCollectionSiswa() {
        return getDatabase().getCollection("SiswaRFID");
    }

    /**
     * Method Instance untuk mengambil koleksi Absensilog.
     */
    public MongoCollection<Document> getCollectionLog() {
        return getDatabase().getCollection("Absensilog");
    }
}