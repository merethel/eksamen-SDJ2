package Sockets.server;
import Sockets.Shared.Request;
import Sockets.server.Model.Action;
import Sockets.server.Model.Decrement;
import Sockets.server.Model.Increment;
import Sockets.server.Model.Randomize;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

public class ServerSocketHandler implements Runnable
{
  private Socket socket;
  private ConnectionPool pool;
  private ObjectOutputStream out;
  private ObjectInputStream in;
  private Action action;
  private int number;

  public ServerSocketHandler(Socket socket, ConnectionPool pool)
      throws IOException
  {
    this.socket=socket;
    this.pool = pool;
    out = new ObjectOutputStream(socket.getOutputStream());
    in = new ObjectInputStream(socket.getInputStream());
  }

  @Override public void run()
  {
    try
    {
      System.out.println("Client connected from " + socket.getInetAddress().getHostAddress() + " " + socket.getLocalPort());

      int id = (int)Math.floor(Math.random()*(1000-100+1)+100);
      pool.broadcastToAll("Client " + id + " has joined");

      String numberFromClient = ((Request)in.readObject()).getArgument();
      number = Integer.parseInt(numberFromClient);

      System.out.println("Number chosen by Sockets.client " + id + ": " + numberFromClient);
      pool.broadcastToAll("Client " + id + " has chosen the number " + numberFromClient);

      while (true){
        String actionFromClient = ((Request)in.readObject()).getArgument();
        setStrategy(actionFromClient);
        operation();
        System.out.println(number);
        pool.broadcastToAll("Client " + id + " new number: " + number);
      }

    } catch(IOException | ClassNotFoundException e){
        e.printStackTrace();
    }
  }

  public void sendMessage(String message)
  {
    try
    {
      out.writeObject(new Request(message));
    }
    catch (IOException e)
    {
      e.printStackTrace();
    }
  }

  private void operation(){
    number = action.operation(number);
  }

  private void setStrategy(String stringValueOfAction){
    if (stringValueOfAction.equals("decrement")){
      action = new Decrement();
    }
    else if (stringValueOfAction.equals("increment")){
      action = new Increment();
    }
    else if (stringValueOfAction.equals("randomize")){
      action = new Randomize();
    }
  }
}
