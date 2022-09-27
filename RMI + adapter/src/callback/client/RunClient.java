package callback.client;

import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.Scanner;

public class RunClient
{
  public static void main(String[] args)
      throws NotBoundException, RemoteException
  {
    RMIClient client = new RMIClient();
    client.startClient();

    Scanner in = new Scanner(System.in);

    while (true){
      System.out.println("Type in word to uppercase: ");
      String input = in.nextLine();
      try
      {
        client.toUpperCase(input); //We try to use stub method -> Sockets.server method
      }
      catch (Exception e){
        System.out.println("Error: " + e.getMessage()); /*if the Sockets.client can't connect to Sockets.server, this
        message is shown to Sockets.client - can for example be used in a gui(smartsmart)*/
      }
    }
  }
}
