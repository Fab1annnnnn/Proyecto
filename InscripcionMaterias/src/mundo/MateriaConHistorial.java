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

public class MateriaConHistorial implements Materia {
    private Materia materiaDecorada;
    private List<String> historial;

    public MateriaConHistorial(Materia materia) {
        this.materiaDecorada = materia;
        this.historial = new ArrayList<>();
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
        // Registrar intento de inscripción
        historial.add("Intento: " + nombreEstudiante + " en " + materiaDecorada.getNombre());
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

    public List<String> getHistorial() {
        return historial;
    }
}

