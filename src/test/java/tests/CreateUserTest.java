package tests;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CreateUserTest {
    @Test

    public void testMethod(){

        RequestSpecification requestSpecification = RestAssured.given();
        requestSpecification.baseUri("https://demoqa.com");
        requestSpecification.header("Content-Type", "application/json");


        JSONObject requestBody = new JSONObject();
        requestBody.put("userName","Andrei" + System.currentTimeMillis());
        requestBody.put("password","Cucu1234!");
        requestSpecification.body(requestBody.toString());


        Response response = requestSpecification.post("/Account/v1/User");


        System.out.println(response.getStatusLine());
        response.getBody().prettyPrint();

        Assert.assertEquals(response.getStatusCode(),201);
        Assert.assertTrue(response.getStatusLine().contains("Created"));
    }
}
