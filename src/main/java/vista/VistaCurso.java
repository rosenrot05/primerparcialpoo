package vista;

/**
 *
 * @author rosam
 */

import java.util.Scanner;
import modelo.Estudiante;

public class VistaCurso {
        private Scanner sc = new Scanner(System.in);

    // leer la cantidad de estudiantes
    public int leerCantidad() {
    String texto;
    int cantidad;

    do {
        System.out.print("Numero de estudiantes: ");
        texto = sc.nextLine();
        
        if (!texto.matches("\\d+")) {
            System.out.println("Valor incorrecto, intenta de nuevo");
        }

    } while (!texto.matches("\\d+"));  // solo recibe numeros

    cantidad = Integer.parseInt(texto);

    return cantidad;
}

    // leer el codigo del estudiante
    public int leerCodigo() {
    String texto;
    int codigo;

    do {
        System.out.print("Ingresa un codigo mayor a 21000: ");
        texto = sc.nextLine();
        
        if (!texto.matches("\\d+") || Integer.parseInt(texto) <= 21000) {
            System.out.println("Valor incorrecto, intenta de nuevo");
        }

    } while (!texto.matches("\\d+") || Integer.parseInt(texto) <= 21000);

    codigo = Integer.parseInt(texto);

    return codigo;
}

    // leer nombre del estudiante
    public String leerNombre() {
    String nombre;

    do {
        System.out.print("Nombre: ");
        nombre = sc.nextLine();

        if (nombre.matches(".*\\d.*") || nombre.isEmpty()) {
            System.out.println("Nombre incorrecto, no debe contener numeros.");
        }

    } while (nombre.matches(".*\\d.*") || nombre.isEmpty());

    return nombre;
}
    
    // leer nota (software, hardware, matemática)
    public double leerNota(String materia) {
        double nota = -1;
        String linea;
        do {
            System.out.print("Nota de " + materia + " (0-5): ");
            linea = sc.nextLine().trim();
            if (linea.isEmpty()) continue; // si no escribio nada se repite
            nota = Double.parseDouble(linea.replace(",", "."));
        } while (nota < 0 || nota > 5);
        return nota;
    }

    // leer limite de nota
    public double leerLimite() {
        double limite = -1;
        String linea;
        do {
            System.out.print("Nota limite (0-5): ");
            linea = sc.nextLine().trim();
            if (linea.isEmpty()) continue;
            limite = Double.parseDouble(linea.replace(",", "."));
        } while (limite < 0 || limite > 5);
        return limite;
    }

    // leer incremento
    public double leerIncremento() {
        double inc = -1;
        String linea;
        do {
            System.out.print("Nota de incremento (0 - 0.5): ");
            linea = sc.nextLine().trim();
            if (linea.isEmpty()) continue;
            inc = Double.parseDouble(linea.replace(",", "."));
        } while (inc < 0 || inc > 0.5);
        return inc;
    }

    // mostrar la lista de estudiantes
    public void mostrar(Estudiante[] lista, int cantidad) {
        for (int i = 0; i < cantidad; i++) {
            System.out.println(
                "Codigo: " + lista[i].getCodigo() +
                " Nombre: " + lista[i].getNombre() +
                " Desarrollo: " + lista[i].getDesarrollo() +
                " Matematicas: " + lista[i].getMatematica() +
                " Definitiva: " + lista[i].getDefinitiva() +
                " Estado: " + lista[i].getEstado()
            );
        }
    }
}
    

    

