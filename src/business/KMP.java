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
public class Kmp {

    static int kmp(String text, String pattern, int pos) {
        int n = text.length(), m = pattern.length();
        boolean start = true;
        int startInt = 0;
        ArrayList<Integer> tab = table(pattern);
        int seen = 0, i = pos;
        while (i < n) {
            
            while(seen>0 && text.charAt(i)!=pattern.charAt(seen)){
                seen = tab.get(seen - 1);
                start = true;
            }
            if (text.charAt(i) == pattern.charAt(seen)) {
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

    static ArrayList<Integer> table(String pattern) {
        int m = pattern.length();
        ArrayList<Integer> tablePos = new ArrayList<>();
        tablePos.add(0);
        int temp, i = 1;
        while (i < m) {
            tablePos.add(tablePos.get(i - 1));
            temp = tablePos.get(i);
            while (temp > 0 && pattern.charAt(i) != pattern.charAt(temp)) {
                if (temp <= i + 1) {
                    tablePos.set(i, tablePos.get(temp - 1));
                    temp = tablePos.get(i);
                }
            }
            if (pattern.charAt(i) == pattern.charAt(temp)) {
                tablePos.set(i, temp + 1);
            }
            i++;
        }
        return tablePos;
    }

    /*
    * Manual version (Split). It's slower than Java Lang implementation
    * */
    static ArrayList<String> split(String pattern) {
        ArrayList<String> split = new ArrayList<>();
        String subCadena = "";
        int m = pattern.length(), i=0;
        while (i < m) {
            if (pattern.charAt(i) == '*') {
                split.add(subCadena);
                subCadena = "";
            } else {
                subCadena += pattern.charAt(i);
                if (i == pattern.length() - 1) {
                    split.add(subCadena);
                }
            }
            i++;
        }
        return split;
    }
}
