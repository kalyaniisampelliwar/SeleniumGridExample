package suiteA;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

public class PracticeGrid {
	
	public static void main(String args[]) throws MalformedURLException {
		
		System.setProperty("webdriver.chrome.driver","‪D:\\Selenium_WebDriver\\chromedriver.exe");
		DesiredCapabilities dc = new DesiredCapabilities();
		dc.setBrowserName("chrome");
		WebDriver driver = new RemoteWebDriver(new URL("http://192.168.0.7:5558/wd/hub"),dc);
		driver.get("https://www.qtpselenium.com/login");
	}

}
