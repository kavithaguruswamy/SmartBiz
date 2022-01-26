package main.test;

import org.testng.annotations.*;
import main.java.SmartHomePage;
import main.resources.CommonUtil;
import main.resources.TestBase;
import main.java.LoanPage;
import main.java.FinancePage;
import main.java.BusinessInception;
import main.java.BusinessIndustryPage;
import main.java.BusinessLocationPage;
import main.java.BusinessEntityPage;
import main.java.BusinessEmployees;
import main.java.BusinessAnnualRevPage;
import main.java.BusinessPasswordPage;
import main.java.OwnersPage;
import main.java.LoginPage;

public class SmartLoanLogin extends TestBase {

	public String baseUrl = "https://qa-app02.smartbizloans.com/apply?partner_id=smartbiz";

	CommonUtil cu;
	SmartHomePage sm;
	LoanPage lp;
	FinancePage fp;
	BusinessInception bi;
	BusinessIndustryPage bh;
	BusinessLocationPage bl;
	BusinessEntityPage be;
	BusinessEmployees buemp;
	BusinessAnnualRevPage br;
	BusinessPasswordPage pass;
	OwnersPage op;
	LoginPage signInPage;

	@BeforeMethod
	public void navigateToSmartHome() {
		initialization();
		cu = new CommonUtil();
		sm = new SmartHomePage();
		lp = new LoanPage();
		fp = new FinancePage();
		bi = new BusinessInception();
		bh = new BusinessIndustryPage();
		bl = new BusinessLocationPage();
		be = new BusinessEntityPage();
		buemp = new BusinessEmployees();
		br = new BusinessAnnualRevPage();
		op = new OwnersPage();
		pass = new BusinessPasswordPage();
		signInPage = new LoginPage();

	}

	/**
	 * This test case validates elements in each page during navigation and creates
	 * a new login password and validates that new user is able to login with the
	 * same credentials. 
	 * 
	 */
	
	@Test 
	public void verifyLogin()  {
		sm.navigateToHome(baseUrl);
		sm.validateForm();
		sm.validateSubmitDisabled();
		sm.selectSBA();
		sm.fillForm();
		lp.validateLoanPage();
		fp.validateFinancePage();
		bi.validateBuinessInceptionPage();
		bh.validateBusinessIndustryPage();
		bl.validateBusinessLocationPage();
		be.validateBusinessEntityPage();
		buemp.validateBuinessEmployeePage();
		br.validateBuinessRevenuePage();
		pass.validateBusinessPasswordPage();
		op.validateOwnersPage();
		signInPage.validateLoginPage();

	}

	@Test 
	public void verifyHomepage() {
		sm.navigateToHome(baseUrl);
		sm.validateForm();
		sm.validateSubmitDisabled();
		
	}


	@AfterMethod
	public void terminateBrowser() {
		System.out.println("closing browser");
		driver.quit();
	}

}
