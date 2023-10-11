package com.example.appcomunidad.BusinessLogic.managers;

import android.content.Context;

import com.example.appcomunidad.BusinessLogic.entities.IngresosAgosto;
import com.example.appcomunidad.BusinessLogic.entities.IngresosSeptiembre;
import com.example.appcomunidad.data_acess.IngresoAgostoDAC;
import com.example.appcomunidad.data_acess.IngresoSeptiembreDAC;
import com.example.appcomunidad.framework.AppException;

import java.util.ArrayList;
import java.util.List;

public class IngresoSeptiembreBL extends GestorBL{
    private IngresoSeptiembreDAC ingresoSeptiembreDAC;
    private IngresosSeptiembre ingresosSeptiembre;
    /**
     * Construcutos de la clase GestorBL.
     *
     * @param contexto el contexto del activity.
     */
    public IngresoSeptiembreBL(Context contexto) {
        super(contexto);
        ingresoSeptiembreDAC= new IngresoSeptiembreDAC(contexto);
        ingresosSeptiembre= new IngresosSeptiembre();
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
            double totalSemana_S) {
        return ingresoSeptiembreDAC.insertarRegistro(nombreMes, añoMes, idUsuarioCom, nombreJaverIng, apellidoJaverIng, cedulaJaverIng, semanaFechaIngreso, masserBaitHaM, roshJodesh, terumahYeladim, terreno, shuljan, tzedaqah, kaparah, arriendo, totalSemana_S);
    }
    public List<IngresosSeptiembre> leerTodosRegistros () throws AppException {
        List<IngresosSeptiembre> ingresosSeptiembreList= new ArrayList<>();
        cursorConsulta= ingresoSeptiembreDAC.leerRegistros();
        if(cursorConsulta.moveToFirst()){
            do{
                ingresosSeptiembre= new IngresosSeptiembre();
                ingresosSeptiembre.setIdMes(cursorConsulta.getInt(0));
                ingresosSeptiembre.setNombreMes(cursorConsulta.getString(1));
                ingresosSeptiembre.setAnnoMes(cursorConsulta.getString(2));
                ingresosSeptiembre.setIdUsuarioCom(cursorConsulta.getInt(3));
                ingresosSeptiembre.setNombreJaver(cursorConsulta.getString(4));
                ingresosSeptiembre.setApellidoJaver(cursorConsulta.getString(5));
                ingresosSeptiembre.setCedulaJaver(cursorConsulta.getString(6));
                ingresosSeptiembre.setSemanaFechaIng(cursorConsulta.getString(7));
                ingresosSeptiembre.setMasserBaitHaM(cursorConsulta.getString(8));
                ingresosSeptiembre.setRoshJodesh(cursorConsulta.getString(9));
                ingresosSeptiembre.setTerumahYeladim(cursorConsulta.getString(10));
                ingresosSeptiembre.setTerreno(cursorConsulta.getString(11));
                ingresosSeptiembre.setShuljan(cursorConsulta.getString(12));
                ingresosSeptiembre.setTzedaqah(cursorConsulta.getString(13));
                ingresosSeptiembre.setKaparah(cursorConsulta.getString(14));
                ingresosSeptiembre.setArriendo(cursorConsulta.getString(15));
                ingresosSeptiembre.setTotalSemana(cursorConsulta.getDouble(16));


                ingresosSeptiembreList.add( ingresosSeptiembre);
            }while(cursorConsulta.moveToNext());
        }
        cursorConsulta.close();
        return  ingresosSeptiembreList;
    }
    public List<IngresosSeptiembre>leerRegistroPorId (int idUsuarioCom) throws AppException {
        List<IngresosSeptiembre> ingresosSeptiembreListIdUsuario= new ArrayList<>();
        cursorConsulta= ingresoSeptiembreDAC.leerPorId(idUsuarioCom);
        if(cursorConsulta.moveToFirst()){
            do{
                ingresosSeptiembre= new IngresosSeptiembre();
                ingresosSeptiembre.setIdMes(cursorConsulta.getInt(0));
                ingresosSeptiembre.setNombreMes(cursorConsulta.getString(1));
                ingresosSeptiembre.setAnnoMes(cursorConsulta.getString(2));
                ingresosSeptiembre.setIdUsuarioCom(cursorConsulta.getInt(3));
                ingresosSeptiembre.setNombreJaver(cursorConsulta.getString(4));
                ingresosSeptiembre.setApellidoJaver(cursorConsulta.getString(5));
                ingresosSeptiembre.setCedulaJaver(cursorConsulta.getString(6));
                ingresosSeptiembre.setSemanaFechaIng(cursorConsulta.getString(7));
                ingresosSeptiembre.setMasserBaitHaM(cursorConsulta.getString(8));
                ingresosSeptiembre.setRoshJodesh(cursorConsulta.getString(9));
                ingresosSeptiembre.setTerumahYeladim(cursorConsulta.getString(10));
                ingresosSeptiembre.setTerreno(cursorConsulta.getString(11));
                ingresosSeptiembre.setShuljan(cursorConsulta.getString(12));
                ingresosSeptiembre.setTzedaqah(cursorConsulta.getString(13));
                ingresosSeptiembre.setKaparah(cursorConsulta.getString(14));
                ingresosSeptiembre.setArriendo(cursorConsulta.getString(15));
                ingresosSeptiembre.setTotalSemana(cursorConsulta.getDouble(16));


                ingresosSeptiembreListIdUsuario.add( ingresosSeptiembre);
            }while(cursorConsulta.moveToNext());
        }
        cursorConsulta.close();
        return   ingresosSeptiembreListIdUsuario;
    }
}
