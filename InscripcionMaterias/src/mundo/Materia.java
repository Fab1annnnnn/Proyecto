/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package mundo;

/**
 *
 * @author fabian
 */

public interface Materia {
    String getNombre();
    int getCupos();
    void inscribir(String nombreEstudiante, boolean esVirtual);
    void agregarObservador(Observador observador);
    void notificarObservadores(String mensaje);
}









