package com.example.appcomunidad.BusinessLogic.managers;

import android.content.Context;

import com.example.appcomunidad.BusinessLogic.entities.IngresosAgosto;
import com.example.appcomunidad.BusinessLogic.entities.IngresosJulio;
import com.example.appcomunidad.data_acess.IngresoAgostoDAC;
import com.example.appcomunidad.framework.AppException;

import java.util.ArrayList;
import java.util.List;

public class IngresoAgostoBL extends GestorBL{
    private IngresoAgostoDAC ingresoAgostoDAC;
    private IngresosAgosto ingresosAgosto;
    /**
     * Construcutos de la clase GestorBL.
     *
     * @param contexto el contexto del activity.
     */
    public IngresoAgostoBL(Context contexto) {
        super(contexto);
        ingresoAgostoDAC = new IngresoAgostoDAC(contexto);
        ingresosAgosto= new IngresosAgosto();
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
            double totalSemana_AG) {
        return ingresoAgostoDAC.insertarRegistro(nombreMes, añoMes, idUsuarioCom, nombreJaverIng, apellidoJaverIng, cedulaJaverIng, semanaFechaIngreso, masserBaitHaM, roshJodesh, terumahYeladim, terreno, shuljan, tzedaqah, kaparah, arriendo, totalSemana_AG);
    }
    public List<IngresosAgosto> leerTodosRegistros () throws AppException {
        List<IngresosAgosto> ingresosAgostoList= new ArrayList<>();
        cursorConsulta= ingresoAgostoDAC.leerRegistros();
        if(cursorConsulta.moveToFirst()){
            do{
                ingresosAgosto= new IngresosAgosto();
                ingresosAgosto.setIdMes(cursorConsulta.getInt(0));
                ingresosAgosto.setNombreMes(cursorConsulta.getString(1));
                ingresosAgosto.setAnnoMes(cursorConsulta.getString(2));
                ingresosAgosto.setIdUsuarioCom(cursorConsulta.getInt(3));
                ingresosAgosto.setNombreJaver(cursorConsulta.getString(4));
                ingresosAgosto.setApellidoJaver(cursorConsulta.getString(5));
                ingresosAgosto.setCedulaJaver(cursorConsulta.getString(6));
                ingresosAgosto.setSemanaFechaIng(cursorConsulta.getString(7));
                ingresosAgosto.setMasserBaitHaM(cursorConsulta.getString(8));
                ingresosAgosto.setRoshJodesh(cursorConsulta.getString(9));
                ingresosAgosto.setTerumahYeladim(cursorConsulta.getString(10));
                ingresosAgosto.setTerreno(cursorConsulta.getString(11));
                ingresosAgosto.setShuljan(cursorConsulta.getString(12));
                ingresosAgosto.setTzedaqah(cursorConsulta.getString(13));
                ingresosAgosto.setKaparah(cursorConsulta.getString(14));
                ingresosAgosto.setArriendo(cursorConsulta.getString(15));
                ingresosAgosto.setTotalSemana(cursorConsulta.getDouble(16));


                ingresosAgostoList.add(ingresosAgosto);
            }while(cursorConsulta.moveToNext());
        }
        cursorConsulta.close();
        return  ingresosAgostoList;
    }
    public List<IngresosAgosto>leerRegistroPorId (int idUsuarioCom) throws AppException {
        List<IngresosAgosto> ingresosAgostoListIdUsuario= new ArrayList<>();
        cursorConsulta= ingresoAgostoDAC.leerPorId(idUsuarioCom);
        if(cursorConsulta.moveToFirst()){
            do{
                ingresosAgosto= new IngresosAgosto();
                ingresosAgosto.setIdMes(cursorConsulta.getInt(0));
                ingresosAgosto.setNombreMes(cursorConsulta.getString(1));
                ingresosAgosto.setAnnoMes(cursorConsulta.getString(2));
                ingresosAgosto.setIdUsuarioCom(cursorConsulta.getInt(3));
                ingresosAgosto.setNombreJaver(cursorConsulta.getString(4));
                ingresosAgosto.setApellidoJaver(cursorConsulta.getString(5));
                ingresosAgosto.setCedulaJaver(cursorConsulta.getString(6));
                ingresosAgosto.setSemanaFechaIng(cursorConsulta.getString(7));
                ingresosAgosto.setMasserBaitHaM(cursorConsulta.getString(8));
                ingresosAgosto.setRoshJodesh(cursorConsulta.getString(9));
                ingresosAgosto.setTerumahYeladim(cursorConsulta.getString(10));
                ingresosAgosto.setTerreno(cursorConsulta.getString(11));
                ingresosAgosto.setShuljan(cursorConsulta.getString(12));
                ingresosAgosto.setTzedaqah(cursorConsulta.getString(13));
                ingresosAgosto.setKaparah(cursorConsulta.getString(14));
                ingresosAgosto.setArriendo(cursorConsulta.getString(15));
                ingresosAgosto.setTotalSemana(cursorConsulta.getDouble(16));


                ingresosAgostoListIdUsuario.add(ingresosAgosto);
            }while(cursorConsulta.moveToNext());
        }
        cursorConsulta.close();
        return  ingresosAgostoListIdUsuario;
    }
}
