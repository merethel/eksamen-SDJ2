package Sockets.server.Model;

public class Increment implements Action
{
  @Override public int operation(int number)
  {
    number++;
    return number;
  }
}
