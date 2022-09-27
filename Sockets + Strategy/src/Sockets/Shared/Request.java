package Sockets.Shared;

import java.io.Serializable;

public class Request implements Serializable
{
  private String argument;

  public Request(String argument)
  {
    this.argument = argument;
  }

  public String getArgument()
  {
    return argument;
  }

}
