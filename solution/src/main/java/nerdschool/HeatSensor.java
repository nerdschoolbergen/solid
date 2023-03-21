package nerdschool;

public class HeatSensor implements Sensor {

  private static final int triggerFrequency = 4;
  private int nrOfIsTriggeredCalls = 0;

  public boolean isTriggered() {
    nrOfIsTriggeredCalls++;
    return (nrOfIsTriggeredCalls % triggerFrequency == 0);
  }

  public String getLocation() {
    return "3rd floor";
  }

  public String getSensorType() {
    return "Heat";
  }

  public SensorCategory getSensorCategory() {
    return SensorCategory.Security;
  }
}
