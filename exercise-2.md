# Exercise 2 - Exceptions, failures and errors

This exercise will cover how to test code that throws exceptions, and explore what the difference between failures and
errors are in tests.

## You will learn how to:

1. Check for exceptions in a test
2. Understand the difference between failures and errors

# 2.1. Checking for exceptions

Sometimes an exception is the correct result of a test. For example, if we have some code validating if a given input is
a valid phone number, in most cases the code would be set up to throw an exception if the input is not a valid phone
number.

JUnit provides some syntax to check for exceptions in a test:

```Java

@Test
void test() {
    assertThrows(Exception.class, () -> ...)
}
```

:pencil2: Take a look at the `SmoothieBar` class. The `blend` method will throw a `IllegalStateException` if the stock
of ingredients required for the smoothie to be blended is to low.  
:pencil2: Create a test that tests this logic (hint: It has something to do with restocking ingredients).  
:pencil2: Run the test, see that test fails with the `IllegalStateException` as cause.  
:pencil2: Use `expected` syntax above to make green again.  
:pencil2: What other behaviors causes `blend` to throw exception(s)? Write test(s) confirming the behavior.

# 2.2. Failures and errors

An important distinction in software testing is the difference between failures and errors.

- Failures can happen when trying to check a behavior, errors can occur at any point in the test
- A failure happens when an assertion fails
- An error happens when the test throws an unexpected exception

Failures means the code under test is broken. Errors might mean the test is broken or the code under test is broken.

:pencil2: Make the test you just made not pass again and see that the test was marked with the error icon in the Test
Runner: ![failed](https://www.jetbrains.com/help/img/idea/2016.3/testError.png)

- Modify the `canBlendOrangeAndAppleSmoothie` test so that it is marked as failed the Test
  Runner: ![failed](https://www.jetbrains.com/help/img/idea/2016.3/testFailed.png)

### [Go to exercise 3 :arrow_right:](exercise-3.md)
