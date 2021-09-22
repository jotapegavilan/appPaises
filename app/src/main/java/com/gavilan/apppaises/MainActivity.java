package com.gavilan.apppaises;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
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
                    new Intent(MainActivity.this,MainActivity.class);
            startActivity(intent_inicio);
            return true;
        }
        if( item.getItemId() == R.id.menu_formulario ){
            Intent intent_formulario =
                    new Intent(MainActivity.this, FormActivity.class);
            startActivity(intent_formulario);
            return true;
        }
        if( item.getItemId() == R.id.menu_listado){
            Intent intent_listado =
                    new Intent(MainActivity.this, ListadoActivity.class);
            startActivity(intent_listado);
            return true;
        }


        return super.onOptionsItemSelected(item);
    }
}