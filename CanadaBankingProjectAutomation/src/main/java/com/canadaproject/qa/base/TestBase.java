package com.canadaproject.qa.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;

public class TestBase {
	
	public static Properties prop;
	public static WebDriver driver;
	
	public TestBase() {
		
		prop=new Properties();
		try {
			FileInputStream ip=new FileInputStream("C:\\Users\\usrin\\eclipse-workspace\\CanadaBankingProjectAutomation\\src\\main\\java\\com\\"
					+ "canadaproject\\qa\\config\\config.properties");
				prop.load(ip);
			} catch (Exception e) {
				e.printStackTrace();
			}
	}
	
	public static void initialization() {
		String browserName=prop.getProperty("browser");
		
		if(browserName.equals("chrome")) {
			System.setProperty("webdriver.chrome.driver", "C:\\chromedriver.exe");
			ChromeOptions options = new ChromeOptions();
			options.addArguments("--remote-allow-origins=*");
			driver = new ChromeDriver(options);
		} else if(browserName.equals("firefox")) {
			System.setProperty("webdriver.gecko.driver", "C:\\firefox.exe");
			driver=new FirefoxDriver();
		} else {
			System.out.println("None of the browsers identified");
		}
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.get(prop.getProperty("url"));
	}

}
