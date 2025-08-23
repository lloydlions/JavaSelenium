package parabank.test;

import org.example.framework.DriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;

public abstract class BaseTest {

    @BeforeEach
    public void setup(){
        DriverManager.getDriver();
    }

    @AfterEach
    public void teardown(){
        DriverManager.quitDriver();
    }

}
