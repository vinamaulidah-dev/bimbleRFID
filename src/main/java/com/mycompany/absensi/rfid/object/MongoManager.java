/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.absensi.rfid.object;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoDatabase;


public class MongoManager {
    private static MongoClient mongoClient;
    private static final String DATABASE_NAME = "bimble_rfid";

    public static MongoDatabase getDatabase() {
        if (mongoClient == null) {
            try {
                // Menggunakan koneksi default untuk MongoDB lokal
                mongoClient = MongoClients.create("mongodb://localhost:27017");
                System.out.println("Koneksi ke MongoDB berhasil!");
            } catch (Exception e) {
                System.err.println("Gagal koneksi ke MongoDB: " + e.getMessage());
            }
        }
        return mongoClient.getDatabase(DATABASE_NAME);
    }
} 

