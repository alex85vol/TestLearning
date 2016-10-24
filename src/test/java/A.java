import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class A {

	@Test
	public void testA() throws Exception {
		//WebDriver driver = new FirefoxDriver();
		// System.setProperty("webdriver.ie.driver",
		// "C:\\Program Files\\Internet Explorer\\IEDriverServer.exe");
		// WebDriver driver = new InternetExplorerDriver();
		System.setProperty("webdriver.chrome.driver",
				"D:\\Install\\Selenium\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		//
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.get("https://www.google.com.ua");
		By mySearch = By.id("lst-ib");
		driver.findElement(mySearch).clear();
		driver.findElement(By.id("lst-ib")).sendKeys("selenium ide");
		driver.findElement(By.name("btnG")).click();
		//driver.findElement(By.name("btnG")).click();
		driver.findElement(By.partialLinkText("Selenium IDE Plugi")).click();
		//
		//WebElement actual = driver.findElement(By.xpath("//div[@id='mainContent']/table/tbody/tr/td/p[2]"));
		WebElement actual = driver.findElement(By.xpath("//td[@valign='top']/p[2]"));
		Assert.assertEquals(actual.getText(),
				"Selenium IDE is not only a recording tool: it is a complete IDE. You can choose to use its recording capability, or you may edit your scripts by hand. With autocomplete support and the ability to move commands around quickly, Selenium IDE is the ideal environment for creating Selenium tests no matter what style of tests you prefer.");
		((JavascriptExecutor)driver).executeScript("document.getElementById('sidebar').innerHTML = '<div>HA-HA-HA</div>'");
		//((JavascriptExecutor)driver).executeScript("alert('Hello World!')");
		Thread.sleep(2000);
		//Alert a =  driver.switchTo().alert();
		//a.accept();
		driver.quit();
	}

}
