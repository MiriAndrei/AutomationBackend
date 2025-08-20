package tests;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.requestSpecification;

public class GetAllBooksTest {

    @Test

    public void testMethod(){

        RequestSpecification request = RestAssured.given();
        request.baseUri("https://demoqa.com");

        Response response = request.get("/BookStore/v1/Books");
        System.out.println(response.getStatusLine());
        response.getBody().prettyPrint();

        Assert.assertEquals(response.getStatusCode(),200);
        Assert.assertTrue(response.getStatusLine().contains("OK"));
    }
}
