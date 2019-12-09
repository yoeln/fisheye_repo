package il.co.fisheye.tests;



import static org.testng.Assert.assertEquals;

import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Properties;

import org.testng.annotations.Test;

import il.co.fisheye.infra.pages.FisheyeEnteryPage;
import il.co.fisheye.infra.pages.FisheyeLoginUserPage;

public class _005_SystemLogOutTest  extends  AbstractTestFisheye {
	
	private String loginbutton;
	
	
	@Test
	public void _005_SystemLogOut() throws Exception {
		
		initParams4();
		report.startLevel("Step 1 - browse to fisheye");
		//enter to fisheye.co.il
		doEntry();
		report.endLevel();
		
		report.startLevel("Step 2 -  do login");
		//click on כניסה button and log on as valid user
		 doLogin();
		report.endLevel();
		
		report.startLevel("step3-click on נתק");
		//click on נתק button
		FisheyeLoginUserPage fisheyeLoginUserPage=new FisheyeLoginUserPage(driver);
		fisheyeLoginUserPage.logOutUesrMode();
		report.endLevel();
		
		report.startLevel("step 3-vervy log out by seeing login button");
		//assert that the login button כניסה is appeared
		FisheyeEnteryPage fisheyeEnteryPage=new FisheyeEnteryPage(driver);
		assertEquals(fisheyeEnteryPage.vervyLoginbutton(),loginbutton);
		report.endLevel();
	}
	private void initParams4() throws Exception {
		InputStreamReader input = new InputStreamReader(new FileInputStream("src/main/resources/_005_SystemLogOutTest.properties"), "UTF8");
		Properties prop = new Properties();
		prop.load(input);

		loginbutton=prop.getProperty("loginbutton");
		
	}
		
	}


