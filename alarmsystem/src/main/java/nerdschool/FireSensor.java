package nerdschool;

public class FireSensor implements Sensor {

  public boolean isTriggered() {
    return false;
  }

  public String getLocation() {
    return null;
  }

  public String getSensorType() {
    return null;
  }

  public double getBatteryPercentage() {
    return -1;
  }
}
