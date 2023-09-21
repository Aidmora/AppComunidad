package com.example.appcomunidad.userInterface.Activity;

import android.os.Bundle;
import android.view.MenuItem;


import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import com.example.appcomunidad.R;
import com.google.android.material.bottomnavigation.BottomNavigationView;


/**
 * Esta es ventana que tiene la barra de navegacion.
 */
public class BarraNavegacionActivity extends AppCompatActivity {

    static BottomNavigationView bn;
    FragmentManager gestorFragmento;
    Fragment fragmentoActual;

    /**
     * onCreate: Se encarga se crear la ventana o activity.
     * @param savedInstanceState
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_barra_navegacion);


        inicializarRecursos();

    }

    /**
     * inicializarRecursos: Se encarga de inicar la barra de navegacion y el item de la barra seleccionado.
     */
    private void inicializarRecursos() {
        bn = findViewById(R.id.barraNavegacion);
    }

}