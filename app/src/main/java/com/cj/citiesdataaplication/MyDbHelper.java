package com.cj.citiesdataaplication;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import java.util.ArrayList;

public class MyDbHelper extends SQLiteOpenHelper {

    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "cities.db";

    public MyDbHelper(@Nullable Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table city (id INTEGER PRIMARY KEY, nombre TEXT, poblacion INTEGER, latitud REAL, longitud REAL)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("drop table if exists city");
        onCreate(db);
    }

    public void insertCity(SQLiteDatabase db, City city) {
        ContentValues values = new ContentValues();
        values.put("id", city.getId());
        values.put("nombre", city.getNombre());
        values.put("poblacion", city.getPoblacion());
        values.put("latitud", city.getLatitud());
        values.put("longitud", city.getLongitud());

        db.insert("city", null, values);
    }

    public ArrayList<City> selectCity(SQLiteDatabase db) {
        ArrayList<City> cities = new ArrayList<City>();
        Cursor filas = db.rawQuery("select * from city", null);
        if (filas.moveToFirst()) {
            do {
                City city = new City(filas.getInt(0), filas.getString(1), filas.getInt(2),
                        filas.getDouble(3),filas.getDouble(4));
                cities.add(city);
            } while (filas.moveToNext());
        }
        return cities;
    }
}
