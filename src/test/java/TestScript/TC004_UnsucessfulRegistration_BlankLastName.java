package TestScript;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.Deltax.testbase.TestBase;

import PageLibrary.SignIn;

public class TC004_UnsucessfulRegistration_BlankLastName extends TestBase {
	SignIn signIn;

	@BeforeClass
	public void setUP() throws IOException{
		init();
	}
	@Test
	public void UnSuccessfulRegistration_BlankLastName() throws InterruptedException{
		signIn= new SignIn(driver); 
		signIn.EnterValidFirstName();
		waitFor(1);
		signIn.SelectDepartment();
		waitFor(1);
		signIn.EntervalidUserName();
		waitFor(1);
		signIn.EntervalidPassword();
		waitFor(1);
		signIn.EntervalidConfirmPassword();
		waitFor(1);
		signIn.EntervalidEmail();
		waitFor(1);
		signIn.EntervalidContactNo();
		waitFor(1);
		signIn.ClickSubmit();
		waitFor(1);

		boolean issucess= signIn.VerifyEmptyLastNameErrorMessage();
		if(issucess){
			Assert.assertTrue(true, "Registration is not done without Last name");
		}
		else{
			Assert.assertTrue(false, "Registration is succussfully done");
		}
		
	}
	
	@AfterClass
	public void quitBrowser(){
		CloseBrowser();
		}


}
