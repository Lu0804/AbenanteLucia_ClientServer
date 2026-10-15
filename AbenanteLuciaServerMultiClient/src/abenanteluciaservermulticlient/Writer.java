/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package abenanteluciaservermulticlient;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;
import java.util.Scanner;
/**
 *
 * @author lucia
 */
public class Writer implements Runnable {
    static Scanner scr = new Scanner(System.in); // static: la tastiera è una sola, condivisa quindi non è detto che i client vedano la risposta.
    Socket socket;
    int numero;

    @Override
    public void run() {
        try {
             // in uscita del socket (i byte che vanno al client)
            OutputStream outputStream = socket.getOutputStream();
            // serve per usre writeUTF invia una stringa
            DataOutputStream dataOutputStream = new DataOutputStream(outputStream);

            while (true) {
                System.out.println("Scrivi al client " + numero + ": ");
                
                String msg = scr.nextLine();     // aspetta che premi invio
                dataOutputStream.writeUTF(msg);  // invia il messaggio al client


                if (msg.equals("exit")) {
                    System.out.println("fine client " + numero);
                    break;
                }
            }
        } catch (IOException e) {
            System.out.println("errore con il client " + numero);
        }
    }

    public void setSocket(Socket socket) { this.socket = socket; }
    public void setNumero(int numero) { this.numero = numero; }
}

