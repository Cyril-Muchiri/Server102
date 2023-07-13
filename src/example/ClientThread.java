package example;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class ClientThread extends Thread {
private Socket socket=null;
    public ClientThread(Socket socket) {
        this.socket=socket;
    }

    @Override
    public void run(){
        try {
            PrintWriter writer=new PrintWriter(socket.getOutputStream(),true);
            writer.println("Hello client.....!");
            BufferedReader reader=new BufferedReader(new InputStreamReader(socket.getInputStream()));

            String clientInput= reader.readLine();
            System.out.println(clientInput);
            socket.close();
            writer.close();
            reader.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}
