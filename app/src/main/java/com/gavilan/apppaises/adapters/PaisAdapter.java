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
import com.gavilan.apppaises.sqlite.DbPais;

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
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DbPais dbPais = new DbPais(holder.itemView.getContext());
                Pais pSelected = listaPaises.get(position);
                AlertDialog.Builder alerta = new AlertDialog.Builder(holder.itemView.getContext());
                alerta.setTitle("Eliminando").setMessage("¿Seguro de eliminar a "+pSelected.getNombrePais()+"?");
                alerta.setPositiveButton("Confirmar", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        int r =dbPais.eliminarPais(pSelected);
                        if(r == 1){
                            Toast.makeText(holder.itemView.getContext(), "País eliminado", Toast.LENGTH_SHORT).show();
                            listaPaises = dbPais.getPaises();
                            notifyDataSetChanged();
                        }
                    }
                });
                alerta.setNegativeButton("Cancelar", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {

                    }
                });
                alerta.create();
                alerta.show();

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

            imgContinente.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Toast.makeText(view.getContext(), p.getNombrePais(), Toast.LENGTH_SHORT).show();
                }
            });

        }

    }
}
