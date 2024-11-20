
package interfaz;

import java.util.Scanner;
import mundo.EstudianteObservador;
import mundo.Materia;
import mundo.MateriaConHistorial;
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

        SistemaInscripcion sistema = SistemaInscripcion.obtenerInstancia();

        MateriaProxy matematicas = new MateriaProxy("Matematicas", 2);
        MateriaProxy historia = new MateriaProxy("Historia", 3);
        MateriaProxy literatura = new MateriaProxy("Literatura", -1);

        Materia matematicasConHistorial = new MateriaConHistorial(matematicas);
        Materia historiaConHistorial = new MateriaConHistorial(historia);
        Materia literaturaConHistorial = new MateriaConHistorial(literatura);

        sistema.agregarMateria(matematicasConHistorial);
        sistema.agregarMateria(historiaConHistorial);
        sistema.agregarMateria(literaturaConHistorial);

        EstudianteObservador estudiante1 = new EstudianteObservador("Carlos");
        EstudianteObservador estudiante2 = new EstudianteObservador("Luisa");

        matematicasConHistorial.agregarObservador(estudiante1);
        historiaConHistorial.agregarObservador(estudiante2);

        boolean continuar = true;
        while (continuar) {
            System.out.println("\nOpciones:");
            System.out.println("1. Ver materias disponibles");
            System.out.println("2. Inscribir estudiante en una materia");
            System.out.println("3. Ver historial de inscripciones");
            System.out.println("4. Salir");
            System.out.print("Seleccione una opción: ");
            int opcion = scanner.nextInt();
            scanner.nextLine();

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
                    System.out.println("\nHistorial de inscripciones:");
                    System.out.println(((MateriaConHistorial) matematicasConHistorial).getHistorial());
                    System.out.println(((MateriaConHistorial) historiaConHistorial).getHistorial());
                    System.out.println(((MateriaConHistorial) literaturaConHistorial).getHistorial());
                }
                case 4 -> {
                    continuar = false;
                    System.out.println("Gracias por usar el sistema.");
                }
                default -> System.out.println("Opción no válida.");
            }
        }

        scanner.close();
    }
}

    

