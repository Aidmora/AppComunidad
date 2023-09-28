package com.example.appcomunidad.data_acess;

import android.content.Context;
import android.database.Cursor;

import androidx.annotation.Nullable;

import com.example.appcomunidad.framework.AppException;

public class UsuarioComunidadDAC extends  GestorBaseDatos{
    public UsuarioComunidadDAC(@Nullable Context contexto) {
        super(contexto);
    }

    @Override
    public Cursor leerRegistros() throws AppException {
        consultaSQL="SELECT IdUsuarioCom, NombreJaver, ApellidoJaver, EstadoCivil, CedulaJaver, CelularJaver, CorreoJaver, fotoJaver, Estado "
                    + " FROM "+ TABLA_USUARIO_COMUNIDAD
                    + " WHERE Estado = '1' ";
        return obtenerConsulta(consultaSQL, null);
    }

    @Override
    public Cursor leerPorId(int idRegistro) throws AppException {
        return null;
    }
}
