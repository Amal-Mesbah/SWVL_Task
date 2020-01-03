package swvl.appium_selenium;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.interactions.touch.TouchActions;
import org.openqa.selenium.remote.DesiredCapabilities;

import com.google.common.util.concurrent.Service.State;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.offset.PointOption;
import io.appium.java_client.TouchAction;
import io.appium.java_client.TouchAction;
import io.appium.java_client.TouchAction;

/*-You have to pass the following capabilities to openswvl function in main
1- Deice_name from device settings.
2- UDID by run the command (adb devices) in CMD.
3- Platform name (Andrid).
4- Platform version from device os settings.
5- App package from the command (dumpsys window windows | grep -E ‘mCurrentFocus’) in adb shell.
6- app activity from the command (dumpsys window windows | grep -E ‘mCurrentFocus’) in adb shell.

-For loginswvl function you have to pass registered mobile number and password.
-For bookRide function you have to pass Destination (ex.Haram, Maadi)
*/


public class AppTest {

	static AppiumDriver<MobileElement> driver;

	public static void main (String[]  args) throws Exception 
	{
		openSwvl("<Device name goes here>","<Udid goes here>","<Platform name goes here>","<Platform version goes here","<App package goes here>","<App activity goes here>");
		loginSwvl("<Mobile number goes here", "<Password goes here>");
		bookRide("<Destination goes here>");
		cancelRide();
	}


//Open swvl app by passing all required desired capabilities
	public static void openSwvl(String device_name, String udid, String platform_name, String platform_version,String app_pkg, String app_actv ) throws Exception 
	{

		/*DesiredCapabilities cap = new DesiredCapabilities();
		cap.setCapability("deviceName", "HUAWEI Y5 lite");
		cap.setCapability("udid", "VUY9K19429914695");
		cap.setCapability("platformName", "Android");
		cap.setCapability("platformVersion", "8.1.0");
		cap.setCapability("automationName", "UiAutomator1");
		cap.setCapability("appPackage", "io.swvl.customer");
		cap.setCapability("appActivity", "io.swvl.customer.features.LaunchScreenActivity");
		*/
		DesiredCapabilities cap = new DesiredCapabilities();
		cap.setCapability("deviceName", device_name);
		cap.setCapability("udid", udid);
		cap.setCapability("platformName", platform_name);
		cap.setCapability("platformVersion", platform_version);
		cap.setCapability("automationName", "UiAutomator1");
		cap.setCapability("appPackage", app_pkg);
		cap.setCapability("appActivity", app_actv);
		URL url= new URL ("http://127.0.0.1:4723/wd/hub");
		driver = new AppiumDriver<MobileElement> (url,cap);
		System.out.println("Application Started");

	}
//Login to the app using mob_number and password that you have to provide in main
	public static void loginSwvl(String mob_number, String pswrd) throws Exception
	{
		Thread.sleep(2000);
		MobileElement allow_btn = driver.findElementById("com.android.packageinstaller:id/permission_allow_button");
		allow_btn.click();
		Thread.sleep(5000);
		MobileElement skip_btn = driver.findElementById("io.swvl.customer:id/skip_btn");
		skip_btn.click();
		MobileElement mob_txtbox = driver.findElementById("io.swvl.customer:id/hint");
		mob_txtbox.click();
		MobileElement mob_editbox = driver.findElementById("io.swvl.customer:id/phone_edit_text");
		mob_editbox.sendKeys(mob_number);
		MobileElement next_btn = driver.findElementById("io.swvl.customer:id/next_btn");
		next_btn.click();
		Thread.sleep(2000);
		MobileElement pswrd_editbox = driver.findElementById("io.swvl.customer:id/password_edit_text");
		pswrd_editbox.click();
		pswrd_editbox.sendKeys(pswrd);
		next_btn.click();
		Thread.sleep(2000);
		MobileElement got_it_btn = driver.findElementById("io.swvl.customer:id/got_it_tv");
		got_it_btn.click();
	}
//bookin a new ride you have to provide the destination in main 
	public static void bookRide(String destination) throws Exception
	{
		MobileElement where_to_txtbox = driver.findElementById("io.swvl.customer:id/where_to");
		where_to_txtbox.click();
		MobileElement drop_off_txtbox = driver.findElementById("io.swvl.customer:id/dropoff_et");
		drop_off_txtbox.sendKeys(destination);
		Thread.sleep(5000);	    
		MobileElement loc_search_result_item = driver.findElementByXPath("//android.widget.TextView[@bounds='[32,458][608,515]']");
		loc_search_result_item.click();
		Thread.sleep(5000);
		MobileElement done_btn = driver.findElementById("io.swvl.customer:id/done_btn");
		done_btn.click();
		Thread.sleep(5000);
		MobileElement walk_time_btn = driver.findElementById("io.swvl.customer:id/walking_time_tv");
		walk_time_btn.click();
		Thread.sleep(5000);
		MobileElement timing_search_result_item = driver.findElementByXPath("//android.widget.TextView[@bounds='[48,501][444,547]']");
		timing_search_result_item.click();
		Thread.sleep(2000);
		MobileElement next_btn = driver.findElementById("io.swvl.customer:id/next_btn");
		next_btn.click();
		MobileElement book_btn = driver.findElementById("io.swvl.customer:id/book_btn");
		book_btn.click();
		Thread.sleep(2000);
		done_btn.click();
		System.out.println ("Ride is booked successfully");
	}
//Cancel the booked ride 
	@SuppressWarnings("rawtypes")
	public static void cancelRide () throws Exception
	{

		MobileElement menu_btn = driver.findElementById("io.swvl.customer:id/menu_iv");
		menu_btn.click();
		MobileElement rides_item = driver.findElementById("io.swvl.customer:id/design_menu_item_text");	
		rides_item.click();
		Thread.sleep(3000);
		MobileElement upcoming_ride_item = driver.findElementById("io.swvl.customer:id/ride_card_view");
		upcoming_ride_item.click();
		Thread.sleep(2000);
		TouchAction action = new TouchAction(driver);
		action.press(point(276, 1148)).waitAction().moveTo(point(276,851)).release().perform();
		MobileElement cancel_icon = driver.findElementById("io.swvl.customer:id/cancel_booking_iv");
		cancel_icon.click();
		MobileElement confirm_cancel_btn =driver.findElementById("io.swvl.customer:id/confirm_btn");
		confirm_cancel_btn.click();
		MobileElement cancel_reason_item = driver.findElementById("io.swvl.customer:id/feedback_cancel_booking_option_name_tv");
		cancel_reason_item.click();
		System.out.println ("Ride is canceled successfully");
	}
	@SuppressWarnings("rawtypes")
	public static PointOption point(int i, int j)
	{
		return null;
	}

}