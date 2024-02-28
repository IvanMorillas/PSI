package app;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class LlegirArxius {
    String arxiuUsuaris;
    String arxiuEntitats;
    String arxiuActivitats;


    public LlegirArxius (String aU, String aE, String aA) {
        arxiuActivitats = aA;
        arxiuEntitats = aE;
        arxiuUsuaris = aU;
    }

    public String[] llegirUsuaris() throws FileNotFoundException{
        String retorn[];
        Scanner f = new Scanner(new File(arxiuUsuaris));
        f.nextLine(); // Nos saltamos la cabecera.
        int nLinies = 0;
        while (f.hasNextLine()) {
            nLinies++;
            f.nextLine();
        }
        f.close();
        
        retorn = new String[nLinies];
        Scanner g = new Scanner(new File(arxiuUsuaris));
        g.nextLine(); // Volvemos a saltarnos la cabecera.
        for (int i = 0; i < nLinies; i++) {
          retorn[i] = g.nextLine(); 
        }
        return retorn;
    }

    public String[] llegirEntitats() throws FileNotFoundException {
        String retorn[];
        Scanner f = new Scanner(new File(arxiuEntitats));
        f.nextLine(); // Ens saltem la capsalera
        int nLinies = 0;
        // Calculem cuantes linies te el arxius. 
        while (f.hasNextLine()) {
            nLinies++;
            f.nextLine();
        }
        f.close();
        
        retorn = new String[nLinies];
        Scanner g = new Scanner(new File(arxiuEntitats));
        g.nextLine(); // Volvemos a saltarnos la cabecera.
        for (int i = 0; i < nLinies; i++) {
          retorn[i] = g.nextLine(); 
        }
        return retorn;
    }

    public String[] llegirActivitats() throws FileNotFoundException {
        String retorn[];
        Scanner f = new Scanner(new File(arxiuActivitats));
        int nLinies = 0;
        while (f.hasNextLine()) {
            nLinies++;
            f.nextLine();
        }
        f.close();
        
        retorn = new String[nLinies];
        Scanner g = new Scanner(new File(arxiuActivitats));
        for (int i = 0; i < nLinies; i++) {
          retorn[i] = g.nextLine(); 
        }
        return retorn;
    }
}
