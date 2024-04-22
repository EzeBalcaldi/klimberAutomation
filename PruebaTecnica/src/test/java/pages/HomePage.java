package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import pom.Base;

public class HomePage extends Base{
		
	public HomePage(WebDriver driver) {
		super(driver);
	}
	
	private By slider = By.className("slider");
	private By btnSave = By.id("btnSaveStep1");
	private By phoneCodeInput = By.id("txtPhoneCode");
	private By birthdateInput = By.id("BirthdayStep1");
	private By cellphoneInput = By.id("txtPhoneNumber");
	private By notificationText = By.className("ui-pnotify-text");
	private By provinceDropdown = By.id("select2-province-container");
	private By provinceInput = By.className("select2-results__option");
	private By closeNotificationPopup = By.className("brighttheme-icon-closer");
	
	public void fillDateInput(String value) {
		this.write(birthdateInput, value);
	}
	
	public void fillDateInputWithEnter(String value) {
		this.write(birthdateInput, value);
		this.sendKey(birthdateInput, Keys.ENTER);
	}
	
	public void fillCellphoneInputs(String phoneCode, String number) {
		this.write(phoneCodeInput, phoneCode);
		this.write(cellphoneInput, number);
	}
	
	public void selectProvince(String value) {
		this.click(provinceDropdown);
		this.selectListOption(provinceInput, value);
	}
	
	public void selectAssuredSum() {
		this.moveSlider(slider);
	}
	
	public String getConfirmationPriceString() {
		this.waitForSubmitBarTextUpdate(btnSave, this.getText(btnSave));
		return this.getText(btnSave);
	}
	
	public void clickSave() {
		this.click(btnSave);
	}
	
	public String getNotificationText() {
		return this.getText(notificationText);
	}
	
	public void clearCellphoneInput() {
		this.clearInput(cellphoneInput);
	}
	
	public void clearPhoneCodeInput() {
		this.clearInput(phoneCodeInput);
	}
	
	public boolean isCurrentPage(String expectedUrl) {
	    return this.getUrl().equals(expectedUrl);
	}
	
	public void clearDateInput() {
		this.clearInput(birthdateInput);
	}
	
	public void closeNotificationPopup() {
		this.click(closeNotificationPopup);
	}
	
	public boolean isSaveButtonEnabled() {
		return this.isEnabled(btnSave);
	}
}
