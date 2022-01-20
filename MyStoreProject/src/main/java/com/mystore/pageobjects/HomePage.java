package com.mystore.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.mystore.actiondriver.Action;
import com.mystore.base.BaseClass;

public class HomePage extends BaseClass {

	@FindBy(xpath = "//span[contains(text(),'My wishlists')]")
	WebElement myWishList;

	@FindBy(xpath = "//span[contains(text(),'Order history and details')]")
	WebElement orderHistoryAndDetails;

	public HomePage() {
		PageFactory.initElements(driver, this);
	}

	public boolean validateMyWishList() {
		return Action.isDisplayed(driver, myWishList);
	}

	public boolean validateOrderHistory() {
		return Action.isDisplayed(driver, orderHistoryAndDetails);
	}

	public String getCurrentUrl() {
		return driver.getCurrentUrl();
	}

}