package com.mystore.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.mystore.actiondriver.Action;
import com.mystore.base.BaseClass;

public class ShippingPage extends BaseClass {

	@FindBy(id = "cgv")
	WebElement termsCheckbox;

	@FindBy(xpath = "//button//span[contains(text(),'Proceed to checkout')]")
	WebElement proceedToCheckButton;

	public ShippingPage() {
		PageFactory.initElements(driver, this);
	}

	public void clickTermsCheckbox() {
		Action.click(driver, termsCheckbox);
	}
	
	public PaymentPage clickOnProceedToCheckout() {
		Action.click(driver, proceedToCheckButton);
		return new PaymentPage();
	}
}