/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mundo;

/**
 *
 * @author fabian
 */
import java.util.HashSet;
import java.util.Set;

public class MateriaConVerificacion implements Materia {
    private Materia materiaDecorada;

    public MateriaConVerificacion(Materia materia) {
        this.materiaDecorada = materia;
    }

    @Override
    public String getNombre() {
        return materiaDecorada.getNombre();
    }

    @Override
    public int getCupos() {
        return materiaDecorada.getCupos();
    }

    @Override
    public void inscribir(String nombreEstudiante) {
        // Lógica de verificación
        if (materiaDecorada instanceof MateriaReal) {
            MateriaReal materiaReal = (MateriaReal) materiaDecorada;
            if (materiaReal.getInscritos().contains(nombreEstudiante)) {
                System.out.println("✖ El estudiante " + nombreEstudiante + " ya está inscrito en " + materiaReal.getNombre() + ".");
                return;
            }
        }

        // Si no está inscrito, procede con la inscripción
        materiaDecorada.inscribir(nombreEstudiante);
    }

    @Override
    public void agregarObservador(Observador observador) {
        materiaDecorada.agregarObservador(observador);
    }

    @Override
    public void notificarObservadores(String mensaje) {
        materiaDecorada.notificarObservadores(mensaje);
    }
}



