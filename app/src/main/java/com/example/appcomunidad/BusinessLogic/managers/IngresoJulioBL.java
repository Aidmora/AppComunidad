package com.example.appcomunidad.BusinessLogic.managers;

import android.content.Context;

import com.example.appcomunidad.BusinessLogic.entities.IngresosJulio;
import com.example.appcomunidad.BusinessLogic.entities.IngresosJunio;
import com.example.appcomunidad.data_acess.IngresoJulioDAC;
import com.example.appcomunidad.framework.AppException;

import java.util.ArrayList;
import java.util.List;

public class IngresoJulioBL extends GestorBL{
    private IngresoJulioDAC ingresoJulioDAC;
    private IngresosJulio ingresosJulio;
    /**
     * Construcutos de la clase GestorBL.
     *
     * @param contexto el contexto del activity.
     */
    public IngresoJulioBL(Context contexto) {
        super(contexto);
        ingresoJulioDAC= new IngresoJulioDAC(contexto);
        ingresosJulio= new IngresosJulio();
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
            double totalSemana_JU) {
        return ingresoJulioDAC.insertarRegistro(nombreMes, añoMes, idUsuarioCom, nombreJaverIng, apellidoJaverIng, cedulaJaverIng, semanaFechaIngreso, masserBaitHaM, roshJodesh, terumahYeladim, terreno, shuljan, tzedaqah, kaparah, arriendo, totalSemana_JU);
    }
    public List<IngresosJulio> leerTodosRegistros () throws AppException {
        List<IngresosJulio> ingresosJulioList= new ArrayList<>();
        cursorConsulta= ingresoJulioDAC.leerRegistros();
        if(cursorConsulta.moveToFirst()){
            do{
                ingresosJulio= new IngresosJulio();
                ingresosJulio.setIdMes(cursorConsulta.getInt(0));
                ingresosJulio.setNombreMes(cursorConsulta.getString(1));
                ingresosJulio.setAnnoMes(cursorConsulta.getString(2));
                ingresosJulio.setIdUsuarioCom(cursorConsulta.getInt(3));
                ingresosJulio.setNombreJaver(cursorConsulta.getString(4));
                ingresosJulio.setApellidoJaver(cursorConsulta.getString(5));
                ingresosJulio.setCedulaJaver(cursorConsulta.getString(6));
                ingresosJulio.setSemanaFechaIng(cursorConsulta.getString(7));
                ingresosJulio.setMasserBaitHaM(cursorConsulta.getString(8));
                ingresosJulio.setRoshJodesh(cursorConsulta.getString(9));
                ingresosJulio.setTerumahYeladim(cursorConsulta.getString(10));
                ingresosJulio.setTerreno(cursorConsulta.getString(11));
                ingresosJulio.setShuljan(cursorConsulta.getString(12));
                ingresosJulio.setTzedaqah(cursorConsulta.getString(13));
                ingresosJulio.setKaparah(cursorConsulta.getString(14));
                ingresosJulio.setArriendo(cursorConsulta.getString(15));
                ingresosJulio.setTotalSemana(cursorConsulta.getDouble(16));


                ingresosJulioList.add(ingresosJulio);
            }while(cursorConsulta.moveToNext());
        }
        cursorConsulta.close();
        return  ingresosJulioList;
    }
    public List<IngresosJulio>leerRegistroPorId (int idUsuarioCom) throws AppException {
        List<IngresosJulio> ingresosJulioListIdUsuario= new ArrayList<>();
        cursorConsulta= ingresoJulioDAC.leerPorId(idUsuarioCom);
        if(cursorConsulta.moveToFirst()){
            do{
                ingresosJulio= new IngresosJulio();
                ingresosJulio.setIdMes(cursorConsulta.getInt(0));
                ingresosJulio.setNombreMes(cursorConsulta.getString(1));
                ingresosJulio.setAnnoMes(cursorConsulta.getString(2));
                ingresosJulio.setIdUsuarioCom(cursorConsulta.getInt(3));
                ingresosJulio.setNombreJaver(cursorConsulta.getString(4));
                ingresosJulio.setApellidoJaver(cursorConsulta.getString(5));
                ingresosJulio.setCedulaJaver(cursorConsulta.getString(6));
                ingresosJulio.setSemanaFechaIng(cursorConsulta.getString(7));
                ingresosJulio.setMasserBaitHaM(cursorConsulta.getString(8));
                ingresosJulio.setRoshJodesh(cursorConsulta.getString(9));
                ingresosJulio.setTerumahYeladim(cursorConsulta.getString(10));
                ingresosJulio.setTerreno(cursorConsulta.getString(11));
                ingresosJulio.setShuljan(cursorConsulta.getString(12));
                ingresosJulio.setTzedaqah(cursorConsulta.getString(13));
                ingresosJulio.setKaparah(cursorConsulta.getString(14));
                ingresosJulio.setArriendo(cursorConsulta.getString(15));
                ingresosJulio.setTotalSemana(cursorConsulta.getDouble(16));


                ingresosJulioListIdUsuario.add(ingresosJulio);
            }while(cursorConsulta.moveToNext());
        }
        cursorConsulta.close();
        return  ingresosJulioListIdUsuario;
    }
}
