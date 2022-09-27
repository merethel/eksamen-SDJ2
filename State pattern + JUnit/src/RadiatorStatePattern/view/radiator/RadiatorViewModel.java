package RadiatorStatePattern.view.radiator;
import RadiatorStatePattern.Radiator.Radiator;
import javafx.application.Platform;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

import java.beans.PropertyChangeEvent;

public class RadiatorViewModel
{
  private Radiator radiator;
  private StringProperty state;
  private StringProperty stateOverview;

  public RadiatorViewModel(Radiator radiator)
  {
    this.radiator = radiator;
    state = new SimpleStringProperty(radiator.getPower());
    stateOverview = new SimpleStringProperty(radiator.getPower());
    radiator.addPropertyChangeListener("newState", evt -> updateState(evt));
  }

  private void updateState(PropertyChangeEvent evt) throws IllegalStateException
  {
    Platform.runLater(() -> { /*javaFX skal køre sine egne tråde, derfor skal koden rammes ind i en
                                runLater - ellers vil den ikke opdatere*/
      String newValue = evt.getNewValue().toString();
      state.setValue(newValue);
      stateOverview.setValue(
          stateOverview.getValue() + "\n" + "Automatic turndown" + "\n" + newValue);
    });
  }

  public void getCurrentState(){
    state.getValue();
  }

  public void onTurnUp(){
    radiator.turnUp();
    state.setValue(radiator.getPower());
    stateOverview.setValue(stateOverview.getValue() + "\n" + radiator.getPower());
  }

  public void onTurnDown(){
    radiator.turnDown();
    state.setValue(radiator.getPower());
    stateOverview.setValue(stateOverview.getValue() + "\n" + radiator.getPower());
  }


  public StringProperty stateProperty()
  {
    return state;
  }

  public StringProperty stateOverviewProperty()
  {
    return stateOverview;
  }
}
