package PageLibrary;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

import com.Deltax.testbase.TestBase;



public class SignIn extends TestBase{
	WebDriver driver;
	static Logger log = Logger.getLogger(SignIn.class.getName());
	public By FirstName=By.xpath("//*[contains(@name,'first_name')]");
	public By LastName=By.xpath("//*[contains(@name,'last_name')]");
	public By Department=By.xpath("//*[contains(@name,'department')]");
	public By Username =By.xpath("//*[contains(@name,'user_name')]");
	public By Password=By.xpath("//*[contains(@name,'user_password')]");
	public By ConfirmPassword=By.xpath("//*[contains(@name,'confirm_password')]");
	public By email=By.xpath("//*[contains(@name,'email')]");
	public By ContactNo=By.xpath("//*[contains(@name,'contact_no')]");
	public By Submit=By.xpath("//*[contains(@type,'submit')]");
	public By EmptyFirstNameMessage=By.xpath("//small[text()='Please enter your First Name']");
	public By EmptyLastNameMessage=By.xpath("//small[text()='Please enter your Last Name']");
	public By EmptyUserNameMessage=By.xpath("//small[text()='Please enter your Username']");
	public By EmptyPasswordMessage=By.xpath("//small[text()='Please enter your Password']");
	public By EmptyConfirmPasswordMessage=By.xpath("//small[text()='Please confirm your Password']");
	public By EmptyEmailMessage=By.xpath("//small[text()='Please enter your Email Address']");
	public By SuccessMessage=By.xpath("//*[contains(@id,'contact_form')]/fieldset/legend/center/h2/b");
	
	public SignIn(WebDriver driver){
		this.driver = driver;
	}
	/**
	 * This method will enter Valid First Name
	 */
	public void EnterValidFirstName(){
		log.info("Entering Valid First Name");
		driver.findElement(FirstName).sendKeys(Repository.getProperty("validfirstname"));	
	}
	/**
	 * This method will enter InValid First Name
	 */
	public void EnterInvalidFirstName(){
		log.info("Entering InValid First Name");
		driver.findElement(FirstName).sendKeys(Repository.getProperty("invalidfirstname"));	
	}
	/**
	 * This method will enter Valid Last Name
	 */
	public void EntervalidLastName(){
		log.info("Entering Valid Last Name");
		driver.findElement(LastName).sendKeys(Repository.getProperty("validlastname"));	
	}
	/**
	 * This method will enter InValid Last Name
	 */
	public void EnterInvalidLastName(){
		log.info("Entering InValid Last Name");
		driver.findElement(LastName).sendKeys(Repository.getProperty("invalidlastname"));	
	}
	/**
	 * This method will Select Department
	 */
	public void SelectDepartment(){
		log.info("Selecting Department");
		Select department= new Select(driver.findElement(Department));
		department.selectByVisibleText("Engineering");		
	}
	/**
	 * This method will enter Valid User Name
	 */
	public void EntervalidUserName(){
		log.info("Entering Valid User Name");
		driver.findElement(Username).sendKeys(Repository.getProperty("validusername"));	
	}
	/**
	 * This method will enter InValid User Name
	 */
	public void EnterInvalidUserName(){
		log.info("Entering Valid User Name");
		driver.findElement(Username).sendKeys(Repository.getProperty("invalidusername"));	
	}
	/**
	 * This method will enter Valid Password
	 */
	public void EntervalidPassword(){
		log.info("Entering Valid Password");
		driver.findElement(Password).sendKeys(Repository.getProperty("validpassword"));	
	}
	/**
	 * This method will enter InValid Password
	 */
	public void EnterInvalidPassword(){
		log.info("Entering InValid Password");
		driver.findElement(Password).sendKeys(Repository.getProperty("invalidpassword"));	
	}
	/**
	 * This method will enter Valid Confirm Password
	 */
	public void EntervalidConfirmPassword(){
		log.info("Entering Valid Confirm Password");
		driver.findElement(ConfirmPassword).sendKeys(Repository.getProperty("validconfirmpassword"));	
	}
	/**
	 * This method will enter InValid Confirm Password
	 */
	public void EnterInvalidConfirmPassword(){
		log.info("Entering InValid Confirm Password");
		driver.findElement(ConfirmPassword).sendKeys(Repository.getProperty("invalidconfirmpassword"));	
	}
	/**
	 * This method will enter Valid Email
	 */
	public void EntervalidEmail(){
		log.info("Entering Valid Email");
		driver.findElement(email).sendKeys(Repository.getProperty("validemailid"));	
	}
	/**
	 * This method will enter InValid Email
	 */
	public void EnterInvalidEmail(){
		log.info("Entering InValid Email");
		driver.findElement(email).sendKeys(Repository.getProperty("invalidemailid"));	
	}
	/**
	 * This method will enter Valid ContactNo
	 */
	public void EntervalidContactNo(){
		log.info("Entering Valid Contact No");
		driver.findElement(ContactNo).sendKeys(Repository.getProperty("validContactNo"));	
	}
	/**
	 * This method will enter InValid ContactNo
	 */
	public void EnterInvalidContactNo(){
		log.info("Entering InValid Contact No");
		driver.findElement(ContactNo).sendKeys(Repository.getProperty("invalidcontactno"));	
	}
	/**
	 * This method will click on Submit Button
	 * @return 
	 */
	public void ClickSubmit(){
		log.info("Clicking on Submit Button");
		driver.findElement(Submit).click();
			
	}
	public boolean VerifySuccessMessage() {
		try {
			log.info("Verifying Success Message");
			 driver.findElement(SuccessMessage).isDisplayed();
			 return true;
		} catch (Exception e) {
			
			e.printStackTrace();
			
		}
		return false;
	}
		
		
		public boolean VerifyEmptyFirstNameErrorMessage() {
			try {
				log.info("Verifying Error Message");
				 driver.findElement(EmptyFirstNameMessage).isDisplayed();
				 return true;
			} catch (Exception e) {
				
				e.printStackTrace();
			}
			return false;
	}
		public boolean VerifyEmptyLastNameErrorMessage() {
			try {
				log.info("Verifying Error Message");
				 driver.findElement(EmptyLastNameMessage).isDisplayed();
				 return true;
			} catch (Exception e) {
				
				e.printStackTrace();
			}
			return false;
	}
		public boolean VerifyEmptyUserNameErrorMessage() {
			try {
				log.info("Verifying Error Message");
				 driver.findElement(EmptyUserNameMessage).isDisplayed();
				 return true;
			} catch (Exception e) {
				
				e.printStackTrace();
			}
			return false;
	}
		public boolean VerifyEmptyPasswordErrorMessage() {
			try {
				log.info("Verifying Error Message");
				 driver.findElement(EmptyPasswordMessage).isDisplayed();
				 return true;
			} catch (Exception e) {
				
				e.printStackTrace();
			}
			return false;
	}
		public boolean VerifyEmptyConfirmPasswordErrorMessage() {
			try {
				log.info("Verifying Error Message");
				 driver.findElement(EmptyConfirmPasswordMessage).isDisplayed();
				 return true;
			} catch (Exception e) {
				
				e.printStackTrace();
			}
			return false;
	}
		public boolean VerifyEmptyEmailErrorMessage() {
			try {
				log.info("Verifying Error Message");
				 driver.findElement(EmptyEmailMessage).isDisplayed();
				 return true;
			} catch (Exception e) {
				
				e.printStackTrace();
			}
			return false;
	}
}
