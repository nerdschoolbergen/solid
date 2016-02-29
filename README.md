# S.O.L.I.D

## Use cases

- The system should support any number of sensors
- The system should support different types of sensors
- The system should poll all sensors to see if any are triggered (an alarm is raised)
- The system should also check for any defected sensors (different types of sensors has different defect rates)

## The starting point

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

## Exercises

1. Implement the `FireSensor` methods.
	- 5% of the time it is called, it raises an alarm
2. Implement the `SmokeSensor` methods.
	- 10% of the time it is called, it raises an alarm
3. Investigate the `ControlUnit.pollSensors()` method. What are its current responsibilities? (No need to do anything, just make sure you find all responsibilities before you continue).
4. Instead of "newing up" sensors when we call `pollSensors()`, we want to pass a collection of sensors in to the ControlUnit somehow. However, we don't want to pass the sensors in when we are polling. When we poll sensors, the control unit should be configured. (Hint: Dependency Inversion Principle).
5. Investigate the pollSensors method again, same as #4. What are the responsibilities now?
6. A new use case! This is no longer a alarm system for only detecting hazards, it should now also include security such as motion and heat sensors. However, these sensors don't run on battery so one of the `Sensor` interface methods is suddenly redundant for a whole set of sensors. Which method is this and what SOLID principle does this break?
7. Following the principle you figured out in #6 (or ask an instructor!), solve the problem by following the presentation slide hints on this principle. If you're stuck, ask an instructor.
8. Create a new `MotionSensor` sensor, which inherits from the Sensor interface. These new security sensors should be polled separately from the hazard sensors. This requires a way to distinguish between the two sensor categories. Make changes to the Sensor interface to accomodate this.
9. Security sensors should only be polled at night between 22:00-06:00. This is the same for all security sensors. Since we don't want to mix security sensor and hazard sensor behaviour in the same polling mechanism, we decide to make use of inheritance and create a new `SecurityControlUnit` which `extends` the existing ControlUnit. Our intention is to pass in the security sensors through the _super (parent) constructor_ and then implement a rule that checks the current time and if it's between 22:00-06:00, we run the `super.pollSensors()` method which alreayd do the heavy lifting for us.
10. Which SOLID principle are we _maintaining/not breaking_ by doing this?
11. Create the SecurityControlUnit and extend ControlUnit
12. Implement the timecheck rule and poll the sensors.
13. In addition to alarms messages, whenever an alarm is raised, it also posts a chuck norris joke from http://www.icndb.com/api/! 

Have fun
