package com.example.appcomunidad.BusinessLogic.managers;

import android.content.Context;

import com.example.appcomunidad.BusinessLogic.entities.IngresosAbril;
import com.example.appcomunidad.BusinessLogic.entities.IngresosMarzo;
import com.example.appcomunidad.data_acess.IngresoAbrilDAC;
import com.example.appcomunidad.framework.AppException;

import java.util.ArrayList;
import java.util.List;

public class IngresoAbrilBL extends GestorBL{
    private IngresoAbrilDAC ingresoAbrilDAC;
    private IngresosAbril ingresosAbril;
    /**
     * Construcutos de la clase GestorBL.
     *
     * @param contexto el contexto del activity.
     */
    public IngresoAbrilBL(Context contexto) {
        super(contexto);
        ingresoAbrilDAC= new IngresoAbrilDAC(contexto);
        ingresosAbril= new IngresosAbril();
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
            double totalSemana_A) {
        return ingresoAbrilDAC.insertarRegistro(nombreMes, añoMes, idUsuarioCom, nombreJaverIng, apellidoJaverIng, cedulaJaverIng, semanaFechaIngreso, masserBaitHaM, roshJodesh, terumahYeladim, terreno, shuljan, tzedaqah, kaparah, arriendo, totalSemana_A);
    }
    public List<IngresosAbril> leerTodosRegistros () throws AppException {
        List<IngresosAbril> ingresosAbrilList= new ArrayList<>();
        cursorConsulta= ingresoAbrilDAC.leerRegistros();
        if(cursorConsulta.moveToFirst()){
            do{
                ingresosAbril= new IngresosAbril();
                ingresosAbril.setIdMes(cursorConsulta.getInt(0));
                ingresosAbril.setNombreMes(cursorConsulta.getString(1));
                ingresosAbril.setAnnoMes(cursorConsulta.getString(2));
                ingresosAbril.setIdUsuarioCom(cursorConsulta.getInt(3));
                ingresosAbril.setNombreJaver(cursorConsulta.getString(4));
                ingresosAbril.setApellidoJaver(cursorConsulta.getString(5));
                ingresosAbril.setCedulaJaver(cursorConsulta.getString(6));
                ingresosAbril.setSemanaFechaIng(cursorConsulta.getString(7));
                ingresosAbril.setMasserBaitHaM(cursorConsulta.getString(8));
                ingresosAbril.setRoshJodesh(cursorConsulta.getString(9));
                ingresosAbril.setTerumahYeladim(cursorConsulta.getString(10));
                ingresosAbril.setTerreno(cursorConsulta.getString(11));
                ingresosAbril.setShuljan(cursorConsulta.getString(12));
                ingresosAbril.setTzedaqah(cursorConsulta.getString(13));
                ingresosAbril.setKaparah(cursorConsulta.getString(14));
                ingresosAbril.setArriendo(cursorConsulta.getString(15));
                ingresosAbril.setTotalSemana(cursorConsulta.getDouble(16));


                ingresosAbrilList.add(ingresosAbril);
            }while(cursorConsulta.moveToNext());
        }
        cursorConsulta.close();
        return  ingresosAbrilList;
    }
    public List<IngresosAbril>leerRegistroPorId (int idUsuarioCom) throws AppException {
        List<IngresosAbril> ingresosAbrilListIdUsuario= new ArrayList<>();
        cursorConsulta= ingresoAbrilDAC.leerPorId(idUsuarioCom);
        if(cursorConsulta.moveToFirst()){
            do{
                ingresosAbril= new IngresosAbril();
                ingresosAbril.setIdMes(cursorConsulta.getInt(0));
                ingresosAbril.setNombreMes(cursorConsulta.getString(1));
                ingresosAbril.setAnnoMes(cursorConsulta.getString(2));
                ingresosAbril.setIdUsuarioCom(cursorConsulta.getInt(3));
                ingresosAbril.setNombreJaver(cursorConsulta.getString(4));
                ingresosAbril.setApellidoJaver(cursorConsulta.getString(5));
                ingresosAbril.setCedulaJaver(cursorConsulta.getString(6));
                ingresosAbril.setSemanaFechaIng(cursorConsulta.getString(7));
                ingresosAbril.setMasserBaitHaM(cursorConsulta.getString(8));
                ingresosAbril.setRoshJodesh(cursorConsulta.getString(9));
                ingresosAbril.setTerumahYeladim(cursorConsulta.getString(10));
                ingresosAbril.setTerreno(cursorConsulta.getString(11));
                ingresosAbril.setShuljan(cursorConsulta.getString(12));
                ingresosAbril.setTzedaqah(cursorConsulta.getString(13));
                ingresosAbril.setKaparah(cursorConsulta.getString(14));
                ingresosAbril.setArriendo(cursorConsulta.getString(15));
                ingresosAbril.setTotalSemana(cursorConsulta.getDouble(16));


                ingresosAbrilListIdUsuario.add(ingresosAbril);
            }while(cursorConsulta.moveToNext());
        }
        cursorConsulta.close();
        return  ingresosAbrilListIdUsuario;
    }
}
