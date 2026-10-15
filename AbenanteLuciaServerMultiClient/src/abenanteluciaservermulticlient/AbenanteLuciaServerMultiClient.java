/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package abenanteluciaservermulticlient;
import java.io.*;
import java.net.*;
/**
 *
 * @author lucia
 */
public class AbenanteLuciaServerMultiClient {
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException  {

    // apre il server sulla porta 5555
        int porta = 5555;
        ServerSocket serverSocket = new ServerSocket(porta);
        System.out.println("In attesa di client...");

        int contatore = 0;
        //il while(true) fa tornare il server ad accept() dopo ogni client, così può accettare un numero illimitato di client
        while (true) { // accetta client all'infinito
            Socket clientSocket = serverSocket.accept(); // si blocca finché arriva un client
            contatore++;
            System.out.println("Client " + contatore + " connesso");
            // crea i due oggetti e gli passa lo stesso socket
            // ogni client ha i suoi thread
            Writer writer = new Writer();
            writer.setSocket(clientSocket);
            writer.setNumero(contatore);

            Reader reader = new Reader();
            reader.setSocket(clientSocket);
            reader.setNumero(contatore);

            new Thread(writer).start();
            new Thread(reader).start();
            
            // NUOVO: tolti join() e close(): se il main aspettasse i thread
            // non potrebbe tornare ad accept() per accettare altri client.
            // Ogni client lavora per conto suo nei propri thread
        }
    }
}