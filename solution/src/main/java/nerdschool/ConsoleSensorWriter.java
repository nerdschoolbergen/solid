package nerdschool;

import java.util.List;

public class ConsoleSensorWriter implements SensorWriter {
  public void WriteSensorStatus(List<Sensor> sensors) {
    if (sensors.isEmpty()) {
      System.out.println("No sensors were triggered");
    } else {
      for (Sensor sensor: sensors) {
        System.out.printf("A %s sensor was triggered at %s%n", sensor.getSensorType(), sensor.getLocation());
      }
    }
  }
}
