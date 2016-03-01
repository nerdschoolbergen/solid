package nerdschool;

import java.util.ArrayList;
import java.util.List;

public class ControlUnit {
    public void pollSensors() {
        List<Sensor> sensors = new ArrayList<Sensor>();
        sensors.add(new FireSensor());
        sensors.add(new SmokeSensor());

        for (Sensor sensor : sensors) {
            if (sensor.isTriggered()){
                System.out.println("A " + sensor.getSensortype() + " sensor was triggered at " + sensor.getLocation());
            }
        }
    }
}
