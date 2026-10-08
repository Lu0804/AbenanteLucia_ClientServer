/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package abenanteluciaclient;
import java.io.*;
import java.net.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.*;
/**
 *
 * @author abenante.lucia
 */
public class AbenanteLuciaClient {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args)throws IOException, InterruptedException {
        String ip = "10.205.0.115";
        int porta = 5555;
       
           Socket socket = new Socket(ip, porta);
           Scanner scr = new Scanner(System.in);
       
        while (true) {
            OutputStream outputStream = socket.getOutputStream();
            DataOutputStream dataOutputStream = new DataOutputStream(outputStream);
            
            System.out.println("bella");
            String msg = scr.nextLine();
            dataOutputStream.writeUTF(msg);
            InputStream inputStream = socket.getInputStream();
            DataInputStream dataInputStream = new DataInputStream(inputStream);
            String response = dataInputStream.readUTF();
            System.out.println("Risposta dal server: " + response );
            Thread.sleep(1000);
           socket.close();
        }

    }

}
