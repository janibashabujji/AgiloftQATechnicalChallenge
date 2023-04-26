package com.agiloft.pages;

import org.openqa.selenium.remote.RemoteWebDriver;

import com.agiloft.wrappers.GenericWrappers;
import com.relevantcodes.extentreports.ExtentTest;

public class ContractManagementHeaderPage extends GenericWrappers{
	
	public ContractManagementHeaderPage(RemoteWebDriver driver, ExtentTest test) {
		this.driver = driver;
		this.test=test;
	}
	
	public ContractManagementHeaderPage switchToHomePageFrame() {
		switchToFrame(prop.getProperty("CreateEditFieldPage.Mainframe.XPath"));
		waitProperty(5000);
		return this;
	}
	
	public ContractManagementHeaderPage verifyContractManagementHeaderText(String text) {
		verifyTextByXpath(prop.getProperty("ContractManagementHeaderPage.ContractManagementHeaderText.XPath"), text);
		return this;
	}
	
	public ContractManagementHeaderPage clickOnBentoMenu() {
		clickByXpath(prop.getProperty("ContractManagementHeaderPage.BentoMenu.XPath"));
		return this;
	}
	
	public ContractManagementHeaderPage switchToDefaultContent() {
		switchToMainWebPage();
		waitProperty(5000);
		return this;
	}
	
	public ContractManagementHeaderPage searchGroupingsAndTables(String data) {
		enterByXpath(prop.getProperty("ContractManagementHeaderPage.SearchBox.XPath"), data);
		return this;
	}
	
	public ContractManagementHeaderPage clickOnContractManagementAfterSearch() {
		clickByXpath(prop.getProperty("ContractManagementHeaderPage.ContractManagement.XPath"));
		return this;
	}
	
	public ContractManagementHeaderPage verifyContractsHeaderText(String text) {
		verifyTextByXpath(prop.getProperty("ContractManagementHeaderPage.ContractHeaderText.XPath"), text);
		return this;
	}
	
	public ContractsPage clickOnContractInHeader() {
		clickByXpath(prop.getProperty("ContractManagementHeaderPage.ContractHeaderText.XPath"));
		return new ContractsPage(driver,test);
	}
	
	public SetupContractPage clickOnSetUpContracts() {
		clickByXpath(prop.getProperty("ContractManagementHeaderPage.SetupContracts.XPath"));
		waitProperty(5000);
		return new SetupContractPage(driver, test);
	}
	
	
	public ContractManagementHeaderPage clickOnContractLinkInHeader() {
		clickByXpath(prop.getProperty("ContractManagementHeaderPage.ContractsLinkInHeader.XPath"));
		return this;
	}
	

}
