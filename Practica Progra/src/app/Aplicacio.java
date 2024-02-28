package app;
import clases.*;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

public class Aplicacio {

    static Scanner s = new Scanner(System.in); //scanner global
    public static void main(String[] args) {

        int opcio = 0;
       
        /*
        * Carga los archivos `reserves.dat`, `activitats.txt`, `entitats.csv` y `usuaris.csv` en memoria.
        *
        * Los archivos `reserves.dat` contiene los datos de las reservas.
        *
        * Los datos se cargan en memoria para que puedan ser utilizados por el resto del programa.
        */
        try {
            // Llegim tots els arxius
            LlegirArxius llegirArxius = new LlegirArxius("src/files/usuaris.csv", "src/files/entitats.csv", "src/files/activitats.txt");
            String[] dataEntitats = llegirArxius.llegirEntitats();
            String[] dataUsuaris = llegirArxius.llegirUsuaris();
            String[] dataActivitats = llegirArxius.llegirActivitats();

            // Carreguem les dades a memoria.
            CarregarDades carregarDades = new CarregarDades(dataActivitats, dataEntitats, dataUsuaris);
            
            LlistaEntitats llistaEntitats = carregarDades.carregarLlistaEntitats();
            LlistaUsuaris llistaUsuaris = carregarDades.carregarLlistaUsuaris();
            LlistaActivitats llistaActivitats = carregarDades.carregarLlistaActivitats();
            LlistaReserves llistaReserves = carregarDades.carregarLlistaReserves("src/files/num_reserves.txt", "src/files/reserves.dat");
            
            /*
            * Inicio de la aplicacion`. Aqui ya se realizan las funciones de la aplicacion.
            */
            boolean sortir = false;
            while(!sortir) {
                
                Funcions funcions = new Funcions(); // Per millor estructura, tenim una clase funcions que te tots els casos i funcions de aplicacio.
                funcions.menu();
                System.out.println("---------");
                System.out.println("Siusplau indiqui la seva opció.");
                opcio = Integer.parseInt(s.nextLine());
                switch(opcio) {
                    case 1:
                        funcions.cas1(llistaActivitats, llistaUsuaris, llistaReserves, llistaEntitats);
                        break;
                    case 2:
                        funcions.cas2(llistaActivitats);
                        break;
                    case 3:
                        funcions.cas3(llistaActivitats);
                        break;
                    case 4:
                        funcions.cas4(llistaActivitats);
                        break;
                    case 5:
                        funcions.cas5(llistaActivitats, llistaEntitats);
                        break;
                    case 6:
                        funcions.cas6(llistaUsuaris, llistaReserves, llistaActivitats);
                        break;
                    case 7:
                        funcions.cas7(llistaActivitats, llistaUsuaris, llistaReserves);
                        break;
                    case 8:
                        funcions.cas8(llistaReserves);
                        break;
                    case 9:
                        funcions.cas9(llistaActivitats, llistaReserves, llistaUsuaris);
                        break;
                    case 10:
                        funcions.cas10(llistaActivitats);
                        break;
                    case 11:
                        funcions.cas11(llistaActivitats);
                        break;
                    case 12:
                        funcions.cas12(llistaActivitats, llistaEntitats);
                        break;
                    case 13:
                        funcions.cas13(llistaActivitats);
                        break;
                    case 14:
                        funcions.cas14(llistaActivitats, llistaReserves);
                        break;
                    default:
                        System.out.println("Vols guardar les dades? Y / N");
                        String guardarDades = s.nextLine();
                        if (guardarDades.equals("Y")) {
                            System.out.println("Guardant dades");
                            GuardarDades guardardades = new GuardarDades("src/files/entitats.csv", "src/files/usuaris.csv", "src/files/activitats.txt", "src/files/reserves.dat", "src/files/num_reserves.txt");
                            guardardades.guardarEntitats(llistaEntitats);
                            guardardades.guardarActivitats(llistaActivitats);
                            guardardades.guardarUsuaris(llistaUsuaris);
                            guardardades.guardarReserves(llistaReserves);
                        } 
                        System.out.println("Adeu!");
                        sortir = true;
                        break;
                }
            }
            s.close();
        } catch (FileNotFoundException e) {
            System.out.println("Error, no se ha trobat el archiu! => ["+e+"]");
        } catch (IOException e) {
            System.out.println("Error, no se ha pogut generar el arxiu reserves.dat! => ["+e+"]");
        } catch (ClassNotFoundException e) {
            System.out.println("Error, no se ha trobat la clase per carregar les dades! => ["+e+"]");
        }
    }
}