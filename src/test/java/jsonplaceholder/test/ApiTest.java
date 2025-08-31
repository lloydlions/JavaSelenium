package jsonplaceholder.test;

import base.ApiBaseTest;
import io.restassured.response.Response;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ApiTest extends JpBaseApi {
    @Test
    public void testGetPosts() {
        Response response = ApiBaseTest.getRequest("/posts");
        System.out.println(response.asString());
        assertEquals(200, response.statusCode());
        assertEquals(100, response.jsonPath().getList("$").size());
    }

    @Test
    public void testCreatePost() {
        String newPost = "{ \"title\": \"foo\", \"body\": \"bar\", \"userId\": 1 }";

        Response response = ApiBaseTest.postRequest("/posts", newPost);
        System.out.println(response.asString());
        assertEquals(201, response.statusCode());
        assertEquals("foo", response.jsonPath().getString("title"));
    }
}
