/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
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
        this.materias = new ArrayList<>();
    }

    public static SistemaInscripcion obtenerInstancia() {
        if (instancia == null) {
            instancia = new SistemaInscripcion();
        }
        return instancia;
    }

    public void agregarMateria(Materia materia) {
        materias.add(materia);
    }

    public void mostrarMaterias() {
        System.out.println("\nMaterias disponibles:");
        for (Materia materia : materias) {
            System.out.println("- " + materia.getNombre() + " (Cupos: " + (materia.getCupos() < 0 ? "Ilimitados" : materia.getCupos()) + ")");
        }
    }

    public void inscribirMateria(String nombreEstudiante, String nombreMateria) {
        for (Materia materia : materias) {
            if (materia.getNombre().equalsIgnoreCase(nombreMateria)) {
                materia.inscribir(nombreEstudiante);
                return;
            }
        }
        System.out.println("✖ La materia " + nombreMateria + " no existe en el sistema.");
    }
}




