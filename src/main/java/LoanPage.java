package main.java;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import main.resources.CommonUtil;
import main.resources.TestBase;

public class LoanPage extends TestBase {

	public LoanPage() {
		PageFactory.initElements(driver, this);
	}

	CommonUtil cu = new CommonUtil();

	@FindBy(css = "a#apply_loading")
	private WebElement loanButton;

	public void validateLoanPage() {
		cu.waitForElement(loanButton, 2);
		loanButton.isDisplayed();
		Assert.assertTrue(cu.getUrl().contains("/apply/loan"), "Loan Apply page is not visible");
		cu.click(loanButton);
	}

}
