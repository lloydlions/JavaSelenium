package parabank.test;

import io.qameta.allure.Allure;
import io.qameta.allure.junit5.AllureJunit5;
import org.example.framework.DriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.extension.ExtendWith;

@ExtendWith(AllureJunit5.class)
public abstract class BaseTest {

    @BeforeEach
    public void setup(){
        DriverManager.getDriver();
        Allure.step("Test started");
    }

    @AfterEach
    public void teardown(){
        DriverManager.quitDriver();
    }

}
