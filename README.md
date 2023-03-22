## :question: What is this Repository about?

This project is the outcome of my self-learning about the using  Page Object Model design pattern with Selenium WebDriver. 

## Why do we need POM?   

The main advantage of POM is to reduce the maintenance when the locator changes or new functionality is being added to a page


## :briefcase: What does this repo contain?
- This repo contains example codes of Page Object Model framework built using  Selenium WebDriver, TestNG, Gradle, Intelij
- [TestNG](https://testng.org/doc/) Listeners are used to capture the events in logs
- [Logback](https://logback.qos.ch/) is used to capture logs.

##  :hammer_and_wrench: How to run the Tests?
### 1. TestNG:
    - Right-Click on the `src/test/resources/testng.xml` and select `Run`
### How to run the test files from command line
`./gradlew clean test --tests "demo.priceless.test.TestGoogleSearch" -Dbrowser=chrome`. 

`./gradlew clean test --tests "demo.priceless.test.TestGoogleSearch" -Dbrowser=firefox`. 


## Test results reporting:
To Open Allure report from the command line:
- `./gradlew allureServe`


## :writing_hand: Overview of modules: 


- **Driver Management** – Managing your choice of browser/driver capabilities and related configuration
- **Configuration Management** – Setting configurations for your project which can be used across the framework code
- **Loggers** – Logging capability of the framework
- **Test Data Management** – Managing static test data as well as for multiple environments
- **Utilities** – Providing file read-write utilities, DB utilities and common methods etc.
- **POM design pattern** – Designing Page Object Model for your application
- - **Creating an Abstract Base Page Class** – Abstract base page class will be a superclass for all POM pages; it will have common functionalities used across the pages
- - **Creating an Abstract Base Test class** – Abstract base test class will be a superclass for all test files; it will have driver initialization, navigating to launch Urls and will have common functionalities used across the test classes
- **Testing framework** – Using TestNG , Junit etc.
- **Reporting** – Creating TestNG reports, Allure reports, and etc.; it will help to understand the errors and debugging them
- **Build Management** – Providing support to compile and run code, e.g., via Maven or Gradle

## :writing_hand: Project structure: 
```
src/main/java
* demo/priceless/test/BaseTest.java - A class extended by all test classes
* demo/priceless/pages/AbstractBasePage.java - A class extended by all page objects
* demo/priceless/utils/ConfigurationManager.java - Managing the configuration
* src/main/java/demo/priceless/utils/DataManager.java - For managing static test data for different environments
* src/main/java/demo/priceless/utils/SummaryReport.java - An implementation of IReporter listener (TestNG) to generate a summary report of the test run
* demo/priceless/webdriver/DriverFactory.java - Creating WebDriver instance
* demo/priceless/webdriver/DriverManager.java - Creating and destroying WebDriver instance
src/main/resources 
* default.properties - A file holding all default configuration
* logback.xml - The configuration for logback

src/test/resources 
* config.properties - The configuration that overrides the default configuration file that comes bundled with the framework
* locators/search-home.properties – A file for storing search homepage web element name and its locator
* locators/search-results.properties – A file for storing search results page web element name and its locator
* testng.xml - A suite of TestNG tests

```

[linkedin]: (https://www.linkedin.com/in/inessag/)
