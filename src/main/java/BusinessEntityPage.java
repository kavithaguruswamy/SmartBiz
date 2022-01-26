package main.java;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import main.resources.CommonUtil;
import main.resources.TestBase;

public class BusinessEntityPage extends TestBase {

	public BusinessEntityPage() {
		PageFactory.initElements(driver, this);
	}

	CommonUtil cu = new CommonUtil();

	@FindBy(xpath = "//select[@id='entity_type_id']")
	private WebElement businessEntity;

	@FindBy(id = "password_new_prequal")
	private WebElement continueButton;

	public void validateBusinessEntityPage() {
		cu.waitForElement(businessEntity, 2);
		businessEntity.isDisplayed();
		Assert.assertTrue(cu.isButtonDisabled(continueButton), "SubmitButton is not disabled");
		cu.selectValue(businessEntity, "1");
		cu.scrollIntoView(continueButton);
		continueButton.isEnabled();
		cu.scrollClick(continueButton);
		Assert.assertTrue(cu.getUrl().contains("/apply/prequalify/business/employees"),
				"business employees page is not visible");
	}

}
