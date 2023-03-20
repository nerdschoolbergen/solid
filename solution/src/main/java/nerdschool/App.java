package nerdschool;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class App {

  public static void main(String[] args) {

    List<Sensor> sensors = new ArrayList<>();
    sensors.add(new FireSensor());
    sensors.add(new SmokeSensor());

    SensorWriter sensorWriter = new ConsoleSensorWriter();
    ControlUnit controlUnit = new ControlUnit(sensors, sensorWriter);

    Scanner scanner = new Scanner(System.in);
    String input = "";
    while (!input.equals("exit")) {
      System.out.println("Type \"poll\" to poll all sensors once or \"exit\" to exit");
      input = scanner.nextLine();
      if (input.equals("poll")) {
        controlUnit.pollSensors();
      }
    }
  }
}
