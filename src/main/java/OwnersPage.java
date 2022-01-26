package main.java;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import main.resources.CommonUtil;
import main.resources.TestBase;

public class OwnersPage extends TestBase {

	public OwnersPage() {
		PageFactory.initElements(driver, this);
	}

	CommonUtil cu = new CommonUtil();

	@FindBy(id = "owners_new_prequal")
	private WebElement continueButton;

	@FindBy(id = "logout-link")
	private WebElement logout;

	@FindBy(xpath = "//div[@class='alert-container add-space-big undefined ']/a")
	private WebElement signOut;

	public void validateOwnersPage() {
		cu.waitForElement(continueButton, 2);
		continueButton.isDisplayed();
		cu.click(logout);
		cu.waitForElement(signOut, 2);
		cu.click(signOut);
	}

}
