package il.co.fisheye.pages;

import java.text.SimpleDateFormat;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class FisheyeEnteryPage {
	
	@Test
	public void createRepositoryAddIssueTest() throws InterruptedException {
		
		
		
		System.setProperty("webdriver.chrome.driver", "webdrivers/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

	//	String username = "yoeln";
	//	String password = "Giveme123456789";
	//	String repositoryName = "new-repo-" + dateFormat1.format(testStartTime);
		
		driver.get("https://fisheye.co.il");
	}

}
