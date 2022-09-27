package callback.server;

import callback.shared.UpperCaseClient;
import callback.shared.UpperCaseServer;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class RMIServerImpl implements UpperCaseServer
{
  public RMIServerImpl() throws RemoteException
  {
    UnicastRemoteObject.exportObject(this, 0);
  }

  @Override public void toUpperCase(String str, UpperCaseClient client)
  {
    String result = str.toUpperCase();

    //Heavy calculation (that's why we would typically make call-back)
    try {Thread.sleep(5000);}//represents the heavy calculation
    catch (InterruptedException e){}

    try {
      client.upperCaseResult(result); //Call-back to Sockets.client - using the clients own method
    }
    catch (RemoteException e) {
      e.printStackTrace();
    }
  }
}
