package main.java;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import main.resources.CommonUtil;
import main.resources.TestBase;

public class BusinessIndustryPage extends TestBase {

	public BusinessIndustryPage() {
		PageFactory.initElements(driver, this);
	}

	CommonUtil cu = new CommonUtil();

	@FindBy(id = "business_type_id")
	private WebElement businessDropDown;

	@FindBy(id = "password_new_prequal")
	private WebElement continueButton;

	public void validateBusinessIndustryPage() {
		cu.waitForElement(businessDropDown, 2);
		businessDropDown.isDisplayed();
		Assert.assertTrue(cu.getUrl().contains("/apply/prequalify/business/industry"),
				" business industry is not visible");
		Assert.assertTrue(cu.isButtonDisabled(continueButton), "SubmitButton is not disabled");
		cu.scrollIntoView(businessDropDown);
		cu.selectValue(businessDropDown, "5");
		continueButton.isEnabled();
		cu.click(continueButton);
		Assert.assertTrue(cu.getUrl().contains("/apply/prequalify/business/address"),
				"business address page is not visible");
	}

}
