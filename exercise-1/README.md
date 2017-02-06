# Exercise 1 - Introduction

This exercise will get you started learning the basics of writing and running some tests in an IDE (Integrated Development Environemnt) using the JUnit testing framework.

We are going to assume you have IntelliJ Community Edition installed.

You will learn how to:

1. Set up your development environment
2. Create your first unit tests using JUnit
3. Structure your tests properly

## 1.1. Dev environment

> **Before you begin**: Please make sure that you have the following installed:
- IntelliJ Community Edition: [IntelliJ Community Edition](https://www.jetbrains.com/idea/download/)
- Java dev kit: [Java SE Development Kit](http://www.oracle.com/technetwork/java/javase/downloads/jdk8-downloads-2133151.html)


* Open `pom.xml` in IntelliJ by selecting **"Open"** in the Welcome screen:

![](../images/intellij-open.png)

* Then select **"Open as Project"**

![](../images/intellij-open-as-project.png)

This will create a IntelliJ project from the Maven `pom.xml`.

## 1.2 Creating your first unit tests

### Code example
In the introductory exercises you will be working with a simple, ready made example. The theme / "problem domain" is a smoothie bar that can blend different types of smoothies and keep track of the stock of ingredients. The smoothie bar is pretty limited, as they only use apples, oranges and bananas in smoothies, and can only serve three different kinds of smoothie: "Orange and apple smoothie", "Banana and apple smoothe" and "Orange and banana smoothie".

The code has the following structure:

- A `SmoothieKind` enum having three different enum values: `OrangeAndAppleSmoothie`, `BananaAndAppleSmoothe` and `OrangeAndBananaSmoothie`. Each smoothie has different recipes (how many apples, oranges and bananas required)
- A `Smoothie` representing the beverage that the bar can blend. It has information about what `SmoothieKind` it is, and what ingredients it consists of
- A `SmoothieBar` class representing the smoothie bar. It has these public methods:
  - `blend` - which takes `SmoothieKind` as a parameter and returns a `Smoothie`
  - `getApplesInStock`, `getOrangesInStock` and `getBananasInStock` which gets the current stock of ingredients
  - `restockApples`, `restockOranges` and  `restockBananas` which lets you add ingredients to the stock

We are going to focus on testing the `SmoothieBar`-class in the next exercises.

### Creating a `SmoothieBar` test class and a test

- To create a test class for the `SmoothieBar` class first use the Project window on the left side of the screen to open the `SmoothieBar` class in the Editor window. (If it's not visible it may be collapsed. If so, click the tab called "Project" on the left side of the screen.)
- To make things easy we are going to have IntelliJ create the test class for us by placing the cursor within the line containing the class declaration (`public class SmoothieBar...`) and press **`Alt+Enter`** (Windows/Linux users) or **`⌥⏎`** (Mac users)
- Choose **Create Test** from the suggestion list

![Suggestion list](../images/intellij-create-test.png)

- In the "Create Test" dialog, fill out the following:
 - Testing library: "JUnit4"
 - Class name: "SmoothieBarTest"
 - Generate test methods for: `blend` (the first method)
- Click **OK**

![Create test dialog](../images/intellij-create-test-dialog.png)

- A test class called `SmoothieBarTest` should now have been created in the `src\test` folder

We now have an test class with a empty test method. Remove the empty `blend` test method and create a `helloNerdSchool` test method with the following syntax:

```java
@Test
public void helloNerdSchool() {
  System.out.println("Hello NerdSchool!");
}
```

Notice the `@Test` annotation that marks this method as a JUnit test method.

### Running tests using the Test Runner tab

When you added the test you may have noticed the green arrow at the left hand side of the Editor window.

- Click the green arrow and run the `helloNerdSchool` test.
- The Test Runner tab should show up at the bottom of the screen, showing that the test has passed and printed out "Hello Nerdschool in the output pane.

[Test Runner documentation](https://www.jetbrains.com/help/idea/2016.3/test-runner-tab.html)

### Creating more tests

We are now going to create a test which tests if the `SmoothieBar` class can blend an orange and apple smoothie.

- Remove the `helloNerdSchool` test and add the following:

```java
@Test
public void canBlendOrangeAndAppleSmoothie() {
    SmoothieBar smoothieBar = new SmoothieBar();
    smoothieBar.restockApples(2);
    smoothieBar.restockOranges(2);
    Smoothie smoothie = smoothieBar.blend(SmoothieKind.OrangeAndAppleSmoothie);
    assertTrue(smoothie.getKind() == SmoothieKind.OrangeAndAppleSmoothie);
}
```

- Run the test, and see that it passes (marked green in the Test Runner).
- Notice the JUnit `assertTrue` method call. This method tests that the given boolean expression is true, if not the test fails
- Try to make the test fail by making a change to the assertion and rerun the test
- Observe what happens in the Test Runner

The `assertTrue` assertion is one of many built in to the JUnit framework. [More about assertions here](https://github.com/junit-team/junit4/wiki/Assertions

We also want to test that the `SmoothieBar` class consumes oranges and apples from its stock when a smoothie is made.

- Add the following test:

```java
@Test
public void blendingOrangeAndAppleSmoothieConsumesOrangesAndApples() {
    SmoothieBar smoothieBar = new SmoothieBar();
    smoothieBar.restockApples(2);
    smoothieBar.restockOranges(2);
    Smoothie smoothie = smoothieBar.blend(SmoothieKind.OrangeAndAppleSmoothie);
    assertTrue(smoothieBar.getApplesInStock() == 0);
    assertTrue(smoothieBar.getOrangesInStock() == 0);
}
```

- Run the test and see that it passes.
- You can also run all tests at once by clicking the green arrow beside the test class name.
- Optional: Think of some more test cases and create some tests.

## 1.3. Test structure

It is good practice to use the following structure when writing tests:

- _Given_
  - What should the world look like when the test happens?
  - The preconditions for the test
- _When_
  - What is being tested?
  - The behavior
- _Then_
  - What are the changes that happened?
  - The post-condition


- Identify the _Given_, _When_, _What_ sections of the tests you just wrote by inserting comments and line breaks to make it clearer.

### [Go to exercise 2 ==>](../exercise-2/README.md)
