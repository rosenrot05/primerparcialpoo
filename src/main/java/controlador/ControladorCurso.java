package controlador;

/**
 *
 * @author rosam
 */

import modelo.Curso;
import modelo.Estudiante;
import modelo.EstudianteBecado;

public class ControladorCurso {
    
    private Curso curso;

    public ControladorCurso(int cantidad) {  //constructor 
        curso = new Curso(cantidad);
    }
    public void agregar(int posicion, int codigo, String nombre, double software, double hardware, double matematica) {
        Estudiante e = new Estudiante(codigo, nombre, software, hardware, matematica);
        curso.agregar(e, posicion);
    
    }
    
    // SOBRECARGA
    public void agregar(int posicion, int codigo, String nombre, double software, double hardware, double matematica, double bono) {
    Estudiante e = new EstudianteBecado(codigo, nombre, software, hardware, matematica, bono);
    curso.agregar(e, posicion);
}
// getter
    public Curso getCurso() {
        return curso;
    }   
    
}

   
