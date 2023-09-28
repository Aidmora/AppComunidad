package com.example.appcomunidad.userInterface.Activity;

import android.os.Bundle;
import android.view.MenuItem;


import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.example.appcomunidad.R;
import com.example.appcomunidad.userInterface.Fragments.MagenFragment;
import com.example.appcomunidad.userInterface.Fragments.PerfilFragment;
import com.example.appcomunidad.userInterface.Fragments.UsuarioComunidadFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;


/**
 * Esta es ventana que tiene la barra de navegacion.
 */
public class BarraNavegacionActivity extends AppCompatActivity {
    private static final PerfilFragment perfilf= new PerfilFragment();
    private  static final MagenFragment magenF= new MagenFragment();
    private static final UsuarioComunidadFragment usuarioComF= new UsuarioComunidadFragment();
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

        cargarFragmento(magenF);
        inicializarRecursos();

    }

    /**
     * inicializarRecursos: Se encarga de inicar la barra de navegacion y el item de la barra seleccionado.
     */
    private void inicializarRecursos() {
        bn = findViewById(R.id.barraNavegacion);
        bn.setOnItemSelectedListener(itemSeleccionado);
    }
    private final NavigationBarView.OnItemSelectedListener itemSeleccionado = new NavigationBarView.OnItemSelectedListener() {
        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem itemSelect) {
            if (itemSelect.getItemId() == R.id.perfil) {
                cargarFragmento(perfilf);
            }else if(itemSelect.getItemId()== R.id.magen){
                cargarFragmento(magenF);
            }else if(itemSelect.getItemId()== R.id.usuarioComunidad){
                cargarFragmento(usuarioComF);
            }
            return true;
        }
    };
    private void cargarFragmento( Fragment fragment){
        FragmentTransaction transaccion = getSupportFragmentManager().beginTransaction();
        transaccion.replace(R.id.fragmento_contenedor,fragment);
        transaccion.commit();
    }
    @Override
    public void onBackPressed() {
    }
}