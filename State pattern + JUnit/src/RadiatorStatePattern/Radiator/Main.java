package RadiatorStatePattern.Radiator;

import RadiatorStatePattern.Radiator.Radiator;

public class Main
{
  public static void main(String[] args) throws InterruptedException
  {
    Radiator radiator = new Radiator();

    radiator.getPower(); //nuværende stadie

    Thread.sleep(2000);
    radiator.turnUp(); //stadie ændres
    radiator.getPower();

    Thread.sleep(2000);
    radiator.turnUp(); //stadie ændres
    radiator.getPower();

    Thread.sleep(2000);
    radiator.turnUp(); //stadie ændres

    Thread.sleep(2000);
    radiator.turnDown(); //stadie ændres
    System.out.println("Changing manually down to 2");

    radiator.getPower();
  }
}
