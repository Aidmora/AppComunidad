package com.example.appcomunidad.data_acess;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import androidx.annotation.Nullable;

import com.example.appcomunidad.framework.AppException;

public class IngresoUsuarioHistorialDAC extends GestorBaseDatos{
    public IngresoUsuarioHistorialDAC(@Nullable Context contexto) {
        super(contexto);
    }

    @Override
    public Cursor leerRegistros() throws AppException {
        consultaSQL = "SELECT IdUsuarioIngresosHistorial, NombreMesIngresos, AñoMesIngreso, NombreJaverIngreso_H, ApellidoJaverIngreso_H, CedulaJaverIngreso_H, SemanaFechaIngreso_H,"
                + " Estado "
                + " FROM " + TABLA_USUARIO_INGRESOS_HISTORIAL;
        cursorConsulta= obtenerConsulta(consultaSQL,null);
        if (cursorConsulta != null) {
            Log.i("VerfificarIngresoUH", "Está obteniendo una consulta");
        } else {
            Log.i("VerfificarIngresoUH", "NO está obteniendo una consulta");
        }
        return cursorConsulta;
    }

    @Override
    public Cursor leerPorId(int idRegistro) throws AppException {
        return null;
    }
    public long insertarRegistro( String nombreMesIngresos, String añoMesIngresos, String nombreJaverIngresos,String apellidoJaverIngresos, String cedulaJaverIngresos,String semanaFechaIngreso) {
        valoresContenido = new ContentValues();
        valoresContenido.put("NombreMesIngresos",nombreMesIngresos);
        valoresContenido.put("AñoMesIngreso",añoMesIngresos);
        valoresContenido.put("NombreJaverIngreso_H",nombreJaverIngresos);
        valoresContenido.put("ApellidoJaverIngreso_H",apellidoJaverIngresos);
        valoresContenido.put("CedulaJaverIngreso_H",cedulaJaverIngresos);
        valoresContenido.put("SemanaFechaIngreso_H",semanaFechaIngreso);
        SQLiteDatabase db= getWritableDatabase();
        if(db!=null){
            Log.i("usuarioHistorial","se inserto con exito.");
        }
        return db.insert(TABLA_USUARIO_INGRESOS_HISTORIAL, null, valoresContenido);
    }

}
