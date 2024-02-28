package clases;

import java.util.Objects;

public class Taller extends Activitat {
    private static final long serialVersionUID = 1L;

    private int hora;
    private int durada; //en minutos, así no se tiene que hacer un float
    private int capacitatMax;
    private int numInscripcions;
    private int sumaPuntuaciones = 0;
    private int numPuntuaciones = 0;

    public Taller(String nom, int codiPostal, int dia, int hora, int durada, int capacitatMax, String entitat, int numInscripcions, int sumaPuntuaciones, int numPuntuaciones) {
        super(nom, codiPostal, dia, entitat);
        this.hora = hora;
        this.durada = durada;
        this.capacitatMax = capacitatMax;
        this.numInscripcions = numInscripcions;
        this.sumaPuntuaciones = sumaPuntuaciones;
        this.numPuntuaciones = numPuntuaciones;
    }

    /**
     * Constructor PRIVATE de Taller SOLO usado para copias.
     */
    /* private Taller(String codi, String nom, int codiPostal, int dia, String nomEntitat, int hora, int durada, int capacitatMax, int sumaPuntuaciones, int numPuntuaciones) {
        super(codi, nom, codiPostal, dia, nomEntitat);
        this.hora = hora;
        this.durada = durada;
        this.sumaPuntuaciones = sumaPuntuaciones;
        this.numPuntuaciones = numPuntuaciones;
        this.capacitatMax = capacitatMax; 
    } */

    public Taller actualizarInscripcions() {
        this.numInscripcions++;
        return this;
    }



    public int getNumInscripcions() {
        return numInscripcions;
    }
    public int getHora() {
        return hora;
    }

    public int getDurada() {
        return durada;
    }

    public int getCapacitatMax() {
        return capacitatMax;
    }
 
    public int getSumaPuntuaciones() { 
        return sumaPuntuaciones;
    }

    public int getNumPuntuaciones() {
        return numPuntuaciones;
    }

    public void setHora(int hora) {
        this.hora = hora;
    }

    public void setDurada(int durada) {
        this.durada = durada;
    }

    public void setCapacitatMax(int capacitatMax) {
        this.capacitatMax = capacitatMax;
    }

    /**
     * Las puntuaciones NO se podrán cambiar fijamente, si no que un usuario simplemente da una puntuación del taller y ya
     * @param num
     */
    public void sumaPuntuacion(int num) {
        if (num < 0 || num > 10) System.out.println("La puntuación tiene que ser entre 0 y 10!");
        sumaPuntuaciones += num;
        numPuntuaciones++;
    }

    public float getMitjanaPuntuacion() {
        float mitjana = 0;
        if (numPuntuaciones != 0) {
            mitjana = (float)sumaPuntuaciones/numPuntuaciones;
        }
        return mitjana;
    }

    public String toString() {
        return (super.toString() + "\nHora: " + hora + "\nDurada (minutos): " + durada + "\nCapacitad Maxima: " + capacitatMax + "\nNum de inscripcions:"+ numInscripcions + ( (numPuntuaciones != 0) ? 
        ("\nSuma de puntuaciones: " + sumaPuntuaciones + " " + "\nMitjana de puntuaciones: " + getMitjanaPuntuacion()) : ""));
    }

    public Taller copia() {
        return this;
    }

    public String  getCodi() {
        return codi;
    }

    public float getProporcioOcupacio() {
        return (numInscripcions * 1.0f)/(capacitatMax * 1.0f); // Convertim els ints a float, per a un correcte us de les dades. 
    }

    /*
    * Necesitamos un metodo equals para que permita comprobar si el ID del taller es igual al ID que nos entra y asi confirmar que 
    * el taller es el mismo. Ya que el metodo equals en java compara por referencia, y nos es util para algunos casos.
    */
    /* Comproba a partir del codi del taller si son iguals o no.
    * Return true  = iguals
    * Return false = no iguals
    * 
    */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        Taller otroTaller = (Taller) obj;
        return Objects.equals(codi, otroTaller.codi);
    } 

}
