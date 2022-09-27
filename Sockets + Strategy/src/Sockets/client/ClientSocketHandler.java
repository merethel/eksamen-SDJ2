package Sockets.client;

import Sockets.Shared.Request;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

public class ClientSocketHandler implements Runnable
{
  private Client client;
  private Socket socket;
  private ObjectInputStream in;
  private ObjectOutputStream out;

  public ClientSocketHandler(Client client, Socket socket) throws IOException
  {
    this.client = client;
    this.socket = socket;
    in = new ObjectInputStream(socket.getInputStream());
    out = new ObjectOutputStream(socket.getOutputStream());
  }

  @Override public void run()
  {
    while (true)
    {
      try
      {
        Request request = (Request) in.readObject();
        client.messageReceived(request.getArgument());
      }
      catch (IOException e)
      {
        e.printStackTrace();
      }
      catch (ClassNotFoundException e)
      {
        e.printStackTrace();
      }
    }
  }

  public void sendMessage(String message){
    try
    {
      out.writeObject(new Request(message));
    }
    catch (IOException e)
    {
      e.printStackTrace();
    }
  }
}
