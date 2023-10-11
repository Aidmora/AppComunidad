package com.example.appcomunidad.data_acess;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import androidx.annotation.Nullable;

import com.example.appcomunidad.framework.AppException;

public class IngresoSeptiembreDAC extends GestorBaseDatos{
    public IngresoSeptiembreDAC(@Nullable Context contexto) {
        super(contexto);
    }

    @Override
    public Cursor leerRegistros() throws AppException {
        consultaSQL = "SELECT IdMesSeptiembre, NombreMes, AñoMes, IdUsuarioCom, NombreJaverIngreso_S, ApellidoJaverIngreso_S, CedulaJaverIngreso_S, SemanaFechaIngreso_S,"
                + " MasserBaitHaM_S, RoshJodesh_S, TerumahYeladim_S, Terreno_S, Shuljan_S, Tzedaqah_S, Kaparah_S, Arriendo_S, TotalSemana_S "
                + " FROM " + TABLA_INGRESOS_SEPTIEMBRE;
        cursorConsulta = obtenerConsulta(consultaSQL, null);
        if (cursorConsulta != null) {
            Log.i("VerfificarIngresoS", "Está obteniendo una consulta");
        } else {
            Log.i("VerfificarIngresoS", "NO está obteniendo una consulta");
        }
        return cursorConsulta;
    }
    @Override
    public Cursor leerPorId(int idUsuarioCom) throws AppException {
        consultaSQL = "SELECT IdMesSeptiembre, NombreMes, AñoMes, IdUsuarioCom, NombreJaverIngreso_S, ApellidoJaverIngreso_S, CedulaJaverIngreso_S, SemanaFechaIngreso_S,"
                + " MasserBaitHaM_S, RoshJodesh_S, TerumahYeladim_S, Terreno_S, Shuljan_S, Tzedaqah_S, Kaparah_S, Arriendo_S, TotalSemana_S "
                + " FROM " + TABLA_INGRESOS_SEPTIEMBRE
                + " WHERE  IdUsuarioCom= ? ";
        String[] valores = new String[]{String.valueOf(idUsuarioCom)};
        cursorConsulta = obtenerConsulta(consultaSQL, valores);
        if (cursorConsulta != null) {
            Log.i("VerfificarIngresoS", "Está obteniendo una consulta");
        } else {
            Log.i("VerfificarIngresoS", "NO está obteniendo una consulta");
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
            double totalSemana_S) {

        valoresContenido = new ContentValues();
        valoresContenido.put("NombreMes",nombreMes);
        valoresContenido.put("AñoMes",añoMes);
        valoresContenido.put("IdUsuarioCom",idUsuarioCom);
        valoresContenido.put("NombreJaverIngreso_S",nombreJaverIng);
        valoresContenido.put("ApellidoJaverIngreso_S",apellidoJaverIng);
        valoresContenido.put("CedulaJaverIngreso_S",cedulaJaverIng);
        valoresContenido.put("SemanaFechaIngreso_S",semanaFechaIngreso);
        valoresContenido.put("MasserBaitHaM_S",masserBaitHaM);
        valoresContenido.put("RoshJodesh_S",roshJodesh);
        valoresContenido.put("TerumahYeladim_S",terumahYeladim);
        valoresContenido.put("Terreno_S",terreno);
        valoresContenido.put("Shuljan_S",shuljan);
        valoresContenido.put("Tzedaqah_S",tzedaqah);
        valoresContenido.put("Kaparah_S",kaparah);
        valoresContenido.put("Arriendo_S",arriendo);
        valoresContenido.put("TotalSemana_S",totalSemana_S);
        SQLiteDatabase db= getWritableDatabase();
        if(db !=null){
            Log.i("VerfificarIngresoS", "Esta ingresando datos en la DB para SEPTIEMBRE");
        }
        return db.insert(TABLA_INGRESOS_SEPTIEMBRE,null,valoresContenido);
    }
}
