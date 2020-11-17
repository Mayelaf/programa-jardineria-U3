package com.ejemplo.servicios;

import com.ejemplo.modelos.Jardin;

import java.util.*;

public class ServicioJardin {

    private List<Jardin> jardines;
    private Scanner sc = new Scanner(System.in);

    public ServicioJardin() {
        jardines = new ArrayList<>();
        jardines.add(new Jardin(
                8,
                "cerrada de las peñas #13",
                "Tropical",
                "100X100"
        ));
    }

    public void altaJardin() {
        Jardin j = new Jardin();

        System.out.println("Inserte domicilio del jardin: (enter para omitir)");
        String tmp = sc.nextLine();
        if(!tmp.isEmpty()) {
            j.setDomicilio(tmp);
        }

        System.out.println("Inserte el tipo de jardin: (enter para omitir)");
        tmp = sc.nextLine();
        if(!tmp.isEmpty()) {
            j.setTipoJardin(tmp);
        }

        System.out.println("Inserte la extension del jardin: (enter para omitir)");
        tmp = sc.nextLine();
        if(!tmp.isEmpty()) {
            j.setExtension(tmp);
        }

        //genera id
        Optional<Jardin> idMax = jardines.stream().max(Comparator.
                comparing(Jardin::getId));
        idMax.ifPresent(value -> j.setId(value.getId() + 1));

        jardines.add(j);
        System.out.println("El jardin fue dado de alta correctamente.");
    }

    public void bajaJardin() {
        System.out.println("Inserte id del jardin a dar de baja: (enter para omitir)");
        String tmp = sc.nextLine();
        if(!tmp.isEmpty()) {
            int id = Integer.parseInt(tmp);
            for (int i = 0; i < jardines.size(); i++) {
                if (jardines.get(i).getId() == id) {
                    jardines.remove(i);
                    System.out.println("El jardin fue dado de baja correctamente.");
                    break;
                }
            }
            System.out.println("No se encontro un jardin con id: " + tmp);
        }
    }

    public void consultaJardines() {
        System.out.println("Hay un total de " + jardines.size() + " jardines.");
        jardines.forEach(j -> {
            System.out.println("----------------------------------------------- " );
            System.out.println("ID jardin: " + j.getId());
            System.out.println("Domicilio jardin: " + j.getDomicilio());
            System.out.println("Tipo de jardin: " + j.getTipoJardin());
            System.out.println("Extension del jardin: " + j.getExtension());
        });
    }

    public void modificaJardin() {
        System.out.println("Inserte id jardin a modificar: ");
        int id = Integer.parseInt(sc.nextLine());

        Optional<Jardin> j = jardines.stream()
                .filter(jardin -> jardin.getId() == id)
                .findFirst();

        if(j.isPresent()) {
            System.out.println("Inserte todos los nuevos datos para el jardin " + id);
            Jardin jardin = j.get();

            System.out.println("Inserte domicilio del jardin: (enter para omitir)");
            String tmp = sc.nextLine();
            if(!tmp.isEmpty()) {
                jardin.setDomicilio(tmp);
            }

            System.out.println("Inserte el tipo de jardin: (enter para omitir)");
            tmp = sc.nextLine();
            if(!tmp.isEmpty()) {
                jardin.setTipoJardin(tmp);
            }

            System.out.println("Inserte la extension del jardin: (enter para omitir)");
            tmp = sc.nextLine();
            if(!tmp.isEmpty()) {
                jardin.setExtension(tmp);
            }

            System.out.println("El jardin fue modificado correctamente.");
        } else {
            System.out.println("No se encontro el trabajador con id: " + id);
        }
    }
}
