package clases;
public class Xerrada extends Activitat {
    private String nomPersona; //no creo que haga falta, ya que el nombre de la entidad que hace la actividad está guardada en "entitat"
    private static int hora = 17; //siempre es 17

    public Xerrada(String nomPersona, String nom, int codiPostal, int dia, String entitat) {
        super(nom, codiPostal, dia, entitat);
        this.nomPersona = nomPersona; //dejo esto de prueba
    }

    /**
     * Constructor que solamente existe para que no se aumente el código
     */
    private Xerrada(String codi, String nom, int codiPostal, int dia, String nomEntitat, String nomPersona) {
        super(codi, nom, codiPostal, dia, nomEntitat);
        this.nomPersona = nomPersona;
    }

    public String getNomPersona() {
        return nomPersona;
    }

    /**
     * Nota: redundante, la hora en este caso siempre es 17
     * @return
     */
    public int getHora() {
        return hora;
    }

    public void setNomPersona(String nomPersona) {
        this.nomPersona = nomPersona;
    }
   
    
    public String toString() {
        return (super.toString() + "\nNom del que fa la xerrada:  " + nomPersona + "\nHora: " + hora);
    }

    public Xerrada copia() {
        return new Xerrada(getCodi(), getNom(), getCodiPostal(), getDia(), getNomEntitat(), getNomPersona());
    }
    public String  getCodi() {
        return codi;
    }
}
