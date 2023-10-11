package com.example.appcomunidad.data_acess;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import androidx.annotation.Nullable;

import com.example.appcomunidad.framework.AppException;

public class IngresoAgostoDAC extends GestorBaseDatos{
    public IngresoAgostoDAC(@Nullable Context contexto) {
        super(contexto);
    }

    @Override
    public Cursor leerRegistros() throws AppException {
        consultaSQL = "SELECT IdMesAgosto, NombreMes, AñoMes, IdUsuarioCom, NombreJaverIngreso_AG, ApellidoJaverIngreso_AG, CedulaJaverIngreso_AG, SemanaFechaIngreso_AG,"
                + " MasserBaitHaM_AG, RoshJodesh_AG, TerumahYeladim_AG, Terreno_AG, Shuljan_AG, Tzedaqah_AG, Kaparah_AG, Arriendo_AG, TotalSemana_AG "
                + " FROM " + TABLA_INGRESOS_AGOSTO;
        cursorConsulta = obtenerConsulta(consultaSQL, null);
        if (cursorConsulta != null) {
            Log.i("VerfificarIngresoAG", "Está obteniendo una consulta");
        } else {
            Log.i("VerfificarIngresoAG", "NO está obteniendo una consulta");
        }
        return cursorConsulta;
    }
    @Override
    public Cursor leerPorId(int idUsuarioCom) throws AppException {
        consultaSQL = "SELECT IdMesAgosto, NombreMes, AñoMes, IdUsuarioCom, NombreJaverIngreso_AG, ApellidoJaverIngreso_AG, CedulaJaverIngreso_AG, SemanaFechaIngreso_AG,"
                + " MasserBaitHaM_AG, RoshJodesh_AG, TerumahYeladim_AG, Terreno_AG, Shuljan_AG, Tzedaqah_AG, Kaparah_AG, Arriendo_AG, TotalSemana_AG "
                + " FROM " + TABLA_INGRESOS_AGOSTO
                + " WHERE  IdUsuarioCom= ? ";
        String[] valores = new String[]{String.valueOf(idUsuarioCom)};
        cursorConsulta = obtenerConsulta(consultaSQL, valores);
        if (cursorConsulta != null) {
            Log.i("VerfificarIngresoAG", "Está obteniendo una consulta");
        } else {
            Log.i("VerfificarIngresoAG", "NO está obteniendo una consulta");
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
            double totalSemana_AG) {

        valoresContenido = new ContentValues();
        valoresContenido.put("NombreMes",nombreMes);
        valoresContenido.put("AñoMes",añoMes);
        valoresContenido.put("IdUsuarioCom",idUsuarioCom);
        valoresContenido.put("NombreJaverIngreso_AG",nombreJaverIng);
        valoresContenido.put("ApellidoJaverIngreso_AG",apellidoJaverIng);
        valoresContenido.put("CedulaJaverIngreso_AG",cedulaJaverIng);
        valoresContenido.put("SemanaFechaIngreso_AG",semanaFechaIngreso);
        valoresContenido.put("MasserBaitHaM_AG",masserBaitHaM);
        valoresContenido.put("RoshJodesh_AG",roshJodesh);
        valoresContenido.put("TerumahYeladim_AG",terumahYeladim);
        valoresContenido.put("Terreno_AG",terreno);
        valoresContenido.put("Shuljan_AG",shuljan);
        valoresContenido.put("Tzedaqah_AG",tzedaqah);
        valoresContenido.put("Kaparah_AG",kaparah);
        valoresContenido.put("Arriendo_AG",arriendo);
        valoresContenido.put("TotalSemana_AG",totalSemana_AG);
        SQLiteDatabase db= getWritableDatabase();
        if(db !=null){
            Log.i("VerfificarIngresoAG", "Esta ingresando datos en la DB para AGOSTO");
        }
        return db.insert(TABLA_INGRESOS_AGOSTO,null,valoresContenido);
    }
}
