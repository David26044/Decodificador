/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mundo;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;
import javax.swing.JOptionPane;

/**
 *
 * @author David
 */

    public class HelloSocket implements Runnable {

        Decodificacion decodificador;
        
        /* Constructor */
        public HelloSocket() {
            Thread treadListener = new Thread(this);
            treadListener.start();
            decodificador = new Decodificacion(new Ascii());
        }

        /* Client:Data >> Socket >> Server */
        public void socket(String msg) {
            try {
                Socket client = new Socket("192.168.0.13", 5000); // portSend 5000
                DataOutputStream outBuffer = new DataOutputStream(client.getOutputStream());
                outBuffer.writeUTF(msg);
                client.close();
            } catch (UnknownHostException e) {
                JOptionPane.showMessageDialog(null, "Client: socket(1) : UnknownHostException: " + e.getMessage());
            } catch (IOException e) {
                JOptionPane.showMessageDialog(null, "Client: socket(2) : IOException: " + e.getMessage());
            }
        }

        @Override
        /* Client: Listen */
        public void run() {
            ServerSocket serverSocket;
            Socket socket;
            DataInputStream inDataBuffer;

            try {
                serverSocket = new ServerSocket(5000); // portListen 5050

                while (true) {
                    socket = serverSocket.accept();
                    inDataBuffer = new DataInputStream(socket.getInputStream());
                    String msg = inDataBuffer.readUTF();
                    System.out.println("Recibo: " + msg);
                    decodificador.recibirEntrada(Integer.parseInt(msg));
                    socket.close();
                }
            } catch (IOException e) {
                JOptionPane.showMessageDialog(null, "Client run() : IOException: " + e.getMessage());
            }
        }
    }

