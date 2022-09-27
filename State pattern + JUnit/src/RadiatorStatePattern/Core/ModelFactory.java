package RadiatorStatePattern.Core;

import RadiatorStatePattern.Radiator.Radiator;

public class ModelFactory
{
  private static final ModelFactory instance = new ModelFactory();
  private volatile Radiator radiator;

  private ModelFactory()
  {
  }

  public static ModelFactory getInstance(){
    return instance;
  }

  public Radiator getModel()
  {
    if (radiator == null) {
      synchronized (this) {
        if (radiator == null) {
          radiator = new Radiator();
        }
      }
    }
    return radiator;
  }

}
