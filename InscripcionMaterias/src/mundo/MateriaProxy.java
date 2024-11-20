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
        System.out.println("Verificando inscripción para " + nombreEstudiante + "...");
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










