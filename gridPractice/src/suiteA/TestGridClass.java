package suiteA;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class TestGridClass {
	public WebDriver driver;
	public String URL, Node;
	public DesiredCapabilities desired_capabilities;

	@Parameters("browser")
	@BeforeTest
	public void launchbrowser(String browser) throws MalformedURLException, InterruptedException {
		String URL = "http://www.calculator.net";
		desired_capabilities = new DesiredCapabilities();

		if (browser.equalsIgnoreCase("chrome")) {
			System.out.println(" Executing on CHROME");
			DesiredCapabilities cap = DesiredCapabilities.chrome();
			cap.setBrowserName("chrome");
			String Node = "http://192.168.0.7:4444/wd/hub";
			driver = new RemoteWebDriver(new URL(Node), cap);
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			driver.navigate().to(URL);		
			driver.manage().window().maximize();
		} 
		else if (browser.equalsIgnoreCase("firefox")) {
			System.out.println(" Executing on Firefox");
			DesiredCapabilities cap = DesiredCapabilities.chrome();
			cap.setBrowserName("chrome");
			String Node = "http://192.168.0.7:5568/wd/hub";
			driver = new RemoteWebDriver(new URL(Node), cap);
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			driver.navigate().to(URL);
			Thread.sleep(15000);
			driver.manage().window().maximize();
		}  else {
			throw new IllegalArgumentException("The Browser Type is Undefined");
		}
	}

	@Test
	public void calculatepercent() {
		// Click on Math Calculators
		driver.findElement(By.xpath("//a[contains(text(),'Math')]")).click();
		// Click on Percent Calculators
		driver.findElement(By.xpath("//a[contains(text(),'Percentage Calculator')]")).click();
		// Enter value 17 in the first number of the percent Calculator
		driver.findElement(By.id("cpar1")).sendKeys("17");
		// Enter value 35 in the second number of the percent Calculator
		driver.findElement(By.id("cpar2")).sendKeys("35");

		// Click Calculate Button
		driver.findElement(By.xpath("(//input[contains(@value,'Calculate')])[1]")).click();
		// Get the Result Text based on its xpath
		String result = driver.findElement(By.xpath(".//*[@id='content']/p[2]/font/b")).getText();
		// Print a Log In message to the screen
		System.out.println(" The Result is " + result);
		if (result.equals("5.95")) {
			System.out.println(" The Result is Pass");
		} else {
			System.out.println(" The Result is Fail");
		}
	}

	@AfterTest
	void tearDown() {
		// make sure to close your WebDriver:
		driver.quit();
	}

}