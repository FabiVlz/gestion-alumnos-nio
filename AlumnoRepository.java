package com.mycompany.appnio;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Jesus Fabian
 */
public class AlumnoRepository {
    Path ruta = Path.of("alumnos.txt");
    
    public AlumnoRepository() {
        try {
            if (!Files.exists(ruta)) {
                Files.createFile(ruta);
            }
        } catch (IOException e) {
            System.err.println("Error de E/S al crear el archivo inicial: " + e.getMessage());
        }
    }
    public boolean existeId(String idBuscado) {
        try {
            List<String> lineas = Files.readAllLines(ruta);
            for (String linea : lineas) {
                if (linea.trim().isEmpty()) continue;
                String[] partes = linea.split(" - ");
                if (partes.length > 0 && partes[0].trim().equals(idBuscado)) {
                    return true;
                }
            }
        } catch (IOException e) {
            System.err.println("Error al leer el archivo para validar ID: " + e.getMessage());
        }
        return false;
    }
    public void registrarAlumno(Alumno alumno) {
        if (existeId(alumno.getId())) {
            System.out.println("Error el ID del Alumno ya existe en el archivo");
            return;
        }

        try {
            String nuevoRegistro = alumno.toString();
            List<String> lineas = Files.readAllLines(ruta);
            
            if (!lineas.isEmpty() && !lineas.get(lineas.size() - 1).isEmpty()) {
                nuevoRegistro = "\n" + nuevoRegistro;
            }

            Files.writeString(ruta, nuevoRegistro, StandardOpenOption.CREATE, StandardOpenOption.APPEND);
            System.out.println("Alumno registrado");

        } catch (IOException e) {
            System.err.println("Error al escribir en el archivo: " + e.getMessage());
        }
    }
    public void mostrarTodos() {
        try {
            List<String> lineas = Files.readAllLines(ruta);
            boolean hayRegistros = false;
            
            System.out.println("\n--- LISTA DE ALUMNOS ---");
            for (String linea : lineas) {
                if (!linea.trim().isEmpty()) {
                    System.out.println(linea);
                    hayRegistros = true;
                }
            }

            if (!hayRegistros) {
                System.out.println("El archivo esta vacío o no hay registros.");
            }

        } catch (IOException e) {
            System.err.println("Error al leer el archivo: " + e.getMessage());
        }
    }
    public void buscarPorId(String idBuscado) {
        try {
            List<String> lineas = Files.readAllLines(ruta);
            boolean encontrado = false;

            for (String linea : lineas) {
                if (linea.trim().isEmpty()) continue;
                String[] partes = linea.split(" - ");
                if (partes.length > 0 && partes[0].trim().equals(idBuscado)) {
                    System.out.println("\n--- Informacion del Alumno ---");
                    System.out.println(linea);
                    encontrado = true;
                    break;
                }
            }

            if (!encontrado) {
                System.out.println("Error: No existe ningun alumno registrado con el ID: " + idBuscado);
            }

        } catch (IOException e) {
            System.err.println("Error al buscar en el archivo: " + e.getMessage());
        }
    }
    
    public void actualizarNombre(String idBuscado, String nuevoNombre) {
        try {
            List<String> lineas = Files.readAllLines(ruta);
            boolean actualizado = false;

            for (int i = 0; i < lineas.size(); i++) {
                String linea = lineas.get(i);
                if (linea.trim().isEmpty()) continue;

                String[] partes = linea.split(" - ");
                if (partes.length > 0 && partes[0].trim().equals(idBuscado)) {
                    lineas.set(i, idBuscado + " - " + nuevoNombre);
                    actualizado = true;
                    break;
                }
            }

            if (actualizado) {
                Files.write(ruta, lineas);
                System.out.println("Nombre del alumno actualizado");
            } else {
                System.out.println("Error: El ID del alumno no existe, no se pudo actualizar.");
            }

        } catch (IOException e) {
            System.err.println("Error al actualizar el archivo: " + e.getMessage());
        }
    }

    public void eliminarAlumno(String idBuscado) {
        try {
            List<String> lineas = Files.readAllLines(ruta);
            boolean eliminado = false;
            List<String> lineasActualizadas = new ArrayList<>();

            for (String linea : lineas) {
                if (linea.trim().isEmpty()) continue;
                String[] partes = linea.split(" - ");
                if (partes.length > 0 && partes[0].trim().equals(idBuscado)) {
                    eliminado = true; 
                } else {
                    lineasActualizadas.add(linea);
                }
            }

            if (eliminado) {
                Files.write(ruta, lineasActualizadas);
                System.out.println("Alumno eliminado");
            } else {
                System.out.println("Error: El alumno con ese ID no existe.");
            }

        } catch (IOException e) {
            System.err.println("Error es eliminar del archivo: " + e.getMessage());
        }
    }
}
