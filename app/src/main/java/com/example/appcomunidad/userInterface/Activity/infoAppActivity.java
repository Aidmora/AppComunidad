package com.example.appcomunidad.userInterface.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.appcomunidad.R;
import com.example.appcomunidad.userInterface.Fragments.PerfilFragment;

public class infoAppActivity extends AppCompatActivity {
    private Button cerrarInfo;
    private static final PerfilFragment perfilf= new PerfilFragment();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info_app);
        inicializarRecursos();
        cerrarInfo.setOnClickListener(this::cerrarInformacion);
    }
    public void inicializarRecursos(){
        cerrarInfo= findViewById(R.id.cerrar_info);
    }
    public void cerrarInformacion(View view){
        Intent intent= new Intent(this, BarraNavegacionActivity.class);
        startActivity(intent);
        finish();

    }
    @Override
    public void onBackPressed() {
    }
}