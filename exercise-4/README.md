# 4.0 - Exercise 4 - extending the alarmsystem

## 4.1 - Adding motion and heat sensors

:book: A new use case! This is no longer a alarm system for only detecting hazards, it should now also include security such as motion and heat sensors. However, these sensors don't run on battery so one of the `Sensor` interface methods is suddenly redundant for a whole set of sensors. 

:question: Which method is this and what SOLID principle does this break?

:pencil2: Following the principle you figured out in the last question, start splitting the current `Sensor` interface into more fitting ones.

:pencil2: Create a new `MotionSensor` sensor, which inherits from the `Sensor` interface. These new security sensors should be polled separately from the hazard sensors. This requires a way to distinguish between the two sensor categories. Make changes to the `Sensor` interface to accomodate this.

## 4.2 - Adding a time-check rule

:pencil2: Security sensors should only be polled at night between 22:00-06:00. This is the same for all security sensors. Since we don't want to mix security sensor and hazard sensor behaviour in the same polling mechanism, we decide to make use of inheritance and create a new `SecurityControlUnit` which `extends` the existing ControlUnit. Our intention is to pass in the security sensors through the _super (parent) constructor_ and then implement a rule that checks the current time and if it's between 22:00-06:00, we run the `super.pollSensors()` method which already do the heavy lifting for us.

:question: Which SOLID principle are we _maintaining/not breaking_ by doing this?

:pencil2: Create the `SecurityControlUnit` and extend `ControlUnit`
:pencil2: Implement the time-check rule and poll the sensors.

## 4.3 - Testing tips pt. 2

:book: Another hard thing when testing is date and time. After all, it would be quite bad if our unit tests could only pass between 22:00-06:00 at night for the exercise above.

:book: We solve this issue with the _[Adapter Design Pattern](https://en.wikipedia.org/wiki/Adapter_pattern)_

:pencil2: Create an interface `LocalDateTimeAdapter` with a method `now()` (it's good practice to have Adapters match the original method signature exactly, and we want to wrap this Adapter around Java 8's `LocalDateTime.now()`).

:pencil2: Create a default implementation of this interface `LocalDateTimeAdapterImpl` that only returns the original `LocalDateTime.now()`.

:pencil2: Make sure the `SecurityControlUnit` only depends on the `LocalDateTimeAdapter` interface.

:pencil2:. In your test you can now substitute your own fake implementation of the adapter interface and return any date and time you want, thus controlling your test.

### [Go to exercise 4 :arrow_right:](../exercise-4/README.md)
