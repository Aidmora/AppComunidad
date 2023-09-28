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
    protected Context contexto;
    protected ContentValues valoresContenido;
    protected String consultaSQL;
    protected Cursor cursorConsulta;

    public GestorBaseDatos(@Nullable Context contexto) {
        super(contexto, BASEDATOS_NOMBRE, null, BASEDATOS_VERSION);

    }

    /**
     * onCreate: Crea la base de datos
     *
     * @param sqLiteDatabase
     */
    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL("CREATE TABLE " + TABLA_USUARIO_ROL + " (" +
                "IdRol                  INTEGER PRIMARY KEY NOT NULL," +
                "Nombre                 TEXT CHECK(length(Nombre) <= 100) NOT NULL," +
                "Estado                 TEXT DEFAULT '1'," +
                "FechaRegistro          DATETIME DEFAULT (datetime('now'))," +
                "FechaModificacion      DATETIME DEFAULT (datetime('now'))" +
                ");");
        sqLiteDatabase.execSQL("CREATE TABLE " + TABLA_USUARIO_COMUNIDAD + " (" +
                "IdUsuarioCom                  INTEGER PRIMARY KEY NOT NULL," +
                "NombreJaver               TEXT CHECK(length(NombreJaver) <= 100) NOT NULL," +
                "ApellidoJaver               TEXT CHECK(length(ApellidoJaver) <= 100) NOT NULL," +
                "EstadoCivil              TEXT CHECK(length(EstadoCivil) <= 100) NOT NULL," +
                "CedulaJaver               TEXT CHECK(length(CedulaJaver) <= 60) NOT NULL," +
                "CelularJaver               TEXT CHECK(length(CelularJaver) <= 60) NOT NULL," +
                "CorreoJaver               TEXT CHECK(length(CorreoJaver) <= 100) NOT NULL," +
                "fotoJaver               TEXT CHECK(length(fotoJaver) <= 200) NOT NULL," +
                "Estado                 TEXT DEFAULT '1'," +
                "FechaRegistro          DATETIME DEFAULT (datetime('now'))," +
                "FechaModificacion      DATETIME DEFAULT (datetime('now'))" +
                ");");
        sqLiteDatabase.execSQL("INSERT INTO " + TABLA_USUARIO_COMUNIDAD+ " ( NombreJaver, ApellidoJaver, EstadoCivil, CedulaJaver, CelularJaver, CorreoJaver,fotoJaver) " +
                "VALUES ( 'Josef', 'Mora', 'Soltero', '1724681513', '0992107227', 'josef@gmail.com', 'ic_imagen_autor');");
        sqLiteDatabase.execSQL("INSERT INTO " + TABLA_USUARIO_COMUNIDAD+ " ( NombreJaver, ApellidoJaver, EstadoCivil, CedulaJaver, CelularJaver, CorreoJaver,fotoJaver) " +
                "VALUES ( 'Steffy', 'Lucio', 'Soltera', '1724567113', '0995467898', 'steffy@gmail.com', 'ic_imagen_autor');");
        sqLiteDatabase.execSQL("CREATE TABLE " + TABLA_USUARIO + " (" +
                "IdUsuario              INTEGER PRIMARY KEY NOT NULL," +
                "IdRol                  INTEGER NOT NULL," +
                "Nombre                 TEXT CHECK(length(Nombre) <= 100) NOT NULL," +
                "Correo                 TEXT CHECK(length(Correo) <= 200) NOT NULL," +
                "Celular                TEXT CHECK(length(Celular) <= 100) NOT NULL," +
                "Estado                 TEXT DEFAULT '1'," +
                "FechaRegistro          DATETIME DEFAULT (datetime('now'))," +
                "FechaModificacion      DATETIME DEFAULT (datetime('now'))," +
                "CONSTRAINT FK_IdRol FOREIGN KEY(IdRol) REFERENCES " + TABLA_USUARIO_ROL + "(IdRol)" +
                ");");

        sqLiteDatabase.execSQL("CREATE TABLE " + TABLA_USUARIO_CREDENCIAL + " (" +
                "IdUsuario              INTEGER NOT NULL," +
                "Contrasena             TEXT CHECK(length(Contrasena) <= 300) NOT NULL,"+
                "Estado                 TEXT DEFAULT '1'," +
                "FechaRegistro          DATETIME DEFAULT (datetime('now'))," +
                "FechaModificacion      DATETIME DEFAULT (datetime('now'))," +
                "CONSTRAINT FK_IdUsuario FOREIGN KEY(IdUsuario) REFERENCES " + TABLA_USUARIO + "(IdUsuario)" +
                ");");
        sqLiteDatabase.execSQL("INSERT INTO " + TABLA_USUARIO_CREDENCIAL + " ( IdUsuario, Contrasena) " +
                "VALUES ( 1,'119ce1ac2e100ee9ce9d3b3b7f0debcf');");

        sqLiteDatabase.execSQL("CREATE TABLE " + TABLA_REGISTRO_USUARIO + " (" +
                "IdRegistroUsuario      INTEGER PRIMARY KEY NOT NULL," +
                "IdUsuario              INTEGER NOT NULL," +
                "ResultadoInicioSesion  TEXT," +
                "EstadoSesion           TEXT," +
                "FechaIngreso           DATETIME DEFAULT (datetime('now'))," +
                "FechaCierre            DATETIME DEFAULT (datetime('now'))," +
                "CONSTRAINT FK_IdUsuario FOREIGN KEY(IdUsuario) REFERENCES " + TABLA_USUARIO + "(IdUsuario)" +
                ");");

        sqLiteDatabase.execSQL("INSERT INTO " + TABLA_USUARIO + " ( IdRol, Nombre, Correo, Celular, Estado) " +
                "VALUES ( 1, 'Ariel Mora', 'arielabc389@gmail.com', '0995468359', '1');");
        sqLiteDatabase.execSQL("INSERT INTO " + TABLA_USUARIO_ROL + " (IdRol, Nombre) " +
                "VALUES (1, 'Admin');");
        sqLiteDatabase.execSQL("INSERT INTO " + TABLA_USUARIO_ROL + " (IdRol, Nombre) " +
                "VALUES (2, 'Javer');");
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
