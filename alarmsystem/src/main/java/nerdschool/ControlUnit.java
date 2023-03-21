package nerdschool;

import java.util.ArrayList;
import java.util.List;

public class ControlUnit {

  public void pollSensors() {
    List<Sensor> sensors = new ArrayList<>();
    sensors.add(new FireSensor());
    sensors.add(new SmokeSensor());

    List<Sensor> triggeredSensors = new ArrayList<>();

    for (Sensor sensor : triggeredSensors) {
      if (sensor.isTriggered()) {
        triggeredSensors.add(sensor);
      }
    }

    if (triggeredSensors.isEmpty()) {
      System.out.println("No sensors were triggered");
    } else {
      for (Sensor sensor: triggeredSensors) {
        System.out.printf("A %s sensor was triggered at %s%n", sensor.getSensorType(), sensor.getLocation());
      }
    }
  }
}
