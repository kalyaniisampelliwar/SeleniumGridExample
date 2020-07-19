package suiteA;

import org.testng.annotations.Test;

public class TestA extends Base{
	@Test
	public void testCase1() throws InterruptedException {
		System.out.println("Starting A");
		openBrowser("Mozilla");
		Thread.sleep(5000);
		System.out.println("Ending A");
    }
	

}
