package com.example.appcomunidad.userInterface.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.appcomunidad.BusinessLogic.entities.Usuario;
import com.example.appcomunidad.BusinessLogic.managers.RegistroSesionBL;
import com.example.appcomunidad.BusinessLogic.managers.UsuarioBL;
import com.example.appcomunidad.BusinessLogic.managers.UsuarioRolBL;
import com.example.appcomunidad.BusinessLogic.utilities.ValidarDatos;
import com.example.appcomunidad.R;
import com.example.appcomunidad.framework.AppException;

public class ActualizarDatosActivity extends AppCompatActivity {
    private EditText
            nombreUsuarioAc,
            correoUsuarioAc,
            celularUsuarioAc;
    private Button guardarInfo;
    private Usuario usuarioActivo;
    private UsuarioBL usuarioBL;
    private RegistroSesionBL registroSesionBL;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_actualizar_datos);
        try {
            inicializarRecursos();
        } catch (AppException e) {
            throw new RuntimeException(e);
        }

        guardarInfo.setOnClickListener(view -> {
            try {
                guardarInfo(view);
            } catch (AppException e) {
                throw new RuntimeException(e);
            }
        });
    }
    private void inicializarRecursos() throws AppException, AppException {
        usuarioBL           = new UsuarioBL(this);
        registroSesionBL    = new RegistroSesionBL(this);
        usuarioActivo= new Usuario();

        nombreUsuarioAc     = findViewById(R.id.ingreso_nom_Usuario2);
        correoUsuarioAc     = findViewById(R.id.correo_usuario2);
        celularUsuarioAc    = findViewById(R.id.celular_usuario2);
        guardarInfo         = findViewById(R.id.guardar_Datos_button);

        nombreUsuarioAc.setText(usuarioActivo.getNombre());
        correoUsuarioAc.setText(usuarioActivo.getCorreo());
        celularUsuarioAc.setText(usuarioActivo.getCelular());

    }
    private void guardarInfo(View view) throws AppException {
        usuarioBL           = new UsuarioBL(this);
        registroSesionBL    = new RegistroSesionBL(this);

        if (!ValidarDatos.campoLleno(this, nombreUsuarioAc) ||
                !ValidarDatos.campoLleno(this, correoUsuarioAc) ||
                !ValidarDatos.campoLleno(this, celularUsuarioAc))
            return;

        if (!ValidarDatos.longitudTextoMaxMin(this, nombreUsuarioAc, "El nombre", 3, 25) ||
                !ValidarDatos.validarCorreo(this,correoUsuarioAc ) ||
                !ValidarDatos.longitudCelular(this, celularUsuarioAc, 10))
            return;
        Log.i("establecerDatos","esta entrando a obtener el usuario activo");
        int idUsuario         = registroSesionBL.obtenerIdUsuarioConectado();
        usuarioActivo         = usuarioBL.obtenerPorId(idUsuario);
        Log.i("establecerDatos","Obtuvo el usuario activo");
        String nombreUsuario  = nombreUsuarioAc.getText().toString();
        String correoUsuario  = correoUsuarioAc.getText().toString();
        String celularUsuario = celularUsuarioAc.getText().toString();
        Log.i("establecerDatos","Entrando a actualizar registro");
        usuarioBL.actualizarRegistro(usuarioActivo.getIdRol(), nombreUsuario, correoUsuario, celularUsuario);
        Toast.makeText(this, "Datos actualizados con éxito", Toast.LENGTH_SHORT).show();

        finish();
        onBackPressed();
    }
    public void onBackPressed() {
        Intent intent = new Intent(this, BarraNavegacionActivity.class);
        startActivity(intent);
    }
}