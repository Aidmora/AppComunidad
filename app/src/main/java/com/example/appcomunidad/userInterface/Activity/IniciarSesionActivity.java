package com.example.appcomunidad.userInterface.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
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
    private Button botonIniciarSesion2;
    private VerificarDatos verificarDatos;
    private boolean activarHacks = false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_iniciar_sesion);

        inicializarRecursos();
        botonIniciarSesion2.setOnClickListener(this::Siguiente);
    }
    private void inicializarRecursos() {
        ingresarCorreo      = findViewById(R.id.ingresarCorreo);
        ingresarContrasena  = findViewById(R.id.ingresarContrasenia);
        botonRegistrarse    = findViewById(R.id.botonRegistrarse);
        botonIniciarSesion2  = findViewById(R.id.botonSiguiente);
    }
    public void irRegistro(View view) {
        Log.i("irPrincipal","ENTRO AL METODO DEL BOTON DE REGISTRO");
        Intent siguiente = new Intent(this, RegistroDatosActivity.class);
        startActivity(siguiente);
    }
    public void Siguiente(View view){
        Log.i("irPrincipal","ENTRO AL METODO DEL BOTON");
        Intent siguiente = new Intent(this, BarraNavegacionActivity.class);
        Log.i("irPrincipal","esta entrando a validar datos");
        if (!ValidarDatos.campoLleno(this, ingresarCorreo) ||
                !ValidarDatos.campoLleno(this, ingresarContrasena))

            return;
        verificarDatos = new VerificarDatos(this);
        try {
            Log.i("irPrincipal","esta entrando a verificar datos");
            if (!verificarDatos.verificarCuentaUsuario(ingresarCorreo.getText().toString(), ingresarContrasena.getText().toString()))

                return;
        } catch (AppException error) {
            throw new RuntimeException(error);
        }
        Log.i("irPrincipal","si verifico los datos.");
        startActivity(siguiente);
        finish();
    }

}