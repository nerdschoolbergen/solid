package nerdschool;

import java.util.ArrayList;
import java.util.List;

public class FakeSensorPoller implements SensorPoller {

  private final List<Sensor> sensors;

  public FakeSensorPoller(List<Sensor> sensors) {
    this.sensors = sensors;
  }

  public List<Sensor> pollSensors() {
    List<Sensor> triggeredSensors = new ArrayList<>();

    for (Sensor sensor : sensors) {
      if (sensor.isTriggered()) {
        triggeredSensors.add(sensor);
      }
    }

    return triggeredSensors;
  }
}
