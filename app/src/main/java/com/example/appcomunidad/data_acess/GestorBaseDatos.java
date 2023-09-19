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
    private static final int BASEDATOS_VERSION = 2;
    private static final String BASEDATOS_NOMBRE = "FeridemBD.db";
    protected static final String TABLA_USUARIO = "USUARIO";
    protected static final String TABLA_USUARIO_ROL = "USUARIO_ROL";
    protected static final String TABLA_USUARIO_CREDENCIAL = "USUARIO_CREDENCIAL";
    protected static final String TABLA_REGISTRO_USUARIO = "REGISTRO_USUARIO";
    protected Context contexto;
    protected ContentValues valoresContenido;
    protected String consultaSQL;
    protected Cursor cursorConsulta;
    private final String rutaBaseDatos;

    public GestorBaseDatos(@Nullable Context contexto) {
        super(contexto, BASEDATOS_NOMBRE, null, BASEDATOS_VERSION);
        this.contexto = contexto;
        this.rutaBaseDatos = contexto.getDatabasePath(BASEDATOS_NOMBRE).getPath();
    }

    /**
     * onCreate: Crea la base de datos
     *
     * @param db
     */
    @Override
    public void onCreate(SQLiteDatabase db) {

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

    public void abrirBaseDatos() {
        Log.i("GestorBaseDatos", "Se está creando x2");

        try {
            // Abre el archivo de base de datos desde los activos
            InputStream inputStream = contexto.getAssets().open(BASEDATOS_NOMBRE);
            if(inputStream!=null){
                Log.i("GestorBaseDatos", "Se está creando x3");
            }

            // Ruta de destino donde se copiará el archivo de la base de datos
            String outputPath = contexto.getDatabasePath(BASEDATOS_NOMBRE).getPath();

            // Abre un flujo de salida hacia el archivo de destino
            OutputStream outputStream = new FileOutputStream(outputPath);

            // Copia los datos del archivo de activos al archivo de destino
            byte[] buffer = new byte[1024];
            int length;
            while ((length = inputStream.read(buffer)) > 0) {
                outputStream.write(buffer, 0, length);
            }

            // Cierra los flujos
            inputStream.close();
            outputStream.close();

            Log.i("GestorBaseDatos", "Base de datos copiada con éxito");
        } catch (IOException e) {
            e.printStackTrace();
            Log.e("GestorBaseDatos", "Error al copiar la base de datos desde los activos");
        }
    }
    public void crearTablasDesdeEsquema() throws AppException {
        try {
            SQLiteDatabase db = getWritableDatabase();
            // Lee el archivo de esquema desde los activos
            InputStream inputStream = contexto.getAssets().open("schema.sql");
            InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
            BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
            StringBuilder stringBuilder = new StringBuilder();
            String line;

            // Lee el archivo línea por línea y agrega las sentencias al StringBuilder
            while ((line = bufferedReader.readLine()) != null) {
                stringBuilder.append(line).append("\n");
            }

            // Ejecuta las sentencias SQL desde el archivo
            String[] sentenciasSQL = stringBuilder.toString().split(";");
            for (String sentencia : sentenciasSQL) {
                if (!TextUtils.isEmpty(sentencia.trim())) {
                    db.execSQL(sentencia);
                }
            }
        } catch (Exception error) {
            throw new AppException(error, getClass(), "crearTablasDesdeEsquema()");
        }
    }

    /**
     * copiarBaseDatos:  se utiliza para copiar una base de datos desde los activos de la aplicacion
     * a una ubicacion en el dispositivo, lo que permite a la aplicacion acceder y utilizar la base
     * de datos en su funcionamiento.
     *
     * @throws AppException
     */
    public void copiarBaseDatos() throws AppException {
        Log.i("GestorBaseDatos", "Copiando base de datos...");
        try {
            InputStream inputStream = contexto.getAssets().open("file:///android_asset/" + BASEDATOS_NOMBRE);
            Log.i("CopiarBaseDatos", "Abriendo el archivo de base de datos en assets...");
            OutputStream outputStream = new FileOutputStream(rutaBaseDatos);
            byte[] buffer = new byte[1024];
            int length;
            while ((length = inputStream.read(buffer)) > 0) {
                outputStream.write(buffer, 0, length);
            }
            Log.i("GestorBaseDatos", "Copia de la base de datos completada.");
        } catch (Exception error) {
            throw new AppException(error, getClass(), "copiarBaseDatos()");
        }
    }

    public void comprobarBaseDatos() throws AppException {
        Log.i("GestorBaseDatos", "Comprobando base de datos...");
        SQLiteDatabase sqliteBaseDatos = null;
        try {
            sqliteBaseDatos = SQLiteDatabase.openDatabase(rutaBaseDatos, null, 0);
            Log.i("GestorBaseDatos", "Base de datos abierta con éxito.");
        } catch (SQLException error) {
            Log.e("GestorBaseDatos", "Error al abrir la base de datos: " + error.getMessage());
        }
        if (sqliteBaseDatos == null) {
            Log.i("GestorBaseDatos", "La base de datos no existe, intentando copiarla...");
            copiarBaseDatos();
        }
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
