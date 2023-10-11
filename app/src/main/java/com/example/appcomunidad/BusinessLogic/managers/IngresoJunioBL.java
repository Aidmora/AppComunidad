package com.example.appcomunidad.BusinessLogic.managers;

import android.content.Context;

import com.example.appcomunidad.BusinessLogic.entities.IngresosJunio;
import com.example.appcomunidad.BusinessLogic.entities.IngresosMayo;
import com.example.appcomunidad.data_acess.IngresoJunioDAC;
import com.example.appcomunidad.framework.AppException;

import java.util.ArrayList;
import java.util.List;

public class IngresoJunioBL extends GestorBL{
    private IngresoJunioDAC ingresoJunioDAC;
    private IngresosJunio ingresoJunio;
    /**
     * Construcutos de la clase GestorBL.
     *
     * @param contexto el contexto del activity.
     */
    public IngresoJunioBL(Context contexto) {
        super(contexto);
        ingresoJunioDAC= new IngresoJunioDAC(contexto);
        ingresoJunio= new IngresosJunio();
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
            double totalSemana_J) {
        return ingresoJunioDAC.insertarRegistro(nombreMes, añoMes, idUsuarioCom, nombreJaverIng, apellidoJaverIng, cedulaJaverIng, semanaFechaIngreso, masserBaitHaM, roshJodesh, terumahYeladim, terreno, shuljan, tzedaqah, kaparah, arriendo, totalSemana_J);
    }
    public List<IngresosJunio> leerTodosRegistros () throws AppException {
        List<IngresosJunio> ingresosJunioList= new ArrayList<>();
        cursorConsulta= ingresoJunioDAC.leerRegistros();
        if(cursorConsulta.moveToFirst()){
            do{
                ingresoJunio= new IngresosJunio();
                ingresoJunio.setIdMes(cursorConsulta.getInt(0));
                ingresoJunio.setNombreMes(cursorConsulta.getString(1));
                ingresoJunio.setAnnoMes(cursorConsulta.getString(2));
                ingresoJunio.setIdUsuarioCom(cursorConsulta.getInt(3));
                ingresoJunio.setNombreJaver(cursorConsulta.getString(4));
                ingresoJunio.setApellidoJaver(cursorConsulta.getString(5));
                ingresoJunio.setCedulaJaver(cursorConsulta.getString(6));
                ingresoJunio.setSemanaFechaIng(cursorConsulta.getString(7));
                ingresoJunio.setMasserBaitHaM(cursorConsulta.getString(8));
                ingresoJunio.setRoshJodesh(cursorConsulta.getString(9));
                ingresoJunio.setTerumahYeladim(cursorConsulta.getString(10));
                ingresoJunio.setTerreno(cursorConsulta.getString(11));
                ingresoJunio.setShuljan(cursorConsulta.getString(12));
                ingresoJunio.setTzedaqah(cursorConsulta.getString(13));
                ingresoJunio.setKaparah(cursorConsulta.getString(14));
                ingresoJunio.setArriendo(cursorConsulta.getString(15));
                ingresoJunio.setTotalSemana(cursorConsulta.getDouble(16));


                ingresosJunioList.add(ingresoJunio);
            }while(cursorConsulta.moveToNext());
        }
        cursorConsulta.close();
        return  ingresosJunioList;
    }
    public List<IngresosJunio>leerRegistroPorId (int idUsuarioCom) throws AppException {
        List<IngresosJunio> ingresosJunioListIdUsuario= new ArrayList<>();
        cursorConsulta= ingresoJunioDAC.leerPorId(idUsuarioCom);
        if(cursorConsulta.moveToFirst()){
            do{
                ingresoJunio= new IngresosJunio();
                ingresoJunio.setIdMes(cursorConsulta.getInt(0));
                ingresoJunio.setNombreMes(cursorConsulta.getString(1));
                ingresoJunio.setAnnoMes(cursorConsulta.getString(2));
                ingresoJunio.setIdUsuarioCom(cursorConsulta.getInt(3));
                ingresoJunio.setNombreJaver(cursorConsulta.getString(4));
                ingresoJunio.setApellidoJaver(cursorConsulta.getString(5));
                ingresoJunio.setCedulaJaver(cursorConsulta.getString(6));
                ingresoJunio.setSemanaFechaIng(cursorConsulta.getString(7));
                ingresoJunio.setMasserBaitHaM(cursorConsulta.getString(8));
                ingresoJunio.setRoshJodesh(cursorConsulta.getString(9));
                ingresoJunio.setTerumahYeladim(cursorConsulta.getString(10));
                ingresoJunio.setTerreno(cursorConsulta.getString(11));
                ingresoJunio.setShuljan(cursorConsulta.getString(12));
                ingresoJunio.setTzedaqah(cursorConsulta.getString(13));
                ingresoJunio.setKaparah(cursorConsulta.getString(14));
                ingresoJunio.setArriendo(cursorConsulta.getString(15));
                ingresoJunio.setTotalSemana(cursorConsulta.getDouble(16));


                ingresosJunioListIdUsuario.add(ingresoJunio);
            }while(cursorConsulta.moveToNext());
        }
        cursorConsulta.close();
        return  ingresosJunioListIdUsuario;
    }
}
