package com.ejemplo.modelos;

public class Cliente extends Persona {

    private int id;
    private String fechaAlta;
    private String domicilioFacturacion;

    public Cliente() {
        super();
    }

    public Cliente(
            int id,
            String fechaAlta,
            String domicilioFacturacion,
            String nombre,
            String domicilio,
            String rfc,
            String telefono,
            String email) {
        super(nombre, domicilio, rfc, telefono, email);
        this.id = id;
        this.fechaAlta = fechaAlta;
        this.domicilioFacturacion = domicilioFacturacion;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFechaAlta() {
        return fechaAlta;
    }

    public void setFechaAlta(String fechaAlta) {
        this.fechaAlta = fechaAlta;
    }

    public String getDomicilioFacturacion() {
        return domicilioFacturacion;
    }

    public void setDomicilioFacturacion(String domicilioFacturacion) {
        this.domicilioFacturacion = domicilioFacturacion;
    }
}
