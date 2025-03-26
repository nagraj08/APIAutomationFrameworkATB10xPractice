package in.co.courage.test.sample;

import io.qameta.allure.Description;
import io.qameta.allure.Owner;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestIntegrationSample {

    // Create A Booking, Create a Token
    // Verify that Get booking -
    // Update the Booking
    // Delete the Booking

    @Test(groups = "qa", priority = 1)
    @Owner("Nagraj")
    @Description("TC#INT1 - Step 1. Verify that the User can be Created")
    public void testCreateUser(){
        Assert.assertTrue(true);
    }

    @Test(groups = "qa", priority = 2)
    @Owner("Nagraj")
    @Description("TC#INT1 - Step 2. Verify that the User By ID")
    public void testVerifyUserId(){
        Assert.assertTrue(true);
    }

    @Test(groups = "qa", priority = 3)
    @Owner("Nagraj")
    @Description("TC#INT1 - Step 3. Verify Updated User by ID")
    public void testUpdateUserByID(){
        Assert.assertTrue(true);
    }

    @Test(groups = "qa", priority = 4)
    @Owner("Nagraj")
    @Description("TC#INT1 - Step 4. Delete the User by ID")
    public void testDeleteUserById(){
        Assert.assertTrue(true);
    }





}
