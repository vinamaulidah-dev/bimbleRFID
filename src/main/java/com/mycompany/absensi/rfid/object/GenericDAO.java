package com.mycompany.absensi.rfid.object;

import java.util.ArrayList;
import java.util.List;

public class GenericDAO<T> implements BaseDAO<T> {
    // TIGA BARIS INI WAJIB ADA AGAR TIDAK ERROR
    private final String collectionName;
    private final Class<T> clazz; 
    private List<T> dataList = new ArrayList<>();

    // CONSTRUCTOR INI JUGA WAJIB ADA
    public GenericDAO(String collectionName, Class<T> clazz) {
        this.collectionName = collectionName;
        this.clazz = clazz;
    }

    @Override
    public void save(T entity) {
        dataList.add(entity);
        // Baris di bawah ini menggunakan clazz dan collectionName
        System.out.println("Menyimpan objek tipe: " + clazz.getSimpleName() + 
                           " ke koleksi: " + collectionName);
    }

    @Override
    public void update(int index, T entity) {
        if (index >= 0 && index < dataList.size()) {
            dataList.set(index, entity);
        }
    }

    @Override
    public void delete(int index) {
        if (index >= 0 && index < dataList.size()) {
            dataList.remove(index);
        }
    }

    @Override
    public List<T> findAll() {
        return dataList;
    }

    @Override
    public T findByIndex(int index) {
        if (index >= 0 && index < dataList.size()) {
            return dataList.get(index);
        }
        return null;
    }
}