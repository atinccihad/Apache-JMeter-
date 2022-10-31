package get_request;

import base_urls.AutoBaseUrl;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

public class Q02 extends AutoBaseUrl {

    @Test
    public void get02() {
        // https://automationexercise.com/api/getUserDetailByEmail
        spec.pathParam("first", "getUserDetailByEmail");

        given().spec(spec).when().get("/{first}");

        Response response = given().spec(spec).when().get("/{first}");

        JsonPath json = response.jsonPath();

        assertEquals(200, response.statusCode());
        assertEquals(400, json.getInt("responseCode"));
        assertEquals("Bad request, email parameter is missing in GET request.", json.getString("message"));
    }
}
