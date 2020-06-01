/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uva;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.StringTokenizer;

/**
 * @author William Torres
 */
class UvaAlgorithm {

    public static void main(String[] args) throws IOException {

        PrintWriter so = new PrintWriter(System.out);
        Scanner lector = new Scanner();

        while (lector.hasNext()) {

            int entradas = Integer.parseInt(lector.next());
            String texto = lector.next();
            while (entradas > 0) {
                String patron = lector.next();
                String[] split = patron.split("\\*");
                int indice = 0;
                boolean esta = true;
                for (int i = 0; i < split.length; i++) {
                    if (split[i].length() > 0) {
                        int pos = kmp(texto, split[i], indice);
                        if (pos < 0) {
                            esta = false;
                            break;
                        }
                        indice = (pos + split[i].length());
                    }
                }

                if (esta) {
                    so.println("yes");
                } else {
                    so.println("no");
                }
                entradas--;
            }
            so.flush();
        }
    }

    static int kmp(String texto, String patron, int pos) {
        int n = texto.length(), m = patron.length();
        boolean start = true;
        int startInt = 0;
        ArrayList<Integer> tab = table(patron);
        int seen = 0, i = pos;
        while (i < n) {

            while (seen > 0 && texto.charAt(i) != patron.charAt(seen)) {
                seen = tab.get(seen - 1);
                start = true;
            }
            if (texto.charAt(i) == patron.charAt(seen)) {
                if (start) {
                    start = false;
                    startInt = i - seen;
                }
                seen++;
            }
            if (seen == m) {
                return startInt;
            }
            i++;
        }
        return -1;
    }

    static ArrayList<Integer> table(String patron) {
        int m = patron.length();
        ArrayList<Integer> tablePos = new ArrayList<Integer>();
        tablePos.add(0);
        int temp, i = 1;
        while (i < m) {
            tablePos.add(tablePos.get(i - 1));
            temp = tablePos.get(i);
            while (temp > 0 && patron.charAt(i) != patron.charAt(temp)) {
                if (temp <= i + 1) {
                    tablePos.set(i, tablePos.get(temp - 1));
                    temp = tablePos.get(i);
                }
            }
            if (patron.charAt(i) == patron.charAt(temp)) {
                tablePos.set(i, temp + 1);
            }
            i++;
        }
        return tablePos;
    }

    static ArrayList<String> split(String patron) {
        ArrayList<String> split = new ArrayList<>();
        String subCadena = "";
        int m = patron.length(), i = 0;
        while (i < m) {
            if (patron.charAt(i) == '*') {
                split.add(subCadena);
                subCadena = "";
            } else {
                subCadena += patron.charAt(i);
                if (i == patron.length() - 1) {
                    split.add(subCadena);
                }
            }
            i++;
        }
        return split;
    }

    static class Scanner {

        InputStreamReader isr = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(isr);
        StringTokenizer st = new StringTokenizer("");
        int espacios = 0;

        public String nextLine() throws IOException {
            if (espacios > 0) {
                espacios--;
                return "";
            } else if (st.hasMoreTokens()) {
                StringBuilder salida = new StringBuilder();
                while (st.hasMoreTokens()) {
                    salida.append(st.nextToken());
                    if (st.countTokens() > 0) {
                        salida.append(" ");
                    }
                }
                return salida.toString();
            }
            return br.readLine();
        }

        public String next() throws IOException {
            espacios = 0;
            while (!st.hasMoreTokens()) {
                st = new StringTokenizer(br.readLine());
            }
            return st.nextToken();
        }

        public boolean hasNext() throws IOException {
            while (!st.hasMoreTokens()) {
                String linea = br.readLine();
                if (linea == null) {
                    return false;
                }
                if (linea.equals("")) {
                    espacios++;
                }
                st = new StringTokenizer(linea);
            }
            return true;
        }
    }

}
