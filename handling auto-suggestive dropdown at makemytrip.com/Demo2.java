package newpack;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class Demo2 {
	
	//handling auto-suggestive dropdowns in makemytrip.com

	public static void main(String[] args) throws InterruptedException {
System.setProperty("webdriver.chrome.driver","D:/BELAJAR JAVA/selenium course/JavaDemoProject/driver/chromedriver.exe");
		
		WebDriver driver = new ChromeDriver();
		
		driver.get("http://www.makemytrip.com/");	
		
		driver.manage().window().maximize();
		
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		
		driver.findElement(By.xpath("//a[@data-cy='mmtLogo']/img")).click();
		
		WebElement logo = driver.findElement(By.xpath("//a[@data-cy='mmtLogo']/img"));
		
		Actions a = new Actions (driver);
		
		a.moveToElement(logo).click().build().perform();
		
		driver.findElement(By.id("fromCity")).click();
		
		Thread.sleep(2000);
		
		driver.findElement(By.xpath("//input[@placeholder='From']")).sendKeys("del");
		
		int i=0;
		
		while (i<4) {
		
		Thread.sleep(2000);
			
		driver.findElement(By.xpath("//input[@placeholder='From']")).sendKeys(Keys.DOWN);
		i++;
		}
		
		driver.findElement(By.xpath("//input[@placeholder='From']")).sendKeys(Keys.ENTER);
		
		Thread.sleep(5000);
		driver.quit();
	}
}
