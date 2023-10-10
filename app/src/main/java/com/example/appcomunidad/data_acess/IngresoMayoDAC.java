package com.example.appcomunidad.data_acess;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import androidx.annotation.Nullable;

import com.example.appcomunidad.framework.AppException;

public class IngresoMayoDAC extends GestorBaseDatos{
    public IngresoMayoDAC(@Nullable Context contexto) {
        super(contexto);
    }
    @Override
    public Cursor leerRegistros() throws AppException {
        consultaSQL = "SELECT IdMesMayo, NombreMes, AñoMes, IdUsuarioCom, NombreJaverIngreso_MA, ApellidoJaverIngreso_MA, CedulaJaverIngreso_MA, SemanaFechaIngreso_MA,"
                + " MasserBaitHaM_MA, RoshJodesh_MA, TerumahYeladim_MA, Terreno_MA, Shuljan_MA, Tzedaqah_MA, Kaparah_MA, Arriendo_MA, TotalSemana_MA "
                + " FROM " + TABLA_INGRESOS_MAYO;
        cursorConsulta = obtenerConsulta(consultaSQL, null);
        if (cursorConsulta != null) {
            Log.i("VerfificarIngresoMA", "Está obteniendo una consulta");
        } else {
            Log.i("VerfificarIngresoMA", "NO está obteniendo una consulta");
        }
        return cursorConsulta;
    }
    @Override
    public Cursor leerPorId(int idUsuarioCom) throws AppException {
        consultaSQL = "SELECT IdMesMayo, NombreMes, AñoMes, IdUsuarioCom, NombreJaverIngreso_MA, ApellidoJaverIngreso_MA, CedulaJaverIngreso_MA, SemanaFechaIngreso_MA,"
                + " MasserBaitHaM_MA, RoshJodesh_MA, TerumahYeladim_MA, Terreno_MA, Shuljan_MA, Tzedaqah_MA, Kaparah_MA, Arriendo_MA, TotalSemana_MA "
                + " FROM " + TABLA_INGRESOS_MAYO
                + " WHERE  IdUsuarioCom= ? ";
        String[] valores = new String[]{String.valueOf(idUsuarioCom)};
        cursorConsulta = obtenerConsulta(consultaSQL, valores);
        if (cursorConsulta != null) {
            Log.i("VerfificarIngresoMA", "Está obteniendo una consulta");
        } else {
            Log.i("VerfificarIngresoMA", "NO está obteniendo una consulta");
        }
        return cursorConsulta;
    }
    public long insertarRegistro(
            String nombreMes,
            String añoMes,
            int idUsuarioCom,
            String nombreJaverIng,
            String apellidoJaverIng,
            String cedulaJaverIng,
            String semanaFechaIngreso,
            String masserBaitHaM,
            String roshJodesh,
            String terumahYeladim,
            String terreno,
            String shuljan,
            String tzedaqah,
            String kaparah,
            String arriendo,
            double totalSemana_MA) {

        valoresContenido = new ContentValues();
        valoresContenido.put("NombreMes",nombreMes);
        valoresContenido.put("AñoMes",añoMes);
        valoresContenido.put("IdUsuarioCom",idUsuarioCom);
        valoresContenido.put("NombreJaverIngreso_MA",nombreJaverIng);
        valoresContenido.put("ApellidoJaverIngreso_MA",apellidoJaverIng);
        valoresContenido.put("CedulaJaverIngreso_MA",cedulaJaverIng);
        valoresContenido.put("SemanaFechaIngreso_MA",semanaFechaIngreso);
        valoresContenido.put("MasserBaitHaM_MA",masserBaitHaM);
        valoresContenido.put("RoshJodesh_MA",roshJodesh);
        valoresContenido.put("TerumahYeladim_MA",terumahYeladim);
        valoresContenido.put("Terreno_MA",terreno);
        valoresContenido.put("Shuljan_MA",shuljan);
        valoresContenido.put("Tzedaqah_MA",tzedaqah);
        valoresContenido.put("Kaparah_MA",kaparah);
        valoresContenido.put("Arriendo_MA",arriendo);
        valoresContenido.put("TotalSemana_MA",totalSemana_MA);
        SQLiteDatabase db= getWritableDatabase();
        if(db !=null){
            Log.i("VerfificarIngresoMA", "Esta ingresando datos en la DB para MAYO");
        }
        return db.insert(TABLA_INGRESOS_MAYO,null,valoresContenido);
    }
}
