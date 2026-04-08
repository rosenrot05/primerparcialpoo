
package modelo;

/**
 *
 * @author rosam
 */
public class EstudianteBecado extends Estudiante {
   
    private double bono;

    public EstudianteBecado(int codigo, String nombre, double software, double hardware, double matematica, double bono) {
        super(codigo, nombre, software, hardware, matematica);
        this.bono = bono;
    }

    // POLIMORFISMO 
    @Override
    public void recalcular() {
        super.recalcular();
        
        // aumenta la definitiva con bono
        double nuevaDef = getDefinitiva() + bono;
        if (nuevaDef > 5) nuevaDef = 5;

        // como definitiva es privada, la usamos modificar indirectamente
        super.modificar(getSoftware(), getHardware(), getMatematica());
    }
}

