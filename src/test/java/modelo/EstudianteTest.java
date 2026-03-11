package modelo;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author rosam
 */
public class EstudianteTest {

// pruebas de estudinte 

    @Test
    public void testCalculoDefinitivaYEstado() {
        Estudiante e = new Estudiante(21001, "Rosenrot", 4.0, 5.0, 3.5);

        assertEquals(4.5, e.getDesarrollo(), 0.001);
        assertEquals(4.05, e.getDefinitiva(), 0.001);
        assertEquals("SI APRUEBA", e.getEstado());
    }

    @Test
    public void testIncrementarNotas() {
        Estudiante e = new Estudiante(21002, "Abril", 4.8, 4.9, 3.0);
        e.incrementar(0.3);

        assertEquals(5.0, e.getSoftware(), 0.001);
        assertEquals(5.0, e.getHardware(), 0.001);
    }

    @Test
    public void testModificarNotas() {
        Estudiante e = new Estudiante(21003, "Christian", 2.0, 2.0, 2.0);
        e.modificar(5.0, 5.0, 5.0);

        assertEquals(5.0, e.getSoftware(), 0.001);
        assertEquals(5.0, e.getHardware(), 0.001);
        assertEquals(5.0, e.getMatematica(), 0.001);
        assertEquals("SI APRUEBA", e.getEstado());
    }

    @Test
    public void testGettersBasicos() {
        Estudiante e = new Estudiante(123, "Rocio", 3, 3, 3);

        assertEquals(123, e.getCodigo());
        assertEquals("Rocio", e.getNombre());
        assertEquals(3.0, e.getMatematica(), 0.001);
    }

    
    // pruebas de curso
    

    @Test
    public void testCursoAgregarYBuscar() {
        Curso curso = new Curso(2);

        Estudiante e1 = new Estudiante(1, "A", 4, 4, 4);
        Estudiante e2 = new Estudiante(2, "B", 3, 3, 3);

        curso.agregar(e1, 0);
        curso.agregar(e2, 1);

        assertEquals(e1, curso.buscar(1));
        assertEquals(e2, curso.buscar(2));
        assertNull(curso.buscar(99));
    }

    @Test
    public void testOrdenarYIncrementarCurso() {
        Curso curso = new Curso(2);

        Estudiante e1 = new Estudiante(1, "A", 5, 5, 5);
        Estudiante e2 = new Estudiante(2, "B", 3, 3, 3);

        curso.agregar(e1, 0);
        curso.agregar(e2, 1);

        curso.incrementarTodos(0.5);
        curso.ordenarAscendente();

        assertEquals(e2, curso.getEstudiantes()[0]);
        assertEquals(e1, curso.getEstudiantes()[1]);
    }

    @Test
    public void testModificarEstudianteCurso() {
        Curso curso = new Curso(1);

        Estudiante e = new Estudiante(10, "Test", 2, 2, 2);
        curso.agregar(e, 0);

        curso.modificarEstudiante(10, 5, 5, 5);

        assertEquals(5.0, curso.buscar(10).getSoftware(), 0.001);
        assertEquals("SI APRUEBA", curso.buscar(10).getEstado());
    }

    @Test
    public void testGetCantidad() {
        Curso curso = new Curso(3);
        assertEquals(3, curso.getCantidad());
    }
}