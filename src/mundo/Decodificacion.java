/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mundo;

import static java.lang.Integer.parseInt;

/**
 *
 * @author David
 */
public class Decodificacion {

    private String pe;
    private String se;
    private String ps;
    private StringBuilder texto;
    private Ascii diccionario;
    private boolean peB;

    public Decodificacion(Ascii diccionario) {
        texto = new StringBuilder();
        this.diccionario = diccionario;
        pe = "";
        se = "";
        peB = true;//es true se recibe pe, sino se recibe se
    }

    public void recibirEntrada(int in) {
        if (peB && pe.equals("")) {//primera vez que se llama al metodo
            pe = diccionario.getCode(in); // se decodifica pe primera vez, ahora debe recibir se por primera vez.
            decodificar(pe); //se decodifica pe
            System.out.println(texto);
            System.out.println("");
            peB = false;
            return;
        }
        if (!peB) { // primera vez que llega se, solo se lee.
            se = diccionario.getCode(in);
            ps = pe + se.substring(0,1); //se concatenan las dos entradas, pe y solo el primer caracter de se
            veryfPs(in);
            System.out.println(texto);
            System.out.println("");
            return;
        }
    }
    
    public void decodificar(String cod){
        if (cod.equals("LF")) {
            texto.append("\n");
            return;
        }
        if (cod.equals("HT")) {
            texto.append("\t");
            return;
        }
        texto.append(cod);
    }

    public void veryfPs(int in) {
        if (!diccionario.contains(ps)) { // si ps no está en el diccionario
            diccionario.put(ps); //se agrega ps
        }
        if (se.equals("LF")) {
            texto.append("\n");
        }else{
            decodificar(se); //se decodifica se
        }
        pe = se;
        se = "";
    }
}
