# Exercise 1 - Introduction

This exercise will get you started learning the basics of writing and running some tests in an IDE (Integrated Development Environemnt) using the JUnit testing framework.

We are going to assume you have IntelliJ Community Edition installed.

You will learn how to:

1. Set up your development environment
2. Create your first unit tests using JUnit
3. Structure your tests properly

## 1. Dev environment

> **Before you begin**: Please make sure that you have the following installed:
- IntelliJ Community Edition: [IntelliJ Community Edition](https://www.jetbrains.com/idea/download/)
- Java dev kit: [Java SE Development Kit](http://www.oracle.com/technetwork/java/javase/downloads/jdk8-downloads-2133151.html)


* Open `pom.xml` in IntelliJ by selecting **"Open"** in the Welcome screen:

![](../images/intellij-open.png)

* Then select **"Open as Project"**

![](../images/intellij-open-as-project.png)

This will create a IntelliJ project from the Maven `pom.xml`.

## 2. Creating your first unit tests

- --Describe exercise code--

- Create a test class
- Create a test method using `assertTrue`
- Run it (show how using screenshots?), see it pass


- Create a second test using `assertTrue` that fails
- Make changes to the code under test to make test pass
- Run test, see it pass

## 3. Test structure

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
