package com.example.appcomunidad.BusinessLogic.utilities;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.appcomunidad.R;
import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.appcomunidad.BusinessLogic.entities.UsuarioComunidad;
import com.example.appcomunidad.userInterface.Activity.usuarioComunidadPagoDetalle;

import java.io.Serializable;
import java.util.List;

public class AdaptadorUsuarioComunidad extends RecyclerView.Adapter<AdaptadorUsuarioComunidad.UsuarioComunidadViewHolder> implements View.OnClickListener {
    List<UsuarioComunidad> listaUsuarioComunidad;
    private LayoutInflater infladorLayout;
    private final Context CONTEXTO;
    private View.OnClickListener listener;
    public AdaptadorUsuarioComunidad(List<UsuarioComunidad> listaUsuarioComunidad, Context contexto) {
        this.CONTEXTO = contexto;
        this.listaUsuarioComunidad = listaUsuarioComunidad;
        this.infladorLayout = LayoutInflater.from(CONTEXTO);

    }

    @NonNull
    @Override
    public UsuarioComunidadViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= infladorLayout.inflate(R.layout.item_usuario_comunidad,null,false);
        view.setOnClickListener(this);
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
        holder.infoUsuarioCom.setOnClickListener(view -> seleccionarUsuarioComunidad(listaUsuarioComunidad.get(position)));
    }

    @Override
    public int getItemCount() {
        return listaUsuarioComunidad.size();
    }
    public void seleccionarUsuarioComunidad(UsuarioComunidad usuarioComunidad){
        Intent intent= new Intent(CONTEXTO, usuarioComunidadPagoDetalle.class);
        intent.putExtra("usuarioCom_seleccionado",  usuarioComunidad);
        CONTEXTO.startActivity(intent);
    }
    public void setOnClickListener(View.OnClickListener listener){
        this.listener=listener;
    }
    @Override
    public void onClick(View view) {
        if(listener!=null){
            listener.onClick(view);
        }
    }

    public class UsuarioComunidadViewHolder extends RecyclerView.ViewHolder {
        protected TextView nombreJaver, apellidoJaver, celularJaver, correoJaver, cedulaJaver,estadoCJaver;
        protected ImageView fotoJaver;
        protected ImageButton infoUsuarioCom;
        protected CardView tarjetaUsuarioComunidad;
        public UsuarioComunidadViewHolder(@NonNull View itemView) {
            super(itemView);
            nombreJaver=itemView.findViewById(R.id.nombre_javer);
            apellidoJaver=itemView.findViewById(R.id.apellido_javer);
            celularJaver=itemView.findViewById(R.id.celular_javer);
            correoJaver=itemView.findViewById(R.id.correo_javer);
            cedulaJaver=itemView.findViewById(R.id.cedula_javer);
            estadoCJaver=itemView.findViewById(R.id.estadoC_javer);
            fotoJaver= itemView.findViewById(R.id.foto_javer);
            tarjetaUsuarioComunidad=itemView.findViewById(R.id.perfil_javer2);
            infoUsuarioCom= itemView.findViewById(R.id.foto_siguiente);

        }
    }
}
