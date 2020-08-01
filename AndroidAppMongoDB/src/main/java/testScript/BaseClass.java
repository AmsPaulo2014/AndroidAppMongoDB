package testScript;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.math3.stat.descriptive.summary.Product;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.google.common.collect.ImmutableMap;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

public class BaseClass {
	
	public static AndroidDriver<AndroidElement> driver;
	public 	static Properties prop;
	public static String loginDetails;
	
	public static String productName;
	public static String productAmount;
	
	
	//constructor
	public BaseClass()
	{
		FileInputStream input;
			
			try 
			{
				prop = new Properties();
				input = new FileInputStream("./Asset.properties");
				prop.load(input);
			} 
			catch (FileNotFoundException e) 
			{
				e.printStackTrace();
			} 
			catch (IOException e) 
			{
				e.printStackTrace();
			}	
	}
	
	@BeforeTest
	public void launchApp() throws IOException
	{
		DesiredCapabilities capabilites = new DesiredCapabilities();
		
		capabilites.setCapability("deviceName", "vivo 1723");
		capabilites.setCapability("udid", "20e99a08");
		capabilites.setCapability("platformVersion", "9");
		
		capabilites.setCapability("platformName", "Android");
		capabilites.setCapability("appPackage", "com.flipkart.android");
		capabilites.setCapability("appActivity", "com.flipkart.android.SplashActivity");
		capabilites.setCapability("chromedriverExecutable", "./browsers/chromedriver.exe");
		capabilites.setCapability("appium:chromeOptions", ImmutableMap.of("w3c", false));
		capabilites.setCapability("autoGrantPermissions", true);
		
		driver= new AndroidDriver<AndroidElement>(new URL("http://0.0.0.0:4723/wd/hub") ,capabilites);	
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		
	}
	
	
	// Search product from flipkart app and goto Buy Now screen.
	@Test
	public void closeApp() throws InterruptedException
	{
		String searchProduct = prop.getProperty("searchProduct");
		loginDetails=	prop.getProperty("mobileNumber");
		
		Thread.sleep(3000);
		PageLocators pageLocators = new PageLocators(driver);
		pageLocators.selectLanguage.click();
		pageLocators.continueBtn.click();
		
		ElementToBeClickable(pageLocators.selectAccount);		
		pageLocators.MobileNumber.click();
		pageLocators.sendOTP.click();
		
		Thread.sleep(6000);
		ElementToBeClickable(pageLocators.HomesearchBox);
		pageLocators.HomesearchBox.click();
		pageLocators.searchBox.sendKeys(searchProduct);
		pageLocators.selectSearchResult.click();
		
		//Allow locations.
		ElementToBeClickable(pageLocators.allowLocation);
		pageLocators.allowLocation.click();
		pageLocators.btnLocation2.click();
		
		Thread.sleep(3000);
		//Get All results in list.
		List<AndroidElement> result =pageLocators.searchResult;
		
		int resultCount=result.size();
		System.out.println("Total result are :- "+resultCount);
		
		//Select 2nd result.
		result.get(1).click();
		
		ElementToBeClickable(pageLocators.buyNow);
		pageLocators.buyNow.click();
		pageLocators.skipAndContinue.click();
		
		
		PageElements PageElements= new PageElements(driver);
		
		 productName = PageElements.productName.getText();
		 productAmount =PageElements.productAmount.getText();
		 
		 
		 System.out.println(productName);
		 System.out.println(productAmount);

		
		
	}
	
	
	public void ElementToBeClickable(WebElement element) throws InterruptedException 
	{
		WebDriverWait wait = new WebDriverWait(driver, 80);
		wait.until(ExpectedConditions.elementToBeClickable(element));
		
	}
	
	public boolean isElementPresent(WebElement element) throws InterruptedException 
	{
		try 
		{
			Thread.sleep(2000);
			element.isDisplayed();
			return true;
		} catch (org.openqa.selenium.NoSuchElementException e) 
		{
			return false;
		}
	}
	
	public static String getDateTime() 
	{

		// Create object of SimpleDateFormat class and decide the format
		DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss");

		// get current date time with Date()
		Date date = new Date();

		// Now format the date
		String currentDate = dateFormat.format(date);

		String newDate = currentDate.replace('/', '1');
		String newCurrentDate = newDate.replace(':', '5');
		return newCurrentDate;

	}

}
