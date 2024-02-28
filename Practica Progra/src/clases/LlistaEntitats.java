package clases;
public class LlistaEntitats {
    
    private int numDades;
    private Entitat[] llista;

    public LlistaEntitats (int mida){
        numDades = 0;
        llista = new Entitat[mida];
    }

    public void afegirEntitat(Entitat e) {
        if (numDades < llista.length) {
            llista[numDades] = e.copia();
        }
        numDades++;
    }

    /**
     * Esborrar un element de la llista
     * @param posicio asumim que va desde 0 fins a nElem-1 (si posicio = nElem -1 la llista técnicament no es modifica però si que decrementa el nElem)
     */
    public void treureEntitat(int posicio) {
        if (posicio < numDades) {
            while (posicio < numDades-1) {
                llista[posicio] = llista[posicio+1];
                posicio++;
            }

            numDades--;
        }
    }

    public String toString() {
        String s = "";
        for (int i = 0; i < numDades; i++) {
            s += llista[i].toString();
        }
        return s;
    }

    public int getNElem() {
        return numDades;
    }

    public Entitat buscarEntitat(String nom) {
        for (int i = 0; i < numDades; i++) {
            if (llista[i].getNom().equals(nom)) return llista[i];
        }
        return null;
    }

    public Entitat getEntitat(int pos) {
        return llista[pos];
    }

}

