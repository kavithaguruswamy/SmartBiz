package main.java;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import main.resources.CommonUtil;
import main.resources.TestBase;

public class SmartHomePage extends TestBase {
	static String emailId;
	CommonUtil cu = new CommonUtil();
	@FindBy(id = "first_name")
	private WebElement firstName;

	@FindBy(id = "last_name")
	private WebElement lastName;

	@FindBy(id = "email")
	private WebElement email;

	@FindBy(id = "phone")
	private WebElement phone;

	@FindBy(id = "legal_business_name")
	private WebElement businessName;

	@FindBy(id = "referral_source")
	private WebElement referralSource;

	@FindBy(id = "submit_apply_form")
	private WebElement submitForm;

	@FindBy(css = "label#square-selector-label-0 i")
	private WebElement business;

	@FindBy(css = "label#square-simple-selector-label-1 i")
	private WebElement sba;

	@FindBy(css = "input#privacy_policy")
	private WebElement policyCheck;

	@FindBy(xpath = "//form[@id=\"inputs-form\"]/div/div/div[3]/div[2]")
	private WebElement emailError;

	@FindBy(css = "a#apply_loading")
	private WebElement loanButton;

	public SmartHomePage() {
		PageFactory.initElements(driver, this);
	}

	public void navigateToHome(String url) {
		String getUrl = cu.navigateToPage(url);
		cu.scrollClick(firstName);
		Assert.assertTrue(getUrl.contains("partner_id=smartbiz"), "HomePage is not visible");
	}

	public void validateForm() {
		Assert.assertTrue(cu.isElementDisplayed(firstName), "FirstName field is not displayed");
		Assert.assertTrue(cu.isElementDisplayed(lastName), "LastName field is not displayed");
		Assert.assertTrue(cu.isElementDisplayed(email), "Email field not is displayed");
		Assert.assertTrue(cu.isElementDisplayed(phone), "Phone field not is displayed");
		Assert.assertTrue(cu.isElementDisplayed(businessName), "BusinessName field not is displayed");
		Assert.assertTrue(cu.isElementDisplayed(referralSource), "ReferralSource field not is displayed");
		Assert.assertTrue(cu.isElementDisplayed(submitForm), "SubmitForm field not is displayed");

	}

	public void validateSubmitDisabled() {
		Assert.assertTrue(cu.isButtonDisabled(submitForm), "SubmitButton is not disabled");

	}

	public void selectSBA() {
		cu.click(business);
		cu.scrollClick(sba);
	}

	public void fillForm() {
		emailId = cu.getEmail();
		cu.scrollClick(firstName);
		firstName.sendKeys("FirstName");
		lastName.sendKeys("lastName");
		email.sendKeys(emailId);
		phone.sendKeys("1234567234");
		businessName.sendKeys("Test Business");
		cu.selectValue(referralSource, "tv");
		cu.scrollClick(policyCheck);
		cu.scrollClick(submitForm);
		cu.waitForElement(loanButton, 2);
		try {
			while (emailError.isDisplayed()) {
				emailId = cu.getEmail();
				email.clear();
				email.sendKeys(emailId);
				cu.scrollClick(policyCheck);
				cu.scrollClick(submitForm);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
