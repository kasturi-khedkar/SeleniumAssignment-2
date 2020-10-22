import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class DragAndDrop {

	WebDriver driver;
	String url="https://jqueryui.com/droppable/";
	
	@Before
	public void setUp() throws Exception {
		
		System.setProperty("webdriver.chrome.driver","F:\\selenium\\Selenium New Jar Files\\chromedriver.exe");
		driver=new ChromeDriver();
		driver.get(url);
		driver.manage().window().maximize();
		Thread.sleep(3000);
		
	}

	@After
	public void tearDown() throws Exception {
		
		driver.quit();
	}

	@Test
	public void test() {
		
		driver.switchTo().frame(0);
		WebElement dragPart=driver.findElement(By.id("draggable"));
		WebElement dropPart=driver.findElement(By.id("droppable"));
		
		Actions action=new Actions(driver);
		
		action.dragAndDrop(dragPart,dropPart).perform();
		
		String txt=driver.findElement(By.xpath("//*[@id=\"droppable\"]/p")).getText();
		
		if(txt.equalsIgnoreCase("Dropped!")) {
			System.out.println("Successfully Droped");
		}
		
	}

}
