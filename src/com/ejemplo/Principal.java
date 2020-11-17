package com.ejemplo;

import com.ejemplo.servicios.ServicioCliente;
import com.ejemplo.servicios.ServicioJardin;
import com.ejemplo.servicios.ServicioTrabajadores;

import java.util.*;

public class Principal {

    static Scanner sc = new Scanner(System.in);

    static ServicioTrabajadores servicioTrabajadores = new ServicioTrabajadores();
    static ServicioCliente servicioCliente = new ServicioCliente();
    static ServicioJardin servicioJardin = new ServicioJardin();

    public static void main(String args[]) {
        int opcion = 0;
        do {
            System.out.println("Seleccione Opcion:");
            System.out.println("1) Clientes");
            System.out.println("2) Trabajadores");
            System.out.println("3) Jardines");
            System.out.println("4) Salir");
            opcion = Integer.parseInt(sc.nextLine());
            evaluaOpcionPrincipal(opcion);
        } while(opcion != 4);
    }

    public static void evaluaOpcionPrincipal(int opcion) {
        switch (opcion) {
            case 1:
                System.out.println("Seleccione Opcion:");
                System.out.println("1) Alta Cliente");
                System.out.println("2) Baja Cliente");
                System.out.println("3) Consultar Clientes");
                System.out.println("4) Modificar Cliente");
                System.out.println("5) Crear Contrato");
                System.out.println("6) Regresar");
                evaluaOpcionCliente(Integer.parseInt(sc.nextLine()));
                break;
            case 2:
                System.out.println("Seleccione Opcion:");
                System.out.println("1) Alta Trabajador");
                System.out.println("2) Baja Trabajador");
                System.out.println("3) Consultar Trabajadores");
                System.out.println("4) Modificar Trabajador");
                System.out.println("5) Calcular Salario De Trabajador");
                System.out.println("6) Regresar");
                evaluaOpcionTrabajador(Integer.parseInt(sc.nextLine()));
                break;
            case 3:
                System.out.println("Seleccione Opcion:");
                System.out.println("1) Alta Jardin");
                System.out.println("2) Baja Jardin");
                System.out.println("3) Consultar Jardin");
                System.out.println("4) Modificar Jardin");
                System.out.println("5) Regresar");
                evaluaOpcionJardin(Integer.parseInt(sc.nextLine()));
                break;
        }
    }

    public static void evaluaOpcionCliente(int opcion) {
        switch (opcion) {
            case 1:
                servicioCliente.altaCliente();
                break;
            case 2:
                servicioCliente.bajaCliente();
                break;
            case 3:
                servicioCliente.consultaClientes();
                break;
            case 4:
                servicioCliente.modificaCliente();
                break;
            case 5:
                servicioCliente.creaContrato();
                break;
        }
    }

    public static void evaluaOpcionTrabajador(int opcion) {
        switch (opcion) {
            case 1:
                servicioTrabajadores.altaTrabajador();
                break;
            case 2:
                servicioTrabajadores.bajaTrabajador();
                break;
            case 3:
                servicioTrabajadores.consultaTrabajadores();
                break;
            case 4:
                servicioTrabajadores.modificaTrabajador();
                break;
            case 5:
                servicioTrabajadores.calculaSalario();
                break;
        }
    }

    public static void evaluaOpcionJardin(int opcion) {
        switch (opcion) {
            case 1:
                servicioJardin.altaJardin();
                break;
            case 2:
                servicioJardin.bajaJardin();
                break;
            case 3:
                servicioJardin.consultaJardines();
                break;
            case 4:
                servicioJardin.modificaJardin();
                break;
        }
    }

}
