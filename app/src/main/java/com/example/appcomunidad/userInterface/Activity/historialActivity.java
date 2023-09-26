package com.example.appcomunidad.userInterface.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.appcomunidad.R;

public class historialActivity extends AppCompatActivity {
    private Button cerrarHistorial;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_historial);
        inicializarRecursos();
        cerrarHistorial.setOnClickListener(this::cerrarHistorial);
    }
    public void inicializarRecursos(){
        cerrarHistorial= findViewById(R.id.cerrar_historial);

    }
    public void cerrarHistorial(View view){
        Intent intent= new Intent(this, BarraNavegacionActivity.class);
        startActivity(intent);
        finish();
    }
}