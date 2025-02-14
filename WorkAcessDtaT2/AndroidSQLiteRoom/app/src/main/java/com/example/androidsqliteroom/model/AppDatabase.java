package com.example.androidsqliteroom.model;

import androidx.room.Database;
import androidx.room.RoomDatabase;

@Database(entities = {User.class}, version = 1) // En caso de cambiar tablas se debe aumentar la version
public abstract class AppDatabase extends RoomDatabase {

    public abstract UserDao userDao();

}
