package il.co.fisheye.tests;


import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;

import il.co.fisheye.infra.pages.FisheyeEnteryPage;
import il.co.fisheye.infra.web.BrowserType;
import il.co.fisheye.infra.web.WebDriverFactory;
import il.co.topq.difido.ReportDispatcher;
import il.co.topq.difido.ReportManager;

@Listeners(il.co.topq.difido.ReportManagerHook.class)
public abstract class AbstractTestFisheye {

	protected WebDriver driver;
	protected ReportDispatcher report = ReportManager.getInstance();

	@BeforeMethod
	public void beforeMethod() throws Exception {

		if (driver == null) {
			driver = WebDriverFactory.getDriver(BrowserType.CHROME);
		}
	}

	public FisheyeEnteryPage doLogin() {

		String url = "https://fisheye.co.il";
		report.log("Browse to URL: " + url);
		driver.get(url);

		FisheyeEnteryPage fisheyeEnteryPage = new FisheyeEnteryPage(driver);
		
		return fisheyeEnteryPage;

	}

	/*
	protected void initWebDriver() {

		System.setProperty("webdriver.chrome.driver", "webdrivers/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	}
	 */
}
