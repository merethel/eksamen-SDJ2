package RadiatorStatePattern.Core;
import RadiatorStatePattern.view.radiator.RadiatorViewModel;

public class ViewModelFactory
{
  private static final ViewModelFactory instance = new ViewModelFactory();
  private RadiatorViewModel radiatorVM;

  private ViewModelFactory() {
  }

  public static ViewModelFactory getInstance(){
    return instance;
  }


  public RadiatorViewModel getRadiatorViewModel()
  {
    if (radiatorVM == null)
      radiatorVM = new RadiatorViewModel(ModelFactory.getInstance().getModel());
    return radiatorVM;
  }
}
