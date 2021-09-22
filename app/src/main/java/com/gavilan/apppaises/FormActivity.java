package com.gavilan.apppaises;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.gavilan.apppaises.models.Pais;

import java.util.ArrayList;


public class FormActivity extends AppCompatActivity {

    EditText txtNombre;
    Spinner spContinentes;
    Button btnGuardar;

    ArrayList<String> arrayContinentes;

    // método para cargar el Spinner
    public void cargarSpinner(){
        arrayContinentes = new ArrayList<>();
        arrayContinentes.add("Seleccione un continente");
        arrayContinentes.add("África");
        arrayContinentes.add("América");
        arrayContinentes.add("Asia");
        arrayContinentes.add("Europa");
        arrayContinentes.add("Oceanía");

        // crear un adaptador para el Spinner
        ArrayAdapter<String> adaptador =
                new ArrayAdapter<>(this,
                        android.R.layout.simple_spinner_dropdown_item,
                        arrayContinentes);
        spContinentes.setAdapter( adaptador );

    }

    // crear un método que contenga un Toast
    public void imprimir(String mensaje){
        Toast.makeText(this, mensaje, Toast.LENGTH_LONG).show();
    }

    public void agregarPaís(){
        // aplicar validaciones

        String nombre = txtNombre.getText().toString();
        String continente = spContinentes.getSelectedItem().toString();

        for( Pais pais : ListadoActivity.arrayList ){
            // Chile - chile == chile
            if( pais.getNombrePais().toLowerCase().equals(nombre.toLowerCase()) ){
                imprimir(nombre+" ya existe!");
                return;
            }
        }

        // validación nombre vacío
        if( nombre.length() == 0 ){
            txtNombre.setError("El nombre es obligatorio");
            return;
        }
        // validación de continente válido
        if( spContinentes.getSelectedItemPosition() == 0  ) {
            imprimir("Selecciona un continente válido");
            return;
        }
        // se ejecutará solo si no hay errores
        Pais p = new Pais(nombre,continente);
        ListadoActivity.arrayList.add(p);
        imprimir(nombre+" registrado correctamente");
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_form);

        txtNombre = findViewById(R.id.txtNombre);
        spContinentes = findViewById(R.id.spContinentes);
        btnGuardar = findViewById(R.id.btnGuardar);

        cargarSpinner();

        btnGuardar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                agregarPaís();
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