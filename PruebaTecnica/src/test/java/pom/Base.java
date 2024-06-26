package pom;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Base {
	
	private WebDriver driver;
	
	public Base(WebDriver driver) {
		this.driver = driver;
	}
	
	public WebDriver firefoxConnection() {
		System.setProperty("webdriver.chrome.driver", "../drivers/geckodriver.exe");
		driver = new FirefoxDriver();
		return driver;
	}
	
	public void goToPage(String url) {
		driver.get(url);
	}
	
	public WebElement findElement(By locator) {
		return driver.findElement(locator);
	}
	
	public void write(By locator, String text) {
		new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.visibilityOfElementLocated(locator));
		 driver.findElement(locator).sendKeys(text);
	}
	
	public void click(By locator) {
		new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.elementToBeClickable(locator));
		 driver.findElement(locator).click();
	}
	
	public void selectListOption(By listLocator, String text) {
	    WebElement option = findListOptionByText(listLocator, text);
	    option.click();
	}

	private WebElement findListOptionByText(By listLocator, String text) {
	    String xpath = "//ul[@class='select2-results__options']/li[text()='" + text + "']";
	    WebElement list = driver.findElement(listLocator);
	    return list.findElement(By.xpath(xpath));
	}
	
	public void waitForSubmitBarTextUpdate(By locator, String text) {
		new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.invisibilityOfElementWithText(locator, text));
	}	
	
	public void moveSlider(By locator) {
		new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.elementToBeClickable(locator));
		WebElement e = driver.findElement(locator);
		Actions move = new Actions(driver);
		move.moveToElement(e).clickAndHold().moveByOffset(0,250).release().perform();
	}
	
	public String getText(By locator) {
		new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.visibilityOfElementLocated(locator));
		return driver.findElement(locator).getText();
	}
	
	public boolean isDisplayed(By locator) {
		try {
			return driver.findElement(locator).isDisplayed();
		}catch(org.openqa.selenium.NoSuchElementException e) {
			return false;
		}
	}
	
	public List<WebElement> findElements(By locator){
		return driver.findElements(locator);
	}
	
	public String getAttribute(By locator, String attributeName) {
	    new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.visibilityOfElementLocated(locator));
	    return driver.findElement(locator).getAttribute(attributeName);
	}

	public String getUrl() {
		 return driver.getCurrentUrl();
	}
	
    public void clearInput(By locator) {
        WebElement inputField = driver.findElement(locator);
        String text = inputField.getAttribute("value");
        for (int i = 0; i < text.length(); i++) {
        	this.click(locator);
            inputField.sendKeys(Keys.BACK_SPACE);
        }
    }
    
    public void sendKey(By locator, Keys key) {
        WebElement inputField = driver.findElement(locator);
        inputField.sendKeys(key);
    }
    
    public boolean isEnabled(By locator) {
	    new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.elementToBeClickable(locator));
    	return driver.findElement(locator).isEnabled();
    }
    
}
