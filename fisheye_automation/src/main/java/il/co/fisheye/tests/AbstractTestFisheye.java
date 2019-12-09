package il.co.fisheye.tests;


import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Properties;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;

import il.co.fisheye.config.MainConfig;
import il.co.fisheye.infra.pages.FisheyeEnteryPage;
import il.co.fisheye.infra.pages.FisheyeLoginPage;
import il.co.fisheye.infra.web.WebDriverFactory;
import il.co.topq.difido.ReportDispatcher;
import il.co.topq.difido.ReportManager;
import il.co.topq.difido.model.Enums.Status;

@Listeners(il.co.topq.difido.ReportManagerHook.class)
public abstract class AbstractTestFisheye {
	private String correctUserName;
	private String correctPassword;


	protected static WebDriver driver;
	protected static ReportDispatcher report = ReportManager.getInstance();

	@BeforeMethod(alwaysRun=true)
	public void beforeMethod() throws Exception {

		DesiredCapabilities dc=DesiredCapabilities.chrome();
		//dc.setCapability("applicationCacheEnabled", "false"); 
		dc.setCapability(CapabilityType.SUPPORTS_APPLICATION_CACHE, false);
		MainConfig.initFromFile("src/main/resources/MainConfig.properties");

	//	if (driver == null) {
			driver = WebDriverFactory.getDriver(MainConfig.browserType);
	//	}
	}

	public FisheyeEnteryPage doEntry() {

		String url = "https://fisheye.co.il";
		report.log("Browse to URL: " + url);
		driver.get(url);

		FisheyeEnteryPage fisheyeEnteryPage = new FisheyeEnteryPage(driver);

		return fisheyeEnteryPage;

	}
	public static void takeScreenshot(String description) throws Exception {

		if (driver != null) {
			File screenshotFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
			report.addImage(screenshotFile, description);
		}
		else {
			report.log("driver == null; Can't take screenshot.", Status.warning);
		}
	}

	public FisheyeLoginPage doLogin() throws Exception {
		initParams2();

	//	report.startLevel("Step 0.1 - browse to fisheye");
	//	FisheyeEnteryPage fisheyeEnteryPage = doEntry();
	//	report.endLevel();

		report.startLevel("step0.2-click on כניסה");
		FisheyeEnteryPage fisheyeEnteryPage =new FisheyeEnteryPage(driver);
		fisheyeEnteryPage.clickOnLoginButton();
		report.endLevel();

		report.startLevel("step 0.3- insert correct user name into שם המשתמש field");
		FisheyeLoginPage fisheyeLoginPage=new FisheyeLoginPage(driver);
		fisheyeLoginPage.insertLogingUserName(correctUserName);
		report.endLevel();

		report.startLevel("step 0.4-insert correct password into סיסמה field");
		fisheyeLoginPage.insertLogingPassword(correctPassword);
		report.endLevel();

		report.startLevel("step 0.5-click on כניסה ");
		fisheyeLoginPage.clickOnloginSumbitButton();
		report.endLevel();



		return fisheyeLoginPage;


	}

	private void initParams2() throws Exception {


		InputStreamReader input = new InputStreamReader(new FileInputStream("src/main/resources/_002_logingWitheCorrectUserNameQPasswordTest.properties"), "UTF8");
		Properties prop = new Properties();
		prop.load(input);

		correctUserName = prop.getProperty("correctUserName");
		correctPassword = prop.getProperty("correctPassword");


	}
	@AfterMethod(alwaysRun=true)
	public static void faildTest(ITestResult result){


		if(!result.isSuccess()){
			File screenshotFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
			report.addImage(screenshotFile, "");



		}





	}
	@AfterSuite(alwaysRun=true)
	public void afterClass() {
		driver.close();

	}

}




/*
	protected void initWebDriver() {

		System.setProperty("webdriver.chrome.driver", "webdrivers/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	}
 */

