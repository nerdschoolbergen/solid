package nerdschool;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ControlUnit {

  private final List<Sensor> sensors;

  public ControlUnit(Sensor... sensors) {
    this.sensors = Arrays.stream(sensors).toList();
  }

  public List<Sensor> pollSensors() {

    List<Sensor> triggeredSensors = new ArrayList<>();

    for (Sensor sensor : sensors) {
      if (sensor.isTriggered()) {
        System.out.println(
            "A " + sensor.getSensorType() + " sensor was triggered at "
                + sensor.getLocation());
        triggeredSensors.add(sensor);
      } else {
        System.out.println(
            "Polled " + sensor.getSensorType() + " at " + sensor.getLocation()
                + " successfully");
      }
    }

    return triggeredSensors;
  }
}
