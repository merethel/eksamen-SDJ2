package Sockets.server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server
{
    private ConnectionPool pool = new ConnectionPool();
    public void start() throws IOException
    {
        try(ServerSocket serverSocket = new ServerSocket(1235);)
        {
            while (true)
            {
                Socket socket = serverSocket.accept();

                ServerSocketHandler serverSocketHandler = new ServerSocketHandler(socket, pool);
                pool.addHandler(serverSocketHandler);
                Thread t = new Thread(serverSocketHandler);
                t.start();
            }
        }
    }

}
