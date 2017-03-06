# Exercises pt. 3

1. A new use case! This is no longer a alarm system for only detecting hazards, it should now also include security such as motion and heat sensors. However, these sensors don't run on battery so one of the `Sensor` interface methods is suddenly redundant for a whole set of sensors. Which method is this and what SOLID principle does this break?
2. Following the principle you figured out in #1, start splitting the current `Sensor` interface into more fitting ones.
3. Create a new `MotionSensor` sensor, which inherits from the `Sensor` interface. These new security sensors should be polled separately from the hazard sensors. This requires a way to distinguish between the two sensor categories. Make changes to the `Sensor` interface to accomodate this.
9. Security sensors should only be polled at night between 22:00-06:00. This is the same for all security sensors. Since we don't want to mix security sensor and hazard sensor behaviour in the same polling mechanism, we decide to make use of inheritance and create a new `SecurityControlUnit` which `extends` the existing ControlUnit. Our intention is to pass in the security sensors through the _super (parent) constructor_ and then implement a rule that checks the current time and if it's between 22:00-06:00, we run the `super.pollSensors()` method which already do the heavy lifting for us.
10. Which SOLID principle are we _maintaining/not breaking_ by doing this?
11. Create the `SecurityControlUnit` and extend `ControlUnit`
12. Implement the time-check rule and poll the sensors.

## Testing tips pt. 2

Another hard thing when testing is date and time. After all, it would be quite bad if our unit tests could only pass between 22:00-06:00 at night for the exercise above.

We solve this issue with the _[Adapter Design Pattern](https://en.wikipedia.org/wiki/Adapter_pattern)_

1. Create an interface `LocalDateTimeAdapter` with a method `now()` (it's good practice to have Adapters match the original method signature exactly, and we want to wrap this Adapter around Java 8's `LocalDateTime.now()`).
2. Create a default implementation of this interface `LocalDateTimeAdapterImpl` that only returns the original `LocalDateTime.now()`.
3. Make sure the `SecurityControlUnit` only depends on the `LocalDateTimeAdapter` interface.
4. In your test you can now substitute your own fake implementation of the adapter interface and return any date and time you want, thus controlling your test.
