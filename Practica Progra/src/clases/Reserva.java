package clases;

import java.io.Serializable;

public class Reserva implements Serializable{
    private static final long serialVersionUID = 1L;

    private static int codiReserva = 0;
    private String codi;
    private Taller taller;
    private Usuari usuari;

    /**
     * Constructor de Reserva
     * @param taller taller que reservamos
     * @param usuari usuario que reserva
     */
    public Reserva(Taller taller, Usuari usuari) {
       
        //this.taller.nuevaPlaza(); //aumentamos de plaza
        if (taller.getNumInscripcions() < taller.getCapacitatMax()) {
            codiReserva++;
            this.taller = taller.actualizarInscripcions();
            this.codi = taller.getCodi()+"R"+codiReserva;
            this.usuari = usuari.actualizar();
        } else {
            System.out.println("Tot ple"); // PASAR A EXCEPCION
        }
    }



    public String getCodiReserva() {
        return codi;
    }

    /* public String getCodiTaller() {
        return taller.getCodi();
    } */

    /*public void setCodiReserva(int codiReserva) {
        this.codiReserva = codiReserva;
    }*/

    public void grauSatisfaccio(int num) {
        taller.sumaPuntuacion(num);
    }

    public String toString() {
        return "Taller: " + taller.getNom() + "\nUsuari: " + usuari.getAlies() + "\nCodi Reserva: " + codi;
    }

    public Usuari getUsuari() {
        return usuari;
    }

    public Taller getTaller() {
        return taller;
    }

    public void setTaller(Taller t) {
        this.taller = t;
    }

    public void setUsuari(Usuari u) {
        this.usuari = u;
    }

    //Esta función SOLAMENTE se llama desde LlistaReserves
/*     public void incrementarReserva() {
        usuari.augmentarInscripcions();
    } */

    // Realizar constructor y todos los metodos necesarios de esta subclase. 



}
