# 7TETL Unit Testing Tutorial

A simple tutorial demonstrating how to write tests in JUnit, use parameterized tests, apply **jqwik** for property‑based testing, and use **Mockito** for mocking.

The tutorial explanation is available at [https://engin.gitbook.io/7tetl](https://engin.gitbook.io/7tetl).

---

## Table of Contents

* [About the Project](#about-the-project)
* [Technologies](#technologies)
* [Project Structure](#project-structure)
* [How to Run Tests](#how-to-run-tests)
* [Examples / What You’ll Learn](#examples--what-youll-learn)
* [Author / Resources](#author--resources)

---

## About the Project

This repository serves as an educational resource for **unit testing** in Java. It demonstrates:

* Writing **simple tests** with JUnit
* Using **parameterized tests** to test multiple inputs at once
* Applying **jqwik** to generate test data (property testing)
* Using **Mockito** to simulate (mock) dependencies

The goal is to showcase modern testing techniques and extend beyond basic unit testing.

---

## Technologies

* **Java**
* **JUnit 5**
* **jqwik**
* **Mockito**
* **Maven** (dependency management, test execution)

---

## Project Structure

```
.
├── .gitignore
├── pom.xml
├── README.md
└── src
    └── main
        └── java
            └── … (production code, if any)
    └── test
        ├── java
            └── … (test classes: JUnit tests, jqwik tests, Mockito, etc.)
```

* `pom.xml` — Maven configuration file
* `src/test/java` — contains all test classes

---

## How to Run Tests

1. Make sure you have **Java JDK** installed (version compatible with the project)
2. Navigate to the project root folder
3. Run the tests using Maven:

```bash
mvn test
```

This will execute all tests (JUnit, jqwik) and display which tests passed or failed.

---

## Examples / What You’ll Learn

* How to write **parameterized tests** with different inputs, without duplicating code
* How to use **jqwik** to generate random or combinatorial values for property testing
* How to **mock dependencies** using Mockito to isolate the tested code from external dependencies
* How to structure your tests to be clear, maintainable, and well‑covered

---

## Author / Resources

* Repository originally created by **Marek Vajgl** as a study source for KIP/7TETL course at University of Ostrava ([github.com](https://github.com/Engin1980/7tetl-unit-testing-tutorial))
* Related course / materials available at: [https://engin.gitbook.io/7tetl](https://engin.gitbook.io/7tetl) ([github.com](https://github.com/Engin1980/7tetl-unit-testing-tutorial))
* Have improvements or suggestions? Feel free to open a pull request or an issue.

---

*(Note: This README can be customized to include specific test class details, sample outputs, or code snippets.)*
