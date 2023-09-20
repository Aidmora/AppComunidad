package com.example.appcomunidad.BusinessLogic.managers;

import android.annotation.SuppressLint;
import android.content.Context;
import android.util.Log;


import com.example.appcomunidad.BusinessLogic.entities.Usuario;
import com.example.appcomunidad.data_acess.UsuarioDAC;
import com.example.appcomunidad.framework.AppException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

/**
 * Corresponde a la logica de negocios correspondiente a usuario.
 */
public class UsuarioBL extends GestorBL{
    private Usuario usuario;
    private UsuarioDAC usuarioDAC;


    public UsuarioBL(Context contexto) {
        super(contexto);
        usuarioDAC = new UsuarioDAC(contexto);
        usuario = new Usuario();
    }



    /**
     * ingresarRegistro: Se encarga de insertar un usuario en la base de datos.
     * @param idRol: Representa el Id del rol
     * @param nombre: Representa el nombre del usuario
     * @param correo: Representa el correo del usuario
     * @param celular: Representa el numero celular del usuario.
     * @return long: Representa el identificador del registro ingresado
     */
    public long ingresarRegistro(int idRol, String nombre, String correo, String celular) {
        return usuarioDAC.insertarRegistro(idRol, nombre, correo, celular);
    }

    /**
     * actualizarRegistro: Se encarga de actualizar la informacion de un usuario en la base de datos.
     * @param idRol: Representa el Id del rol
     * @param nombre: Representa el nombre del usuario
     * @param correo: Representa el correo del usuario
     * @param celular: Representa el numero celular del usuario.
     * @return long: Representa el identificador del registro actualizado.
     */
    public long actualizarRegistro(int idRol, String nombre, String correo, String celular){
        return usuarioDAC.actualizarRegistro(idRol,  nombre,  correo, celular);
    }
    @SuppressLint("Range")
    public int obtenerMaximoRegistroUsuario() throws AppException {
        cursorConsulta = usuarioDAC.leerRegistros();
        if (cursorConsulta != null && cursorConsulta.moveToFirst()) {
            int columnIndex = cursorConsulta.getColumnIndex("maxIdUsuario");
            if (columnIndex != -1) {
                int maximoRegistroUsuario = cursorConsulta.getInt(columnIndex);
                if(maximoRegistroUsuario>0){
                    Log.i("obtenerMaximoRegistro-USUARIO BL","Si esta devolviendo un valor "+maximoRegistroUsuario+"");
                }

                cursorConsulta.close();

                return maximoRegistroUsuario;
            }
        }
        return -1;
    }
    public List<Usuario> obtenerRegistrosActivos() throws AppException {
        List<Usuario> listaUsuarios = new ArrayList<>();
        cursorConsulta = usuarioDAC.leerTodosRegistros();

        if (cursorConsulta.moveToFirst()) {
            do {
                usuario = new Usuario();
                usuario.setId(cursorConsulta.getInt(0));
                usuario.setIdRol(cursorConsulta.getInt(1));
                usuario.setNombre(cursorConsulta.getString(2));
                usuario.setCorreo(cursorConsulta.getString(3));
                usuario.setCelular(cursorConsulta.getString(4));
                usuario.setEstado(cursorConsulta.getInt(5));
                try {
                    usuario.setFechaRegistro(formatoFechaHora.parse(cursorConsulta.getString(6)));
                    usuario.setFechaModificacion(formatoFechaHora.parse(cursorConsulta.getString(7)));
                } catch (ParseException error) {
                    throw new AppException(error, getClass(), "obtenerRegistrosActivos()");
                }
                listaUsuarios.add(usuario);
            } while (cursorConsulta.moveToNext());
        }

        cursorConsulta.close();
        return listaUsuarios;
    }
}
