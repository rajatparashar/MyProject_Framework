package com.mystore.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import com.mystore.base.BaseClass;
import com.mystore.dataprovider.DataProviders;
import com.mystore.pageobjects.HomePage;
import com.mystore.pageobjects.IndexPage;
import com.mystore.pageobjects.LoginPage;
import com.mystore.utility.Log;

public class LoginPageTest extends BaseClass {
	IndexPage indexPage;
	LoginPage loginPage;
	HomePage homePage;

	@Parameters("browser")
	@BeforeMethod(groups= {"Smoke","Sanity","Regression"})
	public void setUp(String browser) {
		launchApp(browser);
	}

	@AfterMethod(groups= {"Smoke","Sanity","Regression"})
	public void tearDown() {
		driver.quit();
	}

	@Test(dataProvider="credentials", dataProviderClass=DataProviders.class, groups= {"Sanity","Smoke"})
	public void loginTest(String username, String password) {
		Log.startTestCase("loginTest");
		indexPage = new IndexPage();
		Log.info("User is clicking on Sign In");
		loginPage = indexPage.clickOnSignIn();
		Log.info("User is entering username and password");
//		homePage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
		homePage = loginPage.login(username, password);
		String actualURL = homePage.getCurrentUrl();
		String expectedUrl = "http://automationpractice.com/index.php?controller=my-account";
		Log.info("Verifying if user is able to login");
		Assert.assertEquals(actualURL, expectedUrl);
		Log.info("Login successful");
		Log.endTestCase("loginTest");
	}

}