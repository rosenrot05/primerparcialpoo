package main;

import controlador.ControladorCurso;
import vista.VistaCurso;

public class Aplicacion {
    public static void main(String[] args) {

        VistaCurso vista = new VistaCurso();
        int cantidad = vista.leerCantidad();
        ControladorCurso controlador = new ControladorCurso(cantidad);

        // solo para agregar estudiantes
        for (int i = 0; i < cantidad; i++) {

            int codigo = vista.leerCodigo();
            String nombre = vista.leerNombre();

            double software = vista.leerNota("Software");
            double hardware = vista.leerNota("Hardware");
            double matematica = vista.leerNota("Matematica");

            // POLIMORFISMO
            if (i % 2 == 0) {
                controlador.agregar(i, codigo, nombre, software, hardware, matematica);
            } else {
                controlador.agregar(i, codigo, nombre, software, hardware, matematica, 0.3);
            }
        } 

        System.out.println("Lista ordenada:");
        controlador.getCurso().ordenarAscendente();
        vista.mostrar(controlador.getCurso().getEstudiantes(), cantidad);

        double limite = vista.leerLimite();
        System.out.println("Estudiantes con notas mayores al limite:");
        controlador.getCurso().mostrarMayorQue(limite);

        double incremento = vista.leerIncremento();
        controlador.getCurso().incrementarTodos(incremento);

        System.out.println("Notas despues del incremento:");
        controlador.getCurso().ordenarAscendente();
        vista.mostrar(controlador.getCurso().getEstudiantes(), cantidad);

        System.out.println("Modificar notas del estudiante:");
        int codigo = vista.leerCodigo();
        double nuevoSoftware = vista.leerNota("Nueva nota de software");
        double nuevoHardware = vista.leerNota("Nueva nota de Hardware");
        double nuevaMatematica = vista.leerNota("Nueva nota de matematicas");

        controlador.getCurso().modificarEstudiante(codigo, nuevoSoftware, nuevoHardware, nuevaMatematica);

        System.out.println("Lista final:");
        controlador.getCurso().ordenarAscendente();
        vista.mostrar(controlador.getCurso().getEstudiantes(), cantidad);
    }
}