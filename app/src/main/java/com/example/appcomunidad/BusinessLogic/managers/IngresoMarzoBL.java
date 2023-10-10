package com.example.appcomunidad.BusinessLogic.managers;

import android.content.Context;

import com.example.appcomunidad.BusinessLogic.entities.IngresosFebrero;
import com.example.appcomunidad.BusinessLogic.entities.IngresosMarzo;
import com.example.appcomunidad.data_acess.IngresoMarzoDAC;
import com.example.appcomunidad.framework.AppException;

import java.util.ArrayList;
import java.util.List;

public class IngresoMarzoBL extends GestorBL{
    private IngresoMarzoDAC ingresoMarzoDAC;
    private IngresosMarzo ingresosMarzo;

    /**
     * Construcutos de la clase GestorBL.
     *
     * @param contexto el contexto del activity.
     */
    public IngresoMarzoBL(Context contexto) {
        super(contexto);
        ingresoMarzoDAC= new IngresoMarzoDAC(contexto);
        ingresosMarzo= new IngresosMarzo();

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
        return ingresoMarzoDAC.insertarRegistro(nombreMes, añoMes, idUsuarioCom, nombreJaverIng, apellidoJaverIng, cedulaJaverIng, semanaFechaIngreso, masserBaitHaM, roshJodesh, terumahYeladim, terreno, shuljan, tzedaqah, kaparah, arriendo, totalSemana_M);
    }
    public List<IngresosMarzo> leerTodosRegistros () throws AppException {
        List<IngresosMarzo> ingresosMarzoList= new ArrayList<>();
        cursorConsulta= ingresoMarzoDAC.leerRegistros();
        if(cursorConsulta.moveToFirst()){
            do{
                ingresosMarzo= new IngresosMarzo();
                ingresosMarzo.setIdMes(cursorConsulta.getInt(0));
                ingresosMarzo.setNombreMes(cursorConsulta.getString(1));
                ingresosMarzo.setAnnoMes(cursorConsulta.getString(2));
                ingresosMarzo.setIdUsuarioCom(cursorConsulta.getInt(3));
                ingresosMarzo.setNombreJaver(cursorConsulta.getString(4));
                ingresosMarzo.setApellidoJaver(cursorConsulta.getString(5));
                ingresosMarzo.setCedulaJaver(cursorConsulta.getString(6));
                ingresosMarzo.setSemanaFechaIng(cursorConsulta.getString(7));
                ingresosMarzo.setMasserBaitHaM(cursorConsulta.getString(8));
                ingresosMarzo.setRoshJodesh(cursorConsulta.getString(9));
                ingresosMarzo.setTerumahYeladim(cursorConsulta.getString(10));
                ingresosMarzo.setTerreno(cursorConsulta.getString(11));
                ingresosMarzo.setShuljan(cursorConsulta.getString(12));
                ingresosMarzo.setTzedaqah(cursorConsulta.getString(13));
                ingresosMarzo.setKaparah(cursorConsulta.getString(14));
                ingresosMarzo.setArriendo(cursorConsulta.getString(15));
                ingresosMarzo.setTotalSemana(cursorConsulta.getDouble(16));


                ingresosMarzoList.add(ingresosMarzo);
            }while(cursorConsulta.moveToNext());
        }
        cursorConsulta.close();
        return  ingresosMarzoList;
    }
    public List<IngresosMarzo>leerRegistroPorId (int idUsuarioCom) throws AppException {
        List<IngresosMarzo> ingresosMarzoListIdUsuario= new ArrayList<>();
        cursorConsulta= ingresoMarzoDAC.leerPorId(idUsuarioCom);
        if(cursorConsulta.moveToFirst()){
            do{
                ingresosMarzo= new IngresosMarzo();
                ingresosMarzo.setIdMes(cursorConsulta.getInt(0));
                ingresosMarzo.setNombreMes(cursorConsulta.getString(1));
                ingresosMarzo.setAnnoMes(cursorConsulta.getString(2));
                ingresosMarzo.setIdUsuarioCom(cursorConsulta.getInt(3));
                ingresosMarzo.setNombreJaver(cursorConsulta.getString(4));
                ingresosMarzo.setApellidoJaver(cursorConsulta.getString(5));
                ingresosMarzo.setCedulaJaver(cursorConsulta.getString(6));
                ingresosMarzo.setSemanaFechaIng(cursorConsulta.getString(7));
                ingresosMarzo.setMasserBaitHaM(cursorConsulta.getString(8));
                ingresosMarzo.setRoshJodesh(cursorConsulta.getString(9));
                ingresosMarzo.setTerumahYeladim(cursorConsulta.getString(10));
                ingresosMarzo.setTerreno(cursorConsulta.getString(11));
                ingresosMarzo.setShuljan(cursorConsulta.getString(12));
                ingresosMarzo.setTzedaqah(cursorConsulta.getString(13));
                ingresosMarzo.setKaparah(cursorConsulta.getString(14));
                ingresosMarzo.setArriendo(cursorConsulta.getString(15));
                ingresosMarzo.setTotalSemana(cursorConsulta.getDouble(16));
                ingresosMarzoListIdUsuario.add(ingresosMarzo);
            }while(cursorConsulta.moveToNext());
        }
        cursorConsulta.close();
        return  ingresosMarzoListIdUsuario;
    }
}
