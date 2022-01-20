package com.mystore.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.mystore.base.BaseClass;

public class OrderConfirmationPage extends BaseClass {

	@FindBy(xpath = "//*[contains(text(),'Your order on My Store is complete.')]")
	WebElement confirmMessage;

	public OrderConfirmationPage() {
		PageFactory.initElements(driver, this);
	}

	public String validateConfirmMessage() {
		return confirmMessage.getText();
	}
}