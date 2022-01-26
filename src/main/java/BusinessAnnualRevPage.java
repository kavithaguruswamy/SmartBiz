package main.java;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import main.resources.CommonUtil;
import main.resources.TestBase;

public class BusinessAnnualRevPage extends TestBase {

	public BusinessAnnualRevPage() {
		PageFactory.initElements(driver, this);
	}

	CommonUtil cu = new CommonUtil();

	@FindBy(css = "div#content div:nth-child(3) > div > label > div")
	private WebElement fifty;

	@FindBy(css = "div#content div:nth-child(4) > div > label > div")
	private WebElement lakh;

	@FindBy(css = "div#content div:nth-child(5) > div > label > div")
	private WebElement oneFifty;

	@FindBy(css = "div#content div:nth-child(6) > div > label > div")
	private WebElement twoFifty;

	@FindBy(css = "div#content div:nth-child(7) > div > label > div")
	private WebElement aboveTwoFifty;

	@FindBy(css = "a#password_new_prequal")
	private WebElement continueButton;

	public void validateBuinessRevenuePage() {
		cu.waitForElement(fifty, 2);
		fifty.isDisplayed();
		lakh.isDisplayed();
		oneFifty.isDisplayed();
		twoFifty.isDisplayed();
		aboveTwoFifty.isDisplayed();
		cu.scrollIntoView(continueButton);
		Assert.assertTrue(cu.isButtonDisabled(continueButton), "SubmitButton is not disabled");
		cu.scrollClick(fifty);
		cu.scrollIntoView(continueButton);
		continueButton.isEnabled();
		cu.wait(1);
		cu.scrollClick(continueButton);
		Assert.assertTrue(cu.getUrl().contains("apply/prequalify/business/password"),
				"Business password page is not visible");
	}

}
