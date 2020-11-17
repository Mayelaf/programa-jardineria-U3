package com.ejemplo.modelos;

public abstract class Trabajador extends Persona {

    private int id;
    private String fechaIngreso;
    private String nss;

    public Trabajador() { super(); }
    public Trabajador(
            int id,
            String fechaIngreso,
            String nss,
            String nombre,
            String domicilio,
            String rfc,
            String telefono,
            String email) {
        super(nombre, domicilio, rfc, telefono, email);
        this.nss = nss;
        this.fechaIngreso = fechaIngreso;
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFechaIngreso() {
        return fechaIngreso;
    }

    public void setFechaIngreso(String fechaIngreso) {
        this.fechaIngreso = fechaIngreso;
    }

    public String getNss() {
        return nss;
    }

    public void setNss(String nss) {
        this.nss = nss;
    }

    public abstract Double calcularSalario();
}
