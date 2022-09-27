package RadiatorStatePattern.view.radiator;

import RadiatorStatePattern.Core.ViewModelFactory;
import RadiatorStatePattern.view.ViewController;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;

public class RadiatorViewController implements ViewController
{
  private RadiatorViewModel radiatorViewModel;

  @FXML
  private TextArea infoBox;

  @FXML
  private Label stateLabel;

  public void init(ViewModelFactory vmf) {
    radiatorViewModel = vmf.getRadiatorViewModel();
    stateLabel.textProperty().bind(radiatorViewModel.stateProperty());
    infoBox.textProperty().bind(radiatorViewModel.stateOverviewProperty());
  }

  @FXML
  void onTurnDown(ActionEvent event) {
    radiatorViewModel.onTurnDown();
  }

  @FXML
  void onTurnUp(ActionEvent event) {
    radiatorViewModel.onTurnUp();
  }
}
