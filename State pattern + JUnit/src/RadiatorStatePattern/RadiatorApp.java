package RadiatorStatePattern;

import RadiatorStatePattern.Core.ViewHandler;
import javafx.application.Application;
import javafx.stage.Stage;

public class RadiatorApp extends Application
{
  @Override public void start(Stage stage) throws Exception
  {
    ViewHandler.getInstance().start();
  }
}
