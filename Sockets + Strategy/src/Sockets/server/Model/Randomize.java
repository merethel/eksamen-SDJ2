package Sockets.server.Model;

public class Randomize implements Action
{
  @Override public int operation(int number)
  {
    number = (int)Math.floor(Math.random()*(1000-100+1)+100);
    return number;
  }
}
