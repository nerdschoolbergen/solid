package nerdschool;

public class SmokeDrivenSensor implements Sensor, BatteryDrivenSensor {

  private static final int triggerFrequency = 2;
  private int nrOfIsTriggeredCalls = 0;
  private int batteryPercentage = 100;

  public boolean isTriggered() {
    if(batteryPercentage == 0) {
      return false;
    }

    batteryPercentage -= 20;

    nrOfIsTriggeredCalls++;
    return (nrOfIsTriggeredCalls % triggerFrequency == 0);
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

  public SensorCategory getSensorCategory() {
    return SensorCategory.Hazard;
  }
}
