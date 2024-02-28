package clases;

public class Visita extends Activitat {
    String localitzacio;
    boolean audioguia;
    boolean adaptPerCecs;

    public Visita(String nom, int codiPostal, int dia, String localitzacio, boolean audioguia, boolean adaptPerCecs, String entitat) {
        super(nom, codiPostal, dia, entitat);
        this.localitzacio = localitzacio;
        this.audioguia = audioguia;
        this.adaptPerCecs = adaptPerCecs;
    }

    /**
     * Constructor que se usa solamente para la copia, por eso es private
     */
    private Visita(String codi, String nom, int codiPostal, int dia, String nomEntitat, String localitzacio, boolean audioguia, boolean adaptPerCecs) {
        super(codi, nom, codiPostal, dia, nomEntitat);
        this.localitzacio = localitzacio;
        this.audioguia = audioguia;
        this.adaptPerCecs = adaptPerCecs;
    }

    public String getLocalitzacio() {
        return localitzacio;
    }

    public boolean teAudioguia() {
        return audioguia;
    }

    public boolean esAdaptPerCecs() {
        return adaptPerCecs;
    }

    public void setLocalitzacio(String localitzacio) {
        this.localitzacio = localitzacio;
    }

    public void setAudioguia(boolean audioguia) {
        this.audioguia = audioguia;
    }

    public void setAdaptPerCecs(boolean adaptPerCecs) {
        this.adaptPerCecs = adaptPerCecs;
    }

    public String toString() {
        return (super.toString() + "\nLocalitzacio: " + localitzacio + ((audioguia) ? "\nTe audioguia" : "\nNo te audioguia") + 
        ((adaptPerCecs) ? "\nEs adapt per Cecs" : "\nNo es adapt per cecs"));
    }

    public Visita copia() {
        //String codi, String nom, int codiPostal, int dia, String nomEntitat, String localitzacio, boolean audioguia, boolean adaptPerCecs
        return new Visita(getCodi(), getNom(), getCodiPostal(), getDia(), getNomEntitat(), this.localitzacio, this.audioguia, this.adaptPerCecs);
    }
    public String  getCodi() {
        return codi;
    }
}
