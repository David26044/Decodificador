/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

import interfaz.PanelDecodificacion;
import mundo.Ascii;
import mundo.Decodificacion;
import mundo.HelloSocket;

/**
 *
 * @author David
 */
public class Controlador {
    
private PanelDecodificacion pnlDecodificacion;

 public Controlador(){
      Decodificacion decodificador = new Decodificacion(new Ascii(), this);
      HelloSocket socket = new HelloSocket(decodificador);
 }
 
 public void conectar(PanelDecodificacion pnlDecodificacion){
     this.pnlDecodificacion = pnlDecodificacion;
 }
 
 public void setCod(String cod){
  pnlDecodificacion.addCod(cod);
 }
 
 public void setDecod(String decod){
  pnlDecodificacion.addDecod(decod);
 }
 
}
