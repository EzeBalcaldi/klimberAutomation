package test;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;

import pages.HomePage;

public class Test05_SaveButtonEnabledAfterProvinceSelection {
	
    private static final String PAGE_URL = "https://purchase-testing.klimber.com/ar/GroupLife/Index";
	
    // WebDriver instance and Page Objects 
	private WebDriver driver;
	private HomePage homePage;
	private String[] provinces = {"CABA", "Buenos Aires", "Córdoba", "Mendoza", "Misiones", "Salta", "San Juan", "Jujuy", "Santa Cruz", "Santiago del Estero", "Tierra del Fuego", "Tucumán", "Catamarca", "Chubut"};
	
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
	
	// Test case: Verifying that the save button remains enabled after selecting each province in the list.
	@Test
	public void test() throws Exception{
		//Filling date and province input with a valid data
		homePage.fillDateInput("20/01/2000");
		homePage.fillCellphoneInputs("10", "202020");
		
		//Iterating every province that is available in the list, and checking that the save button is enabled for each one of them.
		for(int i = 0; i < provinces.length; i++) {
			homePage.selectProvince(provinces[i]);
			Assert.assertTrue(homePage.isSaveButtonEnabled());
		}
	}

}
