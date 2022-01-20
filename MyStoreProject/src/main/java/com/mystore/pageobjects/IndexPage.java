package com.mystore.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.mystore.actiondriver.Action;
import com.mystore.base.BaseClass;

public class IndexPage extends BaseClass {

	@FindBy(xpath = "//a[@class='login']")
	WebElement signInButton;

	@FindBy(xpath = "//img[@class='logo img-responsive']")
	WebElement myStoreLogo;

	@FindBy(id = "search_query_top")
	WebElement searchProductBox;

	@FindBy(name = "submit_search")
	WebElement searchButton;

	// Constructor to initialize all the WebElements
	public IndexPage() {
		PageFactory.initElements(driver, this);
	}

	public LoginPage clickOnSignIn() {
		Action.click(driver, signInButton);
		return new LoginPage();
	}

	public boolean validateLogo() {
		return Action.isDisplayed(driver, myStoreLogo);
	}

	public String getMyStoreTitle() {
		return Action.getTitle(driver);
	}

	public SearchResultPage searchProduct(String productName) {
		Action.type(searchProductBox, productName);
		Action.click(driver, searchButton);
		return new SearchResultPage();
	}
}