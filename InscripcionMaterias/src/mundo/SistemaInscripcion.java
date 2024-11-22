
package mundo;

/**
 *
 * @author fabian
 */

import java.util.ArrayList;
import java.util.List;

public class SistemaInscripcion {
    private static SistemaInscripcion instancia;
    private List<Materia> materias;

    private SistemaInscripcion() {
        materias = new ArrayList<>();
    }

    public static SistemaInscripcion obtenerInstancia() {
        if (instancia == null) {
            instancia = new SistemaInscripcion();
        }
        return instancia;
    }

    // Agregar materia con historial
    public void agregarMateria(String nombre, int cupos) {
        Materia materia = new MateriaProxy(nombre, cupos);
        // Envuelvo la materia con el decorador de historial
        materia = new HistorialDecorador(materia);
        materias.add(materia);
    }

    public void mostrarMaterias() {
        System.out.println("\nMaterias disponibles:");
        for (Materia materia : materias) {
            System.out.println("- " + materia.getNombre() + " (Cupos: " + (materia.getCupos() < 0 ? "Ilimitados" : materia.getCupos()) + ")");
        }
    }

    public void inscribirEstudiante(String materiaNombre, Estudiante estudiante, boolean esVirtual) {
        for (Materia materia : materias) {
            if (materia.getNombre().equalsIgnoreCase(materiaNombre)) {
                materia.inscribir(estudiante.getNombre(), esVirtual);
                return;
            }
        }
        System.out.println("✖ La materia " + materiaNombre + " no existe en el sistema.");
    }

    public void mostrarHistorial(String materiaNombre) {
        for (Materia materia : materias) {
            if (materia.getNombre().equalsIgnoreCase(materiaNombre) && materia instanceof HistorialDecorador) {
                ((HistorialDecorador) materia).mostrarHistorial();
                return;
            }
        }
        System.out.println("✖ No se encontró historial para la materia " + materiaNombre);
    }
}





