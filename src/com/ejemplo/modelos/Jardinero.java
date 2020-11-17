package com.ejemplo.modelos;

public class Jardinero extends Trabajador {

    private double sueldoXHora;
    //horas extra al mes
    private int horasExtra;

    public Jardinero() { super(); }
    public Jardinero(
            double sueldoXHora,
            int horasExtra,
            int id,
            String fechaIngreso,
            String nss,
            String nombre,
            String domicilio,
            String rfc,
            String telefono,
            String email) {
        super(id, fechaIngreso, nss, nombre, domicilio, rfc, telefono, email);
        this.sueldoXHora = sueldoXHora;
        this.horasExtra = horasExtra;
    }

    public double getSueldoXHora() {
        return sueldoXHora;
    }

    public void setSueldoXHora(double sueldoXHora) {
        this.sueldoXHora = sueldoXHora;
    }

    public int getHorasExtra() {
        return horasExtra;
    }

    public void setHorasExtra(int horasExtra) {
        this.horasExtra = horasExtra;
    }

    @Override
    public Double calcularSalario() {
        //se trabaja 8 hora al dia por un mes de 30 dias, extra se agregan las horasExtra del mes
        return sueldoXHora * 8 * 30 + (sueldoXHora * horasExtra);
    }
}
