package nerdschool;

public class MotionSensor implements Sensor {

  private static final int triggerFrequency = 5;
  private int nrOfIsTriggeredCalls = 0;

  public boolean isTriggered() {
    nrOfIsTriggeredCalls++;
    return (nrOfIsTriggeredCalls % triggerFrequency == 0);
  }

  public String getLocation() {
    return "2nd floor";
  }

  public String getSensorType() {
    return "Motion";
  }

  public SensorCategory getSensorCategory() {
    return SensorCategory.Security;
  }
}
