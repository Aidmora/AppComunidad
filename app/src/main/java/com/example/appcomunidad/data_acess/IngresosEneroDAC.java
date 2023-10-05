package com.example.appcomunidad.data_acess;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import androidx.annotation.Nullable;

import com.example.appcomunidad.framework.AppException;

public class IngresosEneroDAC extends GestorBaseDatos{
    public IngresosEneroDAC(@Nullable Context contexto) {
        super(contexto);
    }

    @Override
    public Cursor leerRegistros() throws AppException {
        consultaSQL = "SELECT IdMesEnero, NombreMes, AñoMes, IdUsuarioCom, NombreJaverIngreso_E, ApellidoJaverIngreso_E, CedulaJaverIngreso_E, SemanaFechaIngreso_E,"
                + " MasserBaitHaM_E, RoshJodesh_E, TerumahYeladim_E, Terreno_E, Shuljan_E, Tzedaqah_E, Kaparah_E, Arriendo_E, TotalSemana_E "
                + " FROM " + TABLA_INGRESOS_ENERO;
        cursorConsulta = obtenerConsulta(consultaSQL, null);
        if (cursorConsulta != null) {
            Log.i("VerfificarIngresoE", "Está obteniendo una consulta");
        } else {
            Log.i("VerfificarIngresoE", "NO está obteniendo una consulta");
        }
        return cursorConsulta;
    }
    @Override
    public Cursor leerPorId(int idUsuarioCom) throws AppException {
        consultaSQL = "SELECT IdMesEnero, NombreMes, AñoMes, IdUsuarioCom, NombreJaverIngreso_E, ApellidoJaverIngreso_E, CedulaJaverIngreso_E, SemanaFechaIngreso_E,"
                + " MasserBaitHaM_E, RoshJodesh_E, TerumahYeladim_E, Terreno_E, Shuljan_E, Tzedaqah_E, Kaparah_E, Arriendo_E, TotalSemana_E "
                + " FROM " + TABLA_INGRESOS_ENERO
                + " WHERE  IdUsuarioCom= ? ";
        String[] valores = new String[]{String.valueOf(idUsuarioCom)};
        cursorConsulta = obtenerConsulta(consultaSQL, valores);
        if (cursorConsulta != null) {
            Log.i("VerfificarIngresoE", "Está obteniendo una consulta");
        } else {
            Log.i("VerfificarIngresoE", "NO está obteniendo una consulta");
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
            double totalSemana_E) {

        valoresContenido = new ContentValues();
        valoresContenido.put("NombreMes",nombreMes);
        valoresContenido.put("AñoMes",añoMes);
        valoresContenido.put("IdUsuarioCom",idUsuarioCom);
        valoresContenido.put("NombreJaverIngreso_E",nombreJaverIng);
        valoresContenido.put("ApellidoJaverIngreso_E",apellidoJaverIng);
        valoresContenido.put("CedulaJaverIngreso_E",cedulaJaverIng);
        valoresContenido.put("SemanaFechaIngreso_E",semanaFechaIngreso);
        valoresContenido.put("MasserBaitHaM_E",masserBaitHaM);
        valoresContenido.put("RoshJodesh_E",roshJodesh);
        valoresContenido.put("TerumahYeladim_E",terumahYeladim);
        valoresContenido.put("Terreno_E",terreno);
        valoresContenido.put("Shuljan_E",shuljan);
        valoresContenido.put("Tzedaqah_E",tzedaqah);
        valoresContenido.put("Kaparah_E",kaparah);
        valoresContenido.put("Arriendo_E",arriendo);
        valoresContenido.put("TotalSemana_E",totalSemana_E);
        SQLiteDatabase db= getWritableDatabase();
        if(db !=null){
            Log.i("VerfificarIngresoE", "Esta ingresando datos en la DB para ENERO");
        }
        return db.insert(TABLA_INGRESOS_ENERO,null,valoresContenido);
    }

}
