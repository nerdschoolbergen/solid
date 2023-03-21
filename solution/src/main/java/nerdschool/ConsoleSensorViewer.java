package nerdschool;

import java.util.List;

public class ConsoleSensorViewer implements SensorViewer {
  public void displayTriggeredSensors(List<Sensor> sensors) {
    if (sensors.isEmpty()) {
      System.out.println("No sensors were triggered");
      return;
    }

    for (Sensor sensor : sensors) {
      System.out.printf(
          "A %s sensor of category %s was triggered at %s%n", sensor.getSensorType(), sensor.getSensorCategory().toString(), sensor.getLocation());
    }
  }
}
