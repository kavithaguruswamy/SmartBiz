package main.java;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import main.resources.CommonUtil;
import main.resources.TestBase;

public class BusinessEmployees extends TestBase {

	public BusinessEmployees() {
		PageFactory.initElements(driver, this);
	}

	CommonUtil cu = new CommonUtil();

	@FindBy(id = "bordered-selector-label-option_0")
	private WebElement six;

	@FindBy(id = "bordered-selector-label-option_1")
	private WebElement twelve;

	@FindBy(id = "bordered-selector-label-option_2")
	private WebElement twentyFour;

	@FindBy(id = "bordered-selector-label-option_3")
	private WebElement sixty;

	@FindBy(id = "bordered-selector-label-option_4")
	private WebElement oneTwenty;

	@FindBy(id = "password_new_prequal")
	private WebElement continueButton;

	public void validateBuinessEmployeePage() {
		cu.waitForElement(six, 2);
		six.isDisplayed();
		twelve.isDisplayed();
		twentyFour.isDisplayed();
		sixty.isDisplayed();
		oneTwenty.isDisplayed();
		Assert.assertTrue(cu.isButtonDisabled(continueButton), "SubmitButton is not disabled");
		cu.scrollClick(twentyFour);
		continueButton.isEnabled();
		cu.click(continueButton);
		Assert.assertTrue(cu.getUrl().contains("apply/prequalify/business/annual_revenue"),
				"Business revenue page is not visible");
	}

}
