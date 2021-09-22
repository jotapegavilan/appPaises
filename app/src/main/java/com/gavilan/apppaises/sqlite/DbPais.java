package com.gavilan.apppaises.sqlite;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import androidx.annotation.Nullable;

import com.gavilan.apppaises.models.Pais;
import com.gavilan.apppaises.models.Usuario;

import java.util.ArrayList;

public class DbPais extends DbHelper {
    Context context;
    public DbPais(@Nullable Context context) {
        super(context);
        this.context = context;
    }

    public long insertarPais(String nombre, String continente){
        DbHelper helper = new DbHelper(context);
        SQLiteDatabase db = helper.getWritableDatabase();

        long id = 0;

        ContentValues values = new ContentValues();
        values.put("nombre",nombre);
        values.put("continente",continente);

        id = db.insert(TABLE_PAISES,null,values);

        return id;
    }

    public ArrayList<Pais> getPaises(){
        DbHelper helper = new DbHelper(context);
        SQLiteDatabase db = helper.getReadableDatabase();
        ArrayList<Pais> paises = new ArrayList<>();
        Cursor cursor = null;
        Pais pais = null;

        cursor = db.rawQuery("SELECT * FROM "+TABLE_PAISES+" order by id DESC",null);

        if(cursor.moveToFirst()){
            do{
                pais = new Pais(
                        cursor.getInt(0),
                        cursor.getString(1),
                        cursor.getString(2)
                );
                paises.add(pais);
            }while (cursor.moveToNext());
        }
        return paises;

    }

    public int eliminarPais(Pais p){
        DbHelper helper = new DbHelper(context);
        SQLiteDatabase db = helper.getWritableDatabase();

        int result = db.delete(TABLE_PAISES,"id=?",new String[]{String.valueOf(p.getId())});
        return result;

    }
}
