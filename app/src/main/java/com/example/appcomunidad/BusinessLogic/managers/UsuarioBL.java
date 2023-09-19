package com.example.appcomunidad.BusinessLogic.managers;

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
}
