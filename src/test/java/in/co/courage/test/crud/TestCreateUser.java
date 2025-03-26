package in.co.courage.test.crud;

import in.co.courage.base.BaseTest;
import in.co.courage.endpoints.APIConstants;
import in.co.courage.pojos.UserResponse;
import io.qameta.allure.Description;
import io.qameta.allure.Owner;
import io.qameta.allure.TmsLink;
import io.restassured.RestAssured;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestCreateUser extends BaseTest {

    // Create A Booking, Create a Token
    // Verify that Get booking -
    // Update the Booking
    // Delete the Booking

    @Test(groups = "reg", priority = 1)
    @TmsLink("https://bugz.atlassian.net/browse/TS-1")
    @Owner("Nagraj")
    @Description("TC#INT1 - Step 1. Verify that the Booking can be Created")
    public void testCreateUserPOST() {

       // requestSpecification.basePath(APIConstants.CREATE_UPDATE_USER_URL);
        //requestSpecification.baseUri("https://reqres.in").basePath(APIConstants.CREATE_UPDATE_USER_URL);
        response = RestAssured.given(requestSpecification)
                .when().body(payloadManager.createPayloadBookingAsString())
                .post();
        validatableResponse = response.then().log().all();requestSpecification.basePath(APIConstants.CREATE_UPDATE_USER_URL);
String requestBody = payloadManager.createPayloadBookingAsString();
response = RestAssured.given(requestSpecification)
        .when().body(requestBody)
        .post();
System.out.println("Request URL: " + requestSpecification.baseUri("https://reqres.in") + APIConstants.CREATE_UPDATE_USER_URL);
System.out.println("Request Body: " + requestBody);
System.out.println("Response Status Code: " + response.getStatusCode());
System.out.println("Response Body: " + response.asString());
validatableResponse = response.then().log().all();
validatableResponse.statusCode(201);
        UserResponse userResponse = payloadManager.userResponse(response.asString());
        assertActions.verifyStringKey(userResponse.getName(), "Nagraj");
        assertActions.verifyStringKeyNotNull(userResponse.getId());


    }}
