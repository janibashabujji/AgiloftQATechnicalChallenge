package com.agiloft.pages;

import org.openqa.selenium.remote.RemoteWebDriver;

import com.agiloft.wrappers.GenericWrappers;
import com.relevantcodes.extentreports.ExtentTest;

public class CreateEditFieldPage extends GenericWrappers{
	
	public CreateEditFieldPage(RemoteWebDriver driver, ExtentTest test) {
		this.driver = driver;
		this.test=test;
	}
	
	
	public SetupContractPage switchToHomePageFrame() {
		switchToFrame(prop.getProperty("CreateEditFieldPage.Mainframe.XPath"));
		return new SetupContractPage(driver,test);
	}
	
	
	public CreateEditFieldPage switchToDefaultContent() {
		switchToMainWebPage();
		waitProperty(5000);
		return this;
	}
	
	public CreateEditFieldPage clickOnLogout() {
		clickByXpath(prop.getProperty("CreateEdtFieldPage.Logout.XPath"));
		return this;
	}
	
	public CreateEditFieldPage verifyCreateEditScreenisDisplayed() {
		verifyIsElementDispalyed(prop.getProperty("SetupContractPage.CreateEdiFieldWizardText.XPath"));
		return this;
	}
	
	public CreateEditFieldPage switchToCreateEditFieldFrame() {
		switchToFrame(prop.getProperty("CreateEditFieldPage.CreateEditFieldFrame.XPath"));
		return new CreateEditFieldPage(driver, test);
	}
	
	public CreateEditFieldPage verifyAddWaitPointButtonisDisplayed() {
		verifyIsElementDispalyed(prop.getProperty("CreateEditFiledPage.AddWaitButton.XPath"));
		return this;
	}
	
	public CreateEditFieldPage clickOnAddWaitPoint() {
		clickByXpath(prop.getProperty("CreateEditFiledPage.AddWaitButton.XPath"));
		return this;
	}
	
	
	public CreateEditFieldPage verifyAddWaitisAdded(String text) {
		verifyWaitPointisAddedAfterAction(prop.getProperty("CreateEditFieldPage.AddedWaitButton.XPath"),text);
		return this;
	}
	
	public SetupContractPage clickOnFinishInCreateEdit() {
		clickByXpath(prop.getProperty("CreateEditFieldPage.FinishButton.XPath"));
		return new SetupContractPage(driver, test);
	}
	
	
	public CreateEditFieldPage dragAndDropWaitPoint() {
		dragAndDropByXPath(prop.getProperty("CreateEditFieldPage.WaitForCompletionWait.Xpath"), prop.getProperty("CreateEditFieldPage.SetShowCreateApprovalsWait.Xpath"));
		return this;
	}
	
	public CreateEditFieldPage verifyIfWaitPointIsDragged(String text) {
		validateIsWaitPointIsDraggedByXPath(prop.getProperty("CreateEditFieldPage.AddedWaitButton.XPath"),text);
		return this;
	}
	
	

public CreateEditFieldPage clickOnExecuteActions(String data) {
		clickByXpath("//div[text()='"+data+"']/input");
		return this;
	}
	
	public CreateEditFieldPage clickOnRemove() {
		clickByXpath(prop.getProperty("CreateEditFieldPage.Remove.XPath"));
		return this;
	}
	
	
	
}
