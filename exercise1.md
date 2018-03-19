# Exercise 1

## Case: The Alarm System

In these exercises we're going to make an Alarmsystem - the kind with fire and smoke detectors etc.

## Use cases

- The system should support any number of sensors
- The system should support different types of sensors (fire, smoke, gas, etc)
- The system should poll all sensors to see if any are triggered (an alarm is raised)
- The system should also check for the battery percentage of the sensors (different types of sensors draines faster)

> Important! The goal of these exercises is to work on code with the SOLID principles in mind. Try to evaluate your choices as you go and keep the principles in mind.

## Getting started

> **Before you begin**: Please make sure that you have the following installed:
- IntelliJ Community Edition: [IntelliJ Community Edition](https://www.jetbrains.com/idea/download/)
- Java dev kit: [Java SE Development Kit](http://www.oracle.com/technetwork/java/javase/downloads/jdk8-downloads-2133151.html)

1. :pencil2: Either `git clone https://github.com/nerdschoolbergen/solid.git` or "Download as ZIP"
2. :pencil2: Start IntelliJ and go `File -> Open -> select the POM.xml file in the cloned repository`. If IntelliJ asks, you want to select `Yes` for "Open as Project?" and "Keep existing project" for the second prompt.
3. :pencil2: You should be able to compile the code and run all the existing unit tests.

### Existing code

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

### Existing unit tests

There are some initial unit tests in place: `FireSensorTest.java` and `SmokeSensorTest.java`. These are just dummy implementations to verify our starting template works out of the box as expected.
When you work on your code you should keep the tests green, and that obviously means you will need to change them as you go along. TL;DR - the tests are just placeholders. Write better ones as you go along and remove the placeholder ones.

## Exercises

1. :pencil2: Implement the `FireSensor` methods.
	- 5% of the time it is called, it raises an alarm
	- Drains 10% battery between each poll
2. :pencil2: Implement the `SmokeSensor` methods.
	- 10% of the time it is called, it raises an alarm
	- Drains 20% battery between each poll
