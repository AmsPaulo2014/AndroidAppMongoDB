package testScript;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class PageElements {
	
	public PageElements(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	@FindBy (xpath="//div[@class='_325-ji']")
	public WebElement productName;
	
	@AndroidFindBy (xpath="//span[@class='pMSy0p XU9vZa']")
	public AndroidElement productAmount;
	

}
