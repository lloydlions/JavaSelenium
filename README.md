# Java Test Automation Framework 🚀

This is a **Java Test Automation Framework** built with:

- [JUnit 5](https://junit.org/junit5/) – Test framework
- [Selenium WebDriver](https://www.selenium.dev/) – Browser automation
- [WebDriverManager](https://github.com/bonigarcia/webdrivermanager) – Auto-downloads browser drivers
- [Allure](https://docs.qameta.io/allure/) – Beautiful test reporting

---

## 📦 Project Structure

```
.
├── pom.xml                       # Maven build file
├── src
│   ├── main
│   │   └── java                  # (Optional business logic if needed)
│   └── test
│       └── java
│           └── parabank
│               ├── pages         # Page Object classes
│               └── test          # Test classes
└── target
    ├── surefire-reports           # JUnit/Surefire raw reports
    └── allure-results             # Allure raw JSON results
```

---

## ⚙️ Prerequisites

- Java **21+**
- Maven **3.9+**
- Chrome Browser (latest)
- Git installed

---

## 🔧 Setup

1. Clone the repository:
   ```sh
   git clone https://github.com/<your-repo>/0822-JavaTesAutomation.git
   cd 0822-JavaTesAutomation
   ```

2. Run Maven tests:
   ```sh
   mvn clean test
   ```

   ✅ This will:
    - Download dependencies
    - Run Selenium tests
    - Generate raw Allure results under `target/allure-results`

---

## 📊 Allure Reports

1. To view the report:
   ```sh
   mvn allure:serve
   ```
   This will:
    - Generate the HTML report
    - Start a local server
    - Open report in your browser automatically

2. To generate static report:
   ```sh
   mvn allure:report
   ```
   Report will be available at:
   ```
   target/site/allure-maven-plugin/index.html
   ```

---

## 🧪 Writing Tests

A typical test uses **Page Object Model (POM)** and looks like this:

```java
import io.qameta.allure.Description;
import org.junit.jupiter.api.Test;
import parabank.pages.LoginPage;

public class TestParabank {

    @Test
    @Description("Verify that a user can login and see accounts overview")
    public void testAccountsOverview() {
        LoginPage login = new LoginPage();
        login.open();
        login.login("john", "demo");
        login.verifyWelcomeMessage();
    }
}
```

---

## ✅ Running Only Specific Tests

Run a single test class:
```sh
mvn test -Dtest=TestParabank
```

Run a single method:
```sh
mvn test -Dtest=TestParabank#testAccountsOverview
```

---

## 🐞 Troubleshooting

- **No `allure-results` folder created**  
  Ensure:
    - Allure dependencies are `test` scoped in `pom.xml`
    - Surefire plugin has system property set:
      ```xml
      <allure.results.directory>${project.build.directory}/allure-results</allure.results.directory>
      ```
    - Run `mvn clean test` before checking `target/allure-results`

- **Selenium NoSuchElementException**  
  Element may load slowly → add explicit waits in your Page Object.

---

## 📌 Roadmap

- [ ] Add RestAssured for API testing
- [ ] Add Integrated CI/CD with GitHub Actions
- [ ] Add video recording of test runs
- [ ] Extend Allure with screenshots on failure

