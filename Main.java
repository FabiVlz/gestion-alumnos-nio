package com.mycompany.appnio;

import java.util.Scanner;

/**
 *
 * @author Jesus Fabian
 */
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        AlumnoRepository repository = new AlumnoRepository();
        int opcion = 0;
        //MENU
        do {
            System.out.println("\n=== MENÚ GESTIÓN DE ALUMNOS (JAVA NIO) ===");
            System.out.println("1. Registrar nuevo alumno");
            System.out.println("2. Ver todos los alumnos");
            System.out.println("3. Buscar alumno por ID");
            System.out.println("4. Actualizar nombre de alumno");
            System.out.println("5. Eliminar alumno");
            System.out.println("6. Salir");
            System.out.print("Seleccione una opcion: ");

            if (scanner.hasNextInt()) {
                opcion = scanner.nextInt();
                scanner.nextLine(); 
            } else {
                System.out.println("\nPor favor, ingrese un número válido.");
                scanner.nextLine();
                continue;
            }
            //Agregar Alumno
            switch (opcion) {
                case 1:
                    System.out.println("\n--- Registrar Alumno ---");
                    System.out.print("Ingrese ID: ");
                    String idReg = scanner.nextLine().trim();
                    System.out.print("Ingrese Nombre: ");
                    String nombreReg = scanner.nextLine().trim();
                    
                    if (!idReg.isEmpty() && !nombreReg.isEmpty()) {
                        Alumno nuevoAlumno = new Alumno(idReg, nombreReg);
                        repository.registrarAlumno(nuevoAlumno);
                    } else {
                        System.out.println("Error: Los campos no pueden estar vacíos.");
                    }
                    break;
            //Ver Alumnos del txt
                case 2:
                    repository.mostrarTodos();
                    break;
            //Buscar alumno por id
                case 3:
                    System.out.println("\n--- Buscar Alumno ---");
                    System.out.print("Ingrese ID del alumno a buscar: ");
                    String idBusc = scanner.nextLine().trim();
                    repository.buscarPorId(idBusc);
                    break;
            //Cambair name al alumno
                case 4:
                    System.out.println("\n--- Actualizar Alumno ---");
                    System.out.print("Ingrese ID del alumno a modificar: ");
                    String idAct = scanner.nextLine().trim();
                    System.out.print("Ingrese el nuevo nombre completo: ");
                    String nuevoNombre = scanner.nextLine().trim();
                    
                    if (!idAct.isEmpty() && !nuevoNombre.isEmpty()) {
                        repository.actualizarNombre(idAct, nuevoNombre);
                    } else {
                        System.out.println("Error: Los campos no pueden estar vacíos.");
                    }
                    break;
            //Elimianr alumno
                case 5:
                    System.out.println("\n--- Eliminar Alumno ---");
                    System.out.print("Ingrese ID del alumno que se desea eliminar: ");
                    String idDel = scanner.nextLine().trim();
                    repository.eliminarAlumno(idDel);
                    break;
            }
            //Cerrar programa
        } while (opcion != 6);

        scanner.close();
    }
}