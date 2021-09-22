package com.gavilan.apppaises;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.gavilan.apppaises.models.Pais;

import java.util.ArrayList;

public class EditActivity extends AppCompatActivity {

    EditText txtNombreEdit;
    Spinner spContinentesEdit;
    Button btnCancelar, btnModificar;
    ArrayList<String> listaContinentes;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit);

        txtNombreEdit = findViewById(R.id.txtNombreEdit);
        spContinentesEdit = findViewById(R.id.spContinentesEdit);
        btnCancelar = findViewById(R.id.btnCancelar);
        btnModificar = findViewById(R.id.btnModificar);

        cargarSpinner();

        // recibir el intento
        Intent intent = getIntent();
        // sacar la info (extras)
        Bundle bundle = intent.getExtras();

        //String dato1 = bundle.getString("dato");
        //String dato2 = bundle.getString("dato2");

        // Obtener el país enviado
        Pais pais = (Pais) bundle.get("objetoPais");
        cargarFormulario(pais);

    }

    public void cargarSpinner(){
        listaContinentes = new ArrayList<>();
        listaContinentes.add("África");
        listaContinentes.add("América");
        listaContinentes.add("Asia");
        listaContinentes.add("Europa");
        listaContinentes.add("Oceanía");

        ArrayAdapter<String> adaptador = new ArrayAdapter<>(this,
                android.R.layout.simple_spinner_dropdown_item,
                listaContinentes);
        spContinentesEdit.setAdapter(adaptador);
    }

    public void cargarFormulario(Pais pais){
        txtNombreEdit.setText(pais.getNombrePais());
        // establecer el spinner en el continente del país
        int index = listaContinentes.indexOf(pais.getNombreContinente());
        spContinentesEdit.setSelection(index);

    }

}