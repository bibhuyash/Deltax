package TestScript;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.Deltax.testbase.TestBase;

import PageLibrary.SignIn;

public class TC015_UnsuccessfulRegistration_InvalidContactNo extends TestBase {
	SignIn signIn;

	@BeforeClass
	public void setUP() throws IOException{
		init();
	}
	@Test
	public void UnSuccessfulRegistration_InvalidContactNo() throws InterruptedException{
		signIn= new SignIn(driver); 
		signIn.EnterValidFirstName();
		waitFor(2);
		signIn.EntervalidLastName();
		waitFor(2);
		signIn.SelectDepartment();
		waitFor(2);
		signIn.EntervalidUserName();
		waitFor(2);
		signIn.EntervalidPassword();
		waitFor(2);
		signIn.EntervalidConfirmPassword();
		waitFor(2);
		signIn.EntervalidEmail();
		waitFor(2);
		signIn.EnterInvalidContactNo();
		waitFor(2);

		boolean issucess= signIn.VerifySuccessMessage();
		if(!issucess){
			Assert.assertTrue(false, "Registration is not done for Invalid Contact No.");
		}
		else{
			Assert.assertTrue(true, "Registration is succussfully done");
		}
		
	}
	
	@AfterClass
	public void quitBrowser(){
		CloseBrowser();
		}
}
