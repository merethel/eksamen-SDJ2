package RadiatorStatePattern.Radiator;

public class Power2State implements RadiatorState
{
  private static final int POWER = 2;

  @Override public void turnUp(Radiator radiator)
  {
    radiator.setPowerState(new Power3State(radiator));
  }

  @Override public void turnDown(Radiator radiator)
  {
    radiator.setPowerState(new Power1State());
  }

  @Override public String getPower()
  {
    return "Power state is 2";
  }

  @Override public void autoTurnDown(Radiator radiator)
  {

  }
}
