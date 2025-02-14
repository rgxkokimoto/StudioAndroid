package com.example.androidsqliteroom.model;

import androidx.room.Dao;
import androidx.room.Insert;

@Dao
public interface UserDao {


    // Insertar un nuevo usario en la base de datos SQLite

    @Insert
    void insertRecord(User user);
}
