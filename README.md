# Gestión de Alumnos (Java NIO)

Aplicación de consola desarrollada en Java que implementa las operaciones fundamentales de un CRUD (Crear, Leer, Actualizar y Eliminar) sobre un archivo de texto plano (`alumnos.txt`), utilizando de forma explícita el paquete de entrada/salida no bloqueante (`java.nio.file`).

## Características Principales
- **Crear**: Permite registrar un nuevo alumno solicitando su ID y Nombre Completo, validando que el ID no esté duplicado.
- **Leer**: Muestra todos los registros del archivo o busca un alumno en específico ingresando su ID.
- **Actualizar**: Modifica el nombre de un alumno buscándolo previamente por su ID.
- **Eliminar**: Remueve del archivo el registro correspondiente al ID indicado.
- **Persistencia**: El archivo `alumnos.txt` se crea automáticamente al iniciar el programa si no existe.

## Requisitos Técnicos
- Java Development Kit (JDK) 8 o superior (recomendado JDK 11+).
- Cualquier IDE de Java (NetBeans, IntelliJ IDEA, Eclipse) o terminal de comandos.

## Instrucciones de Ejecución
1. Clona o descarga los archivos fuente de este repositorio (`Main.java`, `AlumnoRepository.java` y `Alumno.java`).
2. Abre tu IDE de preferencia e importa los archivos dentro de tu paquete (ej. `com.mycompany.appnio`).
3. Ejecuta la clase principal **`Main.java`**.
4. ¡Listo! Sigue las opciones que te muestra el menú en la consola.
