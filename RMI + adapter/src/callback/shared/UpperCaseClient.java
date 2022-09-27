package callback.shared;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface UpperCaseClient extends Remote
{
  void upperCaseResult(String result) throws RemoteException;
}
