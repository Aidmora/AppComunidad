package com.example.appcomunidad.BusinessLogic.managers;

import android.content.Context;

import com.example.appcomunidad.BusinessLogic.entities.IngresosOctubre;
import com.example.appcomunidad.BusinessLogic.entities.IngresosSeptiembre;
import com.example.appcomunidad.data_acess.IngresoOctubreDAC;
import com.example.appcomunidad.framework.AppException;

import java.util.ArrayList;
import java.util.List;

public class IngresoOctubreBL extends GestorBL {
    private IngresoOctubreDAC ingresoOctubreDAC;
    private IngresosOctubre ingresosOctubre;
    /**
     * Construcutos de la clase GestorBL.
     *
     * @param contexto el contexto del activity.
     */
    public IngresoOctubreBL(Context contexto) {
        super(contexto);
        ingresoOctubreDAC= new IngresoOctubreDAC(contexto);
        ingresosOctubre= new IngresosOctubre();
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
            double totalSemana_O) {
        return ingresoOctubreDAC.insertarRegistro(nombreMes, añoMes, idUsuarioCom, nombreJaverIng, apellidoJaverIng, cedulaJaverIng, semanaFechaIngreso, masserBaitHaM, roshJodesh, terumahYeladim, terreno, shuljan, tzedaqah, kaparah, arriendo, totalSemana_O);
    }
    public List<IngresosOctubre> leerTodosRegistros () throws AppException {
        List<IngresosOctubre> ingresosSOctubreList= new ArrayList<>();
        cursorConsulta= ingresoOctubreDAC.leerRegistros();
        if(cursorConsulta.moveToFirst()){
            do{
                ingresosOctubre= new IngresosOctubre();
                ingresosOctubre.setIdMes(cursorConsulta.getInt(0));
                ingresosOctubre.setNombreMes(cursorConsulta.getString(1));
                ingresosOctubre.setAnnoMes(cursorConsulta.getString(2));
                ingresosOctubre.setIdUsuarioCom(cursorConsulta.getInt(3));
                ingresosOctubre.setNombreJaver(cursorConsulta.getString(4));
                ingresosOctubre.setApellidoJaver(cursorConsulta.getString(5));
                ingresosOctubre.setCedulaJaver(cursorConsulta.getString(6));
                ingresosOctubre.setSemanaFechaIng(cursorConsulta.getString(7));
                ingresosOctubre.setMasserBaitHaM(cursorConsulta.getString(8));
                ingresosOctubre.setRoshJodesh(cursorConsulta.getString(9));
                ingresosOctubre.setTerumahYeladim(cursorConsulta.getString(10));
                ingresosOctubre.setTerreno(cursorConsulta.getString(11));
                ingresosOctubre.setShuljan(cursorConsulta.getString(12));
                ingresosOctubre.setTzedaqah(cursorConsulta.getString(13));
                ingresosOctubre.setKaparah(cursorConsulta.getString(14));
                ingresosOctubre.setArriendo(cursorConsulta.getString(15));
                ingresosOctubre.setTotalSemana(cursorConsulta.getDouble(16));


                ingresosSOctubreList.add( ingresosOctubre);
            }while(cursorConsulta.moveToNext());
        }
        cursorConsulta.close();
        return  ingresosSOctubreList;
    }
    public List<IngresosOctubre>leerRegistroPorId (int idUsuarioCom) throws AppException {
        List<IngresosOctubre> ingresosOctubreListIdUsuario= new ArrayList<>();
        cursorConsulta= ingresoOctubreDAC.leerPorId(idUsuarioCom);
        if(cursorConsulta.moveToFirst()){
            do{
                ingresosOctubre= new IngresosOctubre();
                ingresosOctubre.setIdMes(cursorConsulta.getInt(0));
                ingresosOctubre.setNombreMes(cursorConsulta.getString(1));
                ingresosOctubre.setAnnoMes(cursorConsulta.getString(2));
                ingresosOctubre.setIdUsuarioCom(cursorConsulta.getInt(3));
                ingresosOctubre.setNombreJaver(cursorConsulta.getString(4));
                ingresosOctubre.setApellidoJaver(cursorConsulta.getString(5));
                ingresosOctubre.setCedulaJaver(cursorConsulta.getString(6));
                ingresosOctubre.setSemanaFechaIng(cursorConsulta.getString(7));
                ingresosOctubre.setMasserBaitHaM(cursorConsulta.getString(8));
                ingresosOctubre.setRoshJodesh(cursorConsulta.getString(9));
                ingresosOctubre.setTerumahYeladim(cursorConsulta.getString(10));
                ingresosOctubre.setTerreno(cursorConsulta.getString(11));
                ingresosOctubre.setShuljan(cursorConsulta.getString(12));
                ingresosOctubre.setTzedaqah(cursorConsulta.getString(13));
                ingresosOctubre.setKaparah(cursorConsulta.getString(14));
                ingresosOctubre.setArriendo(cursorConsulta.getString(15));
                ingresosOctubre.setTotalSemana(cursorConsulta.getDouble(16));


                ingresosOctubreListIdUsuario.add( ingresosOctubre);
            }while(cursorConsulta.moveToNext());
        }
        cursorConsulta.close();
        return  ingresosOctubreListIdUsuario;
    }
}
