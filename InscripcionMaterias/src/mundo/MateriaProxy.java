/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mundo;

/**
 *
 * @author fabian
 */
public class MateriaProxy implements Materia {
    private MateriaReal materiaReal;

    public MateriaProxy(String nombre, int cupos) {
        this.materiaReal = new MateriaReal(nombre, cupos);
    }

    @Override
    public String getNombre() {
        return materiaReal.getNombre();
    }

    @Override
    public int getCupos() {
        return materiaReal.getCupos();
    }

    @Override
    public void inscribir(String nombreEstudiante) {
        System.out.println("Verificando requisitos para " + nombreEstudiante + "...");

        // Verificación simple: el nombre no debe estar vacío o ser demasiado corto
        if (nombreEstudiante == null || nombreEstudiante.trim().length() <= 2) {
            System.out.println("✖ No se puede inscribir: nombre inválido. Debe tener más de 2 caracteres.");
            return;
        }

        // Si pasa la verificación, delega la inscripción a la materia real
        materiaReal.inscribir(nombreEstudiante);
    }

    @Override
    public void agregarObservador(Observador observador) {
        materiaReal.agregarObservador(observador);
    }

    @Override
    public void notificarObservadores(String mensaje) {
        materiaReal.notificarObservadores(mensaje);
    }
}












