# Exercise 5 - Dependencies

This exercise will take you through how to deal with dependencies when working with unit tests.

## Identifying dependencies

All non-trivial applications has dependencies between classes, between modules, and between layers. In this code, the class `LaunchControl` has a dependency on `RocketLauncher` which does exactly what you think it does:

```java
class RocketLauncher {
    public void launchRocket() { /* Launches an actual rocket */ }
}
class LaunchControl{
    public string executeLaunch() {
        return new RocketLauncher().launchRocket();
    }
}
```

The problem with the above example is that the `RocketLauncher` dependency is impossible to work around. We cannot possibly call `LaunchControl.executeLaunch()` without actually launching the rocket. In other words, this is untestable.

## Inversion of Control

The first step to solving this issue, is to apply something called inversion of control, based on what is known as the Dependency Inversion Principle, the "D" in the SOLID patterns, which is another Nerdschool workshop.

Ignoring the fancy words for now, what it means is that instead of having the `LaunchControl` class being responsible for "newing up" the `RocketLauncher` class, we change `LaunchControl` to take in an instance of `RocketLauncher` through its constructor. We have thereby _inverted control_ of the dependency to the _caller_ of `LaunchControl`.

```java
class LaunchControl{
    private RocketLauncher rocketLauncher;
    public LaunchControl(RocketLauncher rocketLauncher) {
        this.rocketLauncher = rocketLauncher;
    }
    public string executeLaunch() {
        return this.rocketLauncher.launchRocket();
    }
}
```

## Working with interfaces

We've still not solved the actual problem though. We cannot call `executeLaunch()` without using the actual `RocketLauncher` class.

The next step is therefore to make `LaunchControl` dependent on a _contract_, and not an actual implementation. In Java, this is done through _interfaces_.

```java
interface RocketLauncher {
    void launchRocket();
}
class RocketLauncherImpl implements RocketLauncher {
    public void launchRocket() { /* Launches an actual rocket */ }
}
class LaunchControl{
    private RocketLauncher rocketLauncher;
    public LaunchControl(RocketLauncher rocketLauncher) {
        this.rocketLauncher = rocketLauncher;
    }
    public string executeLaunch() {
        return this.rocketLauncher.launchRocket();
    }
}
```

> Note that the _interface_ is now called `RocketLauncher` while the implementation _class_ is called `RocketLauncherImpl` as is a typical naming convention in Java.

Finally, the `LaunchControl` class is free of any hard dependency. It now accepts a loose contract that we in production code can implement with an actual rocket launcher, but in our tests implement through an _Mock_.

**Do the following:**

- Open the exercise 5 pom.xml as a project in IntelliJ
- Look through the code
- Apply inversion of control to the `RocketLauncher` and `PreFlightChecks` dependencies inside the `LaunchControl` class.
- In `LaunchControlTest.java`, create a `@Before` function where you can create a new instance of `LaunchControl.java`. Ensure that you can create an instance of `LaunchControl` with dummy implementations and not the real `RocketLauncher` and `PreFlightChecks` classes.

## Mocks and stubs

A _mock_ is a dummy implementation of an interface or abstract class that we create and inject during testing so that we can test our code in isolation. We typically use a framework for creating mocks when we're writing tests.
However, to get a good understanding of how this works in simple cases, we're not going to use a framework today but rather make our own dummy implementations for testing purposes.

> A popular mocking framework for Java is [mockito](http://site.mockito.org/)

A _stub_ is the exact same thing as a mock! Well, it's the same thing in code implementation. The difference between mocks and stubs lie in how we, as programmers, think about them when we read code.

**We use _mocks_ to _assert a condition has been fulfilled during our test_.**

**We use _stubs_ to _control the flow of the application during the test_.**

In other words, if we want to write a test that asserts that the `RocketLauncher.launchRocket()` method was called during execution of `LaunchControl.executeLaunch()`, we would create a _mock_.
If we just want a method to return a certain value so that a certain condition is met in order to test what we want to test, we'd use a _stub_. In practice we would create the same object in code, but name and approach them differently.

> Different test frameworks has different implementations and ideas for mocks and stubs. Some frameworks call everything a mock, some differentiate between the two in significant ways.

**Do the following:**

- If you haven't already, create the classes `RocketLauncherStub.java` and `PreFlightChecksStub.java` which implement the interfaces you might expect them to.
- In `LaunchControlTest.java`, create the following tests:
    - `executeLaunch_whenNoFuelAndDoorIsNotClosed_doesNotLaunchRocket`
    - `executeLaunch_whenHasFuelAndDoorIsNotClosed_doesNotLaunchRocket`
    - `executeLaunch_whenHasFuelAndDoorIsClosed_launchesRocket`
    - `executeLaunch_whenNoFuelAndDoorIsClosed_doesNotLaunchRocket`
- Make all tests pass

## Adapter pattern

Often, we want to test something we cannot easily decouple or take in as an interface. Any static method call on a class, for example. Typical problems are concerning disk, network, and date/time calls.

We don't want to actually delete files during our tests, and we don't want our tests to be depending on time or dates. In fact, we often want to control the current date and time in our tests. For this, we'll use the Adapter Pattern.

![adapter pattern](https://static.dzone.com/dz1/dz-files/adapter_pattern_0.PNG)

The Adapter Pattern is one of the most well-known and basic design patterns.

The short version is that we take whatever hard dependency we have, and define an `(..)Adapter` class and interface for it which defines the methods we need.

**Example:**

```java
public Boolean acceptAgreement() {
    System.out.println("Do you accept the agreement?");
    Scanner reader = new Scanner(System.in);
    String answer = reader.nextLine();
    return answer.equals("yes");
}
```

The above example has a hard dependency on reading input from the console. We couldn't test this code without actually prompting for user input.

**Adapter pattern solution:**

```java
public interface ScannerAdapter {
    String nextLine(); // Note: signature and name of method matching exactly the original Scanner class' method signature.
}

public class ScannerAdapterImpl {
    public String nextLine() {
        // The default implementation of the ScannerAdapter interface which will run during normal execution. This uses the Scanner.nextLine as before.
        Scanner reader = new Scanner(System.in);
        return reader.nextLine();
    }
}

public class Agreement {
    private ScannerAdapter scannerAdapter;
    public Agreement(ScannerAdapter scannerAdapter) { // Only depends on the adapter contract which we can control in our test using mocks/stubs
        this.scannerAdapter = scannerAdapter;
    }
    public Boolean acceptAgreement() {
        System.out.println("Do you accept the agreement?");
        String answer = this.scannerAdapter.nextLine();
        return answer.equals("yes");
    }
}
```

**Do the following:**

- Refactor `PreFlightChecks` to use the adapter pattern
- Create `PreFligthChecksTests.java` in the test dir
- Create test cases for each method that verifies the correct result is returned given "user" (fake) input. You control the user input as stubs in your tests.
