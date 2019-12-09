package il.co.fisheye.tests;

import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Properties;

import org.testng.annotations.Test;

import il.co.fisheye.infra.pages.FisheyeLoginUserPage;
import il.co.fisheye.infra.utils.AssertUtils;

public class _002_logingWitheCorrectUserNameQPasswordTest extends AbstractTestFisheye {
	private String vervyUserName;

	

	@Test
	public void _002_logingWitheCorrectUserNameQPassword() throws Exception{
		initParams3();
		report.startLevel("Step 1 - browse to fisheye");
		//enter to fisheye.co.il
		doEntry();
		report.endLevel();


		report.startLevel("Step 2 - do login");
		//log on  process with right user name and password 
		doLogin();
		report.endLevel();

		report.startLevel("step 2-Entry log on mode");
		//confirm user name : deadmouse
		FisheyeLoginUserPage fisheyeLoginUserPage = new FisheyeLoginUserPage(driver);
		AssertUtils.assertEquals(fisheyeLoginUserPage.vervyUserName(), vervyUserName,"it should be deadmouse ");
		report.endLevel();


	}



	private void initParams3() throws Exception {


		InputStreamReader input = new InputStreamReader(new FileInputStream("src/main/resources/_002_logingWitheCorrectUserNameQPasswordTest.properties"), "UTF8");
		Properties prop = new Properties();
		prop.load(input);

		//	correctUserName = prop.getProperty("correctUserName");
		//	correctPassword = prop.getProperty("correctPassword");
		vervyUserName=prop.getProperty("vervyUserName");

	}




}
