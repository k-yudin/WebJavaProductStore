# UI Web Automated Tests

## Java + Selenide + JUnit + Maven + Allure

### Installation and run from a terminal

1. Make sure that Java and Maven are installed properly.
2. Specify browser in ```env.properties``` file if necessary, e.g. ```chrome``` or ```firefox``` or ```safari```
3. Clone the project, navigate to project directory from your terminal, run:
```mvn clean test```

### Report

To generate the report (Allure need to be installed beforehand) run: ```allure serve allure-results -h localhost```

Report will be opened in your browser automatically.
