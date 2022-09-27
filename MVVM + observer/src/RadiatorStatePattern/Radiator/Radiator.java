package RadiatorStatePattern.Radiator;

import RadiatorStatePattern.util.PropertyChangeSubject;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

public class Radiator implements PropertyChangeSubject
{
  private RadiatorState currentState = new OffState();
  private PropertyChangeSupport propertyChangeSupport = new PropertyChangeSupport(this);


  public void autoTurnDown(){
    propertyChangeSupport.firePropertyChange("newState", null, currentState.getPower());
  }

  public void turnUp(){
    currentState.turnUp(this);
  }

  public void turnDown(){
    currentState.turnDown(this);
  }

  public String getPower(){
    return currentState.getPower();
  }

  public void setPowerState(RadiatorState state){
    currentState = state;
  }

  @Override public void addPropertyChangeListener(PropertyChangeListener listener)
  {
    propertyChangeSupport.addPropertyChangeListener(listener);
  }

  @Override public void addPropertyChangeListener(String name, PropertyChangeListener listener)
  {
    if(name == null)
      addPropertyChangeListener(listener);
    else
      propertyChangeSupport.addPropertyChangeListener(name, listener);
  }

  @Override public void removePropertyChangeListener(PropertyChangeListener listener)
  {
    propertyChangeSupport.removePropertyChangeListener(listener);
  }

  @Override public void removePropertyChangeListener(String name, PropertyChangeListener listener)
  {
    if(name == null)
      propertyChangeSupport.removePropertyChangeListener(listener);
    else
      propertyChangeSupport.removePropertyChangeListener(name, listener);
  }
}
