package com.automation.testscripts;

import java.io.FileInputStream;
import java.util.Properties;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Ksrtc extends LoginDriver {
	Properties properties;
	FileInputStream fis;
	// Actions action=new Actions(driver);

	@BeforeClass
	public void loadingPropertiesFile() throws Exception {
		FileInputStream fis = new FileInputStream(
				"C:\\Users\\siva.mutyala\\eclipse-workspace\\com.automation\\Resources\\Data\\ksrtc.properties");
		properties = new Properties();
		properties.load(fis);
	}

	@Test(priority = 2)
	public void loadingHomePage() {
		String nurl = properties.getProperty("url");
		driver.get(nurl);
	}

	@Test(priority = 3)
	public void fromPlaceName() {
		String nfromplacename = properties.getProperty("fromplacename");
		String nfromplacenamevalue = properties.getProperty("fromplacenamevalue");
		String nfromPlaceId = properties.getProperty("fromPlaceId");

		driver.findElement(By.xpath(nfromplacename)).sendKeys(nfromplacenamevalue);
		{
			WebElement placeId = driver.findElement(By.className(nfromPlaceId));
			placeId.click();
		}
	}
//for alert 
	/*
	 * @Test(priority = 4) public void acceptingAlert() { Alert alert =
	 * driver.switchTo().alert(); System.out.println("the alert value is:" +
	 * alert.getText()); alert.accept(); }
	 */

	@Test(priority = 5)
	public void toPlaceName() {
		String ntoPlaceName = properties.getProperty("toPlaceName");
		String ntoPlaceNameValue = properties.getProperty("toPlaceNameValue");
		// String ntoPlaceId = properties.getProperty("toPlaceId");

		driver.findElement(By.xpath(ntoPlaceName)).sendKeys(ntoPlaceNameValue);

		{
			WebElement placeId = driver.findElement(By.xpath(ntoPlaceName));

			Actions action = new Actions(driver);

			action.moveToElement(placeId).sendKeys(ntoPlaceNameValue).sendKeys(Keys.ENTER).build().perform();
			// placeId.click();
		}
	}

	@Test(priority = 6)
	public void dateOfJourney() {
		String ndateOfJourney = properties.getProperty("dateOfJourney");
		String ndateOfJourneyValue = properties.getProperty("dateOfJourneyValue");
		// String dateOfJourneyId = properties.getProperty("dateOfJourneyId");

		driver.findElement(By.xpath(ndateOfJourney)).click();
		// sendKeys(ndateOfJourneyValue)
		driver.findElement(By.linkText(ndateOfJourneyValue)).click();

	}

	/*
	 * @Test(priority = 7) public void dateOfReturn() { String ndateOfReturn =
	 * properties.getProperty("dateOfReturn"); String ndateOfReturnValue =
	 * properties.getProperty("dateOfReturnValue");
	 * driver.findElement(By.xpath(ndateOfReturn)).click();
	 * driver.findElement(By.linkText(ndateOfReturnValue)).click();
	 * 
	 * }
	 */
	@Test(priority = 7)
	public void searchBus()
	{
		String nsearchByBus = properties.getProperty("searchByBus");
	driver.findElement(By.xpath(nsearchByBus)).click();
	}
	@Test(priority = 8)
	public void selectSeats()
	{
		String nselectSeats = properties.getProperty("selectSeats");
		driver.findElement(By.xpath(nselectSeats)).click();
	}
}
