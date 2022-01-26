package main.java;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import main.resources.CommonUtil;
import main.resources.TestBase;

public class BusinessPasswordPage extends TestBase {

	public BusinessPasswordPage() {
		PageFactory.initElements(driver, this);
	}

	CommonUtil cu = new CommonUtil();

	@FindBy(id = "password")
	private WebElement businessPassword;

	@FindBy(id = "password_new_prequal")
	private WebElement continueButton;

	String password = "Test123!";

	public void validateBusinessPasswordPage() {
		cu.waitForElement(businessPassword, 2);
		businessPassword.isDisplayed();
		Assert.assertTrue(cu.isButtonDisabled(continueButton), "SubmitButton is not disabled");
		cu.scrollIntoView(businessPassword);
		businessPassword.sendKeys(password);
		continueButton.isEnabled();
		cu.click(continueButton);
		Assert.assertTrue(cu.getUrl().contains("/apply/prequalify/owners"), "business owners page is not visible");
	}

}
