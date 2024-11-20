/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mundo;

/**
 *
 * @author fabian
 */
public class EstudianteObservador implements Observador {
    private String nombre;

    public EstudianteObservador(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public void actualizar(String mensaje) {
        System.out.println("Profesor " + nombre + " ha recibido la notificación: " + mensaje);
    }
}



