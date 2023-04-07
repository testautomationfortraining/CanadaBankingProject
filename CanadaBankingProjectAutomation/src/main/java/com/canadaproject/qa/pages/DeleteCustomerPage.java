package com.canadaproject.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.canadaproject.qa.base.TestBase;

public class DeleteCustomerPage extends TestBase {
	
	//Page Factory
	@FindBy(xpath="//input[@name='cusid']")
	WebElement custIdTextBox;
	
	@FindBy(xpath="//input[@name='AccSubmit']")
	WebElement submitBtn;

	
	public DeleteCustomerPage() {
		PageFactory.initElements(driver, this);
	}
	
	//actions
	public String validateTitle() {
		return driver.getTitle();
	}
	
	public void deleteCustomer(String customerId) {
		custIdTextBox.sendKeys(customerId);
		submitBtn.click();
		driver.switchTo().alert().accept();
		driver.switchTo().alert().accept();
	}

}
