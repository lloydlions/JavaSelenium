package jsonplaceholder.test;

import io.restassured.RestAssured;
import org.example.util.ConfigLoader;
import org.junit.jupiter.api.BeforeAll;

public class JpBaseApi {

    @BeforeAll
    public static void setup() {
        RestAssured.baseURI = ConfigLoader.getProperty("JSONPLACEHOLDER_API");
    }
}
