package nerdschool;

import java.util.Scanner;

public class App {

  public static void main(String[] args) {
    ControlUnit controlUnit = new ControlUnit();

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
