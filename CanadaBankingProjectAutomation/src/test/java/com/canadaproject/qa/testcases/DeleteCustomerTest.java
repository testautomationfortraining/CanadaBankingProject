package com.canadaproject.qa.testcases;

import java.util.concurrent.TimeUnit;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.canadaproject.qa.base.TestBase;
import com.canadaproject.qa.pages.DeleteCustomerPage;
import com.canadaproject.qa.pages.HomePage;
import com.canadaproject.qa.pages.LoginPage;

public class DeleteCustomerTest extends TestBase {
	
	LoginPage loginPage;
	HomePage homePage;
	DeleteCustomerPage deleteCustomerPage;
	
	public DeleteCustomerTest() {
		super();
	}

	@BeforeMethod
	public void setUp() throws InterruptedException {
		initialization();
		loginPage=new LoginPage();
		homePage=loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
		deleteCustomerPage=homePage.clickDeleteCustomer();
		Thread.sleep(3000);
	}
	
	@Test(priority=0)
	public void validateDeleteCustomerPageTitle() {
		String actualTitle=deleteCustomerPage.validateTitle();
		Assert.assertEquals(actualTitle, "Guru99 Bank Delete Customer Page");
	}
	
	@Test(priority=1)
	public void deleteCustomer() {
		deleteCustomerPage.deleteCustomer(prop.getProperty("customerId"));
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
}
