package Sockets.server;

import java.util.ArrayList;
import java.util.List;

public class ConnectionPool
{
  private List<ServerSocketHandler> connections;

  public ConnectionPool()
  {
    connections = new ArrayList<>();
  }

  public void addHandler(ServerSocketHandler handler){
    connections.add(handler);
  }

  public void removeHandler(ServerSocketHandler handler){
    connections.remove(handler);
  }

  public void broadcastToAll(String message){
    for (ServerSocketHandler handler:connections)
    {
      handler.sendMessage(message);
    }
  }

}
