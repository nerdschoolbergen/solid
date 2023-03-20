package nerdschool;

public class FireSensor implements Sensor {

  private static final int triggerFrequency = 3;
  private int nrOfIsTriggeredCalls = 0;
  private int batteryPercentage = 100;

  public boolean isTriggered() {
    batteryPercentage -= 10;

    nrOfIsTriggeredCalls++;
    return (nrOfIsTriggeredCalls % triggerFrequency == 0);
  }

  public String getLocation() {
    return "Lobby 1st floor";
  }

  public String getSensorType() {
    return "Fire";
  }

  public double getBatteryPercentage() {
    return batteryPercentage;
  }
}
