package com.gavilan.apppaises.sqlite;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DbHelper extends SQLiteOpenHelper {
    protected static final String DB_NAME = "test";
    protected static  int DB_VERSION = 4;
    protected static final String TABLE_USUARIOS = "usuarios";
    protected static final String TABLE_PAISES = "paises";

    public DbHelper(@Nullable Context context){
        super(context,DB_NAME,null,DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL("CREATE TABLE "+TABLE_USUARIOS+" (" +
                "id INTEGER PRIMARY KEY AUTOINCREMENT," +
                "nombre TEXT NOT NULL," +
                "telefono TEXT NOT NULL," +
                "email TEXT)");
        sqLiteDatabase.execSQL("CREATE TABLE "+TABLE_PAISES+" (" +
                "id INTEGER PRIMARY KEY AUTOINCREMENT," +
                "nombre TEXT NOT NULL," +
                "continente TEXT NOT NULL)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS "+TABLE_USUARIOS);
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS "+TABLE_PAISES);
        onCreate(sqLiteDatabase);
    }
}
