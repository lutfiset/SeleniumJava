package tpack;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Demo111 {

	public static void main(String [] args) throws InterruptedException {
	
		//webdriver manager
		WebDriverManager.chromedriver().setup();
		
		WebDriver driver = new ChromeDriver();
		driver.get("http://tutorialsninja.com/demo/index.php?route=common/home");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		//NAVIGATING TO login page
		driver.findElement(By.linkText("My Account")).click();
		driver.findElement(By.linkText("Login")).click();
		
		//login to the application with a valid credentials
		driver.findElement(By.id("input-email")).sendKeys("arun.selenium5@gmail.com");
		driver.findElement(By.id("input-password")).sendKeys("Second@123");
		driver.findElement(By.xpath("//input[@value='Login']")).click();
		
		//searching for iphone
		driver.findElement(By.name("search")).sendKeys("iPhone");
		driver.findElement(By.cssSelector(".fa.fa-search")).click();
		
		//adding the item from product display page to cart
		driver.findElement(By.linkText("iPhone")).isDisplayed();
		driver.findElement(By.linkText("iPhone")).click();		
		WebElement quantity = driver.findElement(By.id("input-quantity"));
		quantity.clear();
		quantity.sendKeys("2");
		driver.findElement(By.id("button-cart")).click();
		System.out.println(driver.findElement(By.cssSelector("div.alert.alert-success.alert-dismissible")).getText());
		
		//navigating to shopping cart
		driver.findElement(By.xpath("//a[contains(text(),'shopping cart')]")).click();
		
		//navigating to ceckout page
		driver.findElement(By.xpath("//a[contains(text(),'Checkout')]")).click();
		System.out.println(driver.findElement(By.cssSelector("div.alert.alert-danger.alert-dismissible")).getText());
		Thread.sleep(5000);
		
		driver.quit();
		
	}
}
