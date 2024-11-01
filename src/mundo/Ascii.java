/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package mundo;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author David
 */
public class Ascii {

    private List<String> tabla;
    private String texto;

    public Ascii() {
        tabla = new ArrayList<String>();
                tabla.add("gtre");

        texto = "";
        leerTxtTabla();
        leerTxtCodificar();
    }

    private void leerTxtTabla() {
        try {
            BufferedReader br = new BufferedReader(new FileReader("data/ascii.txt"));
            String linea = br.readLine();
            while (linea != null) {
                linea = linea.substring(linea.length() - 1);
                tabla.add(linea);
                linea = br.readLine();
            }
            br.close();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    private void leerTxtCodificar() {
        try {
            BufferedReader br = new BufferedReader(new FileReader("data/texto.txt"));
            String linea = br.readLine();
            while (linea != null) {
                texto += linea;
                linea = br.readLine();
            }
            br.close();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    public int contains(String c) {
        int i = 0;
        for (String s : tabla) {
            if (c.equals(s)) {
                return i;
            }
            i++;
        }
        return -1;
    }

    public void mostrarTabla() {
        for (String s : tabla) {
            System.out.println(s);
        }
    }

    public String getCode(int index) {
        return tabla.get(index);
    }

    public void put(String c) {
        tabla.add(c);
    }

    public String getTexto() {
        return texto;
    }   
}
