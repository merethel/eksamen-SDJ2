package RadiatorStatePattern.Radiator;

public class Power1State implements RadiatorState
{
  private static final int POWER = 1;

  @Override public void turnUp(Radiator radiator)
  {
    radiator.setPowerState(new Power2State());
  }

  @Override public void turnDown(Radiator radiator)
  {
    radiator.setPowerState(new OffState());
  }

  @Override public String getPower()
  {
    return "Power state is 1";
  }

  @Override public void autoTurnDown(Radiator radiator)
  {

  }
}
