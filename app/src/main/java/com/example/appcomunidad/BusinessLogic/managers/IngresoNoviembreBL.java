package com.example.appcomunidad.BusinessLogic.managers;

import android.content.Context;

import com.example.appcomunidad.BusinessLogic.entities.IngresosNoviembre;
import com.example.appcomunidad.BusinessLogic.entities.IngresosOctubre;
import com.example.appcomunidad.data_acess.IngresoNoviembreDAC;
import com.example.appcomunidad.framework.AppException;

import java.util.ArrayList;
import java.util.List;

public class IngresoNoviembreBL extends GestorBL{
    private IngresoNoviembreDAC ingresoNoviembreDAC;
    private IngresosNoviembre ingresosNoviembre;
    /**
     * Construcutos de la clase GestorBL.
     *
     * @param contexto el contexto del activity.
     */
    public IngresoNoviembreBL(Context contexto) {
        super(contexto);
        ingresoNoviembreDAC= new IngresoNoviembreDAC(contexto);
        ingresosNoviembre= new IngresosNoviembre();
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
            double totalSemana_N) {
        return ingresoNoviembreDAC.insertarRegistro(nombreMes, añoMes, idUsuarioCom, nombreJaverIng, apellidoJaverIng, cedulaJaverIng, semanaFechaIngreso, masserBaitHaM, roshJodesh, terumahYeladim, terreno, shuljan, tzedaqah, kaparah, arriendo, totalSemana_N);
    }
    public List<IngresosNoviembre> leerTodosRegistros () throws AppException {
        List<IngresosNoviembre> ingresosNoviembreList= new ArrayList<>();
        cursorConsulta= ingresoNoviembreDAC.leerRegistros();
        if(cursorConsulta.moveToFirst()){
            do{
                ingresosNoviembre= new IngresosNoviembre();
                ingresosNoviembre.setIdMes(cursorConsulta.getInt(0));
                ingresosNoviembre.setNombreMes(cursorConsulta.getString(1));
                ingresosNoviembre.setAnnoMes(cursorConsulta.getString(2));
                ingresosNoviembre.setIdUsuarioCom(cursorConsulta.getInt(3));
                ingresosNoviembre.setNombreJaver(cursorConsulta.getString(4));
                ingresosNoviembre.setApellidoJaver(cursorConsulta.getString(5));
                ingresosNoviembre.setCedulaJaver(cursorConsulta.getString(6));
                ingresosNoviembre.setSemanaFechaIng(cursorConsulta.getString(7));
                ingresosNoviembre.setMasserBaitHaM(cursorConsulta.getString(8));
                ingresosNoviembre.setRoshJodesh(cursorConsulta.getString(9));
                ingresosNoviembre.setTerumahYeladim(cursorConsulta.getString(10));
                ingresosNoviembre.setTerreno(cursorConsulta.getString(11));
                ingresosNoviembre.setShuljan(cursorConsulta.getString(12));
                ingresosNoviembre.setTzedaqah(cursorConsulta.getString(13));
                ingresosNoviembre.setKaparah(cursorConsulta.getString(14));
                ingresosNoviembre.setArriendo(cursorConsulta.getString(15));
                ingresosNoviembre.setTotalSemana(cursorConsulta.getDouble(16));


                ingresosNoviembreList.add( ingresosNoviembre);
            }while(cursorConsulta.moveToNext());
        }
        cursorConsulta.close();
        return  ingresosNoviembreList;
    }
    public List<IngresosNoviembre>leerRegistroPorId (int idUsuarioCom) throws AppException {
        List<IngresosNoviembre> ingresosNoviembreListIdUsuario= new ArrayList<>();
        cursorConsulta= ingresoNoviembreDAC.leerPorId(idUsuarioCom);
        if(cursorConsulta.moveToFirst()){
            do{
                ingresosNoviembre= new IngresosNoviembre();
                ingresosNoviembre.setIdMes(cursorConsulta.getInt(0));
                ingresosNoviembre.setNombreMes(cursorConsulta.getString(1));
                ingresosNoviembre.setAnnoMes(cursorConsulta.getString(2));
                ingresosNoviembre.setIdUsuarioCom(cursorConsulta.getInt(3));
                ingresosNoviembre.setNombreJaver(cursorConsulta.getString(4));
                ingresosNoviembre.setApellidoJaver(cursorConsulta.getString(5));
                ingresosNoviembre.setCedulaJaver(cursorConsulta.getString(6));
                ingresosNoviembre.setSemanaFechaIng(cursorConsulta.getString(7));
                ingresosNoviembre.setMasserBaitHaM(cursorConsulta.getString(8));
                ingresosNoviembre.setRoshJodesh(cursorConsulta.getString(9));
                ingresosNoviembre.setTerumahYeladim(cursorConsulta.getString(10));
                ingresosNoviembre.setTerreno(cursorConsulta.getString(11));
                ingresosNoviembre.setShuljan(cursorConsulta.getString(12));
                ingresosNoviembre.setTzedaqah(cursorConsulta.getString(13));
                ingresosNoviembre.setKaparah(cursorConsulta.getString(14));
                ingresosNoviembre.setArriendo(cursorConsulta.getString(15));
                ingresosNoviembre.setTotalSemana(cursorConsulta.getDouble(16));


                ingresosNoviembreListIdUsuario.add( ingresosNoviembre);
            }while(cursorConsulta.moveToNext());
        }
        cursorConsulta.close();
        return  ingresosNoviembreListIdUsuario;
    }
}
