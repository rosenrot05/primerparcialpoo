package modelo;

/**
 *
 * @author rosam
 */
public class Estudiante {
    // atributos
    private int codigo;
    private String nombre;
    private double software;
    private double hardware;
    private double desarrollo;
    private double matematica;
    private double definitiva;
    private String estado;

    // constructor principal
    public Estudiante(int codigo, String nombre, double software, double hardware, double matematica) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.software = software;
        this.hardware = hardware;
        this.matematica = matematica;
        recalcular(); // calcula desarrollo, la definitiva y el estado
    }

    // recalcula desarrollo, definitiva y estado
    public void recalcular() {
        desarrollo = (software + hardware) / 2;
        definitiva = (desarrollo * 0.55) + (matematica * 0.45);
        if (definitiva >= 3.5) {
            estado = "SI APRUEBA";
        } else {
            estado = "NO APRUEBA";
        }
    }

    // incrementa notas de software y hardware para que afecte desarrollo
    public void incrementar(double incremento) {
        software += incremento;
        hardware += incremento;

        if (software > 5) software = 5;
        if (hardware > 5) hardware = 5;

        recalcular();
    }

    // modifica las notas y recalcula
    public void modificar(double nuevoSoftware, double nuevoHardware, double nuevaMatematica) {
        software = nuevoSoftware;
        hardware = nuevoHardware;
        matematica = nuevaMatematica;
        recalcular();
    }

    // getters

    public int getCodigo() {
        return codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public double getSoftware() {
        return software;
    }

    public double getHardware() {
        return hardware;
    }

    public double getDesarrollo() {
        return desarrollo;
    }

    public double getMatematica() {
        return matematica;
    }

    public double getDefinitiva() {
        return definitiva;
    }

    public String getEstado() {
        return estado;
    }
    
}