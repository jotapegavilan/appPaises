package com.gavilan.apppaises.sqlite;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import androidx.annotation.Nullable;

import com.gavilan.apppaises.models.Usuario;

import java.util.ArrayList;

public class DbUsuarios extends DbHelper {
    Context context;
    public DbUsuarios(@Nullable Context context) {
        super(context);
        this.context = context;
    }

    public long insertarUsuario(String nombre, String telefono, String email){
        DbHelper helper = new DbHelper(context);
        SQLiteDatabase db = helper.getWritableDatabase();

        long id = 0;

        ContentValues values = new ContentValues();
        values.put("nombre",nombre);
        values.put("telefono",telefono);
        values.put("email",email);

        id = db.insert(TABLE_USUARIOS,null,values);

        return id;
    }

    public ArrayList<Usuario> getUsuarios(){
        DbHelper helper = new DbHelper(context);
        SQLiteDatabase db = helper.getReadableDatabase();
        ArrayList<Usuario> usuarios = new ArrayList<>();
        Cursor cursor = null;
        Usuario usuario = null;

        cursor = db.rawQuery("SELECT * FROM "+TABLE_USUARIOS,null);

        if(cursor.moveToFirst()){
            do{
                usuario = new Usuario(
                        cursor.getInt(0),
                        cursor.getString(1),
                        cursor.getString(2),
                        cursor.getString(3)
                );
                usuarios.add(usuario);
            }while (cursor.moveToNext());
        }
        return usuarios;

    }
}
