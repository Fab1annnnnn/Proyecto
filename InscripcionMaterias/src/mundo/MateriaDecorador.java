/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mundo;

/**
 *
 * @author fabian
 */
public abstract class MateriaDecorador implements Materia {
    protected Materia materia;

    public MateriaDecorador(Materia materia) {
        this.materia = materia;
    }

    @Override
    public String getNombre() {
        return materia.getNombre();
    }

    @Override
    public int getCupos() {
        return materia.getCupos();
    }

    @Override
    public void inscribir(String nombreEstudiante) {
        materia.inscribir(nombreEstudiante);
    }
}


