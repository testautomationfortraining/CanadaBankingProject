package com.canadaproject.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.canadaproject.qa.base.TestBase;

public class HomePage extends TestBase {
	
	//Page Factory
	@FindBy(xpath="//a[text()='Delete Customer']")
	WebElement deleteCustomerBtn;
	
	@FindBy(xpath="//h2[text()='Guru99 Bank']")
	WebElement logo;
	
	public HomePage() {
		PageFactory.initElements(driver, this);
	}
	
	//actions
	public String validateTitle() {
		return driver.getTitle();
	}
	
	public boolean logo() {
		return logo.isDisplayed();
	}
	
	public DeleteCustomerPage clickDeleteCustomer() {
		deleteCustomerBtn.click();
		return new DeleteCustomerPage();
	}

}
