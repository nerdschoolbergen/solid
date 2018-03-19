# 2.0 - Exercise 2

In this exercise we will look at how to apply the SOLID principles in code.

## 2.1 - Single responsibility

 :pencil2: Investigate the `ControlUnit.pollSensors()` method. What are its current responsibilities? (No need to do anything, just make sure you find all responsibilities before you continue). Ask an instructor if you're not sure.

## 2.2 - Inversion of control

:book: Instead of "newing up" sensors in a list when we call `pollSensors()`, we want to pass a collection of sensors in to the ControlUnit somehow (we want to _invert the dependencies_ between ControlUnit, pollSensors callee, and the various Sensor classes). However, we don't want to pass the sensors in when we are polling. When we poll sensors, the control unit should be configured with all of the required sensors.

:pencil2: Use Dependency Inversion by sending a _list of sensors_ in as a _constructor parameter_ when we're creating the `ControlUnit` class.

:pencil2: Investigate the pollSensors method again, same as #1. What are the responsibilities now? (Not sure? Ask an instructor!).

> :question: You didn't forget test coverage of ControlUnit or leave failing tests did you?

### 2.2.1 - Testing tips

As you try to write tests for ControlUnit.pollSensors(), you might find it frustrating that it doesn't return any value. Here's a couple of workarounds:

:star: At the moment we're just writing messages using `System.out.println` which is impossible to test. What if you made an `AlarmHandler` interface with the method `handleTriggeredSensor(Sensor sensor)` or `handleTriggeredSensor(String sensorOutput)`?
The default implementation (`ConsoleWritingAlarmHandler`? (Just suggestions...)) could then do the `System.out.println` calls as before, but in your tests you could implement a `FakeAlarmHandler` class that stores all
sensor logs in a List which you can then read and assert against in your test.

:star: Nobody said ``pollSensors`` has to return void. It's your implementation after all. If you want to return a `Map<string, string>` of sensor id's and sensor alarm messages so that it's easier to test, go for it.

### [Go to exercise 3 :arrow_right:](exercise3.md)
