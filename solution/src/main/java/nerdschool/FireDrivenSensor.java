package nerdschool;

public class FireDrivenSensor implements Sensor, BatteryDrivenSensor {

  private static final int triggerFrequency = 3;
  private int nrOfIsTriggeredCalls = 0;
  private int batteryPercentage = 100;

  public boolean isTriggered() {
    if(batteryPercentage == 0) {
      return false;
    }

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

  public SensorCategory getSensorCategory() {
    return SensorCategory.Hazard;
  }

  public double getBatteryPercentage() {
    return batteryPercentage;
  }
}
