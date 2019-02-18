# Summary of principles in exercises

## S - Single Responsibility Principle 
In exercise 2.1 we looked at an example of Single Responsiblity Principle (SRP). SRP states that "a class should have one, and only one reason to change", i.e the class or component should only have one responsibility. 

## O - Open/Closed Principle
In exercise 3.2, we looked at the Open/Close Principle (OCP). We maintained the OCP by extending the `ControlUnit` by creating a new component called `SecurityControlUnit`, and were able to extend its functionality without changing the existing component.

## L - Liskov's Substitution Principle
In exercise 3.1, if we ended up throwing an exception when calling `getBatteryPercentage` using a `MotionSensor`, we would have broken the LSP. The motion sensor that did not require battery functionality would not be substitutable for their base class, as calling the `getBatteryPercentage`-method would cause unexpected side-effects for consuming client.

The LSP is adressing the use of correct abstractions for your components.

![Liskov Substitution Principle](/images/lsp_duck.png)

## I - Interface Segregation Principle

The Interface Segregation Principle (ISP) tells us to make fine grained interfaces that are client specific. No client should be forced to depend on methods that it does not use. 

In exercise 3.1, we broke the Interface Segregation Principle, by adding a new sensor type that had a redundant method (`getBatteryPercentage` is not needed for a sensor that does not require batteries).

We fixed the implementation by splitting the code into fitting interfaces (Maybe you created a interface called `BatteryDrivenSensor`?).

## D - Dependency Inversion Principle
In exercise 2.2, we looked at "inversion of control" and the Depenrency Inversion Principle (DIP). By depending on the abstraction of a sensor, and not the concrete implementations, we were able to decouple our `ControlUnits` from knowing anything about the implementation of our sensors. 