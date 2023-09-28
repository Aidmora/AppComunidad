package com.example.appcomunidad.BusinessLogic.utilities;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.appcomunidad.R;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.appcomunidad.BusinessLogic.entities.UsuarioComunidad;

import java.util.List;

public class AdaptadorUsuarioComunidad extends RecyclerView.Adapter<AdaptadorUsuarioComunidad.UsuarioComunidadViewHolder>{
    List<UsuarioComunidad> listaUsuarioComunidad;
    private LayoutInflater infladorLayout;
    private final Context CONTEXTO;
    public AdaptadorUsuarioComunidad(List<UsuarioComunidad> listaUsuarioComunidad, Context contexto) {
        this.CONTEXTO = contexto;
        this.listaUsuarioComunidad = listaUsuarioComunidad;
        this.infladorLayout = LayoutInflater.from(CONTEXTO);

    }
    
    @NonNull
    @Override
    public UsuarioComunidadViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= infladorLayout.inflate(R.layout.item_usuario_comunidad,null,false);
        return new UsuarioComunidadViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull UsuarioComunidadViewHolder holder, int position) {
        holder.nombreJaver.setText(listaUsuarioComunidad.get(position).getNombreJaver());
        holder.apellidoJaver.setText(listaUsuarioComunidad.get(position).getApellidoJaver());
        holder.celularJaver.setText(listaUsuarioComunidad.get(position).getCelularJaver());
        holder.correoJaver.setText(listaUsuarioComunidad.get(position).getCorreoJaver());
        holder.cedulaJaver.setText(listaUsuarioComunidad.get(position).getCedula());
        holder.estadoCJaver.setText(listaUsuarioComunidad.get(position).getEstadoCivil());
        int imagenResource = CONTEXTO.getResources().getIdentifier(listaUsuarioComunidad.get(position).getFotoJaver(), "drawable", CONTEXTO.getPackageName());
        holder.fotoJaver.setImageResource(imagenResource);
    }

    @Override
    public int getItemCount() {
        return listaUsuarioComunidad.size();
    }

    public class UsuarioComunidadViewHolder extends RecyclerView.ViewHolder {
        TextView nombreJaver, apellidoJaver, celularJaver, correoJaver, cedulaJaver,estadoCJaver;
        ImageView fotoJaver;
        public UsuarioComunidadViewHolder(@NonNull View itemView) {
            super(itemView);
            nombreJaver=itemView.findViewById(R.id.nombre_javer);
            apellidoJaver=itemView.findViewById(R.id.apellido_javer);
            celularJaver=itemView.findViewById(R.id.celular_javer);
            correoJaver=itemView.findViewById(R.id.correo_javer);
            cedulaJaver=itemView.findViewById(R.id.cedula_javer);
            estadoCJaver=itemView.findViewById(R.id.estadoC_javer);
            fotoJaver= itemView.findViewById(R.id.foto_javer);
        }
    }
}
