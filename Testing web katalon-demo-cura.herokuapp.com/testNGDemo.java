package tpack;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;


public class testNGDemo {
	
	// Test Case
	@Test   // ini testNG Annotasi
	public void sampleAutomation() throws InterruptedException {

	WebDriverManager.chromedriver().setup();
	WebDriver driver = new ChromeDriver();
	driver.get("https://katalon-demo-cura.herokuapp.com/");
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
	
	driver.findElement(By.id("btn-make-appointment")).click();
	
	//navigating to login page
	driver.findElement(By.id("txt-username")).sendKeys("John Doe");
	driver.findElement(By.id("txt-password")).sendKeys("ThisIsNotAPassword");
	driver.findElement(By.id("btn-login")).click();
	
	//NAVIGATING to create an appointment
	//handling the drop-down combo box
	driver.findElement(By.id("combo_facility")).click();
	Thread.sleep(2000);
	driver.findElement(By.id("combo_facility")).sendKeys("Seoul");
	
	//handling the checklist 
	driver.findElement(By.id("chk_hospotal_readmission")).click();
	driver.findElement(By.id("radio_program_medicare")).click();
	
	// handling a calendar
	driver.findElement(By.id("txt_visit_date")).click();
	while(!driver.findElement(By.className("datepicker-switch")).getText().contains("August 2022")) {
		driver.findElement(By.xpath("(//th[@class='next'])[1]")).click();
	}
	List<WebElement> days = driver.findElements(By.className("day"));
	for (int i=0; i< days.size();i++) {
		if(days.get(i).getText().equalsIgnoreCase("3")) {
			days.get(i).click();
			break;
		}
	}
	
	driver.findElement(By.id("txt_comment")).sendKeys("I hope the doctor will be available at that time");
	driver.findElement(By.id("btn-book-appointment")).click();
	
	System.out.println(driver.findElement(By.cssSelector("body:nth-child(2) section.section.bg-primary:nth-child(4) div.container > div.row")).getText());
	
	Thread.sleep(5000);
	driver.quit();
	}

}

