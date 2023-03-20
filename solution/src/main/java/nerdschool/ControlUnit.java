package nerdschool;

import java.util.ArrayList;
import java.util.List;

public class ControlUnit {
  private final List<Sensor> sensors;
  public ControlUnit(List<Sensor> sensors) {
    this.sensors = sensors;
  }

  public List<Sensor> pollSensors() {

    List<Sensor> triggeredSensors = new ArrayList<>();

    for (Sensor sensor : sensors) {
      if (sensor.isTriggered()) {
        System.out.println(
            "A " + sensor.getSensorType() + " sensor was triggered at "
                + sensor.getLocation());
      } else {
        System.out.println(
            "Polled " + sensor.getSensorType() + " at " + sensor.getLocation()
                + " successfully");
      }
    }

    return triggeredSensors;
  }
}
