import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<Personaje> personajes = new ArrayList<>();
        int opcion = -1;

        while (opcion != 4) {
            System.out.println("\n========== MENÚ ==========");
            System.out.println("1. Registrar personaje");
            System.out.println("2. Mostrar personajes");
            System.out.println("3. Buscar personaje por id");
            System.out.println("4. Salir");
            System.out.print("Seleccione una opción: ");

            try {
                opcion = Integer.parseInt(sc.nextLine().trim());
            } catch (NumberFormatException e) {
                System.out.println("Entrada no válida. Ingrese un número.");
                continue;
            }

            switch (opcion) {
                case 1:
                    registrarPersonaje(sc, personajes);
                    break;
                case 2:
                    mostrarPersonajes(personajes);
                    break;
                case 3:
                    buscarPersonaje(sc, personajes);
                    break;
                case 4:
                    System.out.println("Saliendo del programa...");
                    break;
                default:
                    System.out.println("Opción no válida.");
            }
        }

        sc.close();
    }

    private static void registrarPersonaje(Scanner sc, ArrayList<Personaje> personajes) {
        try {
            System.out.print("Tipo (1 = Guerrero, 2 = Mago): ");
            int tipo = Integer.parseInt(sc.nextLine().trim());

            if (tipo != 1 && tipo != 2) {
                System.out.println("Tipo inválido. No se registró el personaje.");
                return;
            }

            System.out.print("ID: ");
            int id = Integer.parseInt(sc.nextLine().trim());

            System.out.print("Nombre: ");
            String nombre = sc.nextLine().trim();

            System.out.print("Nivel: ");
            int nivel = Integer.parseInt(sc.nextLine().trim());

            if (id <= 0) {
                System.out.println("Error: el id debe ser mayor que 0. No se registró el personaje.");
                return;
            }
            if (nombre.isEmpty()) {
                System.out.println("Error: el nombre no puede estar vacío. No se registró el personaje.");
                return;
            }
            if (nivel < 1 || nivel > 100) {
                System.out.println("Error: el nivel debe estar entre 1 y 100. No se registró el personaje.");
                return;
            }

            Personaje nuevo;
            if (tipo == 1) {
                nuevo = new Guerrero(id, nombre, nivel);
            } else {
                nuevo = new Mago(id, nombre, nivel);
            }

            personajes.add(nuevo);
            System.out.println("Personaje registrado correctamente.");

        } catch (NumberFormatException e) {
            System.out.println("Error: se esperaba un valor numérico. No se registró el personaje.");
        }
    }

    private static void mostrarPersonajes(ArrayList<Personaje> personajes) {
        if (personajes.isEmpty()) {
            System.out.println("No hay personajes registrados.");
            return;
        }

        for (Personaje p : personajes) {
            p.mostrarInfo();
            System.out.println(p.realizarAccion());
            System.out.println("---------------------------");
        }
    }

    private static void buscarPersonaje(Scanner sc, ArrayList<Personaje> personajes) {
        try {
            System.out.print("Ingrese el id a buscar: ");
            int idBuscado = Integer.parseInt(sc.nextLine().trim());

            for (Personaje p : personajes) {
                if (p.getId() == idBuscado) {
                    p.mostrarInfo();
                    System.out.println(p.realizarAccion());
                    return;
                }
            }

            System.out.println("Personaje no encontrado");

        } catch (NumberFormatException e) {
            System.out.println("Error: se esperaba un valor numérico para el id.");
        }
    }
}
