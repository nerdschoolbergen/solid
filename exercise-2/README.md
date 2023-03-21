# 2.0 - Exercise 2 - Dependency Inversion Principle (DIP)

In this exercise we will look at how to apply the Dependency Inversion Principle (DIP) in code.

The Dependency Inversion Principle (DIP) states:

> A. High-level modules should not import anything from low-level modules. Both should depend on abstractions (e.g., interfaces).
> B. Abstractions should not depend on details. Details (concrete implementations) should depend on abstractions.

## 2.1 - Dependency Inversion Principle (DIP)

```mermaid
classDiagram
    Sensor <|-- FireSensor
    Sensor <|-- SmokeSensor
    FireSensor <.. ControlUnit
    SmokeSensor <.. ControlUnit
    Sensor <.. ControlUnit
    ControlUnit <|-- App
    
    class Sensor
    <<interface>> Sensor
    class FireSensor
    class SmokeSensor
    class ControlUnit{
      -List~Sensor~ : senors
      +ControlUnit()
      +pollSensors()
    }
    class App
```

:pencil2: Take a look at the class diagram above showing the relationships between the different parts of the Alarmsystem application. (Dotted arrows denotes a dependency relation, full arrows denotes an inheritance relation (see [UML Class Diagrams Tutorial](https://www.visual-paradigm.com/guide/uml-unified-modeling-language/uml-class-diagram-tutorial/))).

:pencil2: `ControlUnit` class currently knows which sensors (`FireSensor` and `SmokeSensor`) are registered in the system because they are `new`-ed up in the class (`new` means glue!). This adds a thight coupling between the `ControlUnit` and the Sensor classes.

:pencil2: This thight coupling also violatetes the Open Closed Principle (OCP), because the `ControlUnit` class is not open for extension (eg. adding new types of sensors is not possible without changing the class).

:bulb: We want to apply the _Dependency Inversion Principle (DIP)_ in order to make the `ControlUnit` oblivious to which type of sensor it administers, thereby decoupling it from the sensors.

:book: When we introduce this kind of [loose coupling](https://en.wikipedia.org/wiki/Loose_coupling), the `ControlUnit` class is not prone to change as the Sensor class changes. E.g. we can add new sensor types without changing the `ControlUnit` class. As long as the different types of sensors adhere to the interface of how a sensor should behave. The ControlUnit class no longer has a direct dependency to the different sensor types, instead it only knows the behaviour of a sensor.

:book: A common way to implement DIP is via [_constructor injection_](https://en.wikipedia.org/wiki/Dependency_injection#Constructor_injection).  See the following class diagram:

```mermaid
classDiagram
    Sensor <|-- FireSensor
    Sensor <|-- SmokeSensor
    Sensor <.. ControlUnit
    FireSensor <.. App
    SmokeSensor <.. App
    ControlUnit <.. App
    
    class Sensor
    <<interface>> Sensor
    class FireSensor
    class SmokeSensor
    class ControlUnit{
      -List~Sensor~ : senors
      +ControlUnit(List~Sensor~ : sensors)
      +pollSensors()
    }
    class App
```

:book: Notice that `ControlUnit` no longer has any relationship to `FireSensor` and `SmokeSensor`, only the `Sensor` interface. Instead, the `App` class now controls what sensors the `ControlUnit` polls via a new constructor.

:pencil2: Add a list of sensors as new constructor parameter to `ControlUnit`.

:pencil2: Replace the `new ArrayList` assignment of the `sensors` instance variable in the constructor with the value of the new constructor parameter you added.

:pencil2: Remove the  `new` Sensor statements from the constructor.

:pencil2: In the `App` class, create a list of sensor implementations (`FireSensor` and `SmokeSensor`) and pass them to the `ControlUnit` class constructor as a parameter.

:pencil2: Run the application again to make sure it still works as before.

:book: If you are completely stuck, here is an example:

<details>

```java

public class ControlUnit {
  private final List<Sensor> sensors;

  // Add List<Sensor> sensors parameter here:
  public ControlUnit(List<Sensor> sensors) {
    this.sensors = sensors;
    // Remove the following:
    // this.sensors = new ArrayList<>();
    // sensors.add(new FireSensor());
    // sensors.add(new SmokeSensor());
  }

  // ...
}
```

```java
public class App {

  public static void main(String[] args) {
    // Add list of sensors:
    List<Sensor> sensors = new ArrayList<>();
    sensors.add(new FireSensor());
    sensors.add(new SmokeSensor());
    
    // Pass list of sensors to ControlUnit constructor as parameter:
    ControlUnit controlUnit = new ControlUnit(sensors);
    // ...
  }
}
```

</details>

### Summary

- The `ControlUnit` class violates the Dependency Inversion Principle, because the "high-level module" `ControlUnit` depends on the "low-level modules" `FireSensor` and `SmokeSensor`.
- By introducting constructor injection the module `ControlUnit` now depends on an abstraction (the `Sensor` interface) instead of contrete implementations (`FireSensor` and `SmokeSensor`), thereby adhering to the Dependency Inversion Principle.
- By making the `ControlUnit` not depend directly on sensors the `ControlUnit` now is also adhering to the Open Closed Principle, because we can add new Sensors to poll without changing the `ControlUnit` class.

### [Go to exercise 3 :arrow_right:](../exercise-3/README.md)
