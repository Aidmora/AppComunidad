package com.example.appcomunidad.BusinessLogic.managers;

import android.content.Context;

import com.example.appcomunidad.BusinessLogic.entities.IngresosDiciembre;
import com.example.appcomunidad.BusinessLogic.entities.IngresosNoviembre;
import com.example.appcomunidad.data_acess.IngresoDiciembreDAC;
import com.example.appcomunidad.framework.AppException;

import java.util.ArrayList;
import java.util.List;

public class IngresoDiciembreBL extends GestorBL{
    private IngresoDiciembreDAC ingresoDiciembreDAC;
    private IngresosDiciembre ingresosDiciembre;
    /**
     * Construcutos de la clase GestorBL.
     *
     * @param contexto el contexto del activity.
     */
    public IngresoDiciembreBL(Context contexto) {
        super(contexto);
        ingresoDiciembreDAC= new IngresoDiciembreDAC(contexto);
        ingresosDiciembre= new IngresosDiciembre();
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
            double totalSemana_D) {
        return ingresoDiciembreDAC.insertarRegistro(nombreMes, añoMes, idUsuarioCom, nombreJaverIng, apellidoJaverIng, cedulaJaverIng, semanaFechaIngreso, masserBaitHaM, roshJodesh, terumahYeladim, terreno, shuljan, tzedaqah, kaparah, arriendo, totalSemana_D);
    }
    public List<IngresosDiciembre> leerTodosRegistros () throws AppException {
        List<IngresosDiciembre> ingresosDiciembreList= new ArrayList<>();
        cursorConsulta= ingresoDiciembreDAC.leerRegistros();
        if(cursorConsulta.moveToFirst()){
            do{
                ingresosDiciembre= new IngresosDiciembre();
                ingresosDiciembre.setIdMes(cursorConsulta.getInt(0));
                ingresosDiciembre.setNombreMes(cursorConsulta.getString(1));
                ingresosDiciembre.setAnnoMes(cursorConsulta.getString(2));
                ingresosDiciembre.setIdUsuarioCom(cursorConsulta.getInt(3));
                ingresosDiciembre.setNombreJaver(cursorConsulta.getString(4));
                ingresosDiciembre.setApellidoJaver(cursorConsulta.getString(5));
                ingresosDiciembre.setCedulaJaver(cursorConsulta.getString(6));
                ingresosDiciembre.setSemanaFechaIng(cursorConsulta.getString(7));
                ingresosDiciembre.setMasserBaitHaM(cursorConsulta.getString(8));
                ingresosDiciembre.setRoshJodesh(cursorConsulta.getString(9));
                ingresosDiciembre.setTerumahYeladim(cursorConsulta.getString(10));
                ingresosDiciembre.setTerreno(cursorConsulta.getString(11));
                ingresosDiciembre.setShuljan(cursorConsulta.getString(12));
                ingresosDiciembre.setTzedaqah(cursorConsulta.getString(13));
                ingresosDiciembre.setKaparah(cursorConsulta.getString(14));
                ingresosDiciembre.setArriendo(cursorConsulta.getString(15));
                ingresosDiciembre.setTotalSemana(cursorConsulta.getDouble(16));


                ingresosDiciembreList.add( ingresosDiciembre);
            }while(cursorConsulta.moveToNext());
        }
        cursorConsulta.close();
        return   ingresosDiciembreList;
    }
    public List<IngresosDiciembre>leerRegistroPorId (int idUsuarioCom) throws AppException {
        List<IngresosDiciembre> ingresosDiciembreListIdUsuario= new ArrayList<>();
        cursorConsulta= ingresoDiciembreDAC.leerPorId(idUsuarioCom);
        if(cursorConsulta.moveToFirst()){
            do{
                ingresosDiciembre= new IngresosDiciembre();
                ingresosDiciembre.setIdMes(cursorConsulta.getInt(0));
                ingresosDiciembre.setNombreMes(cursorConsulta.getString(1));
                ingresosDiciembre.setAnnoMes(cursorConsulta.getString(2));
                ingresosDiciembre.setIdUsuarioCom(cursorConsulta.getInt(3));
                ingresosDiciembre.setNombreJaver(cursorConsulta.getString(4));
                ingresosDiciembre.setApellidoJaver(cursorConsulta.getString(5));
                ingresosDiciembre.setCedulaJaver(cursorConsulta.getString(6));
                ingresosDiciembre.setSemanaFechaIng(cursorConsulta.getString(7));
                ingresosDiciembre.setMasserBaitHaM(cursorConsulta.getString(8));
                ingresosDiciembre.setRoshJodesh(cursorConsulta.getString(9));
                ingresosDiciembre.setTerumahYeladim(cursorConsulta.getString(10));
                ingresosDiciembre.setTerreno(cursorConsulta.getString(11));
                ingresosDiciembre.setShuljan(cursorConsulta.getString(12));
                ingresosDiciembre.setTzedaqah(cursorConsulta.getString(13));
                ingresosDiciembre.setKaparah(cursorConsulta.getString(14));
                ingresosDiciembre.setArriendo(cursorConsulta.getString(15));
                ingresosDiciembre.setTotalSemana(cursorConsulta.getDouble(16));


                ingresosDiciembreListIdUsuario.add( ingresosDiciembre);
            }while(cursorConsulta.moveToNext());
        }
        cursorConsulta.close();
        return  ingresosDiciembreListIdUsuario;
    }
}
