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

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        int porta = 5555;

        ServerSocket serverSocket = new ServerSocket(porta);
        while (true) {
            Socket clientSocket = serverSocket.accept();
            InputStream inputStream = clientSocket.getInputStream();
            DataInputStream dataInputStream = new DataInputStream(inputStream);
            String clientMessage = dataInputStream.readUTF();
            System.out.println("Messaggio dal client: " + clientMessage);
            OutputStream outputStream = clientSocket.getOutputStream();
            DataOutputStream dataOutputStream = new DataOutputStream(outputStream);
            String response = "Ciao, client! :)";
            dataOutputStream.writeUTF(response);
            clientSocket.close();
        }
    }

}
