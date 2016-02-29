package nerdschool;

public class SmokeSensor implements Sensor {
    public boolean isTriggered() {
        return false;
    }

    public String getLocation() {
        return null;
    }

    public String getSensortype() {
        return null;
    }

    public double batteryPercentage() {
        return -1;
    }
}
