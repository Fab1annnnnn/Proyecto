package mundo;

import java.util.ArrayList;
import java.util.List;

public class HistorialDecorador implements Materia {
    private Materia materiaDecorada;
    private List<String> historial;

    public HistorialDecorador(Materia materia) {
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
    public void inscribir(String nombreEstudiante, boolean esVirtual) {
        // Registrar intento de inscripción en el historial
        historial.add("Inscripción de " + nombreEstudiante + " en " + materiaDecorada.getNombre() + " (" + (esVirtual ? "Virtual" : "Presencial") + ")");
        materiaDecorada.inscribir(nombreEstudiante, esVirtual);
    }

    @Override
    public void agregarObservador(Observador observador) {
        materiaDecorada.agregarObservador(observador);
    }

    @Override
    public void notificarObservadores(String mensaje) {
        materiaDecorada.notificarObservadores(mensaje);
    }

    public void mostrarHistorial() {
        System.out.println("Historial de inscripciones:");
        if (historial.isEmpty()) {
            System.out.println("No hay inscripciones registradas.");
        } else {
            for (String registro : historial) {
                System.out.println(registro);
            }
        }
    }
}

