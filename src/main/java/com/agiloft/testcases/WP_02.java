package com.agiloft.testcases;

import java.util.HashMap;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.agiloft.pages.LogInPage;
import com.agiloft.utils.ExcelDataProvider;
import com.agiloft.wrappers.ProjectWrappers;

public class WP_02 extends ProjectWrappers {
	
	
	@BeforeClass
	public void setVariables() {
		browserName="chrome";
		url="https://agiloft150159.saas.agiloft.com/logins/janibashashaik";
		testCaseName="WP_02";
		testCaseDescription="Validate that a wait point can be added and saved if it is inserted between actions";
		author="Basha";
		category="Functional";
	}

	@Test(dataProvider="getExcelDataByKeys", dataProviderClass=ExcelDataProvider.class)
	public void addWaitPointBetweenActions(HashMap<Object,String> map) {
		
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
		.editCreateApprovalsButton("Button: Create Approvals")
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
		.switchToSubFrame()
		.editCreateApprovalsButton(map.get("ApprovalButtonName"))
		.switchToDefaultContent()
		.switchToDefaultContent()
		.verifyCreateEditScreenisDisplayed()
		.switchToCreateEditFieldFrame()
		.verifyAddWaitPointButtonisDisplayed()
		.clickOnAddWaitPoint()
		.verifyAddWaitisAdded(map.get("AddWaitName"))
		.dragAndDropWaitPoint()
		.verifyIfWaitPointIsDragged(map.get("AddWaitName"))
		.clickOnFinishInCreateEdit()
		.switchToDefaultContent()
		.switchToHomePageFrame()
		.switchToSubFrame()
		.editCreateApprovalsButton(map.get("ApprovalButtonName"))
		.switchToDefaultContent()
		.switchToDefaultContent()
		.verifyCreateEditScreenisDisplayed()
		.switchToCreateEditFieldFrame()
		.verifyAddWaitPointButtonisDisplayed()
		.verifyIfWaitPointIsDragged(map.get("AddWaitName"))
		.clickOnExecuteActions(map.get("AddWaitName"))
		.clickOnRemove()
		.clickOnFinishInCreateEdit()
		.verifyCreateEditWizardisClosed()
		.switchToDefaultContent()
		.switchToDefaultContent()
		.switchToHomePageFrame()
		.switchToSubFrame()
		.clickOnFinishSetUpContractPage()
		.verifyIsTableWizardClosed()
		.switchToDefaultContent()
		.switchToDefaultContent()
		.switchToHomePageFrame()
		.switchToProfilePageFrame()
		.clickOnProfile()
		.switchToDefaultContent()
		.switchToDefaultContent()
		.clickOnLogout();
				
	}

}
