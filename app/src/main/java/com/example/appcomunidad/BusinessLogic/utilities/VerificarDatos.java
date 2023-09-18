package com.example.appcomunidad.BusinessLogic.utilities;

import android.content.Context;
import android.widget.Toast;


import com.example.appcomunidad.framework.AppException;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.List;

/**
 * Corresponde a una clase para poder verificar los datos del usuario.
 */
public class VerificarDatos {

    private Context contexto;


    public VerificarDatos(Context contexto) {
        this.contexto = contexto;
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
        contrasenia = encriptarContrasenia(contrasenia);
        return contrasenia.equals(contraseniaEncriptada);
    }
}
