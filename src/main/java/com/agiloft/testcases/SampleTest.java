package com.agiloft.testcases;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class SampleTest {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		
		ChromeDriver driver = new ChromeDriver();
		
		driver.manage().window().maximize();
		
		driver.get("https://agiloft150159.saas.agiloft.com/logins/janibashashaik");
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		driver.findElementByXPath("//input[@name='user']").sendKeys("admin");
		
		driver.findElementByXPath("//input[@name='passwd']").sendKeys("ojXkNFXg");
		
		driver.findElementByXPath("//input[@value='Log in']").click();
		
		try {
			driver.findElementByXPath("//i[text()='Log me out of other devices']/..").click();
			} catch (Exception e) {
				// TODO: handle exception
			}
			
		Thread.sleep(5000);
			
		
		driver.switchTo().frame(driver.findElementByXPath("//iframe[@name='frameset']"));
		
		Thread.sleep(3000);
		
		String header = driver.findElementByXPath("//div[@class='navItem groupingName']").getText();
		
		System.out.println(header);
			
		driver.findElementByXPath("//div[@class='navItem bento']").click();
			
		driver.switchTo().defaultContent();
			
		driver.findElementByXPath("//input[@placeholder='Search Groupings and Tables' and @id='inputFilter']").sendKeys("Contract Management");
			
		driver.findElementByXPath("(//b[text()='Contract Management']/..)[2]").click();
			
		driver.switchTo().frame(driver.findElementByXPath("//iframe[@name='frameset']"));
			
		Thread.sleep(3000);

		// TC003
		
		driver.findElementByXPath("//div[@class='navItemWrapper selected']/div/a").click();
		
		Thread.sleep(3000);

		driver.switchTo().frame(driver.findElementByXPath("//iframe[@id='mainContentIframe']"));
		
		driver.findElementByXPath("//a[@id='ab_Operation_New__Main']").click();
		
		Select obj = new Select(driver.findElementByXPath("//select[@name='contract_type_$sel']"));
		
		obj.selectByVisibleText("Master Services Agreement");
		
		driver.findElementByXPath("//input[@name='contract_title1']").sendKeys("Automation Basha");
		
		driver.findElementByXPath("//textarea[@name='contract_description']").sendKeys("Automation Basha");
		
		driver.findElementByXPath("//button[@id='$finishMenuOpen1']/span").click();
		
		Thread.sleep(4000);
		
		driver.switchTo().defaultContent();

		driver.switchTo().defaultContent();
		
		driver.findElementByXPath("//span[text()='Save & Continue']/..").click();
		
		driver.switchTo().frame(driver.findElementByXPath("//iframe[@name='frameset']"));
		
		driver.switchTo().frame(driver.findElementByXPath("//iframe[@id='mainContentIframe']"));
		
		String succMgs = driver.findElementByXPath("//span[@class='msStatus']/..").getText();
		
		if(succMgs.contains("successfully created..")) {
			System.out.println("successfully created..");
		} else {
			System.err.println("Fail");
		}
		
		driver.findElementByXPath("//div[text()='Approvals']/..").click();
		
		String mgs = driver.findElementByXPath("(//div[@data-shortcut-label='Go to Approvals']//span)[1]").getText();
		
		System.out.println("$$$$$"+mgs+"$$$");
		
		if(mgs.equals("No records.")) {
			System.out.println("Pass");
		} else {
			System.out.println("fail");
		}
		
		String app = driver.findElementByXPath("//span[@id='lfnumber_of_approvals_needed']//td//td").getText();
		
		if(app.equals("0")) {
			System.out.println("pass");
		} else {
			System.out.println("fail");
		}
		
		driver.findElementByXPath("//input[@value='Create Approvals']").click();
		
		String mgs1 = driver.findElementByXPath("(//div[@data-shortcut-label='Go to Approvals']//span)[1]").getText();
		
		System.out.println("$$$$$"+mgs1+"$$$");
		
		if(!mgs1.equals("No records.")) {
			System.out.println("Pass");
		} else {
			System.out.println("fail");
		}
		
		String app2 = driver.findElementByXPath("//span[@id='lfnumber_of_approvals_needed']//td//td").getText();
		
		if(app2.equals("1")) {
			System.out.println("pass");
		} else {
			System.out.println("fail");
		}
		
		String succMgs1 = driver.findElementByXPath("//span[@class='msStatus']/..").getText();
		
		System.out.println(succMgs1);
		
		if(succMgs1.contains("successfully updated.")) {
			System.out.println("successfully updated.");
		} else {
			System.err.println("Fail");
		}
		
		String text = driver.findElementByXPath("//div[@class='details']/span").getText();
		
		System.out.println(text);
		
		if(text.equals("1 record(s) found, 1 page(s). Click here to count records again.")) {
			System.out.println("Pass");
		} else {
			System.out.println("fail");
		}
		
	/*	//driver.findElementByXPath("//input[@name='user']").sendKeys("admin");
		
		//driver.findElementByXPath("//input[@name='passwd']").sendKeys("ojXkNFXg");
		
	//	driver.findElementByXPath("//input[@value='Log in']").click();
		
		try {
		driver.findElementByXPath("//i[text()='Log me out of other devices']/..").click();
		} catch (Exception e) {
			// TODO: handle exception
		}
		
	//	Thread.sleep(5000);
		
	//	driver.switchTo().frame(driver.findElementByXPath("//iframe[@name='frameset']"));
		
	//	String header = driver.findElementByXPath("//div[@class='navItem groupingName']").getText();
		
	//	System.out.println(header);
		
	//	driver.findElementByXPath("//div[@class='navItem bento']").click();
		
	//	driver.switchTo().defaultContent();
		
	//	driver.findElementByXPath("//input[@placeholder='Search Groupings and Tables' and @id='inputFilter']").sendKeys("Contract Management");
		
	//	driver.findElementByXPath("(//b[text()='Contract Management']/..)[2]").click();
		
	//	driver.switchTo().frame(driver.findElementByXPath("//iframe[@name='frameset']"));
		
	//	Thread.sleep(3000);

	//	driver.findElementByXPath("(//a[text()='Contracts']/following-sibling::*)[1]").click();
		
	//	driver.switchTo().defaultContent();
		
	//	Thread.sleep(5000);
		
	//	driver.findElementByXPath("//span[text()='Setup Contracts']").click();
		
	//	Thread.sleep(5000);

	//	driver.switchTo().frame(driver.findElementByXPath("//iframe[@name='frameset']"));

	//	driver.switchTo().frame(driver.findElementByXPath("//iframe[@id='mainContentIframe']"));
		
	//	driver.findElementByXPath("//div[text()='Fields']/..").click();

		List<WebElement> allRows = driver.findElementsByXPath("//table[@id='_Main.TV']/tbody/tr");
		
		for(int i=1; i<=allRows.size(); i++) {
						
			String fieldLabel = driver.findElementByXPath("//table[@id='_Main.TV']/tbody/tr["+i+"]/td["+3+"]").getText();
			
			String dataType = driver.findElementByXPath("//table[@id='_Main.TV']/tbody/tr["+i+"]/td["+5+"]").getText();
			
			
			if(fieldLabel.equals("Button: Create Approvals") && dataType.equals("Action Button")) {
				
				driver.findElementByXPath("//table[@id='_Main.TV']/tbody/tr["+i+"]/td["+(2)+"]").click();
				
			}
			
			}
	
	
	//	driver.switchTo().defaultContent();
		
	//	driver.switchTo().defaultContent();
				
		
		if(driver.findElementByXPath("//div[text()='Create/edit Field']").isDisplayed()) {
		
		//	driver.switchTo().frame(driver.findElementByXPath("//iframe[@data-title='Create/edit Field']"));
		
	//	if(driver.findElementByXPath("//input[@name='actionButtonActionsAddChunkButton']").isDisplayed()) {
	//		driver.findElementByXPath("//input[@name='actionButtonActionsAddChunkButton']").click();
	//	}
		
		
		List<WebElement> allvalues = driver.findElementsByXPath("(//label[text()='Execute Actions']/../../following-sibling::tr[1]/td[2]//table)[2]//div");
		
		int count =0;
		
		for(WebElement eachElement : allvalues) {
			
			String eachText = eachElement.getText();
			
			System.out.println(eachText);
			
			if(eachText.equals("-- Wait for Completion --")) {
				count=count+1;
				break;
			} 
			
		}

		
		if(count==1) {
			System.out.println("Pass");
		} else {
			System.out.println("fail");
		}
		
	//	driver.findElementByXPath("//input[@data-shortcut='FINISH']").click();
		
		try {
		if(driver.findElementByXPath("//div[text()='Create/edit Field']").isDisplayed()) {
			
		}
		}catch (NoSuchElementException e) {
			// TODO: handle exception
			System.out.println("The Create/edit Field wizard is closed");
		}
		
	//	driver.switchTo().defaultContent();
		
		///
		
		driver.switchTo().frame(driver.findElementByXPath("//iframe[@name='frameset']"));

		driver.switchTo().frame(driver.findElementByXPath("//iframe[@id='mainContentIframe']"));

		List<WebElement> allRows1 = driver.findElementsByXPath("//table[@id='_Main.TV']/tbody/tr");
		
		for(int i=1; i<=allRows1.size(); i++) {
						
			String fieldLabel = driver.findElementByXPath("//table[@id='_Main.TV']/tbody/tr["+i+"]/td["+3+"]").getText();
			
			String dataType = driver.findElementByXPath("//table[@id='_Main.TV']/tbody/tr["+i+"]/td["+5+"]").getText();
			
			
			if(fieldLabel.equals("Button: Create Approvals") && dataType.equals("Action Button")) {
				
				driver.findElementByXPath("//table[@id='_Main.TV']/tbody/tr["+i+"]/td["+(2)+"]").click();
				
			}
			
			}
	
	
		driver.switchTo().defaultContent();
		
		driver.switchTo().defaultContent();
				
		
		if(driver.findElementByXPath("//div[text()='Create/edit Field']").isDisplayed()) {
		
			driver.switchTo().frame(driver.findElementByXPath("//iframe[@data-title='Create/edit Field']"));
	
		}
		
		List<WebElement> allvalues1 = driver.findElementsByXPath("(//label[text()='Execute Actions']/../../following-sibling::tr[1]/td[2]//table)[2]//div");
		
		int count1 =0;
		
		for(WebElement eachElement : allvalues1) {
			
			String eachText = eachElement.getText();
			
			System.out.println(eachText);
			
			if(eachText.equals("-- Wait for Completion --")) {
				count1=count1+1;
				break;
			} 
			
		}

		
		if(count1==1) {
			System.out.println("Pass");
		} else {
			System.out.println("fail");
		}
		
		driver.findElementByXPath("//input[@data-shortcut='FINISH']").click();
		
		try {
		if(driver.findElementByXPath("//div[text()='Create/edit Field']").isDisplayed()) {
			
		}
		}catch (NoSuchElementException e) {
			// TODO: handle exception
			System.out.println("The Create/edit Field wizard is closed");
		}
		
		driver.switchTo().defaultContent();
		
		}
		
		// end of TC001
		
		// start of TC002

		
	//	driver.switchTo().frame(driver.findElementByXPath("//iframe[@name='frameset']"));

	//	driver.switchTo().frame(driver.findElementByXPath("//iframe[@id='mainContentIframe']"));
		

		List<WebElement> allRows3 = driver.findElementsByXPath("//table[@id='_Main.TV']/tbody/tr");
		
		for(int i=1; i<=allRows3.size(); i++) {
						
			String fieldLabel = driver.findElementByXPath("//table[@id='_Main.TV']/tbody/tr["+i+"]/td["+3+"]").getText();
			
			String dataType = driver.findElementByXPath("//table[@id='_Main.TV']/tbody/tr["+i+"]/td["+5+"]").getText();		
			
			if(fieldLabel.equals("Button: Create Approvals") && dataType.equals("Action Button")) {
				
				driver.findElementByXPath("//table[@id='_Main.TV']/tbody/tr["+i+"]/td["+(2)+"]").click();
				
			}
			
			}
	
	//	driver.switchTo().defaultContent();
		
	//	driver.switchTo().defaultContent();
				
		
		if(driver.findElementByXPath("//div[text()='Create/edit Field']").isDisplayed()) {
		
			driver.switchTo().frame(driver.findElementByXPath("//iframe[@data-title='Create/edit Field']"));
		
		if(driver.findElementByXPath("//input[@name='actionButtonActionsAddChunkButton']").isDisplayed()) {
			driver.findElementByXPath("//input[@name='actionButtonActionsAddChunkButton']").click();
		}
		
		// drag and drop***************************
		
		Thread.sleep(5000);
		
		WebElement p1 = driver.findElementByXPath("//div[text()='-- Wait for Completion --']");
		
		WebElement p2 = driver.findElementByXPath("//div[text()='Set Show Create Approvals Button to No']");
		
		Actions builder = new Actions(driver);
		
		builder.dragAndDrop(p1, p2).perform();
			
		Thread.sleep(5000);
		
		List<WebElement> allvalues3 = driver.findElementsByXPath("(//label[text()='Execute Actions']/../../following-sibling::tr[1]/td[2]//table)[2]//div");
		
		int count3 =0;
		
		int i=0;
		
		for(WebElement eachElement : allvalues3) {
			
			String eachText = eachElement.getText();
			
			System.out.println(eachText);
			
			i++;
			
			if(eachText.equals("-- Wait for Completion --")) {
				count3=count3+1;
				break;
			} 
			
		}

		if(i==2) {
			System.out.println("draggred to 2nd position");
		}else {
			System.out.println("Unable to drag");
		}
		
		if(count3==1) {
			System.out.println("Pass");
		} else {
			System.out.println("fail");
		}
		
	//	driver.findElementByXPath("//input[@data-shortcut='FINISH']").click();
		
		try {
		if(driver.findElementByXPath("//div[text()='Create/edit Field']").isDisplayed()) {
			
		}
		}catch (NoSuchElementException e) {
			// TODO: handle exception
			System.out.println("The Create/edit Field wizard is closed");
		}
		
		// driver.switchTo().defaultContent();
	
		}
				
// verify drag and drop
		
	//	driver.switchTo().frame(driver.findElementByXPath("//iframe[@name='frameset']"));

	//	driver.switchTo().frame(driver.findElementByXPath("//iframe[@id='mainContentIframe']"));
		
		List<WebElement> allRows4 = driver.findElementsByXPath("//table[@id='_Main.TV']/tbody/tr");
		
		for(int i=1; i<=allRows4.size(); i++) {
						
			String fieldLabel = driver.findElementByXPath("//table[@id='_Main.TV']/tbody/tr["+i+"]/td["+3+"]").getText();
			
			String dataType = driver.findElementByXPath("//table[@id='_Main.TV']/tbody/tr["+i+"]/td["+5+"]").getText();		
			
			if(fieldLabel.equals("Button: Create Approvals") && dataType.equals("Action Button")) {
				
				driver.findElementByXPath("//table[@id='_Main.TV']/tbody/tr["+i+"]/td["+(2)+"]").click();
				
			}
			
			}
	
	//	driver.switchTo().defaultContent();
		
	//	driver.switchTo().defaultContent();
				
		
		if(driver.findElementByXPath("//div[text()='Create/edit Field']").isDisplayed()) {
		
			driver.switchTo().frame(driver.findElementByXPath("//iframe[@data-title='Create/edit Field']"));
		
		List<WebElement> allvalues3 = driver.findElementsByXPath("(//label[text()='Execute Actions']/../../following-sibling::tr[1]/td[2]//table)[2]//div");
		
		int count3 =0;
		
		int i=0;
		
		for(WebElement eachElement : allvalues3) {
			
			String eachText = eachElement.getText();
			
			System.out.println(eachText);
			
			i++;
			
			if(eachText.equals("-- Wait for Completion --")) {
				count3=count3+1;
				break;
			} 
			
		}

		if(i==2) {
			System.out.println("draggred to 2nd position");
		}else {
			System.out.println("Unable to drag");
		}
		
		if(count3==1) {
			System.out.println("Pass");
		} else {
			System.out.println("fail");
		}
		
	//	driver.findElementByXPath("//input[@data-shortcut='FINISH']").click();
		
		try {
		if(driver.findElementByXPath("//div[text()='Create/edit Field']").isDisplayed()) {
			
		}
		}catch (NoSuchElementException e) {
			// TODO: handle exception
			System.out.println("The Create/edit Field wizard is closed");
		}
		
	//	driver.switchTo().defaultContent();
		
		
	//	driver.switchTo().frame(driver.findElementByXPath("//iframe[@name='frameset']"));

	//	driver.switchTo().frame(driver.findElementByXPath("//iframe[@id='mainContentIframe']"));
		
	//	driver.findElementByXPath("//input[@data-shortcut='FINISH']").click();

		//
		
	*/
			
		
		
		
		
	}
	
		
	
		
	}


