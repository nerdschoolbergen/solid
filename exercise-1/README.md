# 1.0 - Exercise 1 - Introduction

In these exercises we're going to make an Alarmsystem - the kind with fire and smoke detectors.

## 1.1 - :rotating_light: The Alarm System

Requirements:

- The system should support any number of sensors
- The system should support different types of sensors (fire, smoke, gas, etc)
- The system should poll all sensors to see if any are triggered (an alarm is raised)
- The system should also check for the battery percentage of the sensors (different types of sensors drains faster)

> Important! The goal of these exercises is to work on code with the SOLID principles in mind. Try to evaluate your choices as you go and keep the principles in mind.

## 1.2 - Getting started

> **Before you begin**: Please make sure that you have the following installed:

- IntelliJ Community Edition: [IntelliJ Community Edition](https://www.jetbrains.com/idea/download/)
- JDK Development Kit (JDK 17 or later): [Java SE Development Kit](https://www.oracle.com/java/technologies/downloads/)
- Alternative dev kit (Java 17 or later): [Eclipse Temurin Java Development Kit](https://adoptium.net/)

1. :pencil2: Start by cloning this repository into a folder on your computer. If you've never used git before, you can alternatively use the the green "Code" button to the top right, and then select "Download zip". Unzip the downloaded zip file (make sure to remember where you put it).
2. :pencil2: Start IntelliJ and go `File -> Open -> select the POM.xml file in the 'alarmsystem' folder in the repository`. If IntelliJ asks, you want to select `Yes` for "Open as Project?" and "Keep existing project" for the second prompt. (See [IntelliJ docs](https://www.jetbrains.com/help/idea/maven-support.html#maven_import_project_start))
3. If IntelliJ prompts you to "Trust and Open Project", select `Trust Project` (See [IntelliJ Project Security](https://www.jetbrains.com/help/idea/project-security.html))
4. :pencil2: You should be able to compile the code and run it.

### 1.2.3 Existing code

#### Interfaces

- `Sensor`. This interface defines methods for all sensors to implement.
  - `isTriggered()`: returns true/false for whether the sensor is triggered or not. Different sensors has different rules. See exercises.
  - `getLocation()`: returns a description of the location of the sensor such as "Lobby 1st floor" or "In the auditorium".
  - `getSensortype()`: returns a textual description of the sensor type such as "Fire sensor" or "Smoke sensor".
  - `getBatteryPercentage()`: Returns a number between 0-100 where 0 is empty and 100 is fully charged.

#### Classes

- `FireSensor`. This sensor implements the `Sensor` interface, but has no logic yet.
- `SmokeSensor`. This sensor implements the `Sensor` interface, but has no logic yet.
- `ControlUnit`. This is the starting point for the alarmsystem. It's the main entry point for polling sensors and controlling the system.
- `App` - Entrypoint for the application (where `main` method is located). Calls `pollSensors()` method in `ControlUnit` class.

#### Class diagram

Dotted arrows denotes a dependency relation, full arrows denotes an inheritance relation (see [UML Class Diagrams Tutorial](https://www.visual-paradigm.com/guide/uml-unified-modeling-language/uml-class-diagram-tutorial/)).

```mermaid
---
title: Nerdschool Alarmsystem
---
classDiagram
    Sensor <|-- FireSensor
    Sensor <|-- SmokeSensor
    ControlUnit <.. App
    FireSensor <.. ControlUnit
    SmokeSensor <.. ControlUnit

    class Sensor
    <<interface>> Sensor
    Sensor: +isTriggered() bool
    Sensor: +getLocation() String
    Sensor: +getSensorType() String
    Sensor: +getBatteryPercentage() double
    
    class FireSensor{
      +isTriggered() bool
      +getLocation() String
      +getSensorType() String
      +getBatteryPercentage() double
    }
    
    class SmokeSensor{
      +isTriggered() bool
      +getLocation() String
      +getSensorType() String
      +getBatteryPercentage() double
    }
    
    class ControlUnit{
      +pollSensors()
    }

    class App{
      +main()
    }
```

### 1.2.4 - Running the application

:book: The `App` class contains the `main` method for the application. The application will prompt the user to input either "poll" (which calls `pollSensors()` on the `ControlUnit` class) or "exit" (which exits the application).

:pencil2: In order to start the application, Open upp the `App` class in the `Project` view on the left side of the screen. Then click the green arrow button at the top right of the screen or press <kbd>Shift</kbd> + <kbd>F10</kbd> (Windows) or <kbd>⌃ Control</kbd> + <kbd>R</kbd> (macOS).

:pencil2: To interact with the application, click on the terminal window in the `Run` window at the bottom of the screen.

:pencil2: Stop the app by pressing the red square button at the top right of the screen or press <kbd>CTRL</kbd> + <kbd>F2</kbd> (Windows) or <kbd>⌘ Command</kbd> + <kbd>F2</kbd> (macOS).

## 1.3 - `FireSensor`

:pencil2: Implement the `FireSensor` methods.

:exclamation: Requirements:

- Should raise an alarm every third time it is polled
- Drains 10% battery between each poll
- Battery level cannot go below 0
- An alarm is never triggered if the battery level is 0

:bulb: Hints on how to implement the sensor interface:
<details>

- Add instance variables for all the get methods
- Add a separate backing field for tracking number of polls
- Increment this number each time the isTriggered method is called
- To implement the trigger logic, use the modulo operator in combination with the tigger count field

</details>

:bulb: Example sensor implementation:
<details>

```java
package nerdschool;

public class NoobSensor implements Sensor {
  private static final int triggerFrequency = 5;
  private int nrOfIsTriggeredCalls = 0;
  private int batteryPercentage = 100;

  public boolean isTriggered() {
    batteryPercentage -= 5;

    nrOfIsTriggeredCalls++;
    return (nrOfIsTriggeredCalls % triggerFrequency == 0);
  }

  public String getLocation() {
    return "Nerdschool HQ";
  }

  public String getSensorType() {
    return "Noob";
  }

  public double getBatteryPercentage() {
    return batteryPercentage;
  }
}
```

</details>

## 1.4. - `SmokeSensor`

:pencil2: Implement the `SmokeSensor` methods.

:exclamation: Requirements:

- Should raise an alarm every second time it is polled
- Drains 20% battery between each poll
- Battery level cannot go below 0
- An alarm is never triggered if the battery level is 0

### [Go to exercise 2 :arrow_right:](../exercise-2/README.md)
