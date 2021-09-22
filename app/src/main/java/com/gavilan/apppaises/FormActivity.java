package com.gavilan.apppaises;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.gavilan.apppaises.models.Pais;
import com.gavilan.apppaises.sqlite.DbPais;

public class FormActivity extends AppCompatActivity {

    EditText txtNombre;
    Spinner spContinentes;
    Button btnGuardar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_form);

        txtNombre = findViewById(R.id.txtNombre);
        spContinentes = findViewById(R.id.spContinentes);
        btnGuardar = findViewById(R.id.btnGuardar);

        btnGuardar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Pais p = new Pais(txtNombre.getText().toString(),
                        spContinentes.getSelectedItem().toString());

                DbPais dbPais = new DbPais(getApplicationContext());
                long id = dbPais.insertarPais(txtNombre.getText().toString(),
                        spContinentes.getSelectedItem().toString());
                if(id > 0)
                Toast.makeText(FormActivity.this, "País registrado!",
                        Toast.LENGTH_SHORT).show();
                else
                    Toast.makeText(FormActivity.this, "Error al registrar",
                            Toast.LENGTH_SHORT).show();

            }
        });
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.mi_menu, menu );
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if( item.getItemId() == R.id.menu_inicio ){
            Intent intent_inicio =
                    new Intent(FormActivity.this,MainActivity.class);
            startActivity(intent_inicio);
            return true;
        }
        if( item.getItemId() == R.id.menu_formulario ){
            Intent intent_formulario =
                    new Intent(FormActivity.this, FormActivity.class);
            startActivity(intent_formulario);
            return true;
        }
        if( item.getItemId() == R.id.menu_listado){
            Intent intent_listado =
                    new Intent(FormActivity.this, ListadoActivity.class);
            startActivity(intent_listado);
            return true;
        }


        return super.onOptionsItemSelected(item);
    }

}