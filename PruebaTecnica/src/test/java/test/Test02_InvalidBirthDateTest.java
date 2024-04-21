package test;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;

import pages.HomePage;

public class Test02_InvalidBirthDateTest{
	
    private static final String PAGE_URL = "https://purchase-testing.klimber.com/ar/GroupLife/Index";
    private static final String INVALID_DATE_TEXT = "La fecha que ingresaste es inválida";
    private static final String INVALID_DATE = "31/15/2000";
	
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
	
	@Test
	public void test() throws Exception{
		//Filling the birth date input with an invalid date and trying to save the form
		homePage.fillDateInput(INVALID_DATE);
		homePage.clickSave();
		
		//Checking that the invalid date notification is displayed
		Assert.assertEquals(INVALID_DATE_TEXT, homePage.getNotificationText());
	}

}
