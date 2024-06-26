# BDD-Selenium-Cucumber

Project is an example of Behavior-Driven Development, with Cucumber setup.

### Libraries used in project
* Selenium
* Maven
* Cucumber
* JUnit

### Installation (prerequisites)

1. JDK
2. Maven
3. IntelliJ
4. IntelliJ Plugins for:
   - Maven
   - Cucumber for Java
   - Gherkin

### Framework set up

* Git:

    *     git clone https://github.com/ajjankowski/BDD-Selenium-Cucumber.git

* Manually :

    * Fork / Clone repository from [here](https://github.com/ajjankowski/BDD-Selenium-Cucumber/archive/refs/heads/main.zip) or download zip and set
      it up in your local workspace.

### Test execution

* Mark "src/test/java" as "Test Sources Root" if needed
* To execute in UI mode comment out "headless" option in the DriverFactory file
* To execute run "TestRunner", Scenario from "src/test/resources" or run Jenkins
* For browser report go to "target/cucumber-report/cucumber.html"
* For Jenkins report configure plugin "Cucumber reports" and run via "Pipeline script from SCM"
