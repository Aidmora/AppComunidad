package com.example.appcomunidad.data_acess;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.text.TextUtils;
import android.util.Log;

import androidx.annotation.Nullable;

import com.example.appcomunidad.framework.AppException;

import java.io.BufferedReader;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;

/**
 * Conexion a la base de datos para las operaciones de CRUD
 */
public abstract class GestorBaseDatos extends SQLiteOpenHelper {
    private static final int BASEDATOS_VERSION = 1;
    private static final String BASEDATOS_NOMBRE = "MajanehBD.db";
    protected static final String TABLA_USUARIO = "USUARIO";
    protected static final String TABLA_USUARIO_ROL = "USUARIO_ROL";
    protected static final String TABLA_USUARIO_COMUNIDAD = "USUARIO_COMUNIDAD";
    protected static final String TABLA_USUARIO_CREDENCIAL = "USUARIO_CREDENCIAL";
    protected static final String TABLA_REGISTRO_USUARIO = "REGISTRO_USUARIO";
    protected static final String TABLA_INGRESOS_ENERO="INGRESOS_ENERO";
    protected static final String TABLA_INGRESOS_FEBRERO="INGRESOS_FEBRERO";
    protected static final String TABLA_INGRESOS_MARZO="INGRESOS_MARZO";
    protected static final String TABLA_INGRESOS_ABRIL="INGRESOS_ABRIL";
    protected static final String TABLA_INGRESOS_MAYO="INGRESOS_MAYO";
    protected static final String TABLA_INGRESOS_JUNIO="INGRESOS_JUNIO";
    protected static final String TABLA_INGRESOS_JULIO="INGRESOS_JULIO";
    protected static final String TABLA_INGRESOS_AGOSTO="INGRESOS_AGOSTO";
    protected static final String TABLA_INGRESOS_SEPTIEMBRE="INGRESOS_SEPTIEMBRE";
    protected static final String TABLA_INGRESOS_OCTUBRE="INGRESOS_OCTUBRE";
    protected static final String TABLA_INGRESOS_NOVIEMBRE="INGRESOS_NOVIEMBRE";
    protected static final String TABLA_INGRESOS_DICIEMBRE="INGRESOS_DICIEMBRE";
    protected Context contexto;
    protected ContentValues valoresContenido;
    protected String consultaSQL;
    protected Cursor cursorConsulta;

    public GestorBaseDatos(@Nullable Context contexto) {
        super(contexto, BASEDATOS_NOMBRE, null, BASEDATOS_VERSION);
        this.contexto = contexto;
    }

    /**
     * onCreate: Crea la base de datos
     *
     * @param sqLiteDatabase
     */
    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        try {
            InputStream inputStream = contexto.getAssets().open("schema.sql");
            InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
            BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
            String line;
            StringBuilder query = new StringBuilder();

            while ((line = bufferedReader.readLine()) != null) {
                query.append(line).append("\n");
            }

            Log.d("GestorBaseDatos", "Contenido de schema.sql:\n" + query.toString());

            String[] queries = query.toString().split(";");
            for (String sql : queries) {
                if (!TextUtils.isEmpty(sql.trim())) {
                    Log.d("GestorBaseDatos", "Ejecutando SQL:\n" + sql);
                    sqLiteDatabase.execSQL(sql);
                }
            }

            bufferedReader.close();
            inputStreamReader.close();
            inputStream.close();
        } catch (IOException e) {
            Log.e("GestorBaseDatos", "Error al leer y ejecutar el archivo schema.sql", e);
        }
    }

    /**
     * Actualiza la base de datos
     *
     * @param sqLiteDatabase
     * @param i
     * @param i1
     */
    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
    }



    /**
     * obtenerConsulta:  facilita la ejecucion de consultas SQL en la base de datos
     * y devuelve un Cursor que permite acceder a los resultados de la consulta.
     *
     * @param consultaSQL
     * @param valores
     * @return
     * @throws AppException
     */
    protected Cursor obtenerConsulta(String consultaSQL, String[] valores) throws AppException {
        try {
            cursorConsulta = getReadableDatabase().rawQuery(consultaSQL, valores);
            return cursorConsulta;
        } catch (SQLException error) {
            throw new AppException(error, getClass(), "obtenerConsulta()");
        }
    }
    public abstract Cursor leerRegistros() throws AppException;
    public abstract Cursor leerPorId(int idRegistro) throws AppException;

}
