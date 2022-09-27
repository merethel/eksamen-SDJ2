package RadiatorStatePattern.Radiator;

public class Power3State implements RadiatorState
{
  private static final int POWER = 3;
  private Thread t;

  public Power3State(Radiator radiator)
  {
    getPower();
      t = new Thread(() -> {
        try
        {
          t.sleep(3000);
          System.out.println("Turning power down");
          autoTurnDown(radiator);
          getPower();
          radiator.autoTurnDown();
        }
        catch (InterruptedException e)
        {
          System.out.println("Automatic turn down has been interrupted");
        }
      });
      t.setDaemon(true);
      t.start();
  }


  @Override public void turnUp(Radiator radiator)
  {
  }

  @Override public void turnDown(Radiator radiator)
  {
    t.interrupt();
    radiator.setPowerState(new Power2State());
  }

  @Override public String getPower()
  {
    return "Power state is 3";
  }

  @Override public void autoTurnDown(Radiator radiator)
  {
    radiator.setPowerState(new Power2State());
  }


}
