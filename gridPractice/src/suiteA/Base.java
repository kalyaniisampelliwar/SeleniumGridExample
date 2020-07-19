package suiteA;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

public class Base {
	
public WebDriver driver;
	
	public void openBrowser(String browser) {
		DesiredCapabilities cap = null;
		if(browser.equals("Mozilla")) {
			cap = new DesiredCapabilities();
			cap.setBrowserName("firefox");
			cap.setPlatform(Platform.WINDOWS);
		}else if(browser.equals("Chrome")) {
			cap = new DesiredCapabilities();
			cap.setBrowserName("chrome");
			cap.setPlatform(Platform.WINDOWS);
		}else if(browser.equals("IE")) {
			cap = new DesiredCapabilities();
			cap.setBrowserName("iexplore");
			cap.setPlatform(Platform.WINDOWS);
		}
		
		try {
			driver = new RemoteWebDriver(new URL("http://192.168.0.7:4444/wd/hub"), cap);
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
