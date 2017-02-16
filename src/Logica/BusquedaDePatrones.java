/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logica;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

/**
 *
 * @author Natali Gamboa and William Torres
 */
public class BusquedaDePatrones {

    public void busquedaDePatrones(String rutaArchivo) {
        PrintWriter so = new PrintWriter(System.out);
        try {
            Lector lector = new Lector(rutaArchivo);
            while (lector.hasNext()) {
                int entradas = Integer.parseInt(lector.next()) - 1;
                String texto = lector.next();
                while (entradas > 0) {
                    String patron = lector.next();
                    String[] split = patron.split("\\*");
                    int indice = 0;
                    boolean esta = true;
                    for (int i = 0; i < split.length; i++) {
                        if (split[i].length() > 0) {
                            int pos = Cadena.kmp(texto, split[i], indice);
                            if (pos < 0) {
                                esta = false;
                                break;
                            }
                            indice = (pos + split[i].length());
                        }
                    }

                    /*
                    ArrayList<String> split = Cadena.split(patron);
                    int indice = 0;
                    boolean esta = true;
                    for (int i = 0; i < split.size(); i++) {
                        if(split.get(i).length()>0){
                        int pos = Cadena.kmp(texto,split.get(i), indice);
                        if (pos < 0) {
                            esta = false;
                            break;
                        }
                        indice = (pos + split.get(i).length());
                        }
                    }
                     */
                    if (esta) {
                        so.println(patron + " SI");
                    } else {
                        so.println(patron + " NO");
                    }
                    entradas--;
                }
            }
        } catch (FileNotFoundException fe) {
            so.println("Error en Lectura del archivo");
            so.println(fe);
        } catch (IOException ie) {
            so.println("Error en el Lector");
            so.println(ie);
        } catch (Exception e) {
            so.println("Excepción");
            so.println(e);
        }
        so.flush();
    }
}
