package nerdschool;

import java.util.ArrayList;
import java.util.List;

public class ControlUnit {
    private final Sensor[] sensors;

    public ControlUnit(Sensor... sensors) {
        this.sensors = sensors;
    }

    public void pollSensors() {
        for (Sensor sensor : this.sensors) {
            if (sensor.isTriggered()){
                System.out.println("A " + sensor.getSensorType() + " sensor was triggered at " + sensor.getLocation());
            } else {
                System.out.println("Polled " + sensor.getSensorType() + " at " + sensor.getLocation() + " successfully");
            }
        }
    }
}
