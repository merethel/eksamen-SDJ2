package broadcast.server;

import broadcast.shared.UpperCaseClient;
import broadcast.shared.UpperCaseServer;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.List;

public class RMIServerImpl implements UpperCaseServer
{
  private List<UpperCaseClient> clientsForBroadcast;

  public RMIServerImpl() throws RemoteException
  {
    UnicastRemoteObject.exportObject(this, 0);
    clientsForBroadcast = new ArrayList<>();
  }

  @Override public String toUpperCase(String str, UpperCaseClient client)
  {
    String result = str.toUpperCase();

    //Heavy calculation (that's why we would typically make call-back)
    try {Thread.sleep(1000);}//represents the heavy calculation
    catch (InterruptedException e){}

    broadcastToClients(result);
    return result;
  }

  private void broadcastToClients(String result)
  {
    for (UpperCaseClient client:clientsForBroadcast)
    {
      try {
        client.update(result); /*Try-catch makes sure that result is broadcasted to all clients,
        even though someone disconnects*/
      }
      catch (RemoteException e) {
        e.printStackTrace();
      }
    }
  }

  @Override public void registerClient(UpperCaseClient clientToRegister)
  {
    clientsForBroadcast.add(clientToRegister);
  }
}
