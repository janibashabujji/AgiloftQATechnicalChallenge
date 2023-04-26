package com.agiloft.pages;

import org.openqa.selenium.remote.RemoteWebDriver;

import com.agiloft.wrappers.GenericWrappers;
import com.relevantcodes.extentreports.ExtentTest;

public class SetupContractPage extends GenericWrappers{

	public SetupContractPage(RemoteWebDriver driver, ExtentTest test) {
		this.driver = driver;
		this.test=test;
	}

	public SetupContractPage switchToProfilePageFrame() {
		switchToFrame(prop.getProperty("CreateNewContractPage.ProfilePageFrame.Xpath"));
		return this;
	}
	
	public SetupContractPage clickOnProfile() {
		clickByXpath(prop.getProperty("SetupContractPage.Profile.XPath"));
		return this;
	}

	public SetupContractPage createEditFieldWizardIsClosed() {
		verifyIfElementClosed(prop.getProperty("SetupContractPage.CreateEdiFieldWizardText.XPath"));
		return this;
	}
	
	public SetupContractPage switchToHomePageFrame() {
		switchToFrame(prop.getProperty("CreateEditFieldPage.Mainframe.XPath"));
		return this;
	}
	
	public SetupContractPage switchToSubFrame() {
		switchToFrame(prop.getProperty("ContractsPage.SubFrame.XPath"));
		return this;
	}
	
	public SetupContractPage clickOnFinishInCreateEdit() {
		clickByXpath(prop.getProperty("CreateEditFieldPage.FinishButton.XPath"));
		return new SetupContractPage(driver, test);
	}
	
	public SetupContractPage clickOnFinishSetUpContractPage() {
		clickByXpath(prop.getProperty("CreateEditFieldPage.FinishButton.XPath"));
		return new SetupContractPage(driver, test);
	}
	
	public SetupContractPage verifyContractTableSetup(String text) {
		verifyTextByXpath(prop.getProperty("SetupContractPage.ContractTableSetup.XPath"), text);
		return this;
	}
	
	public SetupContractPage clickOnFieldsTab() {
		clickByXpath(prop.getProperty("SetupContractPage.FieldsTab.XPath"));
		return  this;
	}

	public SetupContractPage editCreateApprovalsButton(String value) {
		selectRowFromTable(prop.getProperty("SetupContractPage.CreateApprovalsButton.XPath"), value);
		return this;
	}
	
	public CreateEditFieldPage switchToDefaultContent() {
		switchToMainWebPage();
		waitProperty(5000);
		return new CreateEditFieldPage(driver,test);
	}
	
	public SetupContractPage verifyCreateEditWizardisClosed() {
		verifyIfElementIsNotPresentByXPath(prop.getProperty("SetupContractPage.CreateEdiFieldWizardText.XPath"));
		return this;
	}
	
	public SetupContractPage verifyIsTableWizardClosed() {
		verifyIfElementIsNotPresentByXPath(prop.getProperty("SetupContractPage.TableWizard.XPath"));
		return this;
	}
	
}
