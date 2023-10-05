package com.example.appcomunidad.BusinessLogic.utilities;

import android.content.Context;
import android.util.Log;
import android.widget.Toast;


import com.example.appcomunidad.BusinessLogic.entities.Usuario;
import com.example.appcomunidad.BusinessLogic.entities.UsuarioCredencial;
import com.example.appcomunidad.BusinessLogic.entities.UsuarioRol;
import com.example.appcomunidad.BusinessLogic.managers.RegistroSesionBL;
import com.example.appcomunidad.BusinessLogic.managers.UsuarioBL;
import com.example.appcomunidad.BusinessLogic.managers.UsuarioCredencialBL;
import com.example.appcomunidad.BusinessLogic.managers.UsuarioRolBL;
import com.example.appcomunidad.data_acess.UsuarioCredencialDAC;
import com.example.appcomunidad.framework.AppException;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.List;

/**
 * Corresponde a una clase para poder verificar los datos del usuario.
 */
public class VerificarDatos {

    private Context contexto;
    private UsuarioBL usuarioBL;
    private UsuarioCredencialBL gestorCredencial;
    private RegistroSesionBL registroSesionBL;

    private UsuarioRolBL usuarioRolBL;

    private int idRolUsuario;
    private String rolUsuario;

    private UsuarioRol usuarioRol;


    public VerificarDatos(Context contexto) {
        this.contexto = contexto;
        usuarioBL= new UsuarioBL(contexto);
        this.usuarioBL = new UsuarioBL(contexto);
        this.gestorCredencial = new UsuarioCredencialBL(contexto);
        this.registroSesionBL = new RegistroSesionBL(contexto);
        this.usuarioRolBL=new UsuarioRolBL(contexto);

    }
    public boolean verificarCuentaUsuario(String correoRegistrado, String ingresarContrasenia) throws AppException {
        List<Usuario> listaUsuarios = usuarioBL.obtenerRegistrosActivos();
        UsuarioCredencial usuarioCredencial;

        for (Usuario usuario : listaUsuarios)
            if (correoRegistrado.equals(usuario.getCorreo()) ) {
                Log.i("verificarCuentaUsuario","verifico el correo.. y es" + correoRegistrado+ " "+ usuario.getCorreo());
                Log.i("verificarCuentaUsuario","el id del usuario es " + usuario.getId()+"");
                usuarioCredencial = gestorCredencial.obtenerPorId(usuario.getId());
                Log.i("verificarCuentaUsuario","paso el obtenerPorId.. ");
                Log.i("verificarCuentaUsuario","la contraseña es"+usuarioCredencial.getContrasena());
                Log.i("verificarCuentaUsuario","las contraseñas a verificar"+ingresarContrasenia);
                if (verificarContrasenia(ingresarContrasenia.trim(), usuarioCredencial.getContrasena().trim())) {
                    Log.i("verificarCuentaUsuario","verifico la contraseña ");
                    idRolUsuario= usuario.getIdRol();
                    usuarioRol=usuarioRolBL.obtenerRolUsuario(idRolUsuario);
                    rolUsuario= usuarioRol.getNombre();
                    Log.i("verificarCuentaUsuario","obteniendo mensaje ");
                    Toast.makeText(contexto, rolUsuario+", "+ usuario.getNombre() + ", Saludos!", Toast.LENGTH_SHORT).show();
                    registroSesionBL.conectarUsuario(usuario.getId(), "OK", 1);
                    return true;
                }
            }
        Toast.makeText(contexto, "Correo y/o contraseña incorrectos", Toast.LENGTH_SHORT).show();
        return false;
    }
    /**
     * encriptarContrasenia:este método toma una contrasenia en formato de texto claro, la encripta
     * utilizando el algoritmo de resumen MD5 y devuelve la representacion hexadecimal de la
     * contrasenia encriptada.
     * @param contrasenia
     * @return un string con la contrasenia encriptada
     * @throws AppException
     */
    public String encriptarContrasenia(String contrasenia) throws AppException {
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            byte[] messageDigest = md.digest(contrasenia.getBytes());
            StringBuilder hexString = new StringBuilder();
            for (byte b : messageDigest) {
                String hex = Integer.toHexString(0xFF & b);
                if (hex.length() == 1) {
                    hexString.append('0');
                }
                hexString.append(hex);
            }
            Log.i("verificarCuentaUsuario","la contraseña encriptada es: "+ hexString.toString());
            return hexString.toString();
        } catch (NoSuchAlgorithmException error) {
            throw new AppException(error, getClass(), "encriptarContrasenia()");
        }
    }

    /**
     * verificarContrasenia:este metodo se utiliza para verificar si una contraseña proporcionada
     * coincide con la contrasenia almacenada despues de aplicar el mismo proceso de encriptacion.
     * @param contrasenia
     * @param contraseniaEncriptada
     * @return
     * @throws AppException
     */
    public boolean verificarContrasenia(String contrasenia, String contraseniaEncriptada) throws AppException {
        Log.i("verificarCuentaUsuario","entro a encriptar contraseña ");
        Log.i("verificarCuentaUsuario","la contraseña encriptada 2 es:  "+ contraseniaEncriptada);
        contrasenia = encriptarContrasenia(contrasenia);
        return contrasenia.equals(contraseniaEncriptada);
    }
    public double valorRegistroIngresado(String valorRegistroIngresado){
        double valor=0;
        valorRegistroIngresado= valorRegistroIngresado.trim();
        if (valorRegistroIngresado.contains(",")){
            valorRegistroIngresado = valorRegistroIngresado.replace(",", ".");
            try {
                valor = Double.parseDouble(valorRegistroIngresado);
                return valor;
            } catch (NumberFormatException e) {
                Log.i("VerificarDouble","Esta dando error en el parseo");
            }
        }else{
             valor= Double.parseDouble(valorRegistroIngresado);
        }
        return valor;
    }
}
