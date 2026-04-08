package modelo;

/**
 *
 * @author rosam
 */
public class Curso {
    private Estudiante[] estudiantes;
    private int cantidad;

    public Curso(int cantidad) {

        this.cantidad = cantidad;
        estudiantes = new Estudiante[cantidad];
    }

    public void agregar(Estudiante e, int posicion) {

        estudiantes[posicion] = e;
    }

    public void ordenarAscendente() {

        for (int i = 0; i < cantidad - 1; i++) {

            for (int j = 0; j < cantidad - 1 - i; j++) {

                if (estudiantes[j].getDefinitiva() >
                    estudiantes[j + 1].getDefinitiva()) {

                    Estudiante aux = estudiantes[j];
                    estudiantes[j] = estudiantes[j + 1];
                    estudiantes[j + 1] = aux;
                }
            }
        }
    }
      
    public void mostrarMayorQue(double limite) {

        for (int i = 0; i < cantidad; i++) {

            if (estudiantes[i].getDefinitiva() > limite) {

                System.out.println(
                    estudiantes[i].getCodigo() + " - " +
                    estudiantes[i].getNombre() + " - " +
                    estudiantes[i].getDefinitiva()
                );
            }
        }
    }
    
    public void incrementarTodos(double incremento) {

        for (int i = 0; i < cantidad; i++) {

            estudiantes[i].incrementar(incremento);
        }
    }

    public Estudiante buscar(int codigo) {

    for (int i = 0; i < cantidad; i++) {

        if (estudiantes[i] != null &&
            estudiantes[i].getCodigo() == codigo) {

            return estudiantes[i];
        }
    }

    return null;
}
    
    public Estudiante buscar(String nombre) {
    for (int i = 0; i < cantidad; i++) {
        if (estudiantes[i] != null &&
            estudiantes[i].getNombre().equalsIgnoreCase(nombre)) {
            return estudiantes[i];
        }
    }
    return null;
}
    
    public void modificarEstudiante(int codigo, double nuevoSoftware, double nuevoHardware, double nuevaMatematica) {
        Estudiante e = buscar(codigo);
        if (e != null) {
            e.modificar(nuevoSoftware, nuevoHardware, nuevaMatematica);
        } 
        
        else {
            System.out.println("Estudiante con codigo " + codigo + " no encontrado");
        }
    }

    public Estudiante[] getEstudiantes() { return estudiantes; }
    public int getCantidad() { return cantidad; }
}
