package salesforce;

import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class OpurtunitysSort {
	
	@Test
	public void OpurtunitySort() throws InterruptedException {
		// TODO Auto-generated method stub

		ChromeOptions chromeoption = new ChromeOptions();
		chromeoption.addArguments("--disable-notifications");
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver(chromeoption);
		driver.manage().window().maximize();
		driver.get("https://login.salesforce.com/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.findElement(By.id("username")).sendKeys("hari.radhakrishnan@qeagle.com");
		driver.findElement(By.id("password")).sendKeys("Leaf@1234");
		driver.findElement(By.id("Login")).click();
		Thread.sleep(4000);
		
		try {
			WebElement switchEle = driver.findElement(By.xpath("//a[@class='switch-to-lightning']"));
			switchEle.click();

		} catch (Exception e) {
			
		}
		WebDriverWait obj = new WebDriverWait(driver, Duration.ofSeconds(20));
		WebElement findElement = driver.findElement(By.xpath("//div[@class='slds-icon-waffle']"));
		obj.until(ExpectedConditions.visibilityOf(findElement));
 findElement.click();
		obj.until(ExpectedConditions.elementToBeClickable(findElement));
		driver.findElement(By.xpath("//button[text()='View All']")).click();
		driver.findElement(By.xpath("//p[text()='Sales']")).click();
		// driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		Thread.sleep(4000);
		JavascriptExecutor obj1 = (JavascriptExecutor) driver;

		obj1.executeScript("arguments[0].click();", driver.findElement(By.xpath("//span[text()='Opportunities']")));
		driver.findElement(By.xpath("//button[@title='Display as Table']")).click();
		driver.findElement(By.xpath("(//div[@class='slds-dropdown slds-dropdown_left']//a)[1]")).click();
		String datedd = driver.findElement(By.xpath("(//span[@class='uiOutputDate'])[1]")).getText();
		WebElement findElement2 = driver.findElement(By.xpath("//span[@title='Close Date']"));
		Thread.sleep(6000);
		obj1.executeScript("arguments[0].click();",findElement2);
		String dateaa = driver.findElement(By.xpath("(//span[@class='uiOutputDate'])[1]")).getText();
		Assert.assertEquals(datedd,dateaa);
		//if(datedd.equals(dateaa))
		//{
		//	System.out.println("Not Equal");
		//}
		//else
		//{
			//System.out.println("Changed to Ascending, Equal");
		//}

	}
	

}
