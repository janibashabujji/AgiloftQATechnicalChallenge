package com.agiloft.pages;

import org.openqa.selenium.remote.RemoteWebDriver;

import com.agiloft.wrappers.GenericWrappers;
import com.relevantcodes.extentreports.ExtentTest;

public class ContractsPage extends GenericWrappers{
	
	public ContractsPage(RemoteWebDriver driver, ExtentTest test) {
		this.driver=driver;
		this.test=test;
	}
	
	public CreateNewContractPage clickOnAddNewRecord() {
		clickByXpath(prop.getProperty("ContractsPage.AddNewRecord.XPath"));
		return new CreateNewContractPage(driver, test);
	}
	

	public ContractsPage switchToSubFrame() {
		switchToFrame(prop.getProperty("ContractsPage.SubFrame.XPath"));
		return this;
	}

}
