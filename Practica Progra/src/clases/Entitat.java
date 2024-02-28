package clases;

public class Entitat {

    private String nom;
    private String telefon;
    private String correuElectronic;


    /**
     * Constructor de la classe entitat
     * @param nom
     * @param telefon
     * @param correuElectronic
     */
    public Entitat(String nom, String telefon, String correuElectronic){
        this.nom = nom;
        this.telefon = telefon;
        this.correuElectronic = correuElectronic;
    }
    
    /**
     * Getter de la variable nom
     * @return nom
     */
    public String getNom() {
        return nom;
    }

    /**
     * Setter de la variable nom
     * @param nom
     */
    public void setNom(String nom) {
        this.nom = nom;
    }

    /**
     * Getter de la variable telefon
     * @return telefon
     */
    public String getTelefon() {
        return telefon;
    }

    /**
     * Setter de la variable telefon
     * @param telefon
     */
    public void setTelefon(String telefon) {
        this.telefon = telefon;
    }

    /**
     * Getter del correu electronic
     * @return correu electronic
     */
    public String getCorreuElectronic() {
        return correuElectronic;
    }

    /**
     * Setter del correu electronic
     * @param correuElectronic
     */
    public void setCorreuElectronic(String correuElectronic) {
        this.correuElectronic = correuElectronic;
    }

    public Entitat copia() {
        return new Entitat(this.nom, this.telefon, this.correuElectronic);
    }

    @Override
    public String toString() {
        return "\nnom: " + nom + "\ntelefon: " + telefon + "\ncorreuElectronic: " + correuElectronic;
    }
}
