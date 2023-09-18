package com.example.appcomunidad.userInterface.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.appcomunidad.BusinessLogic.utilities.ValidarDatos;
import com.example.appcomunidad.BusinessLogic.utilities.VerificarDatos;
import com.example.appcomunidad.R;
import com.example.appcomunidad.framework.AppException;

public class IniciarSesionActivity extends AppCompatActivity {
    private EditText ingresarCorreo;
    private EditText ingresarContrasena;
    private Button botonRegistrarse;
    private Button botonIniciarSesion;
    private VerificarDatos verificarDatos;
    private boolean activarHacks = false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_iniciar_sesion);

        inicializarRecursos();

        botonRegistrarse.setOnClickListener(this::irRegistro);
    }
    private void inicializarRecursos() {
        ingresarCorreo      = findViewById(R.id.ingresarCorreo);
        ingresarContrasena  = findViewById(R.id.ingresarContrasenia);
        botonRegistrarse    = findViewById(R.id.botonRegistrarse);
        botonIniciarSesion  = findViewById(R.id.botonIniciarSesion);
    }
    private void irRegistro(View view) {
        Intent siguiente = new Intent(this, RegistroDatosActivity.class);
        startActivity(siguiente);
    }

}