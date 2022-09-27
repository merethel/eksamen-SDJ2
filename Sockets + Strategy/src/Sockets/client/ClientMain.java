package Sockets.client;

import java.io.IOException;

public class ClientMain
{
  public static void main(String[] args)
      throws IOException, ClassNotFoundException
  {
    Client client = new Client();
    client.start();
  }
}
