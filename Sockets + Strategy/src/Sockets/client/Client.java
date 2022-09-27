package Sockets.client;

import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

public class Client
{
    private ClientSocketHandler handler;

    public Client()
    {
    }

    public void start()
    {
        try(
        Socket socket = new Socket("127.0.0.1", 1235);
        )
        {
            handler = new ClientSocketHandler(this, socket);
            new Thread(handler).start();
            while (true)
            {
                String messageFromClient = new Scanner(System.in).nextLine();
                handler.sendMessage(messageFromClient);
            }
        } catch (IOException e){
            e.printStackTrace();
        }
    }
    public void messageReceived(String message){
        System.out.println(message);
    }
}

