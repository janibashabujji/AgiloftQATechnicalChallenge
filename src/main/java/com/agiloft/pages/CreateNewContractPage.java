package com.agiloft.pages;

import org.openqa.selenium.remote.RemoteWebDriver;

import com.agiloft.wrappers.GenericWrappers;
import com.relevantcodes.extentreports.ExtentTest;

public class CreateNewContractPage extends GenericWrappers{

	public static String id =null;
	
	public CreateNewContractPage(RemoteWebDriver driver, ExtentTest test) {
		this.driver=driver;
		this.test=test;
	}
	
	public CreateNewContractPage switchToDefaultContent() {
		switchToMainWebPage();
		waitProperty(5000);
		return this;
	}
	
	
	public CreateNewContractPage selectContractType(String value) {
		selectVisibleTextByXpath(prop.getProperty("CreateNewContractPage.ContractType.XPath"), value);
		return this;
	}
	
	public CreateNewContractPage enterContractTitle(String data) {
		enterByXpath(prop.getProperty("CreateNewContractPage.ContractTitle.XPath"), data);
		return this;
	}
	
	public CreateNewContractPage enterContractDescription(String data) {
		enterByXpath(prop.getProperty("CreateNewContractPage.ContractDescription.XPath"), data);
		return this;
	}
	
	
	public CreateNewContractPage clickOnSave() {
		clickByXpath(prop.getProperty("CreateNewContractPage.SaveButton.XPath"));
		return this;
	}
	
	public CreateNewContractPage clickOnSaveAndContinue() {
		clickByXpath(prop.getProperty("CreateNewContractPage.SaveAndContinue.XPath"));
		return this;
	}
	
	public CreateNewContractPage switchToHomePageFrame() {
		switchToFrame(prop.getProperty("CreateEditFieldPage.Mainframe.XPath"));
		waitProperty(5000);
		return this;
	}
	

	public SetupContractPage switchToProfilePageFrame() {
		switchToFrame(prop.getProperty("CreateNewContractPage.ProfilePageFrame.Xpath"));
		return new SetupContractPage(driver, test);
	}
	
	
	
	public CreateNewContractPage switchToSubFrame() {
		switchToFrame(prop.getProperty("ContractsPage.SubFrame.XPath"));
		return this;
	}
	
	
	public CreateNewContractPage getContractId() {
		 id = getTextByXpath(prop.getProperty("CreateNewContractPage.ContractID.XPath"));
		 return this;
	}
	
	public CreateNewContractPage verifyCreatedSuccessMessage(String mgs) {
		String succMgs = mgs.replace("num", id);	
		verifyTextByXpath(prop.getProperty("CreateNewContractPage.SuccessMessage.XPath"), succMgs);
		return this;
	}
	
	public CreateNewContractPage clickOnApprovalLink() {
		clickByXpath(prop.getProperty("CreateNewContractPage.ApprovalsLink.XPath"));
		return this;
	}
	
	
	public CreateNewContractPage verifyNoRecordsMessage(String mgs) {
		verifyTextByXpath(prop.getProperty("CreateNewContractPage.NoRecordsMgs.XPath"),mgs);
		return this;
	}
	
	public CreateNewContractPage verifyNoOfApprovals(String number) {
		verifyTextByXpath(prop.getProperty("CreateNewContractPage.NoOFApprovals.XPath"),number);
		return this;
	}
	
	public CreateNewContractPage clickOnCreateApprovals() {
		clickByXpath(prop.getProperty("CreateNewContractPage.CreateApprovalsButton.XPath"));
		return this;
	}
	
	public CreateNewContractPage verifyNoRecordsMessageNotPresent(String mgs) {
		verifyNotEqualsTextByXpath(prop.getProperty("CreateNewContractPage.NoRecordsMgs.XPath"),mgs);
		return this;
	}
	
	public CreateNewContractPage verifyUpdatedSuccessMessage(String mgs) {
		String succMgs = mgs.replace("num", id);	
		verifyTextByXpath(prop.getProperty("CreateNewContractPage.SuccessMessage.XPath"), succMgs);
		return this;
	}
	
	
	public CreateNewContractPage verifyRecordsPresentInTable(String text) {
		verifyTextByXpath(prop.getProperty("CreateNewContractPage.RecordsInTable.XPath"), text);
		return this;
	}
	
}
