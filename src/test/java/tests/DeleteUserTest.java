package tests;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.json.JSONObject;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.BasePage;
import pages.LoginPage;
import sharedData.SharedData;

public class DeleteUserTest extends SharedData {



    @Test

    public void testMethod(){
        System.out.println("==Step 1:Create User==");

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

        String userId = response.path("userID");
        System.out.println(userId);

        System.out.println("==Step 2: Generate Token==");

         response = requestSpecification.post("/Account/v1/GenerateToken");
        System.out.println(response.getStatusLine());
        response.getBody().prettyPrint();

        Assert.assertEquals(response.getStatusCode(),200);
        Assert.assertTrue(response.getStatusLine().contains("OK"));
        String token = response.path("token");

        System.out.println("==Step 3: Get User==");
        requestSpecification.header("Authorization", "Bearer "+token);
        response = requestSpecification.get("/Account/v1/User/"+userId);
        System.out.println(response.getStatusLine());
        response.getBody().prettyPrint();


        System.out.println("=== Step 4: Delete User ===");
//        requestSpecification.header("Authorization", "Bearer "+token);
        response = requestSpecification.delete("/Account/v1/User/"+userId);

        System.out.println(response.getStatusLine());
        response.getBody().prettyPrint();

        Assert.assertEquals(response.getStatusCode(),204);
        Assert.assertTrue(response.getStatusLine().contains("No Content"));

        System.out.println("==Step 5: Get User==");
//        requestSpecification.header("Authorization", "Bearer "+token);
        response = requestSpecification.get("/Account/v1/User/"+userId);
        System.out.println(response.getStatusLine());
        response.getBody().prettyPrint();

        Assert.assertEquals(response.getStatusCode(),401);
        Assert.assertTrue(response.getStatusLine().contains("Unauthorized"));

        LoginPage loginPage = new LoginPage(getDriver());
        loginPage.loginMethod(requestBody.get("userName").toString(),requestBody.get("password").toString());
        loginPage.validateInvalidLogin();






    }
}
