package app;

import java.util.Scanner;

import clases.*;

public class Funcions {
    
    static Scanner s = new Scanner(System.in); //scanner global
    public Funcions() {
        // Solament necesitem un objecte funcions buit, ja que aquesta clase nomes es per funcions
        // de la aplicacio. 
    }

    public void menu() {
        System.out.println("1. Mostrar les dades de totes les llistes.");
        System.out.println("2. Mostrar activitats d'una entitat en concret.");
        System.out.println("3. Mostrar activitats d'un dia en concret.");
        System.out.println("4. Mostrar llista de tallers amb places disponibles.");
        System.out.println("5. Afegir una nova activitat.");
        System.out.println("6. Afegir una reserva a un taller.");
        System.out.println("7. Mostrar usuaris apuntats a un taller.");
        System.out.println("8. Mostrar usuari amb més reserves");
        System.out.println("9. Registrar la nota de satisfacción d'un usuari apuntat a un taller.");
        System.out.println("10. Mostrar nota mitjana del taller.");
        System.out.println("11. Mostrar taller amb més èxit.");
        System.out.println("12. Mostrar visites ofertes per una Entitat en concret.");
        System.out.println("13. Mostrar xerrades d'una persona en concret.");
        System.out.println("14. Eliminar taller on no n'hi hagi persones apuntades.");
        System.out.println("15. Sortir");
    }

    public void cas1(LlistaActivitats la, LlistaUsuaris lu, LlistaReserves lr, LlistaEntitats le) {
        System.out.println("======== Llista d'activitats ========\n" + la + "\n======== Llista d'usuaris ========\n" + lu + "\n======== Llista de reserves ========\n" + lr + "\n======== Llista entitats ========" + le);
    }

    public void cas2(LlistaActivitats la) {
        System.out.println("Introdueix el nom de l'entitat que vols buscar:");
        String nom = s.nextLine();
        LlistaActivitats lTemp = la.entitatConcreta(nom);
        if (lTemp.getNElem() == 0) {
            System.out.println("No se ha trobat activitats per aquesta entitat o entitat erronea.");
        } else {
            System.out.println(lTemp);
        }
    }

    public void cas3(LlistaActivitats la) {
        System.out.println("Introdueix el dia pel qual vols buscar:");
        int dia = Integer.parseInt(s.nextLine());
        System.out.println(la.diaConcret(dia));
    }

    public void cas4(LlistaActivitats la) {
        System.out.println(la.tallersLliures());
    }

    public void cas5(LlistaActivitats la, LlistaEntitats le) {
        boolean tipus_correcte = false;
        String tipus = "";
        while (!tipus_correcte) {
            System.out.println("Quin tipus de activitat vol afegir? Visita | Taller | Xerrada ");
            tipus = s.nextLine();
            if (tipus.equals("Visita") || tipus.equals("Taller") || tipus.equals("Xerrada")) {
                tipus_correcte = true;
            }
        }
        tipus_correcte = false;
        
        if (tipus.equals("Visita")) {
            String nom, localitzacio, nomEntitat;
            Entitat entitat;
            int codPostal, dia;
            boolean audioguia, adaptPerCecs;
            String audioguiaString ="", adapString ="";

            System.out.println("Nom de la visita");
            nom = s.nextLine();
            System.out.println("Codi postal de la localitzacio de la visita");
            codPostal = Integer.parseInt(s.nextLine());
            System.out.println("Dia de la visita (posa sols el dia, no la data completa)");
            dia = Integer.parseInt(s.nextLine());
            System.out.println("Localitzacio de la visita");
            localitzacio = s.nextLine();
            
            while (!tipus_correcte) {
                System.out.println("Es la visita amb audioguia? SI | NO"); // Verifiquem que el usuari pose SI o NO y no una altra dada.
                audioguiaString = s.nextLine();
                if(audioguiaString.equals("SI") || audioguiaString.equals("NO")){
                    tipus_correcte = true;
                }
            }
            if (audioguiaString.equals("SI")) {
                audioguia = true;
            } else {
                audioguia = false;
            }

            tipus_correcte = false;
            while (!tipus_correcte) {
                System.out.println("Es la visita adaptada per cecs? SI | NO"); // Verifiquem que el usuari pose SI o NO y no una altra dada. 
                adapString = s.nextLine();
                if(adapString.equals("SI") || adapString.equals("NO")) {
                    tipus_correcte = true;
                }
            }
            if (adapString.equals("SI")) {
                adaptPerCecs = true;
            } else {
                adaptPerCecs = false;
            }

            System.out.println("Enitat asociada a la vista");
            nomEntitat = s.nextLine();
            while (le.buscarEntitat(nomEntitat) == null) { // Verificacio de que la entrada del usuari sigui una entitat valida
                System.out.println("Entitat no trobada, esta el nom ben posat? Torna a provar");
                nomEntitat = s.nextLine();
            }
            entitat = le.buscarEntitat(nomEntitat);
            nomEntitat = entitat.getNom(); // Posem el nom exacte de la entitat trobada. 
            la.afegirActivitat(new Visita(nom, codPostal, dia, localitzacio, audioguia, adaptPerCecs, nomEntitat));

        } else if (tipus.equals("Taller")) {
            String nom, nomEntitat;
            int codPostal, dia, hora, durada, capacitatMax;
            Entitat entitat;
            
            System.out.println("Digues el nom del taller");
            nom = s.nextLine();
            System.out.println("Digues el codi postal de la ubicacio del taller");
            codPostal = Integer.parseInt(s.nextLine());
            System.out.println("Digues el dia del taller (sols el dia, no format complet)");
            dia = Integer.parseInt(s.nextLine());
            System.out.println("Digues la hora en que es fara el taller");
            hora = Integer.parseInt(s.nextLine());
            System.out.println("Digues la durada que tindra el taller (Expresat en minuts sense cap lletra final EX => 60)");
            durada = Integer.parseInt(s.nextLine());
            System.out.println("Digues la capacitat maxima que tindra el taller");
            capacitatMax = Integer.parseInt(s.nextLine());

            System.out.println("Entitat asociada al taller");
            nomEntitat = s.nextLine();
            while (le.buscarEntitat(nomEntitat) == null) {
                System.out.println("Entitat no trobada, es segur que el nom esta ben posat? Torna a provar");
                nomEntitat = s.nextLine();
            }
            entitat = le.buscarEntitat(nomEntitat);
            nomEntitat = entitat.getNom();
            la.afegirActivitat(new Taller(nom, codPostal, dia, hora, durada, capacitatMax, nomEntitat, 0, 0, 0));

        } else if (tipus.equals("Xerrada")) {
            String nomPersona, nom, nomEntitat;
            int codiPostal, dia;
            Entitat entitat;

            System.out.println("Quina sera la persona que fara la xerrada? (nom)");
            nomPersona = s.nextLine();
            System.out.println("Sobre que fara la xerrada?");
            nom = s.nextLine();
            System.out.println("Codi postal del lloc de la xerrada");
            codiPostal = Integer.parseInt(s.nextLine());
            System.out.println("Dia que es fara la xerrada (sols el dia)");
            dia = Integer.parseInt(s.nextLine());

            System.out.println("Nom de la entitat asociada a la xerrada");
            nomEntitat = s.nextLine();
            while (le.buscarEntitat(nomEntitat) == null) {
                System.out.println("Es el nom de la entitat correcte? Prova una altra vegada");
                nomEntitat = s.nextLine();
            }
            entitat = le.buscarEntitat(nomEntitat);
            nomEntitat = entitat.getNom();
            la.afegirActivitat(new Xerrada(nomPersona, nom, codiPostal, dia, nomEntitat));
        }
    }

    public void cas6(LlistaUsuaris lu, LlistaReserves lr, LlistaActivitats la) {
        System.out.println("Introdueix l'alias del seu usuari:");
        String alies = s.nextLine();
        Usuari u = lu.buscarUsuari(alies);
        if (u == null) {
            System.out.println("No s'ha trobat l'usuari, disculpes.");
        }
        else {
            System.out.println("Introdueixi el nom el taller que vol trobar.");
            String taller = s.nextLine();
            Taller t = la.buscarTaller(taller);
            if (t == null) {
                System.out.println("No s'ha trobat el taller, disculpes.");
            }
            else {
                lr.afegirReserva(new Reserva(t, u));
                System.out.println("S'ha afegit la reserva!");
            }
        }
    }

    public void cas7(LlistaActivitats la, LlistaUsuaris lu, LlistaReserves lr) {
        System.out.println("Digues el codi del taller: ");
        String taller = s.nextLine();
        Taller t = la.buscarTaller(taller);
        if (t == null) {
            System.out.println("No se ha trobat el taller");
        } else {
            LlistaUsuaris llistaInscripcions = lr.usuarisApuntatsATaller(lu, t);
            System.out.println(llistaInscripcions);
        }
        
    }

    public void cas8(LlistaReserves lr) {
        System.out.println(lr.usuariAmbMesReserves());
    }

    public void cas9(LlistaActivitats la, LlistaReserves lr, LlistaUsuaris lu) {
        String aliasUsuari, idTaller;
        int puntuacio;
        Taller t;
        Usuari u;
        System.out.println("Digues el alies del usuari");
        aliasUsuari = s.nextLine();
        while (lu.buscarUsuari(aliasUsuari) == null) { // Forcem a que el usuari indicat sigui existent.
            System.out.println("No se ha trobat el usuari, proba una altra vegada");
            System.out.println("Digues el alies del usuari");
            aliasUsuari = s.nextLine();
        }
        u = lu.buscarUsuari(aliasUsuari);
        System.out.println("Digues el nom del taller al que el usuari esta inscrit");
        idTaller = s.nextLine();
        while (la.buscarTaller(idTaller) == null) { // Forcem a que el taller indicat sigui existent.
            System.out.println("No se ha trobat el taller, proba una altra vegada");
            System.out.println("Digues el ID del taller al que el usuari esta inscrit"); 
            idTaller = s.nextLine();
        }
        t = la.buscarTaller(idTaller);
        System.out.println("Comprobant si existeix reserva amb el usuari i taller proporcionat....");
        if (lr.esUsuariApuntatATaller(u, t)) { // Si el usuari no esta apuntat a aquest taller... 
            System.out.println("Introdueix una puntuacio entre 0-10");
            puntuacio = Integer.parseInt(s.nextLine());
            while (puntuacio < 0 || puntuacio > 10) { // per evitar al menys excepcions numeriques, fem un petit control.
                System.out.println("Puntuacio incorrecta! Prova una altra vegada");
                System.out.println("Introdueix una puntuacio entre 0-10");
                puntuacio = Integer.parseInt(s.nextLine());
            }
            la.afegirPuntuacio(puntuacio, t); // t queda actualitzat amb la puntuacio.
            lr.actualitzarPuntuacions(u, t); // Actualitzem el taller en la reserva (necesari per poder comprobar si un usuari es a un taller concret)
            
        } else {
            System.out.println("No existeix reserva amb aquest taller y usuari");
        }
    }

    public void cas10(LlistaActivitats la) {
        System.out.println("Introdueix el ID del taller:");
        String idTaller = s.nextLine();
        while (la.buscarTaller(idTaller) == null) {
            System.out.println("Introdueix el ID del taller:");
            idTaller = s.nextLine();
        }
        System.out.println("Nota mitjana: " + la.buscarTaller(idTaller).getMitjanaPuntuacion());
    }

    public void cas11(LlistaActivitats la) {
        System.out.println(la.mesExit());
    }

    public void cas12(LlistaActivitats la, LlistaEntitats le) {
        System.out.println("Introdueix el nom de l'entitat: ");
        String entitat = s.nextLine();
        while (le.buscarEntitat(entitat) == null) {
            System.out.println("No se ha trobat la entitat indicada!");
            System.out.println("Introdueix el nom de l'entitat: ");
            entitat = s.nextLine();
        }
        System.out.println(la.mostrarVisitesEntitat(entitat));
    }

    public void cas13(LlistaActivitats la) {
        System.out.println("Introdueix el nom de la persona: ");
        String nomPersona = s.nextLine();
        System.out.println(la.mostrarXerradesPersona(nomPersona));
    }

    public void cas14(LlistaActivitats la, LlistaReserves lr) {
        System.out.println("Introdueix el ID del taller a esborrar.");
        String idTaller = s.nextLine();
        Taller t = la.buscarTaller(idTaller);
        if (t == null) {
            System.out.println("No s'ha trobat el taller.");
        } else if (lr.numReservas(idTaller) > 0) {
            System.out.println("No s'ha pogut borrar el taller degut a que n'hi han places ocupades.");
        } else {
            la.treureActivitatNom(idTaller);
        }
    }

}
