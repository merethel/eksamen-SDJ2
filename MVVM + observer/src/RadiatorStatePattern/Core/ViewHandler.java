package RadiatorStatePattern.Core;

import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class ViewHandler
{
  private static final ViewHandler instance = new ViewHandler();
  private Stage stage1;

  private ViewHandler() {
  }

  public static ViewHandler getInstance(){
    return instance;
  }

  public void start() throws IOException
  {
    stage1 = new Stage();
    ViewFactory.init(stage1);
    stage1.centerOnScreen();
    openRadiatorView();
  }


  public void openRadiatorView() {
    Scene radiator = ViewFactory.getScene("radiator");
    stage1.setScene(radiator);
    stage1.centerOnScreen();
    stage1.show();
  }
}
