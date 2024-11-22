package mundo;

import java.util.HashSet;
import java.util.List;
import java.util.ArrayList;
import java.util.Set;

public class MateriaReal implements Materia {
    private String nombre;
    private int cupos;
    private Set<String> inscritos;
    private List<Observador> observadores;

    public MateriaReal(String nombre, int cupos) {
        this.nombre = nombre;
        this.cupos = cupos;
        this.inscritos = new HashSet<>();
        this.observadores = new ArrayList<>();
    }

    @Override
    public String getNombre() {
        return nombre;
    }

    @Override
    public int getCupos() {
        return cupos;
    }

    @Override
    public void inscribir(String nombreEstudiante, boolean esVirtual) {
        if (inscritos.contains(nombreEstudiante)) {
            System.out.println("✖ El estudiante " + nombreEstudiante + " ya está inscrito en " + nombre + ".");
            return;
        }

        if (cupos == 0) {
            System.out.println("✖ No hay cupos disponibles para " + nombre + ".");
        } else {
            inscritos.add(nombreEstudiante);
            if (cupos > 0) cupos--;
            System.out.println("✔ " + nombreEstudiante + " ha sido inscrito en " + nombre + ".");
            if (cupos >= 0) {
                System.out.println("Cupos restantes: " + cupos);
            } else {
                System.out.println("(Cupos ilimitados)");
            }
            // Notificar a los observadores después de la inscripción
            notificarObservadores("El estudiante " + nombreEstudiante + " se ha inscrito en " + nombre + " (" + (esVirtual ? "Virtual" : "Presencial") + ").");
        }
    }

    @Override
    public void agregarObservador(Observador observador) {
        observadores.add(observador);
    }

    @Override
    public void notificarObservadores(String mensaje) {
        for (Observador observador : observadores) {
            observador.actualizar(mensaje);
        }
    }
}












