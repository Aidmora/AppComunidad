package com.example.appcomunidad.data_acess;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import androidx.annotation.Nullable;

import com.example.appcomunidad.framework.AppException;

public class IngresoNoviembreDAC extends GestorBaseDatos{
    public IngresoNoviembreDAC(@Nullable Context contexto) {
        super(contexto);
    }

    @Override
    public Cursor leerRegistros() throws AppException {
        consultaSQL = "SELECT IdMesNoviembre, NombreMes, AñoMes, IdUsuarioCom, NombreJaverIngreso_N, ApellidoJaverIngreso_N, CedulaJaverIngreso_N, SemanaFechaIngreso_N,"
                + " MasserBaitHaM_N, RoshJodesh_N, TerumahYeladim_N, Terreno_N, Shuljan_N, Tzedaqah_N, Kaparah_N, Arriendo_N, TotalSemana_N "
                + " FROM " + TABLA_INGRESOS_NOVIEMBRE;
        cursorConsulta = obtenerConsulta(consultaSQL, null);
        if (cursorConsulta != null) {
            Log.i("VerfificarIngresoN", "Está obteniendo una consulta");
        } else {
            Log.i("VerfificarIngresoN", "NO está obteniendo una consulta");
        }
        return cursorConsulta;
    }
    @Override
    public Cursor leerPorId(int idUsuarioCom) throws AppException {
        consultaSQL = "SELECT IdMesNoviembre, NombreMes, AñoMes, IdUsuarioCom, NombreJaverIngreso_N, ApellidoJaverIngreso_N, CedulaJaverIngreso_N, SemanaFechaIngreso_N,"
                + " MasserBaitHaM_N, RoshJodesh_N, TerumahYeladim_N, Terreno_N, Shuljan_N, Tzedaqah_N, Kaparah_N, Arriendo_N, TotalSemana_N "
                + " FROM " + TABLA_INGRESOS_NOVIEMBRE
                + " WHERE  IdUsuarioCom= ? ";
        String[] valores = new String[]{String.valueOf(idUsuarioCom)};
        cursorConsulta = obtenerConsulta(consultaSQL, valores);
        if (cursorConsulta != null) {
            Log.i("VerfificarIngresoN", "Está obteniendo una consulta");
        } else {
            Log.i("VerfificarIngresoN", "NO está obteniendo una consulta");
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
            double totalSemana_N) {

        valoresContenido = new ContentValues();
        valoresContenido.put("NombreMes",nombreMes);
        valoresContenido.put("AñoMes",añoMes);
        valoresContenido.put("IdUsuarioCom",idUsuarioCom);
        valoresContenido.put("NombreJaverIngreso_N",nombreJaverIng);
        valoresContenido.put("ApellidoJaverIngreso_N",apellidoJaverIng);
        valoresContenido.put("CedulaJaverIngreso_N",cedulaJaverIng);
        valoresContenido.put("SemanaFechaIngreso_N",semanaFechaIngreso);
        valoresContenido.put("MasserBaitHaM_N",masserBaitHaM);
        valoresContenido.put("RoshJodesh_N",roshJodesh);
        valoresContenido.put("TerumahYeladim_N",terumahYeladim);
        valoresContenido.put("Terreno_N",terreno);
        valoresContenido.put("Shuljan_N",shuljan);
        valoresContenido.put("Tzedaqah_N",tzedaqah);
        valoresContenido.put("Kaparah_N",kaparah);
        valoresContenido.put("Arriendo_N",arriendo);
        valoresContenido.put("TotalSemana_N",totalSemana_N);
        SQLiteDatabase db= getWritableDatabase();
        if(db !=null){
            Log.i("VerfificarIngresoN", "Esta ingresando datos en la DB para NOVIEMBRE");
        }
        return db.insert(TABLA_INGRESOS_NOVIEMBRE,null,valoresContenido);
    }
}
