package clases;
public class LlistaUsuaris {

    private int nElem;
    private Usuari[] llista;

    public LlistaUsuaris(int mida) {
        llista = new Usuari[mida];
        nElem = 0;
    }

    public LlistaUsuaris() {
        llista = new Usuari[100];
        nElem = 0;
    }

    /**
     * Esborrar un element de la llista
     * @param posicio asumim que va desde 0 fins a nElem-1 (si posicio = nElem -1 la llista técnicament no es modifica però si que decrementa el nElem)
     */
    public void afegirUsuari(Usuari u) {
        if (nElem < llista.length) {
            llista[nElem] = u.copia();
            nElem++;
        }
    }

    public void treureUsuari(int posicio) {
        if (posicio < nElem) {
            while (posicio < nElem-1) {
                llista[posicio] = llista[posicio+1];
                posicio++;
            }

            nElem--;
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

    public Usuari buscarUsuari(String alies) {
        for (int i = 0; i < nElem; i++) {
            if (llista[i].getAlies().equals(alies)) return llista[i];
        }
        return null;
    }

    public Usuari getUsuari(int pos) {
        return llista[pos];
    }    
}
