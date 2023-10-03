package com.example.appcomunidad.userInterface.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.appcomunidad.BusinessLogic.entities.UsuarioComunidad;
import com.example.appcomunidad.R;

public class usuarioComunidadPagoDetalle extends AppCompatActivity {
    private ImageView fotoJaverInfor;
    private TextView nombreJaverInfo, apellidoJaverInfo;
    private UsuarioComunidad usuarioComunidad;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_usuario_comunidad_pago_detalle);
        inicializarRecuros();
        establecerDatos();
    }
    public void inicializarRecuros(){
        usuarioComunidad= new UsuarioComunidad();
        fotoJaverInfor= findViewById(R.id.foto_javerInfo);
        nombreJaverInfo=findViewById(R.id.nombre_javerInfo);
        apellidoJaverInfo=findViewById(R.id.apellido_javerInfo);
    }
    public void establecerDatos(){
        usuarioComunidad=(UsuarioComunidad) getIntent().getSerializableExtra("usuarioCom_seleccionado");
        int imagenResource = this.getResources().getIdentifier(usuarioComunidad.getFotoJaver(), "drawable", this.getPackageName());
        fotoJaverInfor.setImageResource(imagenResource);
        nombreJaverInfo.setText(usuarioComunidad.getNombreJaver());
        apellidoJaverInfo.setText(usuarioComunidad.getApellidoJaver());

    }
}