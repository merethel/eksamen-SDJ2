package RadiatorStatePattern.Radiator;

public class OffState implements RadiatorState
{
  private static final int POWER = 0;

  @Override
  public void turnUp(Radiator radiator)
  {
    radiator.setPowerState(new Power1State());
  }

  @Override
  public void turnDown(Radiator radiator)
  {
  }

  @Override
  public String getPower()
  {
    return "Power state is 0";
  }

  @Override public void autoTurnDown(Radiator radiator)
  {

  }
}
