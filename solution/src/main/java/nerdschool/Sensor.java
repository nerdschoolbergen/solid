package nerdschool;

public interface Sensor {

  boolean isTriggered();

  String getLocation();

  String getSensorType();

  SensorCategory getSensorCategory();
}
