package clases;

import java.io.Serializable;

abstract class Activitat implements Serializable {
    private static final long serialVersionUID = 1L;
    
    private static int codiNum = 100; //se le suma 1 cada vez que se crea una actividad de cualquier tipo
    protected String codi;
    private String nom;
    private int codiPostal;
    private int dia;
    private String nomEntitat;
    //nota: esto necesita la clase "entiat" hecha
    //private Entitat entitat;

    /**
     * Constructor
     * @param nomEntitat nomEntitat, 
     * @param nom
     * @param codiPostal
     * @param dia
     * @param entitat
     */
    public Activitat(String nom, int codiPostal, int dia, String entitat) {
        codi = entitat.substring(0,3) + String.valueOf(codiNum);
        this.nom = nom;
        this.codiPostal = codiPostal;
        this.dia = dia;
        this.nomEntitat = entitat;
        codiNum++; //se aumenta el código
    }

    /**
     * Constructor que se usa SOLAMENTE copiar una activitat, para así evitar incrementar el static codiNum
     * Para diferenciarlo, en vez de pasar Entitat entitat se pasa String nomEntitat y además se pasa el codi
     * Este constructor NO se debería de usar fuera de hacer copias, existe solamente para evitar el incremento
     * de codiNum. El constructor es public para que las subclases de Activitat puedan usarlo sin incrementar codiNum.
     */
    public Activitat(String codi, String nom, int codiPostal, int dia, String nomEntitat) {
        this.codi = codi;
        this.nom = nom;
        this.codiPostal = codiPostal;
        this.dia = dia;
        this.nomEntitat = nomEntitat;
    }

    public String getCodi() {
        return codi;
    }

    public String getNom() {
        return nom;
    }

    public int getCodiPostal() {
        return codiPostal;
    }

    public int getDia() {
        return dia;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setCodiPostal(int codiPostal) {
        this.codiPostal = codiPostal;
    }

    public void setDia(int dia) {
        this.dia = dia;
    }

    public String getNomEntitat() {
        return nomEntitat;
    }

    public void setNomEntitat(Entitat e) {
        this.nomEntitat = e.getNom();
    }

    public String toString() {
        //String s = "Codi: " + codi + "\nNom: " + nom + "\nCodi Postal: " + codiPostal + "\nDia: " + dia;
        return "Codi: " + codi + "\nNom: " + nom + "\nCodi Postal: " + codiPostal + "\nDia: " + dia + "\nOrganitzador: " + nomEntitat;
    }

}
