package il.co.fisheye.tests;

import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Properties;

import org.testng.Assert;
import org.testng.annotations.Test;

import il.co.fisheye.infra.pages.FisheyeEnteryPage;
import il.co.fisheye.infra.pages.FisheyeRegistrationPage;
import il.co.fisheye.infra.utils.AssertUtils;

public class _0011_FaildRegisterTest extends AbstractTestFisheye  {
	private String userName;
	private String email;
	private String title;
	private String s1="ERROR";

	@Test(groups = {"Group2"})
	public void _0011_FaildRegister() throws Exception {
		initParams();

		report.startLevel("Step 1 - browse to fisheye");
		//enter to fisheye.co.il
		doEntry();
		report.endLevel();
		takeScreenshot("enter fisheye");

		report.startLevel("step 2-click on registration button");
		//click on הרשמה button
		FisheyeEnteryPage fisheyeEnteryPage =new FisheyeEnteryPage(driver);
		fisheyeEnteryPage.clickOnRegistareButton();
		report.endLevel();
		takeScreenshot("click on registration button");

		report.startLevel("step 3-verify title:הרשמה");
		//vervy title: הרשמה
		FisheyeRegistrationPage fisheyeRegistrationPage=new FisheyeRegistrationPage(driver);
		Assert.assertEquals(fisheyeRegistrationPage.registrationformTitle(),title);
		report.endLevel();

		report.startLevel("step 4-enter username");
		//insert user name :ggg
		fisheyeRegistrationPage.insertuserName(userName);
		report.endLevel();

		report.startLevel("step 5-enter email");
		/// insert right user name
		fisheyeRegistrationPage.insertEmail(email);
		report.endLevel();

		report.startLevel("step 6-click on Registration button");
		//click on הרשמה button  
		fisheyeRegistrationPage.clickOnRegistratinSubmitButton();
		report.endLevel();

		report.startLevel("step 7-assert error message");
		//confirm error massage the contains the word: ERORR
		String actulError = fisheyeRegistrationPage.confirmErorrMessage();
		AssertUtils.assertTrue(actulError.contains(s1), "it should be error");
	}


	private void initParams() throws Exception {

		InputStreamReader input = new InputStreamReader(new FileInputStream("src/main/resources/_001_FaildToregisterWithSameEmailTest.properties"), "UTF8");
		Properties prop = new Properties();
		prop.load(input);

		userName = prop.getProperty("userName");
		email = prop.getProperty("email");
		title=prop.getProperty("title");

	}




}




