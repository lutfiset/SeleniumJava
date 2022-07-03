package newpack;

import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;


public class Demo3 {

	public static void main(String[] args) throws IOException, InterruptedException {
	//HANDLING A CALENDAR
		System.setProperty("webdriver.chrome.driver","D:/BELAJAR JAVA/selenium course/JavaDemoProject/driver/chromedriver.exe");
		
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://www.path2usa.com/travel-companions");	
		
		//driver.manage().window().maximize();
		
		driver.manage().timeouts().implicitlyWait(1,TimeUnit.SECONDS);		
		
		driver.findElement(By.id("travel_date")).click();
		while(!driver.findElement(By.className("datepicker-switch")).getText().contains("August 2022")) {
			driver.findElement(By.xpath("(//th[@class='next'])[1]")).click();
		}
		
		List<WebElement> days = driver.findElements(By.className("day"));
		for (int i=0; i< days.size();i++) {
			if(days.get(i).getText().equalsIgnoreCase("7")) {
				days.get(i).click();
				break;
				
			}
		}
		Thread.sleep(2000);
		driver.quit();

	}

}
