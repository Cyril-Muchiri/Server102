package example;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Main {
    public static void main(String[] args){
        int port=9090;
        try {

        ServerSocket serverSocketocket=new ServerSocket(port);

        boolean stop=false;

        while (!stop){
            System.out.println("waiting for clients.............");
            Socket socket=serverSocketocket.accept();
            System.out.println("Client is connected.............");

            ClientThread clientThread=new ClientThread(socket);
            clientThread.start();


        }
        serverSocketocket.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
