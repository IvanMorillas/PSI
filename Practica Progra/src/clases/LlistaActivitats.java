package clases;
public class LlistaActivitats {

    private int nElem;
    private Activitat[] llista;

    public LlistaActivitats(int mida) {
        llista = new Activitat[mida];
        nElem = 0;
    }

    public LlistaActivitats() {
        llista = new Activitat[100];
        nElem = 0;
    }

    public void afegirActivitat(Activitat a) {
        if (nElem < llista.length) {
            if (a instanceof Taller) llista[nElem] = ((Taller)a).copia();
            else if (a instanceof Xerrada) llista[nElem] = ((Xerrada)a).copia();
            else if (a instanceof Visita) llista[nElem] = ((Visita)a).copia();
            nElem++;
        }
    }

    /**
     * Esborrar un element de la llista
     * @param posicio asumim que va desde 0 fins a nElem-1 (si posicio = nElem -1 la llista técnicament no es modifica però si que decrementa el nElem)
     */
    public void treureActivitat(int posicio) {
        if (posicio < nElem) {
            while (posicio < nElem-1) {
                llista[posicio] = llista[posicio+1];
                posicio++;
            }
            nElem--;
        }
    }

    /**
     * esborrar una activitat especifica, però es pasa el nom i no la posició
     * @param idActivitat de la activitat a esborrar
     */
    public void treureActivitatNom(String idActivitat) {
        boolean trobat = false;
        for (int i = 0; i < nElem && !trobat; i++) {
            if (llista[i].getCodi().equals(idActivitat)) {
                treureActivitat(i);
                trobat = true;
            }
        }
    }

    public void afegirPuntuacio(int puntuacio, Taller t) {
        for (int i = 0; i < nElem; i++) {
            if (llista[i].getCodi().equals(t.getCodi())) {
                if (llista[i] instanceof Taller) ((Taller)llista[i]).sumaPuntuacion(puntuacio);
                i = nElem; //per parar el bucle
            }
        }
    }

    public String toString() {

        String x = "===== Xerrades ====== \n";
        String t = "====== Tallers ====== \n";
        String v = "====== Visites ====== \n";

        for (int i = 0; i < nElem; i++) {
            if (llista[i] instanceof Taller) {
                t += llista[i].toString() + "\n";
            } else if (llista[i] instanceof Visita) {
                v += llista[i].toString()+"\n";
            } else if (llista[i] instanceof Xerrada) {
                x += llista[i].toString()+"\n";
            }
        }

        return x+t+v;
    }

    public int getNElem() {
        return nElem;
    }

    //FUNCIONES PARA LOS EJERCICIOS
    public LlistaActivitats entitatConcreta(String nom) {
        LlistaActivitats l2 = new LlistaActivitats(nElem);
        for (int i = 0; i < nElem; i++) {
            if (llista[i].getNomEntitat().equals(nom)) l2.afegirActivitat(llista[i]);
        }
        return l2;
    }

    public LlistaActivitats diaConcret(int dia) {
        LlistaActivitats l2 = new LlistaActivitats(nElem);
        for (int i = 0; i < nElem; i++) {
            if (llista[i].getDia() == dia) l2.afegirActivitat(llista[i]);
        }
        return l2;
    }


    public Taller buscarTaller(String idTaller) {
        for (int i = 0; i < nElem; i++) {
            if (llista[i] instanceof Taller && llista[i].getCodi().equals(idTaller)) return (Taller)llista[i];
        }
        return null;
    }

     public Taller mesExit() {
        float maxProporcio = Float.MIN_VALUE;
        int posicio = 0;
        for (int i = 0; i < nElem; i++) {
            if (llista[i] instanceof Taller) {
                if (((Taller)llista[i]).getProporcioOcupacio() > maxProporcio) {
                    maxProporcio = ((Taller)llista[i]).getProporcioOcupacio();
                    posicio = i;
                }
            }
        }
        return (Taller)llista[posicio];
    }

    public String mostrarVisitesEntitat(String nom) {
        String visites = "==== VISITES ====\n";
        Visita v;
        for (int i = 0; i < nElem; i++) {
            if (llista[i] instanceof Visita) {
                v = (Visita) llista[i];
                if (v.getNomEntitat().equals(nom)) {
                    visites += llista[i] + "\n";
                }
            }
        }
        if (visites.equals("==== VISITES ====\\n")) {
            return "No se ha trobat visites per a questa entitat";
        } else {
            return visites;
        }
    }

    public String mostrarXerradesPersona(String nom) {

        String xerrades = "===== XERRADES =====\n";
        Xerrada x;
        for (int i = 0; i < nElem; i++) {
            if (llista[i] instanceof Xerrada) {
                x = (Xerrada) llista[i];
                if (x.getNomPersona().equals(nom)) {
                    xerrades += llista[i] + "\n";
                }
            }
        }
        if (xerrades.equals("===== XERRADES =====\n")) {
            return "No se ha trobat xerrades per a aquesta persona";
        } else {
            return xerrades;
        }
    }

    public Activitat getActivitat (int pos) {
        return llista[pos];
    }

    public String tallersLliures() {
        Taller t;
        String retorn = "==== TALLERS LLIURES ====\n";
        for (int i = 0; i < nElem; i++) {
            if(llista[i] instanceof Taller) {
                t =(Taller) llista[i];
                if(t.getProporcioOcupacio() < 1) {
                    retorn += llista[i] + "\n";
                }
            }
        }
        return retorn;
    }
}
