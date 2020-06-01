/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * @author William Torres
 */
public class Main {

    public void searchPatterns(String pathFile) {
        PrintWriter so = new PrintWriter(System.out);
        try {
            Scanner scanner = new Scanner(pathFile);
            while (scanner.hasNext()) {
                int entradas = Integer.parseInt(scanner.next()) - 1;
                String texto = scanner.next();
                while (entradas > 0) {
                    String patron = scanner.next();
                    String[] split = patron.split("\\*");
                    int indice = 0;
                    boolean esta = true;
                    for (String s : split) {
                        if (s.length() > 0) {
                            int pos = KMP.kmp(texto, s, indice);
                            if (pos < 0) {
                                esta = false;
                                break;
                            }
                            indice = (pos + s.length());
                        }
                    }

                    /*
                        ArrayList<String> split = KMP.split(patron);
                        int indice = 0;
                        boolean esta = true;
                        for (int i = 0; i < split.size(); i++) {
                            if(split.get(i).length()>0){
                            int pos = KMP.kmp(texto,split.get(i), indice);
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
        } catch (Exception e) {
            so.println("Error: ".concat(e.getMessage()));
        }
        so.flush();
    }
}
