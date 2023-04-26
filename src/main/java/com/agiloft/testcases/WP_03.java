package com.agiloft.testcases;

import java.util.HashMap;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.agiloft.pages.ContractManagementHeaderPage;
import com.agiloft.pages.LogInPage;
import com.agiloft.utils.ExcelDataProvider;
import com.agiloft.wrappers.ProjectWrappers;

public class WP_03 extends ProjectWrappers{
	
	
	@BeforeClass()
	public void setVariables() {
		browserName="chrome";
		url="https://agiloft150159.saas.agiloft.com/logins/janibashashaik";
		testCaseName="WP_03";
		testCaseDescription="Validate that Action Button works with Wait Points";
		author="Basha";
		category="Functional";
	}

	@Test(dataProvider="getExcelDataByKeys", dataProviderClass=ExcelDataProvider.class)
	public void checkActionButtonFunctionality(HashMap<Object,String> map) {
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
		.verifyAddWaitisAdded("-- Wait for Completion --")
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
		.verifyIsTableWizardClosed();
		new ContractManagementHeaderPage(driver, test)
		.switchToDefaultContent()
		.switchToHomePageFrame()
		.clickOnContractInHeader()
		.switchToSubFrame()
		.clickOnAddNewRecord()
		.selectContractType(map.get("ContactType"))
		.enterContractTitle(map.get("ContractTitle"))
		.enterContractDescription(map.get("ContractDescription"))
		.clickOnSave()
		.switchToDefaultContent()
		.switchToDefaultContent()
		.clickOnSaveAndContinue()
		.switchToHomePageFrame()
		.switchToSubFrame()
		.getContractId()
		.verifyCreatedSuccessMessage(map.get("CreatedMessage"))
		.clickOnApprovalLink()
		.verifyNoRecordsMessage(map.get("NoRecordsMgs"))
		.verifyNoOfApprovals(map.get("NoRecordsCount"))
		.clickOnCreateApprovals()
		.verifyNoRecordsMessageNotPresent(map.get("NoRecordsMgs"))
		.verifyNoOfApprovals(map.get("RecordsCount"))
		.verifyUpdatedSuccessMessage(map.get("UpdatedMessage"))
		.verifyRecordsPresentInTable(map.get("RecordsMgs"))
		.switchToDefaultContent()
		.switchToHomePageFrame()
		.switchToProfilePageFrame()
		.clickOnProfile()
		.switchToDefaultContent()
		.switchToDefaultContent()
		.clickOnLogout();
		
	}
}
