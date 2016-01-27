package com.example.jose.eduticnow;

import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

/**
 * Created by Jose on 26/01/2016.
 */
public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder>{

    List<Foto> fotografias;

    RecyclerViewAdapter(List<Foto> fotos){
        this.fotografias = fotos;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder{
        CardView myCardVew;
        TextView textdescripcion;
        ImageView fotos;

        ViewHolder(View itemView){
            super(itemView);
            myCardVew = (CardView)itemView.findViewById(R.id.myrecycler);
            textdescripcion = (TextView)itemView.findViewById(R.id.textDescription);
            fotos = (ImageView)itemView.findViewById(R.id.imgFoto);
        }
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item,parent, false);
        ViewHolder pvh = new ViewHolder(v);
        return pvh;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.textdescripcion.setText(fotografias.get(position).descripcion);
        holder.fotos.setImageResource(fotografias.get(position).idFoto);
    }

    @Override
    public int getItemCount() {
        return fotografias.size();
    }
}
