package main.java;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import main.resources.CommonUtil;
import main.resources.TestBase;

public class LoginPage extends TestBase {

	public LoginPage() {
		PageFactory.initElements(driver, this);
	}

	CommonUtil cu = new CommonUtil();

	@FindBy(id = "email")
	private WebElement email;

	@FindBy(id = "password")
	private WebElement pass;

	@FindBy(id = "login_to_flow")
	private WebElement login;

	@FindBy(css = "a#logout-link")
	private WebElement logout;

	@FindBy(css = "div#content img")
	private WebElement icon;

	String password = "Test123!";

	public void validateLoginPage() {
		cu.waitForElement(email, 2);
		Assert.assertTrue(cu.getUrl().contains("login"), "Login page is not visible");
		email.isDisplayed();
		pass.isDisplayed();
		email.sendKeys(SmartHomePage.emailId);
		pass.sendKeys(password);
		cu.click(login);
		cu.waitForElement(logout, 9);
		logout.isDisplayed();
	}

}
