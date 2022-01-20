package com.mystore.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.mystore.actiondriver.Action;
import com.mystore.base.BaseClass;

public class AddToCartPage extends BaseClass {

	@FindBy(id = "quantity_wanted")
	WebElement quantity;

	@FindBy(id = "group_1")
	WebElement size;

	@FindBy(xpath = "//span[contains(text(),'Add to cart')]")
	WebElement addToCartButton;

	@FindBy(xpath = "//i[@class='icon-ok']")
	WebElement successMesage;

	@FindBy(xpath = "//*[contains(text(),'Proceed to checkout')]")
	WebElement proceedToCheckoutButton;

	public AddToCartPage() {
		PageFactory.initElements(driver, this);
	}

	public void enterQuantity(String qty) {
		Action.type(quantity, qty);
	}

	public void selectSize(String sze) {
		Action.selectByVisibleText(sze, size);
	}

	public void clickAddToCartButton() {
		Action.click(driver, addToCartButton);
	}

	public boolean validateAddToCartWindow() {
		Action.fluentWait(driver, successMesage, 10);
		return Action.isDisplayed(driver, successMesage);
	}

	public OrderPage clickProceedToCheckout() {
		Action.fluentWait(driver, proceedToCheckoutButton, 10);
		Action.JSClick(driver, proceedToCheckoutButton);
		return new OrderPage();
	}
}