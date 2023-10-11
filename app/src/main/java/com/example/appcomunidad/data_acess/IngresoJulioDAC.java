package com.example.appcomunidad.data_acess;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import androidx.annotation.Nullable;

import com.example.appcomunidad.framework.AppException;

public class IngresoJulioDAC extends GestorBaseDatos{
    public IngresoJulioDAC(@Nullable Context contexto) {
        super(contexto);
    }


    @Override
    public Cursor leerRegistros() throws AppException {
        consultaSQL = "SELECT IdMesJulio, NombreMes, AñoMes, IdUsuarioCom, NombreJaverIngreso_JU, ApellidoJaverIngreso_JU, CedulaJaverIngreso_JU, SemanaFechaIngreso_JU,"
                + " MasserBaitHaM_JU, RoshJodesh_JU, TerumahYeladim_JU, Terreno_JU, Shuljan_JU, Tzedaqah_JU, Kaparah_JU, Arriendo_JU, TotalSemana_JU "
                + " FROM " + TABLA_INGRESOS_JULIO;
        cursorConsulta = obtenerConsulta(consultaSQL, null);
        if (cursorConsulta != null) {
            Log.i("VerfificarIngresoJU", "Está obteniendo una consulta");
        } else {
            Log.i("VerfificarIngresoJU", "NO está obteniendo una consulta");
        }
        return cursorConsulta;
    }
    @Override
    public Cursor leerPorId(int idUsuarioCom) throws AppException {
        consultaSQL = "SELECT IdMesJulio, NombreMes, AñoMes, IdUsuarioCom, NombreJaverIngreso_JU, ApellidoJaverIngreso_JU, CedulaJaverIngreso_JU, SemanaFechaIngreso_JU,"
                + " MasserBaitHaM_JU, RoshJodesh_JU, TerumahYeladim_JU, Terreno_JU, Shuljan_JU, Tzedaqah_JU, Kaparah_JU, Arriendo_JU, TotalSemana_JU "
                + " FROM " + TABLA_INGRESOS_JULIO
                + " WHERE  IdUsuarioCom= ? ";
        String[] valores = new String[]{String.valueOf(idUsuarioCom)};
        cursorConsulta = obtenerConsulta(consultaSQL, valores);
        if (cursorConsulta != null) {
            Log.i("VerfificarIngresoJU", "Está obteniendo una consulta");
        } else {
            Log.i("VerfificarIngresoJU", "NO está obteniendo una consulta");
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
            double totalSemana_JU) {

        valoresContenido = new ContentValues();
        valoresContenido.put("NombreMes",nombreMes);
        valoresContenido.put("AñoMes",añoMes);
        valoresContenido.put("IdUsuarioCom",idUsuarioCom);
        valoresContenido.put("NombreJaverIngreso_JU",nombreJaverIng);
        valoresContenido.put("ApellidoJaverIngreso_JU",apellidoJaverIng);
        valoresContenido.put("CedulaJaverIngreso_JU",cedulaJaverIng);
        valoresContenido.put("SemanaFechaIngreso_JU",semanaFechaIngreso);
        valoresContenido.put("MasserBaitHaM_JU",masserBaitHaM);
        valoresContenido.put("RoshJodesh_JU",roshJodesh);
        valoresContenido.put("TerumahYeladim_JU",terumahYeladim);
        valoresContenido.put("Terreno_JU",terreno);
        valoresContenido.put("Shuljan_JU",shuljan);
        valoresContenido.put("Tzedaqah_JU",tzedaqah);
        valoresContenido.put("Kaparah_JU",kaparah);
        valoresContenido.put("Arriendo_JU",arriendo);
        valoresContenido.put("TotalSemana_JU",totalSemana_JU);
        SQLiteDatabase db= getWritableDatabase();
        if(db !=null){
            Log.i("VerfificarIngresoJU", "Esta ingresando datos en la DB para JULIO");
        }
        return db.insert(TABLA_INGRESOS_JULIO,null,valoresContenido);
    }
}
