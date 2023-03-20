package nerdschool;

import java.util.ArrayList;
import java.util.List;

public class ControlUnit {
  private final List<Sensor> sensors;
  private SensorWriter sensorWriter;

  public ControlUnit(List<Sensor> sensors, SensorWriter sensorWriter) {
    this.sensors = sensors;
    this.sensorWriter = sensorWriter;
  }

  public void pollSensors() {
    List<Sensor> triggeredSensors = new ArrayList<>();

    for (Sensor sensor : sensors) {
      if (sensor.isTriggered()) {
        triggeredSensors.add(sensor);
      }
    }

    this.sensorWriter.WriteSensorStatus(triggeredSensors);
  }
}
