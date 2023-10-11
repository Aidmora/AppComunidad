package com.example.appcomunidad.data_acess;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import androidx.annotation.Nullable;

import com.example.appcomunidad.framework.AppException;

public class IngresoOctubreDAC extends GestorBaseDatos{
    public IngresoOctubreDAC(@Nullable Context contexto) {
        super(contexto);
    }

    @Override
    public Cursor leerRegistros() throws AppException {
        consultaSQL = "SELECT IdMesOctubre, NombreMes, AñoMes, IdUsuarioCom, NombreJaverIngreso_O, ApellidoJaverIngreso_O, CedulaJaverIngreso_O, SemanaFechaIngreso_O,"
                + " MasserBaitHaM_O, RoshJodesh_O, TerumahYeladim_O, Terreno_O, Shuljan_O, Tzedaqah_O, Kaparah_O, Arriendo_O, TotalSemana_O "
                + " FROM " + TABLA_INGRESOS_OCTUBRE;
        cursorConsulta = obtenerConsulta(consultaSQL, null);
        if (cursorConsulta != null) {
            Log.i("VerfificarIngresoO", "Está obteniendo una consulta");
        } else {
            Log.i("VerfificarIngresoO", "NO está obteniendo una consulta");
        }
        return cursorConsulta;
    }
    @Override
    public Cursor leerPorId(int idUsuarioCom) throws AppException {
        consultaSQL = "SELECT IdMesOctubre, NombreMes, AñoMes, IdUsuarioCom, NombreJaverIngreso_O, ApellidoJaverIngreso_O, CedulaJaverIngreso_O, SemanaFechaIngreso_O,"
                + " MasserBaitHaM_O, RoshJodesh_O, TerumahYeladim_O, Terreno_O, Shuljan_O, Tzedaqah_O, Kaparah_O, Arriendo_O, TotalSemana_O "
                + " FROM " + TABLA_INGRESOS_OCTUBRE
                + " WHERE  IdUsuarioCom= ? ";
        String[] valores = new String[]{String.valueOf(idUsuarioCom)};
        cursorConsulta = obtenerConsulta(consultaSQL, valores);
        if (cursorConsulta != null) {
            Log.i("VerfificarIngresoO", "Está obteniendo una consulta");
        } else {
            Log.i("VerfificarIngresoO", "NO está obteniendo una consulta");
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
            double totalSemana_O) {

        valoresContenido = new ContentValues();
        valoresContenido.put("NombreMes",nombreMes);
        valoresContenido.put("AñoMes",añoMes);
        valoresContenido.put("IdUsuarioCom",idUsuarioCom);
        valoresContenido.put("NombreJaverIngreso_O",nombreJaverIng);
        valoresContenido.put("ApellidoJaverIngreso_O",apellidoJaverIng);
        valoresContenido.put("CedulaJaverIngreso_O",cedulaJaverIng);
        valoresContenido.put("SemanaFechaIngreso_O",semanaFechaIngreso);
        valoresContenido.put("MasserBaitHaM_O",masserBaitHaM);
        valoresContenido.put("RoshJodesh_O",roshJodesh);
        valoresContenido.put("TerumahYeladim_O",terumahYeladim);
        valoresContenido.put("Terreno_O",terreno);
        valoresContenido.put("Shuljan_O",shuljan);
        valoresContenido.put("Tzedaqah_O",tzedaqah);
        valoresContenido.put("Kaparah_O",kaparah);
        valoresContenido.put("Arriendo_O",arriendo);
        valoresContenido.put("TotalSemana_O",totalSemana_O);
        SQLiteDatabase db= getWritableDatabase();
        if(db !=null){
            Log.i("VerfificarIngresoO", "Esta ingresando datos en la DB para OCTUBRE");
        }
        return db.insert(TABLA_INGRESOS_OCTUBRE,null,valoresContenido);
    }
}
