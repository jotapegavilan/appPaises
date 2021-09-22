package com.gavilan.apppaises.adapters;

import android.content.DialogInterface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.recyclerview.widget.RecyclerView;

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

    @Override
    public void onBindViewHolder(@NonNull PaisAdapter.ViewHolder holder, int position) {
        holder.cargar(listaPaises.get(position));

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
