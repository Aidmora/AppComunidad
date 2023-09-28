package com.example.appcomunidad.userInterface.Activity;

import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.util.Log;

import com.example.appcomunidad.BusinessLogic.entities.RegistroSesion;
import com.example.appcomunidad.BusinessLogic.managers.RegistroSesionBL;
import com.example.appcomunidad.R;
import com.example.appcomunidad.data_acess.GestorBaseDatos;
import com.example.appcomunidad.framework.AppException;

import java.util.Timer;
import java.util.TimerTask;

public class SplashActivity extends Activity {
    private RegistroSesionBL registroSesionBL;
    private RegistroSesion registroSesion;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        TimerTask mostrarSplash = new TimerTask() {
            @Override
            public void run() {
                registroSesionBL = new RegistroSesionBL(SplashActivity.this);
                registroSesion = new RegistroSesion();
                Intent intent;
                try {

                    registroSesion = registroSesionBL.obtenerRegistroConectado();
                    if(registroSesion != null ) {
                        intent= new Intent( SplashActivity.this, BarraNavegacionActivity.class);
                        finish();
                    }else {
                        intent= new Intent( SplashActivity.this, IniciarSesionActivity.class);
                        finish();
                    }
                    startActivity(intent);
                } catch (Exception e) {
                    Log.i("AppException","catch error");
                }
            }
        };
        Timer tiempo= new Timer();
        tiempo.schedule(mostrarSplash,3000);
    }
}