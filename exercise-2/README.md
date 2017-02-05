# Exercise 2 - Exceptions, failures and errors

This exercise will cover how to test code that throws exceptions, and explore what the difference between failures and errors are in tests.

You will learn how to:

1. Check for exceptions in a test
2. Understand the difference between failures and errors

# 2.1. Checking for exceptions

Sometimes an exception is the correct result of a test. For example, if we have some code validating if a given input is a valid phone number, in most cases the code would be set up to throw an exception if the input is not a valid phone number.

JUnit provides some syntax to check for exceptions in a test:

```Java
@Test(expected = ExceptionName.class)
```

- Make code under test throw an error when test #1 runs
- Run test, see that test fails with unhandled exception
- Insert syntax above to make test pass

# 2.2. Failures and errors

Blabla.

### [Go to exercise 3 ==>](../exercise-3/README.md)
