package tests;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.Test;

public class GetAllBooksTest {

    @Test

    public void testMethod(){

        RequestSpecification request = RestAssured.given();
        Response response = request.get("https://demoqa.com/BookStore/v1/Books");
        System.out.println(response.getStatusLine());
        System.out.println(response.getBody().asString());
    }
}
