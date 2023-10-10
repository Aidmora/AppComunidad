package com.example.appcomunidad.data_acess;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import androidx.annotation.Nullable;

import com.example.appcomunidad.framework.AppException;

public class IngresoMarzoDAC extends GestorBaseDatos{
    public IngresoMarzoDAC(@Nullable Context contexto) {
        super(contexto);
    }
    @Override
    public Cursor leerRegistros() throws AppException {
        consultaSQL = "SELECT IdMesMarzo, NombreMes, AñoMes, IdUsuarioCom, NombreJaverIngreso_M, ApellidoJaverIngreso_M, CedulaJaverIngreso_M, SemanaFechaIngreso_M,"
                + " MasserBaitHaM_M, RoshJodesh_M, TerumahYeladim_M, Terreno_M, Shuljan_M, Tzedaqah_M, Kaparah_M, Arriendo_M, TotalSemana_M "
                + " FROM " + TABLA_INGRESOS_MARZO;
        cursorConsulta = obtenerConsulta(consultaSQL, null);
        if (cursorConsulta != null) {
            Log.i("VerfificarIngresoM", "Está obteniendo una consulta");
        } else {
            Log.i("VerfificarIngresoM", "NO está obteniendo una consulta");
        }
        return cursorConsulta;
    }
    @Override
    public Cursor leerPorId(int idUsuarioCom) throws AppException {
        consultaSQL = "SELECT IdMesMarzo, NombreMes, AñoMes, IdUsuarioCom, NombreJaverIngreso_M, ApellidoJaverIngreso_M, CedulaJaverIngreso_M, SemanaFechaIngreso_M,"
                + " MasserBaitHaM_M, RoshJodesh_M, TerumahYeladim_M, Terreno_M, Shuljan_M, Tzedaqah_M, Kaparah_M, Arriendo_M, TotalSemana_M "
                + " FROM " + TABLA_INGRESOS_MARZO
                + " WHERE  IdUsuarioCom= ? ";
        String[] valores = new String[]{String.valueOf(idUsuarioCom)};
        cursorConsulta = obtenerConsulta(consultaSQL, valores);
        if (cursorConsulta != null) {
            Log.i("VerfificarIngresoM", "Está obteniendo una consulta");
        } else {
            Log.i("VerfificarIngresoM", "NO está obteniendo una consulta");
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
            double totalSemana_M) {

        valoresContenido = new ContentValues();
        valoresContenido.put("NombreMes",nombreMes);
        valoresContenido.put("AñoMes",añoMes);
        valoresContenido.put("IdUsuarioCom",idUsuarioCom);
        valoresContenido.put("NombreJaverIngreso_M",nombreJaverIng);
        valoresContenido.put("ApellidoJaverIngreso_M",apellidoJaverIng);
        valoresContenido.put("CedulaJaverIngreso_M",cedulaJaverIng);
        valoresContenido.put("SemanaFechaIngreso_M",semanaFechaIngreso);
        valoresContenido.put("MasserBaitHaM_M",masserBaitHaM);
        valoresContenido.put("RoshJodesh_M",roshJodesh);
        valoresContenido.put("TerumahYeladim_M",terumahYeladim);
        valoresContenido.put("Terreno_M",terreno);
        valoresContenido.put("Shuljan_M",shuljan);
        valoresContenido.put("Tzedaqah_M",tzedaqah);
        valoresContenido.put("Kaparah_M",kaparah);
        valoresContenido.put("Arriendo_M",arriendo);
        valoresContenido.put("TotalSemana_M",totalSemana_M);
        SQLiteDatabase db= getWritableDatabase();
        if(db !=null){
            Log.i("VerfificarIngresoM", "Esta ingresando datos en la DB para MARZO");
        }
        return db.insert(TABLA_INGRESOS_MARZO,null,valoresContenido);
    }
}
