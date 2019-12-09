package il.co.fisheye.tests;



import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Properties;

import org.testng.annotations.Test;

import il.co.fisheye.infra.pages.FisheyeLoginUserPage;
import il.co.fisheye.infra.pages.FisheyeeditProfilePage;
import il.co.fisheye.infra.utils.AssertUtils;



public class _004_changeUserNameTest extends AbstractTestFisheye {

	private String title;
	private String vervyUserName;
	private String newName;


	@Test
	public void _004_changeUserName() throws Exception {
		initParams3();
		report.startLevel("Step 1 - browse to fisheye");
		//enter to fisheye.co.il
		doEntry();
		report.endLevel();

		report.startLevel("Step 2 - browse to fisheye and do login");
		// log on
		doLogin();
		report.endLevel();

		report.startLevel("step 3-click on ערוך פרופיל button");
		// click on ערוך פרופיל button
		FisheyeLoginUserPage fisheyeLoginUserPage=new FisheyeLoginUserPage(driver);
		fisheyeLoginUserPage.clickOnEditProfile();
		report.endLevel();

		report.startLevel("step 4- assert edit profile title page");
		//assert title הפרופיל שלך
		FisheyeeditProfilePage fisheyeeditProfilePage=new FisheyeeditProfilePage(driver);
		AssertUtils.assertEquals(title,fisheyeeditProfilePage.confirmprofileTitle(),"the title is : הפרופיל שלך" );
		report.endLevel();

		report.startLevel("step 5 select new user name");
		//select new user name:יואל
		fisheyeeditProfilePage.selectNewUeserName();
		report.endLevel();

		report.startLevel("step 6-click on update button");
		//click on update button
		fisheyeeditProfilePage.clickupdateProfileButton();
		report.endLevel();
		
		report.startLevel("step 7-vervy new user name");
		//assert old user name :יואל
		AssertUtils.assertEquals(fisheyeeditProfilePage.vervyNewUserName(), newName,"it should be יואל ");
		report.endLevel();

		report.startLevel("step 8-select deadmouse profile name back");
		// select old user name
		fisheyeeditProfilePage.selectOldUeserNane();
		report.endLevel();

		report.startLevel("step 9-click on update button again");
		//click again on update button
		fisheyeeditProfilePage.clickupdateProfileButton();
		report.endLevel();

		report.startLevel("step 10-vervy old user name");
		//assert old user name :deadmouse
		FisheyeLoginUserPage fisheyeLoginUserPage1 = new FisheyeLoginUserPage(driver);
		AssertUtils.assertEquals(fisheyeLoginUserPage1.vervyUserName(), vervyUserName,"it should be deadmouse ");
		report.endLevel();
	}

	private void initParams3() throws Exception {

		InputStreamReader input = new InputStreamReader(new FileInputStream("src/main/resources/changeUserNameTest.properties"), "UTF8");
		Properties prop = new Properties();
		prop.load(input);

		title=prop.getProperty("title");
		vervyUserName=prop.getProperty("vervyUserName");
		newName=prop.getProperty("newName");

	}


}
