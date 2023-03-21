# 2.0 - Exercise 2 - Dependency Inversion Principle (DIP)

In this exercise we will look at how to apply the SOLID principles in code.

## 2.1 - Dependency Inversion Principle (DIP)

```mermaid
classDiagram
    FireSensor <.. ControlUnit
    SmokeSensor <.. ControlUnit

    class FireSensor{
    }
    
    class SmokeSensor{
    }
    
    class ControlUnit{
      +pollSensors()
    }
```

:pencil2: The `pollSensors` method on the `ControlUnit` class currently knows which sensors (`FireSensor` and `SmokeSensor`) are registered in the system. This adds a thight coupling between the `ControlUnit` and the Sensor classes.

:exclamation: We want to apply the _Dependency Inversion Principle (DIP)_ in order to make the `ControlUnit` oblivious to which type of sensor it administers.

:book: When we introduce this kind of [loose coupling](https://en.wikipedia.org/wiki/Loose_coupling), the `ControlUnit` class is not prone to change as the Sensor class changes. E.g. we can add new sensor types without changing the `ControlUnit` class. As long as the different types of sensors adhere to the interface of how a sensor should behave. The ControlUnit class no longer has a direct dependency to the different sensor types, instead it only knows the behaviour of a sensor.

:pencil2: A common way to implement DIP is via _constructor injection_. Create a new constructor for the `ControlUnit` class that takes a list of `Sensor`s as a parameter. Store the list of sensors as a private instance variable inside the class.

:pencil2: Change the `pollSensors` method to loop over the new list of sensors. Remove the `new` statements.

:pencil2: In the `App` class, a list of sensor implementations and pass them to the `ControlUnit` class constructor.

:bulb: Example:

<details>

```java

public class ControlUnit {
  private final List<Sensor> sensors;

  public ControlUnit(List<Sensor> sensors) {
    this.sensors = sensors;
  }

  public List<Sensor> pollSensors() {
    // Remove the following:
    // List<Sensor> sensors = new ArrayList<>();
    // sensors.add(new FireSensor());
    // sensors.add(new SmokeSensor()); 
    // 
    // ...
  }
  // ...
}
```

```java
public class App {

  public static void main(String[] args) {
    List<Sensor> sensors = new ArrayList<>();
    sensors.add(new FireSensor());
    sensors.add(new SmokeSensor());
    
    ControlUnit controlUnit = new ControlUnit(sensors);
    // ...
  }
}
```

</details>

:book: TODO - Add part about what we gain by injecting sensors into control class.

### [Go to exercise 3 :arrow_right:](../exercise-3/README.md)
