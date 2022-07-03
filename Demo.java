package newpack;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;





public class Demo {

	public static void main(String[] args) throws IOException {

		System.setProperty("webdriver.chrome.driver","D:/BELAJAR JAVA/selenium course/JavaDemoProject/driver/chromedriver.exe");
		
		//selenium wbdriver sample code
		WebDriver driver = new ChromeDriver();
		
		//browser akan terbuka, isi disini
		driver.get("http://omayo.blogspot.com/");	
		//driver.get("http://tutorialsninja.com/demo/index.php?route=account/login");
		
		//maximize the browser window
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		
		//take  screenshots
		File JavaDemoProject = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
	
		FileUtils.copyFile(JavaDemoProject,new File ("screenshot\\screenshot5.png"));
		
		driver.findElement(By.linkText("onlytestingblog")).click();
		
		//again, another screenshot will be take here
		File JavaDemoProject2 = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		
		FileUtils.copyFile(JavaDemoProject2,new File ("screenshot\\screenshot6.png"));
	driver.quit();

	}

}
