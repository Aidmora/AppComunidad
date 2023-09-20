package com.example.appcomunidad.data_acess;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import androidx.annotation.Nullable;

import com.example.appcomunidad.framework.AppException;

/**
 * Este es el DAC para usuario.
 */
public class UsuarioDAC extends GestorBaseDatos {

    public UsuarioDAC(@Nullable Context contexto) {
        super(contexto);
    }

    @Override
    public Cursor leerRegistros() throws AppException {
        consultaSQL = "SELECT  COUNT(*) maxIdUsuario "
                        +" FROM "+ TABLA_USUARIO
                        +" WHERE ESTADO = '1' ";
        cursorConsulta = obtenerConsulta(consultaSQL,null);
        if (cursorConsulta != null) {
            Log.i("leerRegistros-USUARIODAC","Si esta devolviendo el maximo"+cursorConsulta+"");
        }
        return cursorConsulta ;
    }

    /**
     * leerRegistros: Se encarga de leer los registros activos en la tabla "Usuario"
     * @return cursorConsulta:Representa la tabla de registros activos, obtenidos a partir del query.
     * @throws AppException
     */


    /**
     * leerPorId: Se encarga de leer los registros activos en la tabla "Usuario" a partir de un Id de
     * usuario especifico.
     * @param idRegistro: Representa al Id del usuario.
     * @return cursorConsulta:Representa la tabla de registros activos, obtenidos a partir del query.
     * @throws AppException
     */


    /**
     * insertarRegistro: Se encarga de insertar un nuevo registro en la tabla "Usuario"
     * @param IdRol Representa el Id del Rol.
     * @param nombre Representa el nombre del usuario
     * @param correo Representa al correo del usuario:
     * @param celular Representa el número celular del usuario.
     * @return long Representa el identificador del registro que ha sido insertado.
     */
    public long insertarRegistro(int IdRol, String nombre, String correo, String celular) {
        valoresContenido = new ContentValues();
        valoresContenido.put("IdRol", IdRol);
        valoresContenido.put("Nombre", nombre);
        valoresContenido.put("Correo", correo);
        valoresContenido.put("Celular", celular);
        SQLiteDatabase db= getWritableDatabase();
        if(db!=null){
            Log.i("insertarRegistro - USUARIO DAC","La base de datos se creo con exito");
        }
        return db.insert(TABLA_USUARIO, null, valoresContenido);
    }

    /**
     * actualizarRegistro: Se encarga de actualizar los datos de un Usuario en la respectiva tabla.
     * @param IdRol Representa el Id del rol
     * @param nombre Representa el nombre del usuario
     * @param correo Representa el correo del usuario
     * @param celular Representa el numero celular del usuario.
     * @return long Representa el numero de registros que se han actializado en la tabla.
     */
    public long actualizarRegistro(int IdRol, String nombre, String correo, String celular) {
        String[] valores = new String[] {String.valueOf(IdRol)};
        valoresContenido = new ContentValues();
        valoresContenido.put("Nombre", nombre);
        valoresContenido.put("Correo", correo);
        valoresContenido.put("Celular", celular);
        return getWritableDatabase().update(TABLA_USUARIO,valoresContenido,"IdRol= ?",valores);
    }
    public Cursor leerTodosRegistros() throws AppException {
        consultaSQL = " SELECT IdUsuario, IdRol, Nombre, Correo, Celular, Estado, FechaRegistro, FechaModificacion "
                + " FROM " + TABLA_USUARIO
                + " WHERE Estado = '1' ";
        return obtenerConsulta(consultaSQL, null);
    }
}
