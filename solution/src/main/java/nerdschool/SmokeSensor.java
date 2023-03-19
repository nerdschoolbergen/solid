package nerdschool;

public class SmokeSensor implements Sensor {
  private static final int triggerFrequency = 2;
  private int nrOfIsTriggeredCalls = 0;
  private int batteryPercentage = 100;

  public boolean isTriggered() {
    batteryPercentage -= 20;

    nrOfIsTriggeredCalls++;
    if (nrOfIsTriggeredCalls % triggerFrequency == 0) {
      nrOfIsTriggeredCalls = 0;
      return true;
    }

    return false;
  }

  public String getLocation() {
    return "In the auditorium";
  }

  public String getSensorType() {
    return "Smoke";
  }

  public double getBatteryPercentage() {
    return batteryPercentage;
  }
}
