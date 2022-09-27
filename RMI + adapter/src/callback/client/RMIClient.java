package callback.client;

import callback.shared.UpperCaseClient;
import callback.shared.UpperCaseServer;

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
  }

  public void toUpperCase(String arg)
  {
    String result = null;
    try
    {
      server.toUpperCase(arg, this); /*this refers to this Sockets.client - Sockets.server must send result
      back to this Sockets.client, when ready*/
    }
    catch (RemoteException e)
    {
      e.printStackTrace();
      throw new RuntimeException("Could not find Sockets.server");
    }
  }

  @Override public void upperCaseResult(String result)
  {
    System.out.println("Result: " + result);
  }
}
