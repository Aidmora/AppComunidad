package com.example.appcomunidad.BusinessLogic.utilities;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.appcomunidad.BusinessLogic.entities.IngresosUsuarioHistorial;
import com.example.appcomunidad.R;

import java.util.List;

public class AdaptadorHistorialAccionesUsuario extends RecyclerView.Adapter <AdaptadorHistorialAccionesUsuario.UsuarioHistorialViewHolder> implements View.OnClickListener {
    private List<IngresosUsuarioHistorial> ingresosUsuarioHistorialList;
    private LayoutInflater infladorLayout;
    private final Context CONTEXTO;
    private View.OnClickListener listener;

    public AdaptadorHistorialAccionesUsuario(List<IngresosUsuarioHistorial> ingresosUsuarioHistorialList,Context contexto) {
        this.CONTEXTO = contexto;
        this.ingresosUsuarioHistorialList = ingresosUsuarioHistorialList;
        this.infladorLayout = LayoutInflater.from(CONTEXTO);
    }


    @NonNull
    @Override
    public UsuarioHistorialViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= infladorLayout.inflate(R.layout.item_usuario_historial,null,false);
        view.setOnClickListener(this);
        return new UsuarioHistorialViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull UsuarioHistorialViewHolder holder, int position) {
        holder.mesIngresos.setText(ingresosUsuarioHistorialList.get(position).getNombreMesIngresos());
        holder.annoIngresos.setText(ingresosUsuarioHistorialList.get(position).getAñoMesIngresos());
        holder.nombreJaverIngresos.setText(ingresosUsuarioHistorialList.get(position).getNombreJaverIngresos());
        holder.apellidoJaverIngresos.setText(ingresosUsuarioHistorialList.get(position).getApellidJaverIngresos());
        holder.semanaFechaIngresos.setText(ingresosUsuarioHistorialList.get(position).getSemanaFechaIngresos());

    }

    @Override
    public int getItemCount() {
        return ingresosUsuarioHistorialList.size();
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

    public class UsuarioHistorialViewHolder extends RecyclerView.ViewHolder {
        protected TextView nombreJaverIngresos, apellidoJaverIngresos, mesIngresos, annoIngresos, semanaFechaIngresos;
        public UsuarioHistorialViewHolder(@NonNull View itemView) {
            super(itemView);
            nombreJaverIngresos= itemView.findViewById(R.id.usuarioIngresoHistorialNombre);
            apellidoJaverIngresos= itemView.findViewById(R.id.usuarioIngresoHistorialApellido);
            mesIngresos=itemView.findViewById(R.id.mesIngreso);
            annoIngresos= itemView.findViewById(R.id.añoIngreso);
            semanaFechaIngresos= itemView.findViewById(R.id.semanaFechaIngreso);
        }
    }
}
