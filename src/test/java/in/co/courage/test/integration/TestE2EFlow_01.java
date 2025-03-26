package in.co.courage.test.integration;

import in.co.courage.base.BaseTest;
import in.co.courage.endpoints.APIConstants;
import in.co.courage.pojos.User;
import in.co.courage.pojos.UserResponse;
import io.qameta.allure.Description;
import io.qameta.allure.Owner;
import io.restassured.RestAssured;
import org.testng.Assert;
import org.testng.ITestContext;
import org.testng.annotations.Test;
import static org.assertj.core.api.Assertions.assertThat;

public class TestE2EFlow_01 extends BaseTest {


    //  Test E2E Scenario 1

    //  1. Create a User -> ID

    // 2. Create Token -> token

    // 3. Verify that the Create User is working - GET Request to ID

    // 4. Update the User ( ID, Token) - Need to get the token, ID from above request

    // 5. Delete the User - Need to get the token, ID from above request


    // Create A User, Create a Token
    // Verify that Get User -
    // Update the User
    // Delete the User

    @Test(groups = "qa", priority = 1)
    @Owner("Nagraj")
    @Description("TC#INT1 - Step 1. Verify that the User can be Created")
    public void testCreateBooking(ITestContext iTestContext){

        requestSpecification.basePath(APIConstants.CREATE_UPDATE_USER_URL);
        response = RestAssured.given(requestSpecification)
                .when().body(payloadManager.createPayloadBookingAsString())
                .post();
        validatableResponse = response.then().log().all();
        validatableResponse.statusCode(201);
        UserResponse userResponse = payloadManager.userResponse(response.asString());
        assertActions.verifyStringKey(userResponse.getName(), "Nagraj");
        assertActions.verifyStringKeyNotNull(userResponse.getId());

        iTestContext.setAttribute("id", userResponse.getId());




    }

    @Test(groups = "qa", priority = 2)
    @Owner("Nagraj")
    @Description("TC#INT1 - Step 2. Verify that the User By ID")
    public void testVerifyId(ITestContext iTestContext){
        Integer id = (Integer) iTestContext.getAttribute("id");


        // GET Request - to verify that the firstname after creation is James
        String basePathGET = APIConstants.CREATE_UPDATE_USER_URL+"/" + id;
        System.out.println(basePathGET);

        requestSpecification.basePath(basePathGET);
        response = RestAssured
                .given(requestSpecification)
                .when().get();
        validatableResponse = response.then().log().all();
        // Validatable Assertion
        validatableResponse.statusCode(201);

        User user = payloadManager.getResponseFromJSON(response.asString());
        assertThat(user.getName()).isNotNull().isNotBlank();
        assertThat(user.getName()).isEqualTo("Nagraj");




    }

    @Test(groups = "qa", priority = 3)
    @Owner("Nagraj")
    @Description("TC#INT1 - Step 3. Verify Updated User by ID")
    public void testUpdateUserByID(ITestContext iTestContext){

        Integer id = (Integer) iTestContext.getAttribute("id");
        String token = getToken();
        iTestContext.setAttribute("token",token);

        String basePathPUTPATCH = APIConstants.CREATE_UPDATE_USER_URL + "/" + id;
        System.out.println(basePathPUTPATCH);

        requestSpecification.basePath(basePathPUTPATCH);

        response = RestAssured
                .given(requestSpecification).cookie("token", token)
                .when().body(payloadManager.fullUpdatePayloadAsString()).put();


        validatableResponse = response.then().log().all();
        // Validatable Assertion
        validatableResponse.statusCode(201);

        User user = payloadManager.getResponseFromJSON(response.asString());

        assertThat(user.getName()).isNotNull().isNotBlank();
        assertThat(user.getName()).isEqualTo("Rupesh");




    }

    @Test(groups = "qa", priority = 4)
    @Owner("Nagraj")
    @Description("TC#INT1 - Step 4. Delete the User by ID")
    public void testDeleteUserById(ITestContext iTestContext){

        String token = (String)iTestContext.getAttribute("token");
        Integer id = (Integer) iTestContext.getAttribute("id");

        String basePathDELETE = APIConstants.CREATE_UPDATE_USER_URL + "/" + id;

        requestSpecification.basePath(basePathDELETE).cookie("token", token);
        validatableResponse = RestAssured.given().spec(requestSpecification)
                .when().delete().then().log().all();
        validatableResponse.statusCode(200);


    }




}

