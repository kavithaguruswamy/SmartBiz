package main.java;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import main.resources.CommonUtil;
import main.resources.TestBase;

public class FinancePage extends TestBase {

	public FinancePage() {
		PageFactory.initElements(driver, this);
	}

	CommonUtil cu = new CommonUtil();

	@FindBy(css = "div#content div:nth-child(1) > label > div")
	private WebElement lessTime;

	@FindBy(css = "div#content div:nth-child(3) > label > div")
	private WebElement flexTime;

	@FindBy(css = "div#content div:nth-child(3) > label > div")
	private WebElement noSpecTime;

	@FindBy(id = "financial_needs_new_prequal")
	private WebElement continueButton;

	public void validateFinancePage() {
		cu.waitForElement(lessTime, 2);
		lessTime.isDisplayed();
		flexTime.isDisplayed();
		noSpecTime.isDisplayed();
		Assert.assertTrue(cu.getUrl().contains("apply/prequalify/financing_needs"), "Finance page is not visible");
		Assert.assertTrue(cu.isButtonDisabled(continueButton), "SubmitButton is not disabled");
		cu.scrollClick(flexTime);
		continueButton.isEnabled();
		cu.click(continueButton);
		Assert.assertTrue(cu.getUrl().contains("/apply/prequalify/business/inception_date"),
				"Prequalify page is not visible");
	}

}
