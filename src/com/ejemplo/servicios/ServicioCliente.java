package com.ejemplo.servicios;

import com.ejemplo.modelos.Cliente;

import java.time.LocalDateTime;
import java.util.*;

public class ServicioCliente {

    private List<Cliente> clientes;
    private Scanner sc = new Scanner(System.in);

    public ServicioCliente() {
        clientes = new ArrayList<>();
        clientes.add(new Cliente(
                        5,
                        "10/12/20",
                        "",
                        "Jose Velasco",
                        "Colon #23",
                        "GRED546712",
                        "9876543",
                        "jose@gmail.com"));
    }

    public void altaCliente() {
        Cliente cliente = new Cliente();

        //agrega informacion del cliente
        cliente = modificaInformacionCliente(cliente);

        //toma fecha actual
        cliente.setFechaAlta(LocalDateTime.now().toString());

        //genera id
        Optional<Cliente> idMax = clientes.stream().max(Comparator.
                comparing(Cliente::getId));
        if(idMax.isPresent()) {
            cliente.setId(idMax.get().getId() + 1);
        }

        //guarda al nuevo cliente
        clientes.add(cliente);
        System.out.println("El cliente fue dado de alta correctamente.");
    }

    public void bajaCliente() {
        System.out.println("Inserte id de cliente a dar de baja: (enter para omitir)");
        String tmp = sc.nextLine();
        if(!tmp.isEmpty()) {
            int id = Integer.parseInt(tmp);
            for (int i = 0; i < clientes.size(); i++) {
                if (clientes.get(i).getId() == id) {
                    clientes.remove(i);
                    System.out.println("El cliente fue dado de baja correctamente.");
                    break;
                }
            }
            System.out.println("No se encontro el cliente con id: "+ tmp);
        }
    }

    public void consultaClientes() {
        System.out.println("Hay un total de " + clientes.size() + " clientes.");
        clientes.forEach(c -> {
            System.out.println("----------------------------------------------- " );
            System.out.println("ID cliente: " + c.getId());
            System.out.println("Nombre cliente: " + c.getNombre());
            System.out.println("Domicilio cliente: " + c.getDomicilio());
            System.out.println("RFC cliente: " + c.getRfc());
            System.out.println("Email cliente: " + c.getEmail());
            System.out.println("Telefono cliente: " + c.getTelefono());
            System.out.println("Fecha Alta cliente: " + c.getFechaAlta());
        });
    }

    public void modificaCliente() {
        System.out.println("Inserte id cliente a modificar: ");
        int id = Integer.parseInt(sc.nextLine());

        Optional<Cliente> cli = clientes.stream()
                .filter(cliente -> cliente.getId() == id)
                .findFirst();

        if(cli.isPresent()) {
            System.out.println("Inserte todos los nuevos datos para el cliente " + id);
            modificaInformacionCliente(cli.get());
            System.out.println("El cliente fue modificado correctamente.");
        } else {
            System.out.println("No se encontro el cliente con id: " + id);
        }
    }

    private Cliente modificaInformacionCliente(Cliente cliente) {
        String tmp;
        //informacion personal
        System.out.println("Inserte nombre: (enter para omitir)");
        tmp = sc.nextLine();
        if(!tmp.isEmpty()) {
            cliente.setNombre(tmp);
        }
        System.out.println("Inserte domicilio: (enter para omitir)");
        tmp = sc.nextLine();
        if(!tmp.isEmpty()) {
            cliente.setDomicilio(tmp);
        }
        System.out.println("Inserte RFC: (enter para omitir)");
        tmp = sc.nextLine();
        if(!tmp.isEmpty()) {
            cliente.setRfc(tmp);
        }
        System.out.println("Inserte email: (enter para omitir)");
        tmp = sc.nextLine();
        if(!tmp.isEmpty()) {
            cliente.setEmail(tmp);
        }
        System.out.println("Inserte telefono: (enter para omitir)");
        tmp = sc.nextLine();
        if(!tmp.isEmpty()) {
            cliente.setTelefono(tmp);
        }

        //agrega direccion de facturacion
        System.out.println("Quieres usar la direccion personal para facturacion: yes/no");
        if(sc.nextLine().toLowerCase().equals("no")) {
            System.out.println("Inserte domicilio de facturacion: (enter para omitir)");
            tmp = sc.nextLine();
            if(!tmp.isEmpty()) {
                cliente.setDomicilioFacturacion(tmp);
            }
        } else {
            cliente.setDomicilioFacturacion(cliente.getDomicilio());
        }

        return cliente;
    }

    public void creaContrato() {
        //TODO: falta definir contrato

    }
}
