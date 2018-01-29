package com.example.home_pc.cathouse;


import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import com.example.home_pc.cathouse.HotelContract.*;

public class HotelDbHelper extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "hotel.db";

      //Версия базы данных. При изменении схемы увеличить на единицу
    private static final int DATABASE_VERSION = 1;

    public HotelDbHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String SQL_CREATE_GUEST_TABLE = "CREATE TABLE" + GuestEntry.TABLE_NAME + "("
                + GuestEntry._ID + "INTEGER PRIMARY KEY AUTOINCREMENT, "
                + GuestEntry.TABLE_NAME + "TEXT NOT NULL, "
                + GuestEntry.COLUMN_CITY + "TEXT NOT NULL, "
                + GuestEntry.COLUMN_GENDER + "INTEGER NOT NULL DEFAULT 3, "
                + GuestEntry.COLUMN_AGE + "INTEGER INTEGER NOT NULL DEFAULT 0);";
        db.execSQL(SQL_CREATE_GUEST_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
// Запишем в журнал
        Log.w("SQLite", "Обновляемся с версии " + oldVersion + " на версию " + newVersion);

        // Удаляем старую таблицу и создаём новую
        db.execSQL("DROP TABLE IF EXISTS " + GuestEntry.TABLE_NAME );
        // Создаём новую таблицу
        onCreate(db);
    }
}
