
package com.agiloft.wrappers;

public interface Wrappers {
	/**
	 * This method will launch the given browser and maximise the browser and set the
	 * wait for 30 seconds and load the url
	 * @author Basha
	 * @param browser - The browser of the application to be launched
	 * @param url - The url with http or https
	 * @throws Exception 
	 * 
	 */
	public void invokeApp(String browser, String url);	
	
	/**
	 * This method will enter the value to the text field using xpath attribute to locate
	 * 
	 * @param xpathValue - name of the webelement
	 * @param data - The data to be sent to the webelement
	 * @author Basha
	 */
	public void enterByXpath(String xpathValue, String data);
	
	/**
	 * This method will verify the given text with exact match
	 * @param xpath - The locator of the object in id
	 * @param text  - The text to be verified
	 * @author Basha
	 */
	public void verifyTextByXpath(String xpath, String text);
	
	/**
	 * This method will click the element using xpath as locator
	 * @param xpathVal  The xpath (locator) of the element to be clicked
	 * @author Basha
	 */
	public void clickByXpath(String xpathVal);
	

	/**
	 * This method will get the text of the element using xpath as locator
	 * @param xpathVal  The xpath (locator) of the element 
	 * @author Basha
	 */
	public String getTextByXpath(String xpathVal);
	
	public void selectVisibleTextByXpath(String xpathValue, String value);
		
		

		
	/**
	 * This method will close the active browser
	 * @author Basha
	 */
	public void closeBrowser();
	
	
	/**
	 * This method will close all the browsers
	 * @author Basha
	 */
	public void closeAllBrowsers();

	public void waitProperty(long time);

	
}

