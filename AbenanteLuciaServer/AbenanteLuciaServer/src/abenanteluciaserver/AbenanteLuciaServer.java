/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package abenanteluciaserver;
import java.io.*;
import java.net.*;
import java.net.ServerSocket;
import java.net.Socket;
/**
 *
 * @author abenante.lucia
 */
public class AbenanteLuciaServer {

    public static void main(String[] args) throws IOException, InterruptedException {
        int porta = 5555;

        // apre il server sulla porta 5555
        ServerSocket serverSocket = new ServerSocket(porta);
        System.out.println("In attesa di un client...");

        // si ferma qui finché un client si collega
        Socket clientSocket = serverSocket.accept();
        System.out.println("Client connesso");

        // crea i due oggetti e gli passa lo stesso socket
        Writer writer = new Writer();
        writer.setSocket(clientSocket);

        Reader reader = new Reader();
        reader.setSocket(clientSocket);

        // un Runnable va inserito in un Thread per partire
        Thread threadWriter = new Thread(writer);
        Thread threadReader = new Thread(reader);

        threadWriter.start(); // avvia run() di Writer
        threadReader.start(); // avvia run() di Reader

        // il main aspetta che i thread finiscano
        threadWriter.join();
        threadReader.join();

        // chiude solo alla fine
        clientSocket.close();
        serverSocket.close();
    }
}