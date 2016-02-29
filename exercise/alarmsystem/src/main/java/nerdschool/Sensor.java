package nerdschool;

public interface Sensor {
    boolean isTriggered();
    String getLocation();
    String getSensortype();
    double batteryPercentage();
}
