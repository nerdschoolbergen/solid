# 1.0 - Exercise 1 - Introduction

In these exercises we're going to make an Alarmsystem - the kind with fire and smoke detectors.

## 1.1 - The Alarm System :rotating_light:

Requirements:

- The system should support any number of sensors
- The system should support different types of sensors (fire, smoke, gas, etc)
- The system should poll all sensors to see if any are triggered (an alarm is raised)
- The system should also check for the battery percentage of the sensors (different types of sensors draines faster)

> Important! The goal of these exercises is to work on code with the SOLID principles in mind. Try to evaluate your choices as you go and keep the principles in mind.

## 1.2 - Getting started

> **Before you begin**: Please make sure that you have the following installed:

- IntelliJ Community Edition: [IntelliJ Community Edition](https://www.jetbrains.com/idea/download/)
- Java dev kit: [Java SE Development Kit](https://docs.oracle.com/en/java/javase/19/install/overview-jdk-installation.html)

1. :pencil2: Start by cloning this repository into a folder on your computer. If you've never used git before, you can alternatively use the the green "Code" button to the top right, and then select "Download zip". Unzip the downloaded zip file (make sure to remember where you put it).
2. :pencil2: Start IntelliJ and go `File -> Open -> select the POM.xml file in the cloned repository`. If IntelliJ asks, you want to select `Yes` for "Open as Project?" and "Keep existing project" for the second prompt. (See [IntelliJ docs](https://www.jetbrains.com/help/idea/maven-support.html#maven_import_project_start))
3. :pencil2: You should be able to compile the code and run all the existing unit tests.

### 1.2.3 Existing code

**Interfaces**

- `Sensor`. This interface defines methods for all sensors to implement.
	- `isTriggered()`: returns true/false for whether the sensor is triggered or not. Different sensors has different rules. See exercises.
	- `getLocation()`: returns a description of the location of the sensor such as "Lobby 1st floor" or "In the auditorium".
	- `getSensortype()`: returns a textual description of the sensor type such as "Fire sensor" or "Smoke sensor".
	- `getBatteryPercentage()`: Returns a number between 0-100 where 0 is empty and 100 is fully charged.

**Classes**

- `FireSensor`. This sensor implements the `Sensor` interface but has no logic yet.
- `SmokeSensor`. This sensor implements the `Sensor` interface but has no logic yet.
- `ControlUnit`. This is the starting point for the alarmsystem. It's the main entry point for polling sensors and controlling the system.
- `App` - Entrypoint for the application (where `main` method is located). Calls `pollSensors()` method in `ControlUnit` class.

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

### 1.2.4 - Existing unit tests

:book: There are some initial unit tests in place: `FireSensorTest.java` and `SmokeSensorTest.java`. These are just dummy implementations to verify our starting template works out of the box as expected.
When you work on your code you should keep the tests green, and that obviously means you will need to change them as you go along. TL;DR - the tests are just placeholders. Write better ones as you go along and remove the placeholder ones.

## 1.3 - `FireSensor`

:pencil2: Implement the `FireSensor` methods.


:exclamation: Requirements:

- Should raise an alarm every third time it is polled
- Drains 10% battery between each poll

## 1.4. - `SmokeSensor`

:pencil2: Implement the `SmokeSensor` methods.


:exclamation: Requirements:

- Should raise an alarm every second time it is polled
- Drains 20% battery between each poll

### [Go to exercise 2 :arrow_right:](../exercise-2/README.md)
