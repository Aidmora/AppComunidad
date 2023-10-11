package com.example.appcomunidad.data_acess;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import androidx.annotation.Nullable;

import com.example.appcomunidad.framework.AppException;

public class IngresoDiciembreDAC extends GestorBaseDatos{
    public IngresoDiciembreDAC(@Nullable Context contexto) {
        super(contexto);
    }
    @Override
    public Cursor leerRegistros() throws AppException {
        consultaSQL = "SELECT IdMesDiciembre, NombreMes, AñoMes, IdUsuarioCom, NombreJaverIngreso_D, ApellidoJaverIngreso_D, CedulaJaverIngreso_D, SemanaFechaIngreso_D,"
                + " MasserBaitHaM_D, RoshJodesh_D, TerumahYeladim_D, Terreno_D, Shuljan_D, Tzedaqah_D, Kaparah_D, Arriendo_D, TotalSemana_D "
                + " FROM " + TABLA_INGRESOS_DICIEMBRE;
        cursorConsulta = obtenerConsulta(consultaSQL, null);
        if (cursorConsulta != null) {
            Log.i("VerfificarIngresoD", "Está obteniendo una consulta");
        } else {
            Log.i("VerfificarIngresoD", "NO está obteniendo una consulta");
        }
        return cursorConsulta;
    }
    @Override
    public Cursor leerPorId(int idUsuarioCom) throws AppException {
        consultaSQL = "SELECT IdMesDiciembre, NombreMes, AñoMes, IdUsuarioCom, NombreJaverIngreso_D, ApellidoJaverIngreso_D, CedulaJaverIngreso_D, SemanaFechaIngreso_D,"
                + " MasserBaitHaM_D, RoshJodesh_D, TerumahYeladim_D, Terreno_D, Shuljan_D, Tzedaqah_D, Kaparah_D, Arriendo_D, TotalSemana_D "
                + " FROM " + TABLA_INGRESOS_DICIEMBRE
                + " WHERE  IdUsuarioCom= ? ";

        String[] valores = new String[]{String.valueOf(idUsuarioCom)};
        cursorConsulta = obtenerConsulta(consultaSQL, valores);
        if (cursorConsulta != null) {
            Log.i("VerfificarIngresoD", "Está obteniendo una consulta");
        } else {
            Log.i("VerfificarIngresoD", "NO está obteniendo una consulta");
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
            double totalSemana_D) {

        valoresContenido = new ContentValues();
        valoresContenido.put("NombreMes",nombreMes);
        valoresContenido.put("AñoMes",añoMes);
        valoresContenido.put("IdUsuarioCom",idUsuarioCom);
        valoresContenido.put("NombreJaverIngreso_D",nombreJaverIng);
        valoresContenido.put("ApellidoJaverIngreso_D",apellidoJaverIng);
        valoresContenido.put("CedulaJaverIngreso_D",cedulaJaverIng);
        valoresContenido.put("SemanaFechaIngreso_D",semanaFechaIngreso);
        valoresContenido.put("MasserBaitHaM_D",masserBaitHaM);
        valoresContenido.put("RoshJodesh_D",roshJodesh);
        valoresContenido.put("TerumahYeladim_D",terumahYeladim);
        valoresContenido.put("Terreno_D",terreno);
        valoresContenido.put("Shuljan_D",shuljan);
        valoresContenido.put("Tzedaqah_D",tzedaqah);
        valoresContenido.put("Kaparah_D",kaparah);
        valoresContenido.put("Arriendo_D",arriendo);
        valoresContenido.put("TotalSemana_D",totalSemana_D);
        SQLiteDatabase db= getWritableDatabase();
        if(db !=null){
            Log.i("VerfificarIngresoD", "Esta ingresando datos en la DB para DICIEMBRE");
        }
        return db.insert(TABLA_INGRESOS_DICIEMBRE,null,valoresContenido);
    }
}
