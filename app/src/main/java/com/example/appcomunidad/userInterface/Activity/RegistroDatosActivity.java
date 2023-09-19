package com.example.appcomunidad.userInterface.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.appcomunidad.BusinessLogic.managers.UsuarioBL;
import com.example.appcomunidad.BusinessLogic.utilities.ValidarDatos;
import com.example.appcomunidad.BusinessLogic.utilities.VerificarDatos;
import com.example.appcomunidad.R;

public class RegistroDatosActivity extends AppCompatActivity {
    private Button
            botonIniciarSesion,
            botonRegistrarse;
    private EditText
            ingresarNombre,
            ingresarCorreo,
            ingresarCelular,
            ingresarContrasenia,
            confirmarContrasenia;
    private VerificarDatos verificarDatos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro);
        inicializarRecursos();
        botonIniciarSesion.setOnClickListener(this::irIniciarSesion);
        botonRegistrarse.setOnClickListener(this::irPrincipal);
    }
    private void inicializarRecursos() {
        botonIniciarSesion      = findViewById(R.id.botonIniciarSesion);
        botonRegistrarse        = findViewById(R.id.botonRegistrarse);
        ingresarNombre          = findViewById(R.id.ingresarNombreCompleto);
        ingresarCorreo          = findViewById(R.id.ingresarCorreo);
        ingresarCelular         = findViewById(R.id.ingresarNumeroCelular);
        ingresarContrasenia     = findViewById(R.id.ingresarContrasenia);
        confirmarContrasenia    = findViewById(R.id.ingresarConfirmarContrasenia);
        verificarDatos          = new VerificarDatos(this);
    }
    private void irIniciarSesion(View vista) {
        onBackPressed();
    }
    private void irPrincipal(View view){
        if (!ValidarDatos.campoLleno(this, ingresarNombre) ||
                !ValidarDatos.campoLleno(this, ingresarCorreo) ||
                !ValidarDatos.campoLleno(this, ingresarCelular) ||
                !ValidarDatos.campoLleno(this, ingresarContrasenia) ||
                !ValidarDatos.campoLleno(this, confirmarContrasenia))
            return;

        if (!ValidarDatos.longitudTextoMaxMin(this, ingresarNombre, "El nombre", 3, 25) ||
                !ValidarDatos.validarCorreo(this, ingresarCorreo) ||
                !ValidarDatos.longitudCelular(this, ingresarCelular, 10) ||
                !ValidarDatos.longitudTextoMaxMin(this, ingresarContrasenia, "La contraseña", 5, 15) ||
                !ValidarDatos.confirmarContrasenia(this, ingresarContrasenia, confirmarContrasenia))
            return;
        Intent intent= new Intent(this, IniciarSesionActivity.class);
        UsuarioBL usuarioBL = new UsuarioBL(this);
        long idUsuario = usuarioBL.ingresarRegistro(1,ingresarNombre.getText().toString(),
                         ingresarCorreo.getText().toString(),
                         ingresarCelular.getText().toString());
        Log.i("RegistroDatosActivity","Esta retornando algun valor"+idUsuario+"");
        if(idUsuario>0){
            Toast.makeText(this, "Cuenta creada", Toast.LENGTH_SHORT).show();
            finish();
            startActivity(intent);

        }else{
            Toast.makeText(this, "Usuario ya registrado", Toast.LENGTH_SHORT).show();
        }
    }
}