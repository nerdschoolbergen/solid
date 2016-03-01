package nerdschool;

public class FireSensor implements Sensor {
    private static final int triggeredPercentage = 10;
    private int nrOfIsTriggeredCalls = 0;
    private int batteryPercentage = 100;

    public boolean isTriggered() {
        batteryPercentage -= 10;

        nrOfIsTriggeredCalls++;
        if (nrOfIsTriggeredCalls % triggeredPercentage == 0) {
            nrOfIsTriggeredCalls = 0;
            return true;
        }
        return false;
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
