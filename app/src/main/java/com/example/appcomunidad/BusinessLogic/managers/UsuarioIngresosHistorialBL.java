package com.example.appcomunidad.BusinessLogic.managers;

import android.content.Context;

import com.example.appcomunidad.BusinessLogic.entities.IngresosUsuarioHistorial;
import com.example.appcomunidad.data_acess.IngresoUsuarioHistorialDAC;
import com.example.appcomunidad.framework.AppException;

import java.util.ArrayList;
import java.util.List;

public class UsuarioIngresosHistorialBL extends GestorBL{
    private IngresoUsuarioHistorialDAC ingresoUsuarioHistorialDAC;
    private IngresosUsuarioHistorial ingresosUsuarioHistorial;
    /**
     * Construcutos de la clase GestorBL.
     *
     * @param contexto el contexto del activity.
     */
    public UsuarioIngresosHistorialBL(Context contexto) {
        super(contexto);
        ingresoUsuarioHistorialDAC= new IngresoUsuarioHistorialDAC(contexto);
        ingresosUsuarioHistorial = new IngresosUsuarioHistorial();
    }
    public long insertarRegistro(
            String nombreMesIngreso,
            String añoMesIngreso,
            String nombreJaverIngreso,
            String apellidoJaverIngreso,
            String cedulaJaverIngreso,
            String semanaFechaIngreso) {
        return ingresoUsuarioHistorialDAC.insertarRegistro(nombreMesIngreso,añoMesIngreso,nombreJaverIngreso,apellidoJaverIngreso,cedulaJaverIngreso,semanaFechaIngreso);
    }
    public List<IngresosUsuarioHistorial> leerTodosRegistros() throws AppException {
        List<IngresosUsuarioHistorial> listaUsuarioHistorialIng= new ArrayList<>();
        cursorConsulta= ingresoUsuarioHistorialDAC.leerRegistros();
        if(cursorConsulta.moveToFirst()){
            do {
                ingresosUsuarioHistorial= new IngresosUsuarioHistorial();
                ingresosUsuarioHistorial.setIdUsuarioHistorial(cursorConsulta.getInt(0));
                ingresosUsuarioHistorial.setNombreMesIngresos(cursorConsulta.getString(1));
                ingresosUsuarioHistorial.setAñoMesIngresos(cursorConsulta.getString(2));
                ingresosUsuarioHistorial.setNombreJaverIngresos(cursorConsulta.getString(3));
                ingresosUsuarioHistorial.setApellidJaverIngresos(cursorConsulta.getString(4));
                ingresosUsuarioHistorial.setCedulaJaverIngresos(cursorConsulta.getString(5));
                ingresosUsuarioHistorial.setSemanaFechaIngresos(cursorConsulta.getString(6));

                listaUsuarioHistorialIng.add(ingresosUsuarioHistorial);
            }while(cursorConsulta.moveToNext());
        }
        cursorConsulta.close();
        return listaUsuarioHistorialIng;
    }
}
