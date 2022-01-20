package com.mystore.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.mystore.actiondriver.Action;
import com.mystore.base.BaseClass;

public class LoginPage extends BaseClass {

	@FindBy(id = "email")
	WebElement userName;

	@FindBy(id = "passwd")
	WebElement password;

	@FindBy(id = "SubmitLogin")
	WebElement signInButton;

	@FindBy(id = "email_create")
	WebElement emailForNewAccount;

	@FindBy(id = "SubmitCreate")
	WebElement createNewAcountButton;

	public LoginPage() {
		PageFactory.initElements(driver, this);
	}

	public HomePage login(String uName, String pswd) {
		Action.type(userName, uName);
		Action.type(password, pswd);
		Action.click(driver, signInButton);
		return new HomePage();
	}
	
	public AddressPage loginToLandAddressPage(String uName, String pswd) {
		Action.type(userName, uName);
		Action.type(password, pswd);
		Action.click(driver, signInButton);
		return new AddressPage();
	}

	public AccountCreationPage createNewAccount(String newEmail) {
		Action.type(emailForNewAccount, newEmail);
		Action.click(driver, createNewAcountButton);
		return new AccountCreationPage();
	}

}