package il.co.fisheye.tests;

import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Properties;

import org.testng.annotations.Test;

import il.co.fisheye.infra.pages.FisheyeEnteryPage;
import il.co.fisheye.infra.pages.FisheyeLoginPage;
import il.co.fisheye.infra.utils.AssertUtils;

public class _003_TheSystemWontLetTheUserEnterWithWrongUserNameTest extends AbstractTestFisheye {

	private String wrongUserName;
	private String correctPassword;
	private String s1="שם משתמש";

	@Test
	public void _003_TheSystemWontLetTheUserEnterWithWrongUserName() throws Exception {
		initParams2();
		report.startLevel("Step 1 - browse to fisheye");
		//enter to fisheye.co.il
		doEntry();
		report.endLevel();

		report.startLevel("step0.2-click on כניסה");
		//click on כניסה button
		FisheyeEnteryPage fisheyeEnteryPage =new FisheyeEnteryPage(driver);
		fisheyeEnteryPage.clickOnLoginButton();
		report.endLevel();

		report.startLevel("step 0.3- insert wrong user name into שם המשתמש field");
		//enter wrong user name
		FisheyeLoginPage fisheyeLoginPage=new FisheyeLoginPage(driver);
		fisheyeLoginPage.insertLogingUserName(wrongUserName);
		report.endLevel();

		report.startLevel("step 0.4-insert correct password into סיסמה field");
		//insert right password
		fisheyeLoginPage.insertLogingPassword(correctPassword);
		report.endLevel();

		report.startLevel("step 0.5-click on כניסה ");
		//click on כניסה button
		fisheyeLoginPage.clickOnloginSumbitButton();
		report.endLevel();

		report.startLevel("step 0.6-assert error message");
		//	confirm error massage that contains the words: שם המשתמש
		String actuLogin_Error = fisheyeLoginPage.confirmErorrMessage();
		AssertUtils.assertTrue(actuLogin_Error.contains(s1), "צריך להכיל את המילים שם המשתמש");
		report.endLevel();	
	}

	private void initParams2() throws Exception {


		InputStreamReader input = new InputStreamReader(new FileInputStream("src/main/resources/_003_TheSystemWontLetTheUserEnterWithWrongUserNameTest.properties"), "UTF8");
		Properties prop = new Properties();
		prop.load(input);

		wrongUserName = prop.getProperty("wrongUserName");
		correctPassword = prop.getProperty("correctPassword");


	}

}
