package test;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;

import pages.HomePage;

public class Test03_NoCharactersAllowedInPhoneInputs {
	
    private static final String PAGE_URL = "https://purchase-testing.klimber.com/ar/GroupLife/Index";
    private static final String INVALID_PHONENUMBER = "0102a2";
    private static final String VALID_PHONECODE = "11";
    private static final String ONLY_NUMBERS_TEXT = "Por favor, ingresá solo números.";
    private static final String INVALID_PHONECODE = "aaa";
    private static final String VALID_PHONENUMBER = "012345";
	
    // WebDriver instance and Page Objects 
	private WebDriver driver;
	private HomePage homePage;
	
	@Before
	public void setUp() throws Exception{
		homePage = new HomePage(driver);
		driver = homePage.firefoxConnection();
		driver.manage().window().maximize();
		homePage.goToPage(PAGE_URL);
	}
	
	// Post-test configs
	@After
	public void tearDown() throws Exception{
		//driver.quit();
	}
	
	@Test
	public void test() throws Exception{
		//Filling date and province input with a valid data
		homePage.fillDateInput("20/01/2000");
		homePage.selectProvince("Misiones");
		
		//Filling phone number with an invalid number and a valid phoneCode, and trying to save.
		homePage.fillCellphoneInputs(VALID_PHONECODE, INVALID_PHONENUMBER);
		homePage.clickSave();
		Assert.assertEquals(ONLY_NUMBERS_TEXT, homePage.getNotificationText());
		
		//Clearing both phone code and phone numbers fields
		homePage.clearCellphoneInput();
		homePage.clearPhoneCodeInput();
		
		//Filling the fields with a invalid phone code, and a valid phone number
		homePage.fillCellphoneInputs(INVALID_PHONECODE, VALID_PHONENUMBER);
		
		// Have to save twice because it seems like after filling a field with invalid data and then correcting it, the page does not register the change until you perform an action outside the field
		homePage.clickSave();
		homePage.clickSave();
		Assert.assertTrue("The page allows you to save even though there is an invalid format in phone code input", homePage.isCurrentPage(PAGE_URL));

	}
}
