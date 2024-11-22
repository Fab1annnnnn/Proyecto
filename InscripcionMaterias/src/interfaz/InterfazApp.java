
package interfaz;

import java.util.Scanner;
import mundo.Estudiante;
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
        SistemaInscripcion sistema = SistemaInscripcion.obtenerInstancia();

        // Configuración inicial
        sistema.agregarMateria("matematicas", 3);  // Materia con 3 cupos
        sistema.agregarMateria("fisica", 2);      // Materia con 2 cupos
        sistema.agregarMateria("quimica", 5);     // Materia con 5 cupos

        // Crear estudiantes
        Estudiante estudiante1 = new Estudiante("Juan");
        Estudiante estudiante2 = new Estudiante("María");

        // Menú interactivo
        int opcion;
        do {
            System.out.println("\n--- Menú de Inscripción ---");
            System.out.println("1. Mostrar materias y cupos");
            System.out.println("2. Inscribir estudiante a materia");
            System.out.println("3. Mostrar historial de inscripciones");
            System.out.println("4. Salir");
            System.out.print("Seleccione una opción: ");
            opcion = scanner.nextInt();
            scanner.nextLine();  // Limpiar el buffer

            switch (opcion) {
                case 1:
                    // Mostrar materias y sus cupos
                    sistema.mostrarMaterias();
                    break;

                case 2:
                    // Inscribir estudiante a una materia
                    System.out.print("Ingrese el nombre de la materia: ");
                    String materiaNombre = scanner.nextLine();
                    System.out.print("¿Es inscripción presencial (1) o virtual (2)? ");
                    int tipoInscripcion = scanner.nextInt();
                    scanner.nextLine();  // Limpiar el buffer

                    System.out.print("Ingrese el nombre del estudiante: ");
                    String estudianteNombre = scanner.nextLine();

                    Estudiante estudiante = null;
                    if (estudianteNombre.equalsIgnoreCase(estudiante1.getNombre())) {
                        estudiante = estudiante1;
                    } else if (estudianteNombre.equalsIgnoreCase(estudiante2.getNombre())) {
                        estudiante = estudiante2;
                    }

                    if (estudiante != null) {
                        boolean esVirtual = (tipoInscripcion == 2);
                        sistema.inscribirEstudiante(materiaNombre, estudiante, esVirtual);
                    } else {
                        System.out.println("Estudiante no encontrado.");
                    }
                    break;

                case 3:
                    // Mostrar historial de inscripciones
                    System.out.print("Ingrese el nombre de la materia para ver el historial: ");
                    String materiaHistorial = scanner.nextLine();
                    sistema.mostrarHistorial(materiaHistorial);
                    break;

                case 4:
                    System.out.println("¡Hasta luego!");
                    break;

                default:
                    System.out.println("Opción no válida.");
            }
        } while (opcion != 4);

        scanner.close();
    }
}

    

