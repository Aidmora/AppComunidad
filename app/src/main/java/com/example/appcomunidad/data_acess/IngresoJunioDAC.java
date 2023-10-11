package com.example.appcomunidad.data_acess;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import androidx.annotation.Nullable;

import com.example.appcomunidad.framework.AppException;

public class IngresoJunioDAC extends GestorBaseDatos{
    public IngresoJunioDAC(@Nullable Context contexto) {
        super(contexto);
    }

    @Override
    public Cursor leerRegistros() throws AppException {
        consultaSQL = "SELECT IdMesJunio, NombreMes, AñoMes, IdUsuarioCom, NombreJaverIngreso_J, ApellidoJaverIngreso_J, CedulaJaverIngreso_J, SemanaFechaIngreso_J,"
                + " MasserBaitHaM_J, RoshJodesh_J, TerumahYeladim_J, Terreno_J, Shuljan_J, Tzedaqah_J, Kaparah_J, Arriendo_J, TotalSemana_J "
                + " FROM " + TABLA_INGRESOS_JUNIO;
        cursorConsulta = obtenerConsulta(consultaSQL, null);
        if (cursorConsulta != null) {
            Log.i("VerfificarIngresoJ", "Está obteniendo una consulta");
        } else {
            Log.i("VerfificarIngresoJ", "NO está obteniendo una consulta");
        }
        return cursorConsulta;
    }
    @Override
    public Cursor leerPorId(int idUsuarioCom) throws AppException {
        consultaSQL = "SELECT IdMesJunio, NombreMes, AñoMes, IdUsuarioCom, NombreJaverIngreso_J, ApellidoJaverIngreso_J, CedulaJaverIngreso_J, SemanaFechaIngreso_J,"
                + " MasserBaitHaM_J, RoshJodesh_J, TerumahYeladim_J, Terreno_J, Shuljan_J, Tzedaqah_J, Kaparah_J, Arriendo_J, TotalSemana_J "
                + " FROM " + TABLA_INGRESOS_JUNIO
                + " WHERE  IdUsuarioCom= ? ";
        String[] valores = new String[]{String.valueOf(idUsuarioCom)};
        cursorConsulta = obtenerConsulta(consultaSQL, valores);
        if (cursorConsulta != null) {
            Log.i("VerfificarIngresoJ", "Está obteniendo una consulta");
        } else {
            Log.i("VerfificarIngresoJ", "NO está obteniendo una consulta");
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
            double totalSemana_J) {

        valoresContenido = new ContentValues();
        valoresContenido.put("NombreMes",nombreMes);
        valoresContenido.put("AñoMes",añoMes);
        valoresContenido.put("IdUsuarioCom",idUsuarioCom);
        valoresContenido.put("NombreJaverIngreso_J",nombreJaverIng);
        valoresContenido.put("ApellidoJaverIngreso_J",apellidoJaverIng);
        valoresContenido.put("CedulaJaverIngreso_J",cedulaJaverIng);
        valoresContenido.put("SemanaFechaIngreso_J",semanaFechaIngreso);
        valoresContenido.put("MasserBaitHaM_J",masserBaitHaM);
        valoresContenido.put("RoshJodesh_J",roshJodesh);
        valoresContenido.put("TerumahYeladim_J",terumahYeladim);
        valoresContenido.put("Terreno_J",terreno);
        valoresContenido.put("Shuljan_J",shuljan);
        valoresContenido.put("Tzedaqah_J",tzedaqah);
        valoresContenido.put("Kaparah_J",kaparah);
        valoresContenido.put("Arriendo_J",arriendo);
        valoresContenido.put("TotalSemana_J",totalSemana_J);
        SQLiteDatabase db= getWritableDatabase();
        if(db !=null){
            Log.i("VerfificarIngresoJ", "Esta ingresando datos en la DB para JUNIO");
        }
        return db.insert(TABLA_INGRESOS_JUNIO,null,valoresContenido);
    }
}
