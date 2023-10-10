package com.example.appcomunidad.data_acess;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import androidx.annotation.Nullable;

import com.example.appcomunidad.framework.AppException;

public class IngresoAbrilDAC extends GestorBaseDatos{
    public IngresoAbrilDAC(@Nullable Context contexto) {
        super(contexto);
    }
    @Override
    public Cursor leerRegistros() throws AppException {
        consultaSQL = "SELECT IdMesAbril, NombreMes, AñoMes, IdUsuarioCom, NombreJaverIngreso_A, ApellidoJaverIngreso_A, CedulaJaverIngreso_A, SemanaFechaIngreso_A,"
                + " MasserBaitHaM_A, RoshJodesh_A, TerumahYeladim_A, Terreno_A, Shuljan_A, Tzedaqah_A, Kaparah_A, Arriendo_A, TotalSemana_A "
                + " FROM " + TABLA_INGRESOS_ABRIL;
        cursorConsulta = obtenerConsulta(consultaSQL, null);
        if (cursorConsulta != null) {
            Log.i("VerfificarIngresoA", "Está obteniendo una consulta");
        } else {
            Log.i("VerfificarIngresoA", "NO está obteniendo una consulta");
        }
        return cursorConsulta;
    }
    @Override
    public Cursor leerPorId(int idUsuarioCom) throws AppException {
        consultaSQL = "SELECT IdMesAbril, NombreMes, AñoMes, IdUsuarioCom, NombreJaverIngreso_A, ApellidoJaverIngreso_A, CedulaJaverIngreso_A, SemanaFechaIngreso_A,"
                + " MasserBaitHaM_A, RoshJodesh_A, TerumahYeladim_A, Terreno_A, Shuljan_A, Tzedaqah_A, Kaparah_A, Arriendo_A, TotalSemana_A "
                + " FROM " + TABLA_INGRESOS_ABRIL
                + " WHERE  IdUsuarioCom= ? ";
        String[] valores = new String[]{String.valueOf(idUsuarioCom)};
        cursorConsulta = obtenerConsulta(consultaSQL, valores);
        if (cursorConsulta != null) {
            Log.i("VerfificarIngresoA", "Está obteniendo una consulta");
        } else {
            Log.i("VerfificarIngresoA", "NO está obteniendo una consulta");
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
            double totalSemana_A) {

        valoresContenido = new ContentValues();
        valoresContenido.put("NombreMes",nombreMes);
        valoresContenido.put("AñoMes",añoMes);
        valoresContenido.put("IdUsuarioCom",idUsuarioCom);
        valoresContenido.put("NombreJaverIngreso_A",nombreJaverIng);
        valoresContenido.put("ApellidoJaverIngreso_A",apellidoJaverIng);
        valoresContenido.put("CedulaJaverIngreso_A",cedulaJaverIng);
        valoresContenido.put("SemanaFechaIngreso_A",semanaFechaIngreso);
        valoresContenido.put("MasserBaitHaM_A",masserBaitHaM);
        valoresContenido.put("RoshJodesh_A",roshJodesh);
        valoresContenido.put("TerumahYeladim_A",terumahYeladim);
        valoresContenido.put("Terreno_A",terreno);
        valoresContenido.put("Shuljan_A",shuljan);
        valoresContenido.put("Tzedaqah_A",tzedaqah);
        valoresContenido.put("Kaparah_A",kaparah);
        valoresContenido.put("Arriendo_A",arriendo);
        valoresContenido.put("TotalSemana_A",totalSemana_A);
        SQLiteDatabase db= getWritableDatabase();
        if(db !=null){
            Log.i("VerfificarIngresoA", "Esta ingresando datos en la DB para ABRIL");
        }
        return db.insert(TABLA_INGRESOS_ABRIL,null,valoresContenido);
    }
}
