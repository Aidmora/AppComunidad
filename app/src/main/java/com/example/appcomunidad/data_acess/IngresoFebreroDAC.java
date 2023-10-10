package com.example.appcomunidad.data_acess;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import androidx.annotation.Nullable;

import com.example.appcomunidad.framework.AppException;

public class IngresoFebreroDAC  extends  GestorBaseDatos{
    public IngresoFebreroDAC(@Nullable Context contexto) {
        super(contexto);
    }
    @Override
    public Cursor leerRegistros() throws AppException {
        consultaSQL = "SELECT IdMesFebrero, NombreMes, AñoMes, IdUsuarioCom, NombreJaverIngreso_F, ApellidoJaverIngreso_F, CedulaJaverIngreso_F, SemanaFechaIngreso_F,"
                + " MasserBaitHaM_F, RoshJodesh_F, TerumahYeladim_F, Terreno_F, Shuljan_F, Tzedaqah_F, Kaparah_F, Arriendo_F, TotalSemana_F "
                + " FROM " + TABLA_INGRESOS_FEBRERO;
        cursorConsulta = obtenerConsulta(consultaSQL, null);
        if (cursorConsulta != null) {
            Log.i("VerfificarIngresoF", "Está obteniendo una consulta");
        } else {
            Log.i("VerfificarIngresoF", "NO está obteniendo una consulta");
        }
        return cursorConsulta;
    }
    @Override
    public Cursor leerPorId(int idUsuarioCom) throws AppException {
        consultaSQL = "SELECT IdMesFebrero, NombreMes, AñoMes, IdUsuarioCom, NombreJaverIngreso_F, ApellidoJaverIngreso_F, CedulaJaverIngreso_F, SemanaFechaIngreso_F,"
                + " MasserBaitHaM_F, RoshJodesh_F, TerumahYeladim_F, Terreno_F, Shuljan_F, Tzedaqah_F, Kaparah_F, Arriendo_F, TotalSemana_F "
                + " FROM " + TABLA_INGRESOS_FEBRERO
                + " WHERE  IdUsuarioCom= ? ";
        String[] valores = new String[]{String.valueOf(idUsuarioCom)};
        cursorConsulta = obtenerConsulta(consultaSQL, valores);
        if (cursorConsulta != null) {
            Log.i("VerfificarIngresoF", "Está obteniendo una consulta");
        } else {
            Log.i("VerfificarIngresoF", "NO está obteniendo una consulta");
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
            double totalSemana_F) {

        valoresContenido = new ContentValues();
        valoresContenido.put("NombreMes",nombreMes);
        valoresContenido.put("AñoMes",añoMes);
        valoresContenido.put("IdUsuarioCom",idUsuarioCom);
        valoresContenido.put("NombreJaverIngreso_F",nombreJaverIng);
        valoresContenido.put("ApellidoJaverIngreso_F",apellidoJaverIng);
        valoresContenido.put("CedulaJaverIngreso_F",cedulaJaverIng);
        valoresContenido.put("SemanaFechaIngreso_F",semanaFechaIngreso);
        valoresContenido.put("MasserBaitHaM_F",masserBaitHaM);
        valoresContenido.put("RoshJodesh_F",roshJodesh);
        valoresContenido.put("TerumahYeladim_F",terumahYeladim);
        valoresContenido.put("Terreno_F",terreno);
        valoresContenido.put("Shuljan_F",shuljan);
        valoresContenido.put("Tzedaqah_F",tzedaqah);
        valoresContenido.put("Kaparah_F",kaparah);
        valoresContenido.put("Arriendo_F",arriendo);
        valoresContenido.put("TotalSemana_F",totalSemana_F);
        SQLiteDatabase db= getWritableDatabase();
        if(db !=null){
            Log.i("VerfificarIngresoF", "Esta ingresando datos en la DB para FEBRERO");
        }
        return db.insert(TABLA_INGRESOS_FEBRERO,null,valoresContenido);
    }

}
