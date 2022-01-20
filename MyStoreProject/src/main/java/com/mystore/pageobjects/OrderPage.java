package com.mystore.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.mystore.actiondriver.Action;
import com.mystore.base.BaseClass;

public class OrderPage extends BaseClass {

	@FindBy(xpath = "//*[@class='cart_unit']/span[@class='price']/span")
	WebElement unitPrice;

	@FindBy(id = "total_price")
	WebElement totalPrice;

	@FindBy(xpath = "//p[@class='cart_navigation clearfix']//*[contains(text(),'Proceed to checkout')]")
	WebElement proceedToCheckOut;

	public OrderPage() {
		PageFactory.initElements(driver, this);
	}

	public double getUnitPrice() {
		String result = unitPrice.getText();
		double unitPrice = Double.parseDouble("" + new StringBuilder(result).replace(0, 1, ""));
		return unitPrice;
	}

	public double getTotalPrice() {
		String result = totalPrice.getText();
		double totalPrice = Double.parseDouble("" + new StringBuilder(result).replace(0, 1, ""));
		return totalPrice;
	}

	public LoginPage clickOnCheckOut() {
		Action.click(driver, proceedToCheckOut);
		return new LoginPage();
	}
}