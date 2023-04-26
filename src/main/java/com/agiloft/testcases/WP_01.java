package com.agiloft.testcases;

import java.util.HashMap;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.agiloft.pages.LogInPage;
import com.agiloft.utils.ExcelDataProvider;
import com.agiloft.wrappers.ProjectWrappers;

public class WP_01 extends ProjectWrappers{
	
	
	@BeforeClass
	public void setVariables() {
		browserName="chrome";
		url="https://agiloft150159.saas.agiloft.com/logins/janibashashaik";
		testCaseName="WP_01";
		testCaseDescription="Validate that a wait point can be added and saved if it is inserted after the last action";
		author="Basha";
		category="Functional";
	}
	
	@Test(dataProvider="getExcelDataByKeys", dataProviderClass=ExcelDataProvider.class)
	public void addWaitPointAfterTheLastAction(HashMap<Object,String> map) {
		new LogInPage(driver, test)
		.enterUserName(map.get("UserName"))
		.enterPassword(map.get("Password"))
		.clickOnLogin()
		.switchToHomePageFrame()
		.clickOnBentoMenu()
		.switchToDefaultContent()
		.searchGroupingsAndTables(map.get("SearchGropingandTablesName"))
		.clickOnContractManagementAfterSearch()
		.switchToHomePageFrame()
		.verifyContractManagementHeaderText(map.get("SearchGropingandTablesName"))
		.verifyContractsHeaderText(map.get("HeaderLinkName"))
		.clickOnContractLinkInHeader()
		.switchToDefaultContent()
		.clickOnSetUpContracts()
		.switchToHomePageFrame()
		.switchToSubFrame()
		.clickOnFieldsTab()
		.editCreateApprovalsButton(map.get("ApprovalButtonName"))
		.switchToDefaultContent()
		.switchToDefaultContent()
		.verifyCreateEditScreenisDisplayed()
		.switchToCreateEditFieldFrame()
		.verifyAddWaitPointButtonisDisplayed()
		.clickOnAddWaitPoint()
		.verifyAddWaitisAdded(map.get("AddWaitName"))
		.clickOnFinishInCreateEdit()
		.createEditFieldWizardIsClosed()
		.switchToDefaultContent()
		.switchToHomePageFrame()
		.switchToSubFrame()
		.editCreateApprovalsButton(map.get("ApprovalButtonName"))
		.switchToDefaultContent()
		.switchToDefaultContent()
		.verifyCreateEditScreenisDisplayed()
		.switchToCreateEditFieldFrame()
		.verifyAddWaitPointButtonisDisplayed()
		.verifyAddWaitisAdded(map.get("AddWaitName"))
		.clickOnExecuteActions(map.get("AddWaitName"))
		.clickOnRemove()
		.clickOnFinishInCreateEdit()
		.createEditFieldWizardIsClosed()
		.switchToDefaultContent()
		.switchToHomePageFrame()
		.switchToProfilePageFrame()
		.clickOnProfile()
		.switchToDefaultContent()
		.switchToDefaultContent()
		.clickOnLogout();
		
	}

}
