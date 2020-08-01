package testScript;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class PageLocators extends BaseClass{
	
	public PageLocators(AndroidDriver<AndroidElement> driver)
	{
		PageFactory.initElements( new AppiumFieldDecorator(driver), this);
	}
	
	
	
	
	@AndroidFindBy (xpath="//android.widget.TextView[@text='English']")
	public AndroidElement selectLanguage;
	
	@AndroidFindBy (xpath="//android.widget.Button[@text='CONTINUE']")
	public AndroidElement continueBtn;
	
	@AndroidFindBy (xpath="//android.widget.TextView[@text='Sign up with']")
	public AndroidElement selectAccount;
	
	@AndroidFindBy (xpath="//android.widget.TextView[@text='081690 00000']")
	public AndroidElement MobileNumber;
	
	@AndroidFindBy (xpath="//android.widget.TextView[@text='Send OTP']")
	public AndroidElement sendOTP;
	
	@AndroidFindBy (id="select_btn")
	public AndroidElement continueBtn1;
	
	@AndroidFindBy (id="search_widget_textbox")
	public AndroidElement HomesearchBox;
	
	@AndroidFindBy (id="com.flipkart.android:id/search_autoCompleteTextView")
	public AndroidElement searchBox;
	
	//android.widget.ImageView[@enabled='true']
	
	@AndroidFindBy (xpath="//android.view.ViewGroup/android.view.ViewGroup[@displayed='true']")
	public static List<AndroidElement> searchResult;
	
	@AndroidFindBy (id="com.flipkart.android:id/root_titles")
	public AndroidElement selectSearchResult;
	
	
	
	
	@AndroidFindBy (id="custom_back_icon")
	public AndroidElement closeScreenBtn;
	
	
	@AndroidFindBy (id="not_now_button")
	public AndroidElement notAllowLocation;
	
	@AndroidFindBy (id="com.flipkart.android:id/allow_button")
	public AndroidElement allowLocation;
	
	@AndroidFindBy (id="//android.widget.Button[@text='Allow']")
	public AndroidElement btnLocation2;
	
	@AndroidFindBy (xpath="//android.view.ViewGroup[1]/android.widget.LinearLayout")
	public AndroidElement selectProduct;
	
	//android.view.ViewGroup[1]/android.widget.LinearLayout
	
	
	@AndroidFindBy (xpath="//android.widget.TextView[@text='SKIP & CONTINUE']")
	public AndroidElement skipAndContinue;
	
	@AndroidFindBy (xpath="//android.widget.TextView[@text='BUY NOW']")
	public AndroidElement buyNow;
	

}
