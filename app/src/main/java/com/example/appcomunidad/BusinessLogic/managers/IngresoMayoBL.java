package com.example.appcomunidad.BusinessLogic.managers;

import android.content.Context;

import com.example.appcomunidad.BusinessLogic.entities.IngresosAbril;
import com.example.appcomunidad.BusinessLogic.entities.IngresosMayo;
import com.example.appcomunidad.data_acess.IngresoMayoDAC;
import com.example.appcomunidad.framework.AppException;

import java.util.ArrayList;
import java.util.List;

public class IngresoMayoBL extends GestorBL{
    private IngresoMayoDAC ingresoMayoDAC;
    private IngresosMayo ingresosMayo;
    /**
     * Construcutos de la clase GestorBL.
     *
     * @param contexto el contexto del activity.
     */
    public IngresoMayoBL(Context contexto) {
        super(contexto);
        ingresoMayoDAC= new IngresoMayoDAC(contexto);
        ingresosMayo= new IngresosMayo();
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
            double totalSemana_MA) {
        return ingresoMayoDAC.insertarRegistro(nombreMes, añoMes, idUsuarioCom, nombreJaverIng, apellidoJaverIng, cedulaJaverIng, semanaFechaIngreso, masserBaitHaM, roshJodesh, terumahYeladim, terreno, shuljan, tzedaqah, kaparah, arriendo, totalSemana_MA);
    }
    public List<IngresosMayo> leerTodosRegistros () throws AppException {
        List<IngresosMayo> ingresosMayoList= new ArrayList<>();
        cursorConsulta= ingresoMayoDAC.leerRegistros();
        if(cursorConsulta.moveToFirst()){
            do{
                ingresosMayo= new IngresosMayo();
                ingresosMayo.setIdMes(cursorConsulta.getInt(0));
                ingresosMayo.setNombreMes(cursorConsulta.getString(1));
                ingresosMayo.setAnnoMes(cursorConsulta.getString(2));
                ingresosMayo.setIdUsuarioCom(cursorConsulta.getInt(3));
                ingresosMayo.setNombreJaver(cursorConsulta.getString(4));
                ingresosMayo.setApellidoJaver(cursorConsulta.getString(5));
                ingresosMayo.setCedulaJaver(cursorConsulta.getString(6));
                ingresosMayo.setSemanaFechaIng(cursorConsulta.getString(7));
                ingresosMayo.setMasserBaitHaM(cursorConsulta.getString(8));
                ingresosMayo.setRoshJodesh(cursorConsulta.getString(9));
                ingresosMayo.setTerumahYeladim(cursorConsulta.getString(10));
                ingresosMayo.setTerreno(cursorConsulta.getString(11));
                ingresosMayo.setShuljan(cursorConsulta.getString(12));
                ingresosMayo.setTzedaqah(cursorConsulta.getString(13));
                ingresosMayo.setKaparah(cursorConsulta.getString(14));
                ingresosMayo.setArriendo(cursorConsulta.getString(15));
                ingresosMayo.setTotalSemana(cursorConsulta.getDouble(16));


                ingresosMayoList.add(ingresosMayo);
            }while(cursorConsulta.moveToNext());
        }
        cursorConsulta.close();
        return  ingresosMayoList;
    }
    public List<IngresosMayo>leerRegistroPorId (int idUsuarioCom) throws AppException {
        List<IngresosMayo> ingresosMayoListIdUsuario= new ArrayList<>();
        cursorConsulta= ingresoMayoDAC.leerPorId(idUsuarioCom);
        if(cursorConsulta.moveToFirst()){
            do{
                ingresosMayo= new IngresosMayo();
                ingresosMayo.setIdMes(cursorConsulta.getInt(0));
                ingresosMayo.setNombreMes(cursorConsulta.getString(1));
                ingresosMayo.setAnnoMes(cursorConsulta.getString(2));
                ingresosMayo.setIdUsuarioCom(cursorConsulta.getInt(3));
                ingresosMayo.setNombreJaver(cursorConsulta.getString(4));
                ingresosMayo.setApellidoJaver(cursorConsulta.getString(5));
                ingresosMayo.setCedulaJaver(cursorConsulta.getString(6));
                ingresosMayo.setSemanaFechaIng(cursorConsulta.getString(7));
                ingresosMayo.setMasserBaitHaM(cursorConsulta.getString(8));
                ingresosMayo.setRoshJodesh(cursorConsulta.getString(9));
                ingresosMayo.setTerumahYeladim(cursorConsulta.getString(10));
                ingresosMayo.setTerreno(cursorConsulta.getString(11));
                ingresosMayo.setShuljan(cursorConsulta.getString(12));
                ingresosMayo.setTzedaqah(cursorConsulta.getString(13));
                ingresosMayo.setKaparah(cursorConsulta.getString(14));
                ingresosMayo.setArriendo(cursorConsulta.getString(15));
                ingresosMayo.setTotalSemana(cursorConsulta.getDouble(16));


                ingresosMayoListIdUsuario.add(ingresosMayo);
            }while(cursorConsulta.moveToNext());
        }
        cursorConsulta.close();
        return  ingresosMayoListIdUsuario;
    }
}
