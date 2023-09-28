package com.example.appcomunidad.BusinessLogic.managers;

import android.content.Context;

import com.example.appcomunidad.BusinessLogic.entities.UsuarioComunidad;
import com.example.appcomunidad.data_acess.UsuarioComunidadDAC;
import com.example.appcomunidad.data_acess.UsuarioDAC;
import com.example.appcomunidad.framework.AppException;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

public class UsuarioComunidadBL extends  GestorBL{
    private UsuarioComunidadDAC usuarioComunidadDAC;
    private UsuarioComunidad usuarioComunidad;
    /**
     * Construcutos de la clase GestorBL.
     *
     * @param contexto el contexto del activity.
     */
    public UsuarioComunidadBL(Context contexto) {
        super(contexto);
        usuarioComunidad=new UsuarioComunidad();
        usuarioComunidadDAC=new UsuarioComunidadDAC(contexto);
    }
    public List<UsuarioComunidad> obtenerRegistrosActivos() throws AppException {
        List<UsuarioComunidad> listaUsuariosComunidad= new ArrayList<>();
        cursorConsulta= usuarioComunidadDAC.leerRegistros();
        if(cursorConsulta.moveToFirst()){
            do{
                usuarioComunidad= new UsuarioComunidad();
                usuarioComunidad.setIdUsuarioComunidad(cursorConsulta.getInt(0));
                usuarioComunidad.setNombreJaver(cursorConsulta.getString(1));
                usuarioComunidad.setApellidoJaver(cursorConsulta.getString(2));
                usuarioComunidad.setEstadoCivil(cursorConsulta.getString(3));
                usuarioComunidad.setCedula(cursorConsulta.getString(4));
                usuarioComunidad.setCelularJaver(cursorConsulta.getString(5));
                usuarioComunidad.setCorreoJaver(cursorConsulta.getString(6));
                usuarioComunidad.setFotoJaver(cursorConsulta.getString(7));
                usuarioComunidad.setEstado(cursorConsulta.getInt(8));
                listaUsuariosComunidad.add(usuarioComunidad);
            }while(cursorConsulta.moveToNext());
        }
        return listaUsuariosComunidad;
    }
}
