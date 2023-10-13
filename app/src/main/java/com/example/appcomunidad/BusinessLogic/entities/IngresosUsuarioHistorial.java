package com.example.appcomunidad.BusinessLogic.entities;

public class IngresosUsuarioHistorial {
    private int IdUsuarioHistorial;
    private String nombreMesIngresos;
    private String añoMesIngresos;
    private String nombreJaverIngresos;
    private String apellidJaverIngresos;
    private String cedulaJaverIngresos;
    private String semanaFechaIngresos;
    private int estado;


    public int getIdUsuarioHistorial() {
        return IdUsuarioHistorial;
    }

    public void setIdUsuarioHistorial(int idUsuarioHistorial) {
        IdUsuarioHistorial = idUsuarioHistorial;
    }

    public String getNombreMesIngresos() {
        return nombreMesIngresos;
    }

    public void setNombreMesIngresos(String nombreMesIngresos) {
        this.nombreMesIngresos = nombreMesIngresos;
    }

    public String getAñoMesIngresos() {
        return añoMesIngresos;
    }

    public void setAñoMesIngresos(String añoMesIngresos) {
        this.añoMesIngresos = añoMesIngresos;
    }

    public String getNombreJaverIngresos() {
        return nombreJaverIngresos;
    }

    public void setNombreJaverIngresos(String nombreJaverIngresos) {
        this.nombreJaverIngresos = nombreJaverIngresos;
    }

    public String getApellidJaverIngresos() {
        return apellidJaverIngresos;
    }

    public void setApellidJaverIngresos(String apellidJaverIngresos) {
        this.apellidJaverIngresos = apellidJaverIngresos;
    }

    public String getCedulaJaverIngresos() {
        return cedulaJaverIngresos;
    }

    public void setCedulaJaverIngresos(String cedulaJaverIngresos) {
        this.cedulaJaverIngresos = cedulaJaverIngresos;
    }

    public String getSemanaFechaIngresos() {
        return semanaFechaIngresos;
    }

    public void setSemanaFechaIngresos(String semanaFechaIngresos) {
        this.semanaFechaIngresos = semanaFechaIngresos;
    }

    public int getEstado() {
        return estado;
    }

    public void setEstado(int estado) {
        this.estado = estado;
    }
}
