package com.example.appcomunidad.data_acess;

import android.content.Context;
import android.database.Cursor;
import android.util.Log;

import androidx.annotation.Nullable;

import com.example.appcomunidad.framework.AppException;

public class UsuarioRolDAC  extends  GestorBaseDatos{
    public UsuarioRolDAC(@Nullable Context contexto) {
        super(contexto);
    }

    @Override
    public Cursor leerRegistros() throws AppException {
        consultaSQL=" SELECT IdRol, Nombre, Estado, FechaRegistro, FechaModificacion "
                    +" FROM "+ TABLA_USUARIO_ROL
                    +" WHERE Estado= '1' ";
        cursorConsulta=obtenerConsulta(consultaSQL,null);

        if(cursorConsulta!= null){
            Log.i("leerRegistros - USUARIO ROL DAC", "Si esta retornando la consulta");
        }
        return cursorConsulta;
    }

    @Override
    public Cursor leerPorId(int idRol) throws AppException {
        consultaSQL=" SELECT  IdRol, Nombre, Estado, FechaRegistro, FechaModificacion "
                +" FROM "+ TABLA_USUARIO_ROL
                +" WHERE Estado = '1' "
                +" AND IdRol = ? ";
        String [] valorId= new String[] {String.valueOf(idRol)};
        return obtenerConsulta(consultaSQL,valorId);
    }
}
