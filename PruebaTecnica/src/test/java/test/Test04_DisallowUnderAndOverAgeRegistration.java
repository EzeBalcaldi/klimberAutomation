package test;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;

import pages.HomePage;

public class Test04_DisallowUnderAndOverAgeRegistration {
	
    private static final String PAGE_URL = "https://purchase-testing.klimber.com/ar/GroupLife/Index";
    private static final String OVER_AGE_TEXT = "Por el momento, la edad máxima de contratación es 64 años";
    private static final String OVER_AGE_VALUE = "21/04/1959";
    private static final String UNDER_AGE_TEXT = "Por el momento, la edad mínima de contratación es 18 años";
    private static final String UNDER_AGE_VALUE = "21/05/2006";
	
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
		driver.quit();
	}
	
	// Test case: Verifying that notifications are displayed when attempting to register with ages under 18 or over 64.
	@Test
	public void test() throws Exception{
		//Filling the birth date input with a over 18 years old age to check the notification is displayed, and adding some dummy data to the other fields.
		homePage.fillDateInput(OVER_AGE_VALUE);
		homePage.fillCellphoneInputs("294", "102545");
		homePage.selectProvince("Chubut");
		
		//Checking that the over age notification is displayed
		Assert.assertEquals(OVER_AGE_TEXT, homePage.getNotificationText());
		
		//Closing the past notification, and clearing the Date Input.
		homePage.closeNotificationPopup();
		homePage.clearDateInput();
		
		//Filling the birth date input with a under 18 years old age to check the notification is displayed
		homePage.fillDateInputWithEnter(UNDER_AGE_VALUE);
		
		//Checking that the over age notification is displayed
		Assert.assertEquals(UNDER_AGE_TEXT, homePage.getNotificationText());
	}
}

