package broadcast.client;

import broadcast.shared.UpperCaseClient;
import broadcast.shared.UpperCaseServer;

import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

public class RMIClient implements UpperCaseClient
{
  private UpperCaseServer server; //this is the stub

  public RMIClient() throws RemoteException
  {
    UnicastRemoteObject.exportObject(this, 0);
  }

  public void startClient() throws RemoteException, NotBoundException
  {
    Registry registry = LocateRegistry.getRegistry("localhost", 1099); //We find the registry
    server = (UpperCaseServer) registry.lookup("Sockets.server"); //same name as the Sockets.server added in registry
    server.registerClient(this); //Sockets.client now listens to Sockets.server
  }

  public String toUpperCase(String arg)
  {
    try
    {
      String result = server.toUpperCase(arg, this); /*this refers to this Sockets.client - Sockets.server must send result
      back to this Sockets.client, when ready*/
      return result;
    }
    catch (RemoteException e)
    {
      e.printStackTrace();
      throw new RuntimeException("Could not find Sockets.server");
    }
  }

  @Override public void update(String result)
  {
    System.out.println("Broadcasted: " + result);
  }
}
