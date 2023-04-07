package com.canadaproject.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.canadaproject.qa.base.TestBase;
import com.canadaproject.qa.pages.DeleteCustomerPage;
import com.canadaproject.qa.pages.HomePage;
import com.canadaproject.qa.pages.LoginPage;

public class HomePageTest extends TestBase {
	
	//This line is pushed to github
	
	LoginPage loginPage;
	HomePage homePage;
	DeleteCustomerPage deleteCustomerPage;
	
	public HomePageTest() {
		super();
	}
	
	@BeforeMethod
	public void setUp() {
		initialization();
		loginPage=new LoginPage();
		homePage=loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
	}
	
	@Test(priority=0)
	public void validateHomePageTitle() {
		String actualTitle=homePage.validateTitle();
		Assert.assertEquals(actualTitle, "Guru99 Bank Manager HomePage");
	}

	@Test(priority=1)
	public void vaidateHomePageLogo() {
		Assert.assertTrue(homePage.logo());
	}
	
	@Test(priority=2)
	public void navigateToDeleteCustomerPage() {
		deleteCustomerPage=homePage.clickDeleteCustomer();
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
}
