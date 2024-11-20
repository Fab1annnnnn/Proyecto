
package interfaz;

import java.util.Scanner;
import mundo.EstudianteObservador;
import mundo.Materia;
import mundo.MateriaConVerificacion;
import mundo.MateriaProxy;
import mundo.SistemaInscripcion;

/**
 *
 * @author fabian
 */
public class InterfazApp {

    /**
     * @param args the command line arguments
     */
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Singleton: Obtener la instancia del sistema de inscripción
        SistemaInscripcion sistema = SistemaInscripcion.obtenerInstancia();

        // Crear materias con cupos y agregar al sistema
        MateriaProxy matematicas = new MateriaProxy("Matemáticas", 2);
        MateriaProxy historia = new MateriaProxy("Historia", 3);
        MateriaProxy literatura = new MateriaProxy("Literatura", -1); // Ilimitada
        
        // Aplicar decorador para verificar inscripciones
        Materia matematicasConVerificacion = new MateriaConVerificacion(matematicas);
        Materia historiaConVerificacion = new MateriaConVerificacion(historia);
        Materia literaturaConVerificacion = new MateriaConVerificacion(literatura);

        sistema.agregarMateria(matematicasConVerificacion);
        sistema.agregarMateria(historiaConVerificacion);
        sistema.agregarMateria(literaturaConVerificacion);

        // Agregar observadores (Profesores)
        EstudianteObservador estudiante1 = new EstudianteObservador("Juan");
        EstudianteObservador estudiante2 = new EstudianteObservador("Maria");
        matematicasConVerificacion.agregarObservador(estudiante1);
        historiaConVerificacion.agregarObservador(estudiante2);

        System.out.println("Bienvenido al sistema de inscripción de materias.");

        boolean continuar = true;
        while (continuar) {
            System.out.println("\nOpciones:");
            System.out.println("1. Ver materias disponibles");
            System.out.println("2. Inscribir estudiante en una materia");
            System.out.println("3. Salir");
            System.out.print("Seleccione una opción: ");
            int opcion = scanner.nextInt();
            scanner.nextLine(); // Consumir el salto de línea

            switch (opcion) {
                case 1 -> sistema.mostrarMaterias();
                case 2 -> {
                    System.out.print("Ingrese el nombre del estudiante: ");
                    String nombreEstudiante = scanner.nextLine();

                    System.out.print("Ingrese el nombre de la materia a inscribir: ");
                    String nombreMateria = scanner.nextLine();

                    sistema.inscribirMateria(nombreEstudiante, nombreMateria);
                }
                case 3 -> {
                    continuar = false;
                    System.out.println("Cerrando el sistema de inscripción. ¡Gracias por usarlo!");
                }
                default -> System.out.println("Opción no válida. Intente de nuevo.");
            }
        }

        scanner.close();
    }
}

    

