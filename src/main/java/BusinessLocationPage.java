package main.java;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import main.resources.CommonUtil;
import main.resources.TestBase;

public class BusinessLocationPage extends TestBase {

	public BusinessLocationPage() {
		PageFactory.initElements(driver, this);
	}

	CommonUtil cu = new CommonUtil();

	@FindBy(id = "street")
	private WebElement street;

	@FindBy(xpath = "//div[@id='PlacesAutocomplete__root']/div/div")
	private WebElement selectAddress;

	@FindBy(id = "password_new_prequal")
	private WebElement continueButton;

	public void validateBusinessLocationPage() {
		String address = "378 East St, Bloomsburg, PA, USA";
		cu.waitForElement(street, 2);
		street.isDisplayed();
		Assert.assertTrue(cu.isButtonDisabled(continueButton), "SubmitButton is not disabled");
		cu.scrollIntoView(street);
		street.sendKeys(address);
		cu.wait(2);
		cu.hoverClick(selectAddress);
		cu.wait(2);
		cu.scrollClick(continueButton);
		Assert.assertTrue(cu.getUrl().contains("/apply/prequalify/business/entity_type"),
				"business entity_type page is not visible");
	}

}
