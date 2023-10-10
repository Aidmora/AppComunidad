package com.example.appcomunidad.BusinessLogic.managers;

import android.content.Context;

import com.example.appcomunidad.BusinessLogic.entities.IngresosEnero;
import com.example.appcomunidad.BusinessLogic.entities.IngresosFebrero;
import com.example.appcomunidad.data_acess.IngresoFebreroDAC;
import com.example.appcomunidad.framework.AppException;

import java.util.ArrayList;
import java.util.List;

public class IngresoFebreroBL extends GestorBL {
    private IngresoFebreroDAC ingresoFebreroDAC;
    private IngresosFebrero ingresosFebrero;
    /**
     * Construcutos de la clase GestorBL.
     *
     * @param contexto el contexto del activity.
     */
    public IngresoFebreroBL(Context contexto) {
        super(contexto);
        ingresoFebreroDAC= new IngresoFebreroDAC(contexto);
        ingresosFebrero= new IngresosFebrero();
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
        return ingresoFebreroDAC.insertarRegistro(nombreMes, añoMes, idUsuarioCom, nombreJaverIng, apellidoJaverIng, cedulaJaverIng, semanaFechaIngreso, masserBaitHaM, roshJodesh, terumahYeladim, terreno, shuljan, tzedaqah, kaparah, arriendo, totalSemana_F);
    }
    public List<IngresosFebrero> leerTodosRegistros () throws AppException {
        List<IngresosFebrero> ingresosFebreroList= new ArrayList<>();
        cursorConsulta= ingresoFebreroDAC.leerRegistros();
        if(cursorConsulta.moveToFirst()){
            do{
                ingresosFebrero= new IngresosFebrero();
                ingresosFebrero.setIdMes(cursorConsulta.getInt(0));
                ingresosFebrero.setNombreMes(cursorConsulta.getString(1));
                ingresosFebrero.setAnnoMes(cursorConsulta.getString(2));
                ingresosFebrero.setIdUsuarioCom(cursorConsulta.getInt(3));
                ingresosFebrero.setNombreJaver(cursorConsulta.getString(4));
                ingresosFebrero.setApellidoJaver(cursorConsulta.getString(5));
                ingresosFebrero.setCedulaJaver(cursorConsulta.getString(6));
                ingresosFebrero.setSemanaFechaIng(cursorConsulta.getString(7));
                ingresosFebrero.setMasserBaitHaM(cursorConsulta.getString(8));
                ingresosFebrero.setRoshJodesh(cursorConsulta.getString(9));
                ingresosFebrero.setTerumahYeladim(cursorConsulta.getString(10));
                ingresosFebrero.setTerreno(cursorConsulta.getString(11));
                ingresosFebrero.setShuljan(cursorConsulta.getString(12));
                ingresosFebrero.setTzedaqah(cursorConsulta.getString(13));
                ingresosFebrero.setKaparah(cursorConsulta.getString(14));
                ingresosFebrero.setArriendo(cursorConsulta.getString(15));
                ingresosFebrero.setTotalSemana(cursorConsulta.getDouble(16));


                ingresosFebreroList.add(ingresosFebrero);
            }while(cursorConsulta.moveToNext());
        }
        cursorConsulta.close();
        return  ingresosFebreroList;
    }
    public List<IngresosFebrero>leerRegistroPorId (int idUsuarioCom) throws AppException {
        List<IngresosFebrero> ingresosFebreroListIdUsuario= new ArrayList<>();
        cursorConsulta= ingresoFebreroDAC.leerPorId(idUsuarioCom);
        if(cursorConsulta.moveToFirst()){
            do{
                ingresosFebrero= new IngresosFebrero();
                ingresosFebrero.setIdMes(cursorConsulta.getInt(0));
                ingresosFebrero.setNombreMes(cursorConsulta.getString(1));
                ingresosFebrero.setAnnoMes(cursorConsulta.getString(2));
                ingresosFebrero.setIdUsuarioCom(cursorConsulta.getInt(3));
                ingresosFebrero.setNombreJaver(cursorConsulta.getString(4));
                ingresosFebrero.setApellidoJaver(cursorConsulta.getString(5));
                ingresosFebrero.setCedulaJaver(cursorConsulta.getString(6));
                ingresosFebrero.setSemanaFechaIng(cursorConsulta.getString(7));
                ingresosFebrero.setMasserBaitHaM(cursorConsulta.getString(8));
                ingresosFebrero.setRoshJodesh(cursorConsulta.getString(9));
                ingresosFebrero.setTerumahYeladim(cursorConsulta.getString(10));
                ingresosFebrero.setTerreno(cursorConsulta.getString(11));
                ingresosFebrero.setShuljan(cursorConsulta.getString(12));
                ingresosFebrero.setTzedaqah(cursorConsulta.getString(13));
                ingresosFebrero.setKaparah(cursorConsulta.getString(14));
                ingresosFebrero.setArriendo(cursorConsulta.getString(15));
                ingresosFebrero.setTotalSemana(cursorConsulta.getDouble(16));
                ingresosFebreroListIdUsuario.add(ingresosFebrero);
            }while(cursorConsulta.moveToNext());
        }
        cursorConsulta.close();
        return  ingresosFebreroListIdUsuario;
    }
}
