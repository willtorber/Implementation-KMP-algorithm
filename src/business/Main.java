/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business;

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
                            int pos = Kmp.kmp(texto, s, indice);
                            if (pos < 0) {
                                esta = false;
                                break;
                            }
                            indice = (pos + s.length());
                        }
                    }
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
