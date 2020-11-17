package com.ejemplo.servicios;

import com.ejemplo.modelos.AtencionCliente;
import com.ejemplo.modelos.Jardinero;
import com.ejemplo.modelos.Trabajador;

import java.time.LocalDateTime;
import java.util.*;

public class ServicioTrabajadores {

    private List<Trabajador> trabajadores;
    private Scanner sc = new Scanner(System.in);

    public ServicioTrabajadores() {
        trabajadores = new ArrayList<>();
        trabajadores.add(new Jardinero(
                        65.0,
                        0,
                        3,
                        "15/01/19",
                        "109923456",
                        "Manuel Aguirre",
                        "serafin vasquez #395",
                        "MAAQ593021",
                        "98765432",
                        "manuel@gmail.com"));
    }

    public void altaTrabajador() {
        Trabajador trabajador;

        System.out.println("Que tipo de trabajador es?:");
        System.out.println("Opciones: J) jardinero | A) atencionClientes");
        String tmp = sc.nextLine();
        if (tmp.toLowerCase().equals("a")) {
            AtencionCliente ac = new AtencionCliente();
            ac = (AtencionCliente) modificaInformacionTrabajador(ac);
            ac = modificaTrabajadorAtencionCliente(ac);
            trabajador = ac;
        } else {
            Jardinero j = new Jardinero();
            j = (Jardinero) modificaInformacionTrabajador(j);
            j = modificaTrabajadorJardinero(j);
            trabajador = j;
        }

        //toma fecha actual
        trabajador.setFechaIngreso(LocalDateTime.now().toString());

        //genera id
        Optional<Trabajador> idMax = trabajadores.stream().max(Comparator.
                comparing(Trabajador::getId));
        idMax.ifPresent(value -> trabajador.setId(value.getId() + 1));

        //guarda al nuevo trabajador
        trabajadores.add(trabajador);
        System.out.println("El trabajador fue dado de alta correctamente.");
    }

    public void bajaTrabajador() {
        System.out.println("Inserte id del trabajador a dar de baja: (enter para omitir)");
        String tmp = sc.nextLine();
        if(!tmp.isEmpty()) {
            int id = Integer.parseInt(tmp);
            for (int i = 0; i < trabajadores.size(); i++) {
                if (trabajadores.get(i).getId() == id) {
                    trabajadores.remove(i);
                    System.out.println("El trabajador fue dado de baja correctamente.");
                    break;
                }
            }
            System.out.println("No se encontro el trabajador con id: " + tmp);
        }
    }

    public void consultaTrabajadores() {
        System.out.println("Hay un total de " + trabajadores.size() + " trabajadores.");
        trabajadores.forEach(t -> {
            System.out.println("----------------------------------------------- " );
            System.out.println("ID trabajador: " + t.getId());
            System.out.println("Nombre trabajador: " + t.getNombre());
            System.out.println("Domicilio trabajador: " + t.getDomicilio());
            System.out.println("RFC trabajador: " + t.getRfc());
            System.out.println("Email trabajador: " + t.getEmail());
            System.out.println("Telefono trabajador: " + t.getTelefono());
            System.out.println("NSS trabajador: " + t.getNss());
            System.out.println("Fecha Ingreso: " + t.getFechaIngreso());
            if (t instanceof AtencionCliente) {
                System.out.println("Sueldo Base del trabajador: " + ((AtencionCliente) t).getSueldoBase());
                System.out.println("Comision por cliente: " + ((AtencionCliente) t).getComisionPorCliente());
                System.out.println("Clientes nuevos en el mes: " + ((AtencionCliente) t).getNuevosClientes());
            } else {
                System.out.println("Sueldo por Hora del trabajador: " + ((Jardinero) t).getSueldoXHora());
                System.out.println("Horas extra de trabajador: " + ((Jardinero) t).getHorasExtra());
            }
        });
    }

    public void modificaTrabajador() {
        System.out.println("Inserte id trabajador a modificar: ");
        int id = Integer.parseInt(sc.nextLine());

        Optional<Trabajador> t = trabajadores.stream()
                .filter(trabajador -> trabajador.getId() == id)
                .findFirst();

        if(t.isPresent()) {
            System.out.println("Inserte todos los nuevos datos para el trabajador " + id);
            Trabajador trabajador = modificaInformacionTrabajador(t.get());
            if (trabajador instanceof AtencionCliente) {
                modificaTrabajadorAtencionCliente((AtencionCliente) trabajador);
            } else {
                modificaTrabajadorJardinero((Jardinero) trabajador);
            }
            System.out.println("El trabajador fue modificado correctamente.");
        } else {
            System.out.println("No se encontro el trabajador con id: " + id);
        }
    }

    private Trabajador modificaInformacionTrabajador(Trabajador trabajador) {
        String tmp;
        //informacion personal
        System.out.println("Inserte nombre: (enter para omitir)");
        tmp = sc.nextLine();
        if(!tmp.isEmpty()) {
            trabajador.setNombre(tmp);
        }
        System.out.println("Inserte domicilio: (enter para omitir)");
        tmp = sc.nextLine();
        if(!tmp.isEmpty()) {
            trabajador.setDomicilio(tmp);
        }
        System.out.println("Inserte RFC: (enter para omitir)");
        tmp = sc.nextLine();
        if(!tmp.isEmpty()) {
            trabajador.setRfc(tmp);
        }
        System.out.println("Inserte email: (enter para omitir)");
        tmp = sc.nextLine();
        if(!tmp.isEmpty()) {
            trabajador.setEmail(tmp);
        }
        System.out.println("Inserte telefono: (enter para omitir)");
        tmp = sc.nextLine();
        if(!tmp.isEmpty()) {
            trabajador.setTelefono(tmp);
        }

        System.out.println("Inserte nss: (enter para omitir)");
        tmp = sc.nextLine();
        if(!tmp.isEmpty()) {
            trabajador.setNss(tmp);
        }

        return trabajador;
    }

    private AtencionCliente modificaTrabajadorAtencionCliente(AtencionCliente ac) {
        System.out.println("Inserte sueldo base: (enter para omitir)");
        String tmp = sc.nextLine();
        if(!tmp.isEmpty()) {
            ac.setSueldoBase(Double.parseDouble(tmp));
        }
        System.out.println("Inserte comision por cliente: (enter para omitir)");
        tmp = sc.nextLine();
        if(!tmp.isEmpty()) {
            ac.setComisionPorCliente(Double.parseDouble(tmp));
        }
        return ac;
    }

    private Jardinero modificaTrabajadorJardinero(Jardinero j) {
        System.out.println("Inserte sueldo por hora: (enter para omitir)");
        String tmp = sc.nextLine();
        if(!tmp.isEmpty()) {
            j.setSueldoXHora(Double.parseDouble(tmp));
        }
        System.out.println("Inserte horas extra: (enter para omitir)");
        tmp = sc.nextLine();
        if(!tmp.isEmpty()) {
            j.setHorasExtra(Integer.parseInt(tmp));
        }
        return j;
    }

    public void calculaSalario() {
        System.out.println("Inserte id del trabajador a calcular el salario: ");
        int id = Integer.parseInt(sc.nextLine());

        Optional<Trabajador> t = trabajadores.stream()
                .filter(trabajador -> trabajador.getId() == id)
                .findFirst();

        if(t.isPresent()) {
            double salarioXmes = t.get().calcularSalario();
            System.out.println("El salario mensual del trabajador: " + id + " es de: " + salarioXmes);
        } else {
            System.out.println("No se encontro un trabajador con id: " + id);
        }
    }
}
