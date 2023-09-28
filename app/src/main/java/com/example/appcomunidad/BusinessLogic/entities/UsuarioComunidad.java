package com.example.appcomunidad.BusinessLogic.entities;

import java.util.Date;

public class UsuarioComunidad {
    private int idUsuarioComunidad;
    private String nombreJaver;
    private String apellidoJaver;
    private String estadoCivil;
    private String cedula;
    private String correoJaver;
    private String celularJaver;
    private String fotoJaver;
    private int estado;

    public int getEstado() {
        return estado;
    }

    public void setEstado(int estado) {
        this.estado = estado;
    }


    public int getIdUsuarioComunidad() {
        return idUsuarioComunidad;
    }

    public void setIdUsuarioComunidad(int idUsuarioComunidad) {
        this.idUsuarioComunidad = idUsuarioComunidad;
    }

    public String getNombreJaver() {
        return nombreJaver;
    }

    public void setNombreJaver(String nombreJaver) {
        this.nombreJaver = nombreJaver;
    }

    public String getApellidoJaver() {
        return apellidoJaver;
    }

    public void setApellidoJaver(String apellidoJaver) {
        this.apellidoJaver = apellidoJaver;
    }

    public String getEstadoCivil() {
        return estadoCivil;
    }

    public void setEstadoCivil(String estadoCivil) {
        this.estadoCivil = estadoCivil;
    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public String getCorreoJaver() {
        return correoJaver;
    }

    public void setCorreoJaver(String correoJaver) {
        this.correoJaver = correoJaver;
    }

    public String getCelularJaver() {
        return celularJaver;
    }

    public void setCelularJaver(String celularJaver) {
        this.celularJaver = celularJaver;
    }

    public String getFotoJaver() {
        return fotoJaver;
    }

    public void setFotoJaver(String fotoJaver) {
        this.fotoJaver = fotoJaver;
    }
}
