package com.example.appcomunidad.userInterface.Activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

import com.example.appcomunidad.R;

import java.util.Timer;
import java.util.TimerTask;

public class SplashActivity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

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