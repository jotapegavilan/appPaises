package com.gavilan.apppaises;

import androidx.appcompat.app.AppCompatActivity;

import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.gavilan.apppaises.sqlite.DbHelper;
import com.gavilan.apppaises.sqlite.DbUsuarios;

public class MainActivity2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
    }

    public void crearbase(View v){
        DbUsuarios usuarios = new DbUsuarios(this);
        long id = usuarios.insertarUsuario("Alan","+56925251414","jasojas@gmail.com");
        if(id > 0){
            Toast.makeText(this, "Usuario insertado", Toast.LENGTH_SHORT).show();
        }else{
            Toast.makeText(this, "Error al insertar", Toast.LENGTH_SHORT).show();
        }

    }

    public void getLargo(View v){
        int largo = new DbUsuarios(this).getUsuarios().size();
        Toast.makeText(this, "Existen "+largo+" registros.", Toast.LENGTH_SHORT).show();
    }
}