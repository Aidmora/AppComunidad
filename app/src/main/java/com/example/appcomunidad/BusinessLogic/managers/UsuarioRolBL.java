package com.example.appcomunidad.BusinessLogic.managers;

import android.content.Context;
import android.util.Log;

import com.example.appcomunidad.BusinessLogic.entities.UsuarioRol;
import com.example.appcomunidad.data_acess.UsuarioRolDAC;
import com.example.appcomunidad.framework.AppException;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

public class UsuarioRolBL extends GestorBL{
    /**
     * Construcutos de la clase GestorBL.
     *
     * @param contexto el contexto del activity.
     */
    protected UsuarioRol usuarioRol;
    protected UsuarioRolDAC usuarioRolDAC;
    public UsuarioRolBL(Context contexto) {
        super(contexto);
        usuarioRol= new UsuarioRol();
        usuarioRolDAC= new UsuarioRolDAC(contexto);
    }
    public List<UsuarioRol> obtenerRolesUsario() throws AppException {
        List<UsuarioRol> lstUsuariosRol = new ArrayList<>();
        cursorConsulta = usuarioRolDAC.leerRegistros();

        if (cursorConsulta.moveToFirst()) {
            do {
                usuarioRol = new UsuarioRol();
                usuarioRol.setId(cursorConsulta.getInt(0));
                usuarioRol.setNombre(cursorConsulta.getString(1));
                usuarioRol.setEstado(cursorConsulta.getInt(2));

                try {
                    // Utiliza java.util.Date en lugar de java.sql.Date
                    usuarioRol.setFechaIngreso(formatoFechaHora.parse(cursorConsulta.getString(3)));
                    usuarioRol.setFechaModificacion(formatoFechaHora.parse(cursorConsulta.getString(4)));
                } catch (ParseException error) {
                    throw new AppException(error, getClass(), "obtenerRegistrosActivos()");
                }

                lstUsuariosRol.add(usuarioRol);
            } while (cursorConsulta.moveToNext());
        }

        return lstUsuariosRol;
    }

    public UsuarioRol obtenerRolUsuario(int IdRol) throws AppException {
        cursorConsulta = usuarioRolDAC.leerPorId(IdRol);

        try {
            if (cursorConsulta.moveToFirst()) {
                Log.i("Obtener Rol Usuario - USUARIO ROL BL", "Sí existe una consulta");
                usuarioRol = new UsuarioRol();
                usuarioRol.setId(cursorConsulta.getInt(0));
                usuarioRol.setNombre(cursorConsulta.getString(1));
                usuarioRol.setEstado(cursorConsulta.getInt(2));
                usuarioRol.setFechaIngreso(formatoFechaHora.parse(cursorConsulta.getString(3)));
                usuarioRol.setFechaModificacion(formatoFechaHora.parse(cursorConsulta.getString(4)));
            } else {
                // Si no se encontraron resultados, puedes lanzar una excepción o devolver null según tu preferencia
                // throw new AppException("No se encontró un rol con el ID proporcionado.");
                return null;
            }
        } catch (ParseException error) {
            // Manejo de excepción específico para problemas de formato de fecha
            throw new AppException(error, getClass(), "obtenerRolUsuario()");
        } finally {
            // Asegúrate de cerrar el cursor en el bloque finally
            if (cursorConsulta != null && !cursorConsulta.isClosed()) {
                cursorConsulta.close();
            }
        }

        return usuarioRol;
    }

}
