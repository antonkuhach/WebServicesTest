import entity.TypicodeUser;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class RestAssuredTest {
    @BeforeTest
    public void setup() {
        RestAssured.baseURI = "https://jsonplaceholder.typicode.com";
    }

    @Test
    public void checkStatusCodeTest() {
        Response rp = RestAssured.given().get("/users").andReturn();
        int actual = rp.getStatusCode();
        assertEquals(actual, 200);
    }

    @Test
    public void checkResponseHeaderTest() {
        Response rp = RestAssured.given().get("/users").andReturn();
        String actual = rp.getHeader("content-type");
        assertTrue(actual.contains("application/json; charset=utf-8"));
    }

    @Test
    public void checkResponseBodyTest() {
        Response rp = RestAssured.given().get("/users").andReturn();
        TypicodeUser[] users = rp.as(TypicodeUser[].class);
        assertEquals(users.length, 10);
    }
}
