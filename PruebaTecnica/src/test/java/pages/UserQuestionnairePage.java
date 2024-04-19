package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import pom.Base;

public class UserQuestionnairePage  extends Base {

	public UserQuestionnairePage(WebDriver driver) {
		super(driver);
	}
	
	private By heightInput = By.id("txtHeight");
	private By weightInput = By.id("txtWeight");
	private By mainTitle =  By.className("title");
	private By saveButton = By.id("btnSaveStep2");
	private By radioButtonToClick = By.xpath("//input[@type='radio' and @name='UnderwritingCustom[1].ResponseBool' and @value='true']");

	
	public String getMainTitleText() {
		return this.getText(mainTitle);
	}
	
	public void checkAssistanceNeededRadioButton() {
		this.click(radioButtonToClick);
	}
	
	public void fillHeightInput(String value) {
		this.write(heightInput, "180");
	}
	
	public void fillWeightInput(String value) {
		this.write(weightInput, "70");
	}
	
	public String getHeightInputValue() {
	    return this.getAttribute(heightInput, "value");
	}
	
	public String getWeightInputValue() {
	    return this.getAttribute(weightInput, "value");
	}
	
	public void saveForm() {
		this.click(saveButton);
	}

}
