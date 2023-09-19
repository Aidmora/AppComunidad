package com.example.appcomunidad.userInterface.Activity;

import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;

import com.example.appcomunidad.R;
import com.example.appcomunidad.data_acess.GestorBaseDatos;
import com.example.appcomunidad.framework.AppException;

import java.util.Timer;
import java.util.TimerTask;

public class SplashActivity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        GestorBaseDatos gestorBD = new GestorBaseDatos(this) {
            @Override
            public Cursor leerRegistros() throws AppException {
                return null;
            }

            @Override
            public Cursor leerPorId(int idRegistro) throws AppException {
                return null;
            }
        };
        gestorBD.abrirBaseDatos();
        TimerTask mostrarSplash = new TimerTask() {
            @Override
            public void run() {
                Intent intent= new Intent(SplashActivity.this, IniciarSesionActivity.class);
                startActivity(intent);
                finish();

            }
        };

        Timer tiempo= new Timer();
        tiempo.schedule(mostrarSplash,3000);
    }
}