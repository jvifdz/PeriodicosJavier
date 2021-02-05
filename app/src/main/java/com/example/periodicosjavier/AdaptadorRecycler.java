package com.example.periodicosjavier;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class AdaptadorRecycler    extends RecyclerView.Adapter<AdaptadorRecycler.ViewHolder> {

    List<Periodico> misFilas;

    private OnRecyclerViewLongItemClickListener itemLongClickListener;


    public void setOnItemLongClickListener
            (OnRecyclerViewLongItemClickListener listener){
        itemLongClickListener = listener;
    }
    //ha

    public AdaptadorRecycler(List<Periodico> datosEnviados){

        misFilas = datosEnviados;
    }


    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.
                from(parent.getContext()).
                inflate(R.layout.fila,parent,false);
        final ViewHolder viewHolder = new ViewHolder(v);

        //establecer en el layout v que hicimos del recycler el click
        v.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                if (itemLongClickListener!=null){
                    itemLongClickListener.onItemLongClick(
                            v,viewHolder.getAdapterPosition());;
                }
                return true;
            }
        });
        //hasta aqui

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        final int pos = position;
        holder.nombre.setText(misFilas.get(position).getNombre());
        holder.tematica.setText(misFilas.get(position).getTematica());

    }

    @Override
    public int getItemCount() {
        return misFilas.size();
    }


    public static class ViewHolder extends RecyclerView.ViewHolder{


        TextView nombre;
        TextView tematica;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            nombre = itemView.findViewById(R.id.textViewMarca);
            tematica = itemView.findViewById(R.id.textViewTematica);
        }
    }
}
