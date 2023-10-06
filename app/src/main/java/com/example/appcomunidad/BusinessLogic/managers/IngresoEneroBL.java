package com.example.appcomunidad.BusinessLogic.managers;

import android.content.Context;

import com.example.appcomunidad.BusinessLogic.entities.IngresosEnero;
import com.example.appcomunidad.data_acess.IngresosEneroDAC;
import com.example.appcomunidad.framework.AppException;

import java.util.ArrayList;
import java.util.List;

public class IngresoEneroBL extends GestorBL{

    private IngresosEneroDAC ingresosEneroDAC;
    private IngresosEnero ingresosEnero;
    /**
     * Construcutos de la clase GestorBL.
     *
     * @param contexto el contexto del activity.
     */
    public IngresoEneroBL(Context contexto) {
        super(contexto);
        ingresosEneroDAC=new IngresosEneroDAC(contexto);
        ingresosEnero= new IngresosEnero();

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
        return ingresosEneroDAC.insertarRegistro(nombreMes, añoMes, idUsuarioCom, nombreJaverIng, apellidoJaverIng, cedulaJaverIng, semanaFechaIngreso, masserBaitHaM, roshJodesh, terumahYeladim, terreno, shuljan, tzedaqah, kaparah, arriendo, totalSemana_E);
    }

    public List<IngresosEnero> leerTodosRegistros () throws AppException {
        List<IngresosEnero> ingresosEneroList= new ArrayList<>();
        cursorConsulta= ingresosEneroDAC.leerRegistros();
        if(cursorConsulta.moveToFirst()){
            do{
                ingresosEnero= new IngresosEnero();
                ingresosEnero.setIdMes(cursorConsulta.getInt(0));
                ingresosEnero.setNombreMes(cursorConsulta.getString(1));
                ingresosEnero.setAnnoMes(cursorConsulta.getString(2));
                ingresosEnero.setIdUsuarioCom(cursorConsulta.getInt(3));
                ingresosEnero.setNombreJaver(cursorConsulta.getString(4));
                ingresosEnero.setApellidoJaver(cursorConsulta.getString(5));
                ingresosEnero.setCedulaJaver(cursorConsulta.getString(6));
                ingresosEnero.setSemanaFechaIng(cursorConsulta.getString(7));
                ingresosEnero.setMasserBaitHaM(cursorConsulta.getString(8));
                ingresosEnero.setRoshJodesh(cursorConsulta.getString(9));
                ingresosEnero.setTerumahYeladim(cursorConsulta.getString(10));
                ingresosEnero.setTerreno(cursorConsulta.getString(11));
                ingresosEnero.setShuljan(cursorConsulta.getString(12));
                ingresosEnero.setTzedaqah(cursorConsulta.getString(13));
                ingresosEnero.setKaparah(cursorConsulta.getString(14));
                ingresosEnero.setArriendo(cursorConsulta.getString(15));
                ingresosEnero.setTotalSemana(cursorConsulta.getDouble(16));


                ingresosEneroList.add(ingresosEnero);
            }while(cursorConsulta.moveToNext());
        }
        cursorConsulta.close();
        return  ingresosEneroList;
    }

    public List<IngresosEnero> leerRegistroPorId(int idUsuarioCom) throws AppException {
        List<IngresosEnero> ingresosEneroListIdUsuario= new ArrayList<>();
        cursorConsulta= ingresosEneroDAC.leerPorId(idUsuarioCom);
        if(cursorConsulta.moveToFirst()){
            do{
                ingresosEnero= new IngresosEnero();
                ingresosEnero.setIdMes(cursorConsulta.getInt(0));
                ingresosEnero.setNombreMes(cursorConsulta.getString(1));
                ingresosEnero.setAnnoMes(cursorConsulta.getString(2));
                ingresosEnero.setIdUsuarioCom(cursorConsulta.getInt(3));
                ingresosEnero.setNombreJaver(cursorConsulta.getString(4));
                ingresosEnero.setApellidoJaver(cursorConsulta.getString(5));
                ingresosEnero.setCedulaJaver(cursorConsulta.getString(6));
                ingresosEnero.setSemanaFechaIng(cursorConsulta.getString(7));
                ingresosEnero.setMasserBaitHaM(cursorConsulta.getString(8));
                ingresosEnero.setRoshJodesh(cursorConsulta.getString(9));
                ingresosEnero.setTerumahYeladim(cursorConsulta.getString(10));
                ingresosEnero.setTerreno(cursorConsulta.getString(11));
                ingresosEnero.setShuljan(cursorConsulta.getString(12));
                ingresosEnero.setTzedaqah(cursorConsulta.getString(13));
                ingresosEnero.setKaparah(cursorConsulta.getString(14));
                ingresosEnero.setArriendo(cursorConsulta.getString(15));
                ingresosEnero.setTotalSemana(cursorConsulta.getDouble(16));
                ingresosEneroListIdUsuario.add(ingresosEnero);
            }while (cursorConsulta.moveToNext());
        }
        cursorConsulta.close();
        return ingresosEneroListIdUsuario ;
    }
}
