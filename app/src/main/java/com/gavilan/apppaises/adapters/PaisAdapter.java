package com.gavilan.apppaises.adapters;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.recyclerview.widget.RecyclerView;

import com.gavilan.apppaises.EditActivity;
import com.gavilan.apppaises.ListadoActivity;
import com.gavilan.apppaises.R;
import com.gavilan.apppaises.models.Pais;


import java.util.ArrayList;

public class PaisAdapter extends RecyclerView.Adapter<PaisAdapter.ViewHolder>{
    ArrayList<Pais> listaPaises;

    public PaisAdapter(ArrayList<Pais> paises){
        this.listaPaises = paises;
    }

    @NonNull
    @Override
    public PaisAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.
                from(parent.getContext()).
                inflate(R.layout.item_pais,parent,false);
        ViewHolder vholder = new ViewHolder(v);
        return vholder;
    }

    public void eliminarPais( Pais pais, Context context ){
        AlertDialog.Builder alerta = new AlertDialog.Builder(context);
        alerta.setTitle("CUIDADO");
        alerta.setMessage("¿Seguro de eliminar a "+pais.getNombrePais()+"?");
        alerta.setPositiveButton("Confirmar", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                ListadoActivity.arrayList.remove(pais); // borrando de array static
                listaPaises = ListadoActivity.arrayList; // actualizo el arraylocal con los datos
                // del array static
                notifyDataSetChanged();
            }
        });
        alerta.setNegativeButton("Cancelar",null);
        alerta.create();
        alerta.show();
    }

    @Override
    public void onBindViewHolder(@NonNull PaisAdapter.ViewHolder holder, int position) {
        // variables que usaremos
        Context context = holder.itemView.getContext();
        Pais pais = listaPaises.get(position);
        holder.cargar(pais);

        holder.itemView.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
                eliminarPais(pais, context);
                return false;
            }
        });

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Abrir activity nuevo (EditActivity) -> mandar la información del país
                // que se clickeo en el recycler
                Intent intent = new Intent(context, EditActivity.class);
                //intent.putExtra("dato","Hola mundo android");
                //intent.putExtra("dato2","Hola mundo android 2");
                intent.putExtra("objetoPais", pais);
                context.startActivity(intent);
            }
        });




    }

    @Override
    public int getItemCount() {
        return listaPaises.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView imgContinente;
        TextView txtNombrePais, txtNombreContinente;
        View view;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            imgContinente = itemView.findViewById(R.id.imgContinente);
            txtNombrePais = itemView.findViewById(R.id.txtNombrePais);
            txtNombreContinente = itemView.findViewById(R.id.txtNombreContinente);
            view = itemView;


        }

        public void cargar(Pais p){
            txtNombrePais.setText(p.getNombrePais());
            txtNombreContinente.setText(p.getNombreContinente());

            if( p.getNombreContinente().equals("América") ){
                imgContinente.setImageResource(R.drawable.america);
            }
            if( p.getNombreContinente().equals("Asia") ){
                imgContinente.setImageResource(R.drawable.asia);
            }
            if( p.getNombreContinente().equals("África") ){
                imgContinente.setImageResource(R.drawable.africa);
            }
            if( p.getNombreContinente().equals("Oceanía") ){
                imgContinente.setImageResource(R.drawable.australia);
            }
            if( p.getNombreContinente().equals("Europa") ){
                imgContinente.setImageResource(R.drawable.europa);
            }



        }

    }
}
