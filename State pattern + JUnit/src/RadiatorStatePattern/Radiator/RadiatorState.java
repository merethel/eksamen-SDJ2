package RadiatorStatePattern.Radiator;

public interface RadiatorState
{
  void turnUp(Radiator radiator);
  void turnDown(Radiator radiator);
  String getPower();
  void autoTurnDown(Radiator radiator);
}
