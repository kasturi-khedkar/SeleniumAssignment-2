import static org.junit.Assert.*;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class BootStrapDragDrop {

	WebDriver driver;
	String url="https://www.jquery-az.com/boots/demo.php?ex=63.0_2";

	@Before
	public void setUp() throws Exception {

		System.setProperty("webdriver.chrome.driver","F:\\selenium\\Selenium New Jar Files\\chromedriver.exe");
		driver=new ChromeDriver();
		driver.get(url);
		driver.manage().window().maximize();

		//driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
	}

	@After
	public void tearDown() throws Exception {

		driver.quit();
	}

	@Test
	public void test() throws InterruptedException {

		Thread.sleep(3000);
		driver.findElement(By.xpath("/html/body/div[3]/table/tbody/tr[2]/td[3]/div/span/div/button")).click();

		List<WebElement> ele=driver.findElements(By.xpath("//ul[contains(@class,'multiselect-container')]//li//a//label"));

		for(int i=0;i<ele.size();i++) 
		{
			Thread.sleep(5000);
			String value=ele.get(i).getText();
			if(value.equalsIgnoreCase("BootStrap")||value.equalsIgnoreCase("Java")||value.equalsIgnoreCase("Oracle")) {
				ele.get(i).click();
			}
		}

	}

}
