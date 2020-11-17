package com.ejemplo.modelos;

public class Jardin {

    private int id;
    private String domicilio;
    private String tipoJardin;
    private String extension;

    public Jardin() {

    }
    public Jardin(int id, String domicilio, String tipoJardin, String extension) {
        this.id = id;
        this.domicilio = domicilio;
        this.tipoJardin = tipoJardin;
        this.extension = extension;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDomicilio() {
        return domicilio;
    }

    public void setDomicilio(String domicilio) {
        this.domicilio = domicilio;
    }

    public String getTipoJardin() {
        return tipoJardin;
    }

    public void setTipoJardin(String tipoJardin) {
        this.tipoJardin = tipoJardin;
    }

    public String getExtension() {
        return extension;
    }

    public void setExtension(String extension) {
        this.extension = extension;
    }
}
