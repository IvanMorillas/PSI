package clases;
public class LlistaReserves {
    
    private int nElem;
    private Reserva[] llista;

    //Constructor con tamaño definido
    public LlistaReserves(int mida) {
        nElem = 0;
        llista = new Reserva[mida];
    }

    //Constructor sin definir
    public LlistaReserves() {
        nElem = 0;
        llista = new Reserva[100];
    }

    public int numReservas(String codiTaller) {
        int num = 0;
        for (int i = 0; i < nElem; i++) {
            if (llista[i].getTaller().getCodi().equals(codiTaller)) num++;
        }
        return num;
    }



    public void afegirReserva(Reserva r) {
        if (nElem < llista.length) {
            llista[nElem] = r;
            nElem++;
        }
    } 


    public String toString() {
        String s = "";
        for (int i = 0; i < nElem; i++) {
            s += llista[i].toString() + "\n";
        }
        return s;
    }

    public int getNElem() {
        return nElem;
    }

    public Usuari usuariAmbMesReserves() {
        int maxInscripcions = 0;
        int posicio = 0;
        for (int i = 0; i < nElem; i++) {
            if (llista[i].getUsuari().getNumInscripcions() > maxInscripcions) {
                maxInscripcions = llista[i].getUsuari().getNumInscripcions();
                posicio = i;
            }
        }
        return llista[posicio].getUsuari();
    }

    public Reserva getReserva(int pos) {
        return llista[pos];
    }

    /**
     * @param u
     * @param t
     * @return true / false segons si esta o no apuntat al taller. 
     */
    public boolean esUsuariApuntatATaller(Usuari u, Taller t) {
        boolean esApuntat = false;
        int i = 0;
        while (!esApuntat && i < nElem) {
           if (llista[i].getTaller().equals(t) && llista[i].getUsuari().equals(u)) {
            esApuntat = true;
           }
           i++;
        }
        return esApuntat;
    }

        /** Genera una llista de usuaris apuntats a un taller pasat per parametre. 
     * @param u
     * @param t
     * @return LlistaUsuaris
     */
    public LlistaUsuaris usuarisApuntatsATaller(LlistaUsuaris u, Taller t) {
        LlistaUsuaris llistaRetorn = new LlistaUsuaris(t.getNumInscripcions());
        
        for (int i = 0; i < u.getNElem(); i++) {
            if (esUsuariApuntatATaller(u.getUsuari(i), t)) {
                llistaRetorn.afegirUsuari(u.getUsuari(i));
            }
        }
        return llistaRetorn;
    }
     
    /** Si safegeix una puntuacio es te que actualitzar tambe en la llista de reserves. 
     * @param u
     * @param t
     */
    public void actualitzarPuntuacions(Usuari u, Taller t) {
        int posicioTrobada = trobarReserva(u, t);
        if (posicioTrobada != -1) {
           Reserva r = llista[posicioTrobada];
           r.setTaller(t);
           llista[posicioTrobada] = r;
        }
    }

    /** Metode privat per trobar una reserva en la llista. 
     * @param u
     * @param t
     * @return posicio de la llista on es troba
     */
    private int trobarReserva(Usuari u, Taller t) {

        int posicioTrobada = -1;
        boolean noTrobat = true;
        int i = 0;
        while (noTrobat) { // Aquesta funcio solament es crida si la reserva es valida, per tant, sempre estara a la llista.
            if (llista[i].getTaller().equals(t) && llista[i].getUsuari().equals(u)) {
                posicioTrobada = i;
                noTrobat = false;
            }
            i++;
        }
        return posicioTrobada;
    }
}
