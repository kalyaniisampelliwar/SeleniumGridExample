package suiteA;

import org.testng.annotations.Test;

public class TestB extends Base{

	@Test
	public void testCase1() throws InterruptedException {
		System.setProperty("webdriver.chrome.driver",
		         "D:\\Selenium_WebDriver\\chromedriver.exe");
		System.out.println("Starting B");
		openBrowser("Chrome");
		Thread.sleep(5000);
		System.out.println("Ending B");
	
	}
}
