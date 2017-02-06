# Exercise 3 -  Writing good tests

This exercise will cover how to write good tests by following some good practices.

You will learn how to:

1. Create well named tests
2. Keep things DRY
3. Test behavior, not implementation
4. Make tests easy to diagnose on failure

## 3.1. Good naming conventions

Using good naming conventions when naming tests creates a form of executable documentation for your application. It makes maintaining the code easier by it easier to look up what test does what, and helps readability.

### Naming anti-patterns

Here are some examples of bad naming:

```java
@Test
public void test1() {
  ...
}
```
- Completely unreadable.


```java
@Test
public void oranges() {
  ...
}
```
- Something to do with oranges?

```java
@Test
public void makeJuice() {
  ...
}
```
- Probably tests the `makeJuice`-method?

### Naming rules

Here are some simple naming rules:

- Use domain terminology
- Use natural language
- Be descriptive

Take a look at some of tests we added in the previous exercises:

- `canBlendOrangeAndAppleSmoothie`
- `blendingOrangeAndAppleSmoothieConsumesOrangesAndApples`

As you can se the names use the domain terms `blend`, `OrangeAndAppleSmoothie`. They´re also pretty descriptive and uses natural language to convey meaning.

- See if you can rename some of the other tests you made using these rules

### Alternate naming convention

Author Roy Osherove has coined another naming convention popular in C#/.NET programming, read about it [here](http://osherove.com/blog/2005/4/3/naming-standards-for-unit-tests.html).

## 3.2. Don't repeat yourself

You may have noticed that the arrange-part of the tests have some duplicated code. Often the arrange-part of tests for particular class/method have overlapping code. To make the arrange code more DRY, we can utilize the `@Before` annotation provided by JUnit.

- Refactor the common arrange code into a method
- Add the `@Before` syntax to the method
- Run the tests to make sure they still pass
- Observe that the `@Before` annotated method runs before each test 

### Magic numbers

The arrange code we wrote contains some "magic numbers" such as the number of apples and oranges restocked before making a smoothie (`smoothieBar.restockApples(2)`).

- Refactor the code to use properly named constants for all magic numbers.

## 3.3. Making tests easy to diagnose on failure

When diagnosing why tests fail it is very helpful to have tests output detailed information about what caused the test to fail, so that you can avoid having to debug the test using the debugger.

- Update the `blendingOrangeAndAppleSmoothieConsumesOrangesAndApples` test to restock the wrong amount of apples.
- Rerun the test
- Notice that the test outputs an `AssertionError`, but it's not very helpful.

### Using the `assertEquals` assertion

To make tests easier to diagnose, we can use the `assertEquals` assertion. `assertEquals` can be used to compare expected values to actual values:

Syntax: 
```java
assertEquals(1, someNumber)
```

Test failure output:

```
Expected :1
Actual :0
```

### Exposing a reason

Supplying an identifying message makes the assertion error more readable:

Syntax:

```java
assertEquals(“Wrong quantity of stuff!”, 1, stuffQuantity);
Wrong quantity of stuff!
```

Test failure output:

```
Expected :1
Actual :0
```

- Replace the `assertTrue` assertions in the test with `assertEquals` assertions
- The test output should now be easier to diagnose

### [Go to exercise 4 ==>](../exercise-4/README.md)
