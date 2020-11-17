package com.ejemplo.modelos;

public class AtencionCliente extends Trabajador {

    private double sueldoBase;
    private double comisionPorCliente;
    private int nuevosClientes;

    public AtencionCliente() {
        super();
        this.nuevosClientes = 0;
    }
    public AtencionCliente(
            double sueldoBase,
            double comisionPorCliente,
            int nuevosClientes,
            int id,
            String fechaIngreso,
            String nss,
            String nombre,
            String domicilio,
            String rfc,
            String telefono,
            String email) {
        super(id, fechaIngreso, nss, nombre, domicilio, rfc, telefono, email);
        this.sueldoBase = sueldoBase;
        this.comisionPorCliente = comisionPorCliente;
        this.nuevosClientes = nuevosClientes;
    }

    public double getSueldoBase() {
        return sueldoBase;
    }

    public void setSueldoBase(double sueldoBase) {
        this.sueldoBase = sueldoBase;
    }

    public double getComisionPorCliente() {
        return comisionPorCliente;
    }

    public void setComisionPorCliente(double comisionPorCliente) {
        this.comisionPorCliente = comisionPorCliente;
    }

    public int getNuevosClientes() {
        return nuevosClientes;
    }

    public void setNuevosClientes(int nuevosClientes) {
        this.nuevosClientes = nuevosClientes;
    }

    @Override
    public Double calcularSalario() {
        return sueldoBase + (comisionPorCliente * nuevosClientes);
    }
}
