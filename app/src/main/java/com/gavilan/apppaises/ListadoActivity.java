package com.gavilan.apppaises;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

import com.gavilan.apppaises.adapters.PaisAdapter;
import com.gavilan.apppaises.models.Pais;

import java.util.ArrayList;

public class ListadoActivity extends AppCompatActivity {

    RecyclerView recyclerPaises;
    public static ArrayList<Pais> arrayList = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listado);

        recyclerPaises = findViewById(R.id.recyclerPaises);

        recyclerPaises.
                setLayoutManager(new LinearLayoutManager(ListadoActivity.this));


        arrayList.add(new Pais("Chile","América"));
        arrayList.add(new Pais("España","Europa"));
        arrayList.add(new Pais("China","Asia"));
        arrayList.add(new Pais("Australia","Oceanía"));
        arrayList.add(new Pais("Egipto","África"));

        recyclerPaises.setAdapter(new PaisAdapter(arrayList));


    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.mi_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == R.id.menu_inicio) {
            Intent intent_inicio =
                    new Intent(ListadoActivity.this, MainActivity.class);
            startActivity(intent_inicio);
            return true;
        }
        if (item.getItemId() == R.id.menu_formulario) {
            Intent intent_formulario =
                    new Intent(ListadoActivity.this, FormActivity.class);
            startActivity(intent_formulario);
            return true;
        }
        if (item.getItemId() == R.id.menu_listado) {
            Intent intent_listado =
                    new Intent(ListadoActivity.this, ListadoActivity.class);
            startActivity(intent_listado);
            return true;
        }


        return super.onOptionsItemSelected(item);
    }
}

