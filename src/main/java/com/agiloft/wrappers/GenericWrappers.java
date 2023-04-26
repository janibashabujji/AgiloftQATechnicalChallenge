package com.agiloft.wrappers;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.ElementNotInteractableException;
import org.openqa.selenium.ElementNotSelectableException;
import org.openqa.selenium.ElementNotVisibleException;
import org.openqa.selenium.InvalidArgumentException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.NoSuchFrameException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.SessionNotCreatedException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.Select;

import com.agiloft.utils.Reporting;


public class GenericWrappers extends Reporting implements Wrappers {
	
	public RemoteWebDriver driver;
	
	int i=1;
	
	public static Properties prop;
	
	public void loadObjects() {
		
		try {
			prop = new Properties();
			prop.load(new FileInputStream("./src/test/java/object.properties"));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	
	public void unloadObjects() {
		prop=null;
	}

	public void invokeApp(String browser, String url) {
		// TODO Auto-generated method stub
		
		
		try { 
			if(browser.equalsIgnoreCase("chrome")) {
				System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
				driver = new ChromeDriver();
			}else if(browser.equalsIgnoreCase("firefox")) {
				System.setProperty("webdriver.gecko.driver", "./drivers/geckodriver.exe");
				driver = new FirefoxDriver();
			}else if(browser.equalsIgnoreCase("ie")) {
				System.setProperty("webdriver.ie.driver", "./drivers/IEDriverServer.exe");
				driver = new InternetExplorerDriver();
			}
			driver.manage().window().maximize();
			driver.get(url);
			
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);			
			reportStep("The browser "+browser+" is successfully launched with the given url "+url , "pass");
		} catch (SessionNotCreatedException e) {
			// TODO Auto-generated catch block
			reportStep("The browser "+browser+" is not launched with the given url "+url+" due to session not created error", "fail");
		}catch (InvalidArgumentException e) {
			// TODO: handle exception
			reportStep("The browser "+browser+" is not launched because the url "+url+" doesnt contain http/https", "fail");
		}catch (WebDriverException e) {
			// TODO: handle exception
		reportStep("The browser "+browser+" is not launched due to unknown error", "fail");
		}
	}

	

	
	public void enterByXpath(String xpathValue, String data) {
		// TODO Auto-generated method stub
		try {
			driver.findElementByXPath(xpathValue).sendKeys(data);
			reportStep("The element with the xpath "+xpathValue+" is entered with data "+data,"pass");
		} catch (NoSuchElementException e) {
			// TODO Auto-generated catch block
			reportStep("The element with the xpath "+xpathValue+" is not found in the DOM ","fail");
		}catch (ElementNotVisibleException e) {
			reportStep("The element with the xpath "+xpathValue+" is not visible in the application","fail");
		}catch (ElementNotInteractableException e) {
			// TODO: handle exception
			reportStep("The element with the xpath "+xpathValue+" is not interactable in the application","fail");
		}catch (StaleElementReferenceException e) {
			// TODO: handle exception
			reportStep("The element with the xpath "+xpathValue+" is not stable in the application","fail");
		}catch (WebDriverException e) {
			// TODO: handle exception
			reportStep("The element with the xpath "+xpathValue+" is not entered with data "+data+" due to unknown error","fail");
		}
	}



	

	public void verifyTextByXpath(String xpath, String text) {
		// TODO Auto-generated method stub
		try {
			String actualtext = driver.findElementByXPath(xpath).getText();	
			if(actualtext.equals(text)) {	
				reportStep("The element with the xpath "+xpath+" is holding the text "+actualtext+" is exactly matched with the expected text "+text,"pass");
			}else {
				reportStep("The element with the xpath "+xpath+" is holding the text "+actualtext+" is not exactly matched with the expected text "+text,"fail");
			}
		}catch (NoSuchElementException e) {
			// TODO: handle exception
			reportStep("The element with the xpath "+xpath+" is not found in the DOM","fail");
		}catch (ElementNotVisibleException e) {
			// TODO: handle exception
			reportStep("The element with the xpath "+xpath+" is not visible in the application","fail");
		}catch (ElementNotInteractableException e) {
			// TODO: handle exception
			reportStep("The element with the xpath "+xpath+" is not interactable in the application","fail");
		}catch (StaleElementReferenceException e) {
			// TODO: handle exception
			reportStep("The element with the xpath "+xpath+" is not stable in the application","fail");
		}catch (WebDriverException e) {
			// TODO: handle exception
			reportStep("The element with the xpath "+xpath+" is holding the text "+text+" is not verified due to some unknown error","fail");
		}
	}

	public void verifyNotEqualsTextByXpath(String xpath, String text) {
		// TODO Auto-generated method stub
		try {
			String actualtext = driver.findElementByXPath(xpath).getText();
			if(!actualtext.equals(text)) {	
				reportStep("The element with the xpath "+xpath+" is holding the text "+actualtext+" is not matched with the expected text "+text,"pass");	
			}else {
				reportStep("The element with the xpath "+xpath+" is holding the text "+actualtext+" is exactly matched with the expected text "+text,"fail");
			}
		
		}catch (NoSuchElementException e) {
			// TODO: handle exception
			reportStep("The element with the xpath "+xpath+" is not found in the DOM","fail");
		}catch (ElementNotVisibleException e) {
			// TODO: handle exception
			reportStep("The element with the xpath "+xpath+" is not visible in the application","fail");
		}catch (ElementNotInteractableException e) {
			// TODO: handle exception
			reportStep("The element with the xpath "+xpath+" is not interactable in the application","fail");
		}catch (StaleElementReferenceException e) {
			// TODO: handle exception
			reportStep("The element with the xpath "+xpath+" is not stable in the application","fail");	
		}catch (WebDriverException e) {
			// TODO: handle exception
			reportStep("The element with the xpath "+xpath+" is holding the text "+text+" is not verified due to some unknown error","fail");
		}
	}
	

	public void clickByXpath(String xpathVal, String value) {
		try {
			if(xpathVal.contains("$")) {
				xpathVal= 	xpathVal.replace("$value$", value);
			}
			driver.findElementByXPath(xpathVal).click();
			reportStep("The element with the xpath "+xpathVal+" is clicked successfully","pass");
		} catch (NoSuchElementException e) {
			// TODO Auto-generated catch block
			reportStep("The element with the xpath "+xpathVal+" is not found in the DOM","fail");
		}catch (ElementNotVisibleException e) {
			// TODO: handle exception
			reportStep("The element with the xpath "+xpathVal+" is not visible in the application","fail");
		}catch (ElementClickInterceptedException e) {
			// TODO: handle exception
			reportStep("The element with the xpath "+xpathVal+" is unable to click in the application","fail");
		}catch (StaleElementReferenceException e) {
			// TODO: handle exception
			reportStep("The element with the xpath "+xpathVal+" is not stable in the application","fail");
		}catch (WebDriverException e) {
			// TODO: handle exception
			reportStep("The element with the xpath "+xpathVal+" is not clicked due to unknown error","fail");	
		}
	}
	
	public void clickByXpath(String xpathVal) {
		try {
			driver.findElementByXPath(xpathVal).click();
			reportStep("The element with the xpath "+xpathVal+" is clicked successfully","pass");
		} catch (NoSuchElementException e) {
			// TODO Auto-generated catch block
			reportStep("The element with the xpath "+xpathVal+" is not found in the DOM","fail");
		}catch (ElementNotVisibleException e) {
			// TODO: handle exception
			reportStep("The element with the xpath "+xpathVal+" is not visible in the application","fail");
		}catch (ElementClickInterceptedException e) {
			// TODO: handle exception
			reportStep("The element with the xpath "+xpathVal+" is unable to click in the application","fail");
		}catch (StaleElementReferenceException e) {
			// TODO: handle exception
			reportStep("The element with the xpath "+xpathVal+" is not stable in the application","fail");
		}catch (WebDriverException e) {
			// TODO: handle exception
			reportStep("The element with the xpath "+xpathVal+" is not clicked due to unknown error","fail");	
		}
	}


	public void verifyIsElementDispalyed(String xpathVal) {
		try {
			if(driver.findElementByXPath(xpathVal).isDisplayed()) {
				reportStep("The element with the xpath "+xpathVal+" is displayed successfully","pass");
			} else {
				reportStep("The element with the xpath "+xpathVal+" is not displayed successfully","fail");
			}
		} catch (NoSuchElementException e) {
			// TODO Auto-generated catch block
			reportStep("The element with the xpath "+xpathVal+" is not found in the DOM","fail");
		}catch (ElementNotVisibleException e) {
			// TODO: handle exception
			reportStep("The element with the xpath "+xpathVal+" is not visible in the application","fail");
		}catch (ElementClickInterceptedException e) {
			// TODO: handle exception
			reportStep("The element with the xpath "+xpathVal+" is unable to click in the application","fail");
		}catch (StaleElementReferenceException e) {
			// TODO: handle exception
			reportStep("The element with the xpath "+xpathVal+" is not stable in the application","fail");
		}catch (WebDriverException e) {
			// TODO: handle exception
			reportStep("The element with the xpath "+xpathVal+" is not clicked due to unknown error","fail");	
		}
	}

	

	public String getTextByXpath(String xpathVal) {
		 String text = null;
		// TODO Auto-generated method stub
		try {
		text = driver.findElementByXPath(xpathVal).getText();
		reportStep("The element with the xpath "+xpathVal+" is getting the text "+text,"pass");
		} catch (NoSuchElementException e) {
			// TODO Auto-generated catch block
			reportStep("The element with the xpath "+xpathVal+" is not found in the DOM","fail");
		}catch (ElementNotVisibleException e) {
			// TODO: handle exception
			reportStep("The element with the xpath "+xpathVal+" is not visible in the application","fail");
		}catch (ElementNotInteractableException e) {
			// TODO: handle exception
			reportStep("The element with the xpath "+xpathVal+" is not interactable in the application","fail");
		}catch (StaleElementReferenceException e) {
			// TODO: handle exception
			reportStep("The element with the xpath "+xpathVal+" is not stable in the application","fail");
		}catch (WebDriverException e) {
			// TODO: handle exception
			reportStep("The element with the xpath "+xpathVal+" is not getting the text "+text+" due to unknown error","fail");
		}
		return text;
	}

	

	public long takeSnap() {
		// TODO Auto-generated method stub
		long number=0;
		try {
			number= (long) (Math.floor(Math.random()*100000000)+100000);
			File input = driver.getScreenshotAs(OutputType.FILE);
			File output = new File("./reports/screenshots/"+number+".png");
			FileUtils.copyFile(input, output);
		} catch (WebDriverException e) {
			// TODO Auto-generated catch block
			reportStep("The screenshot not taken due to unknown error","fail", false);
		} catch (Throwable e) {
			// TODO Auto-generated catch block
			reportStep("The screenshot not taken and not copied due to some error","fail", false);
		} 
		return number;
	}
	
	
	public void closeBrowser() {
		// TODO Auto-generated method stub
		try {
			driver.close();
			reportStep("The browser is closed successfully","pass", false);
		} catch (WebDriverException e) {
			// TODO Auto-generated catch block
			reportStep("due to unknown error the  browser is not closed","fail",false);
		}
		
	}

	public void closeAllBrowsers() {
		// TODO Auto-generated method stub
	try {
		driver.quit();
		reportStep("All browsers closed successfully","pass", false);
	} catch (WebDriverException e) {
		// TODO Auto-generated catch block
		reportStep("All browsers not closed successfully due to unknown error","fail", false);
	}	
	}

	
	public void waitProperty(long time) {
		// TODO Auto-generated method stub
		try {
			Thread.sleep(time);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	
	public void selectVisibleTextByXpath(String xpathValue, String value) {
		// TODO Auto-generated method stub
		try {
			WebElement element = driver.findElementByXPath(xpathValue);
			Select sel = new Select(element);
			sel.selectByVisibleText(value);
			reportStep("The element with xpath "+xpathValue+" is selected dropdown visible text "+value,"pass");
		} catch (NoSuchElementException e) {
			// TODO Auto-generated catch block
			reportStep("The element with xpath "+xpathValue+" is not found in the DOM","fail");
		}catch (ElementNotVisibleException e) {
			// TODO: handle exception
			reportStep("The element with xpath "+xpathValue+" is not visible in the application","fail");
		}catch (ElementNotInteractableException e) {
			// TODO: handle exception
			reportStep("The element with xpath "+xpathValue+" is not interactable in the application","fail");
		}catch (ElementNotSelectableException e) {
			// TODO: handle exception
			reportStep("The element with the xpath "+xpathValue+" is not selectable in the application","fail");
		}catch (StaleElementReferenceException e) {
			// TODO: handle exception
			reportStep("The element with the xpath "+xpathValue+" is not stable in the application","fail");
		}catch (WebDriverException e) {
			// TODO: handle exception
			reportStep("The element with the xpath "+xpathValue+" is not selected dropdown visible text "+value+" due to unknown error","fail");
		}
		
	}

	public void switchToFrame(String Xpath) {
		// TODO Auto-generated method stub

		try {
			WebElement frame=driver.findElementByXPath(Xpath);
			driver.switchTo().frame(frame);			
			reportStep("The element with xpath "+Xpath+" Switched to frame","pass");
		}catch (NoSuchFrameException e) {
			// TODO Auto-generated catch block
			reportStep("The element with xpath "+Xpath+" not Switched to frame as no such frame present","fail");
		}
		catch (WebDriverException e) {
			// TODO Auto-generated catch block
			reportStep("The element with xpath "+Xpath+" not Switched to frame due to unknown error","fail");
		}
	}

	

	public void selectRowFromTable(String xpath, String value) {
		try {
			waitProperty(5000);
		List<WebElement> allRows = driver.findElementsByXPath(xpath);
		for(int i=1; i<=allRows.size(); i++) {
			String fieldLabel = driver.findElementByXPath("//table[@id='_Main.TV']/tbody/tr["+i+"]/td["+3+"]").getText();
			String dataType = driver.findElementByXPath("//table[@id='_Main.TV']/tbody/tr["+i+"]/td["+5+"]").getText();
			if(fieldLabel.equals("Button: Create Approvals") && dataType.equals("Action Button")) {
				driver.findElementByXPath("//table[@id='_Main.TV']/tbody/tr["+i+"]/td["+(2)+"]").click();
				waitProperty(2000);
			}
			}
		reportStep("clicked on Button: Create Approvals with type Action Button", "pass");
		}catch (NoSuchElementException e) {
			// TODO: handle exception
			reportStep("Unable to find the table", "fail");
		}
	}
	
	public void switchToMainWebPage() {
		try {
			driver.switchTo().defaultContent();
			reportStep("Switched to Main Web Page", "pass");
		} catch (NoSuchFrameException e) {
			// TODO Auto-generated catch block
			reportStep("Unable to switch to Main Web Page", "fail");
		}
	}

	
	public void verifyWaitPointisAddedAfterAction(String xpath, String text) {
	try {
		List<WebElement> allvalues = driver.findElementsByXPath(xpath);
		int count =0;
		for(WebElement eachElement : allvalues) {
			String eachText = eachElement.getText();
			if(eachText.equals(text)) {
				count=count+1;
				break;
			} 
		}
		
		if(count==1) {
			reportStep("Wait point is added after the action and text "+text+" of a wait point is shown in the Execute Actions list:-- Wait for Completion --", "pass");
		} else {
			reportStep("Wait point is not added after the action and text "+text+" of a wait point is not shown in the Execute Actions list:-- Wait for Completion --", "fail");
		}	
	}catch (Exception e) {
		// TODO: handle exception
		reportStep("Unable to verify if wait point is added after action", "fail");
	}
	}
	
	public void verifyIfElementClosed(String xpath) {
		try {
			if(driver.findElementByXPath(xpath).isDisplayed()) {
				reportStep("The element with xpath "+xpath+" is dispalyed in the application", "fail");
			}
			}catch (NoSuchElementException e) {
				// TODO: handle exception
				reportStep("The Create/edit Field wizard is closed", "pass");
			}
			
	}

	public void dragAndDropByXPath(String xpathSource, String xpathDest) {
		// TODO Auto-generated method stub
		
		try {
			
			Thread.sleep(5000);
			
			WebElement p1 = driver.findElementByXPath(xpathSource);
			
			WebElement p2 = driver.findElementByXPath(xpathDest);
			
			Actions builder = new Actions(driver);
			
			builder.dragAndDrop(p1, p2).perform();
				
			Thread.sleep(5000);
			
			reportStep("The element with xpath "+xpathSource+" is dragged to the element with xpath "+xpathDest+" successfully", "pass");
			
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			reportStep("Unable to wait due to Interrupted Exception","Info");
		} catch (NoSuchElementException e) {
			// TODO: handle exception
			reportStep("The element with the xpath "+xpathDest+" is not found in the DOM","fail");
		}
	}
	
	public void verifyIsWaitPointAddedByXPath(String xpath, String waitPointName) {
		try {
		List<WebElement> allvalues = driver.findElementsByXPath(xpath);
		int count =0;
		for(WebElement eachElement : allvalues) {
			String eachText = eachElement.getText();
			if(eachText.equals(waitPointName)) {
				count=count+1;
				break;
			} 
		}
		if(count==1) {
			reportStep("Wait point is added after the action and The text -- Wait for Completion --of a wait point is shown in the Execute Actions list: ", "Pass");
		} else {
			reportStep("Wait point is added after the action and The text -- Wait for Completion --of a wait point is shown in the Execute Actions list: ", "Fail");
		}
		}catch (Exception e) {
			// TODO: handle exception
			reportStep("Unable to verify if wait point is added after action", "fail");
		}
	}
	
	public void validateIsWaitPointIsDraggedByXPath(String xpath, String waitPointName) {
		try {
		List<WebElement> allvalues = driver.findElementsByXPath(xpath);
		int i=0;
		for(WebElement eachElement : allvalues) {
			String eachText = eachElement.getText();
			System.out.println(eachText);
			i++;
			if(eachText.equals(waitPointName)) {
				break;
			} 
		}
		if(i==2) {
			reportStep("The wait point is moved and wait point is set between 2 actions", "pass");
		}else {
			reportStep("The wait point is not moved and wait point is not set between 2 actions", "fail");
		}
		} catch (NoSuchElementException e) {
			// TODO: handle exception
			reportStep("The element with the xpath "+xpath+" is not found in the DOM","fail");
		}
	}
	
	
	public void verifyIfElementIsNotPresentByXPath(String xpath) {
		try {
			if(driver.findElementByXPath(xpath).isDisplayed()) {
				reportStep("The element with xpath "+xpath+" is present in the application","Fail");
			}
			}catch (NoSuchElementException e) {
				// TODO: handle exception
				reportStep("The element with xpath "+xpath+" is not present in the application","Pass");
			}
	}
	
	public void logOutDevices(String xpath) {
		try {
			Thread.sleep(3000);
			driver.findElementByXPath(xpath).click();
			reportStep("The element with the xpath "+xpath+" is clicked successfully","pass");
			reportStep("Logged out of the application successfully","pass");
			}catch (Exception e) {
				// TODO Auto-generated catch block	
			}
	}


}
