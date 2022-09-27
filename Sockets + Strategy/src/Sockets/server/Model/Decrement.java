package Sockets.server.Model;

public class Decrement implements Action
{
  @Override public int operation(int number)
  {
    number--;
    return number;
  }
}
