package com.agiloft.pages;

import org.openqa.selenium.remote.RemoteWebDriver;

import com.agiloft.wrappers.GenericWrappers;
import com.relevantcodes.extentreports.ExtentTest;

public class LogInPage extends GenericWrappers{
	
	public LogInPage(RemoteWebDriver driver, ExtentTest test) {
		this.driver=driver;
		this.test=test;
	}
	
	public LogInPage enterUserName(String data) {
		enterByXpath(prop.getProperty("LogInPage.UserName.XPath"), data);
		return this;
	}

	public LogInPage enterPassword(String data) {
		enterByXpath(prop.getProperty("LogInPage.Password.XPath"), data);
		return this;
	}
	
	public ContractManagementHeaderPage clickOnLogin() {
		clickByXpath(prop.getProperty("LogInPage.LogInButton.XPath"));
		logOutDevices(prop.getProperty("LogInPage.LogOutOtherDevices.XPath"));
		return new ContractManagementHeaderPage(driver, test);
	}
	
	
	
	
}
