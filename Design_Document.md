# Test Framework Design

## Framework Type

Page Object Model (POM)

---

## Features

* Config-driven execution using `config.properties`
* FluentWait for handling dynamic elements (no Thread.sleep)
* Reusable Page classes following POM design
* WebDriverManager for automatic driver setup
* Screenshot capture on test failure using TestNG Listener
* ExtentReports for HTML reporting
* Centralized BasePage for common actions
* Clean separation of Test, Page, and Utility layers

---

## Test Coverage

* Form Interactions
* Table Operations
* Alerts and Dialogs
* Dynamic Elements
* Frames Handling

---

## Tools & Technologies

* Java
* Selenium WebDriver
* TestNG
* Maven
* WebDriverManager
* ExtentReports

---

## Design Highlights

* No hardcoded values — all configurable via properties
* No Thread.sleep — uses FluentWait for stability
* Reusable and scalable framework structure
* Test classes contain only test logic (no WebDriver code)
* Page classes contain all locators and actions

---

## Project Structure
```
AdminPanel
│
├── src/main/java
│   ├── com.srm.base
│   │   ├── BasePage.java
│   │   └── BaseTest.java
│   │
│   ├── com.srm.driver
│   │   └── DriverFactory.java
│   │
│   ├── com.srm.listeners
│   │   └── TestListener.java
│   │
│   ├── com.srm.pages
│   │   ├── AlertPage.java
│   │   ├── DynamicPage.java
│   │   ├── FormPage.java
│   │   ├── FramePage.java
│   │   └── TablePage.java
│   │
│   ├── com.srm.utils
│   │   ├── ConfigReader.java
│   │   ├── ExtentManager.java
│   │   ├── ScreenshotUtil.java
│   │   └── WaitUtils.java
│
├── src/main/resources
│   └── config.properties
│
├── src/test/java
│   └── com.srm.tests
│       ├── AlertTest.java
│       ├── DynamicTest.java
│       ├── FormTest.java
│       ├── FrameTest.java
│       └── TableTest.java
│
├── reports
│   
│
├── screenshots
│   
│
├── testng.xml
├── pom.xml
```
