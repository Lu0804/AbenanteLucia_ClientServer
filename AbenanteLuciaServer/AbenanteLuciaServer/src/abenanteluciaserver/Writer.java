/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package abenanteluciaserver;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.Scanner;
/**
 *
 * @author lucia
 */
public class Writer implements Runnable {

    Scanner scr = new Scanner(System.in); // legge da tastiera
    Socket socket;                        // socket del client connesso

    @Override
    public void run() {

        try {
            // in uscita del socket (i byte che vanno al client)
            OutputStream outputStream = socket.getOutputStream();
            // serve per usre writeUTF invia una stringa
            DataOutputStream dataOutputStream = new DataOutputStream(outputStream);

            while (true) { // per scrivere più messaggi
                System.out.println("Scrivi al client: ");

                String msg = scr.nextLine();     // aspetta che premi invio
                dataOutputStream.writeUTF(msg);  // invia il messaggio al client

                if (msg.equals("exit")) { // per uscire dal ciclo
                     System.out.println("fine server");
                    break;
                }
            }
        } catch (IOException e) {
            System.out.println("errore"); // problema 
        }
    }

    
    public void setSocket(Socket socket) {
        this.socket = socket;
    }
}
