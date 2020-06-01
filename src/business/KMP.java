/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business;

import java.util.ArrayList;

/**
 * @author William Torres
 */
public class KMP {

    static int kmp(String texto, String patron, int pos) {
        int n = texto.length(), m = patron.length();
        boolean start = true;
        int startInt = 0;
        ArrayList<Integer> tab = table(patron);
        int seen = 0, i = pos;
        while (i < n) {
            
            while(seen>0 && texto.charAt(i)!=patron.charAt(seen)){
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

    /*
    * Manual version (Split). It's slower than Java Lang implementation
    * */
    static ArrayList<String> split(String patron) {
        ArrayList<String> split = new ArrayList<>();
        String subCadena = "";
        int m = patron.length(), i=0;
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
}
