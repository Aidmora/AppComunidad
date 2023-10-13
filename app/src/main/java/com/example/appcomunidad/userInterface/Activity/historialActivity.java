package com.example.appcomunidad.userInterface.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.appcomunidad.BusinessLogic.entities.IngresosUsuarioHistorial;
import com.example.appcomunidad.BusinessLogic.managers.UsuarioIngresosHistorialBL;
import com.example.appcomunidad.BusinessLogic.utilities.AdaptadorHistorialAccionesUsuario;
import com.example.appcomunidad.R;
import com.example.appcomunidad.framework.AppException;

import java.util.ArrayList;
import java.util.List;

public class historialActivity extends AppCompatActivity {
    private Button cerrarHistorial;
    RecyclerView usuarioHistorialRC;
    private UsuarioIngresosHistorialBL usuarioIngresosHistorialBL;
    private List<IngresosUsuarioHistorial> ingresosUsuarioHistorialList= new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_historial);
        inicializarRecursos();
        try {
            ingresosUsuarioHistorialList= usuarioIngresosHistorialBL.leerTodosRegistros();
        } catch (AppException e) {
            throw new RuntimeException(e);
        }
        usuarioHistorialRC= findViewById(R.id.recycler_usuarioHistorial);
        usuarioHistorialRC.setLayoutManager(new LinearLayoutManager(this));
        AdaptadorHistorialAccionesUsuario adaptadorHistorialAccionesUsuario= new AdaptadorHistorialAccionesUsuario(ingresosUsuarioHistorialList,this);
        adaptadorHistorialAccionesUsuario.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
        usuarioHistorialRC.setAdapter(adaptadorHistorialAccionesUsuario);
    }
    public void inicializarRecursos(){
        usuarioIngresosHistorialBL= new UsuarioIngresosHistorialBL(this);

    }
    public void onBackPressed() {
        Intent intent = new Intent(this, BarraNavegacionActivity.class);
        startActivity(intent);
    }
}