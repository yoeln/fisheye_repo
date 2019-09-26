package il.co.fisheye.tests;

import java.io.FileInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Properties;

import org.testng.annotations.Test;

import il.co.fisheye.infra.pages.FisheyeEnteryPage;

public class _001_FaildToEnterWithRrgisteredEmailAndNewUserNmeTest extends AbstractTestFisheye {

	private String movieName;
	
	@Test
	public void _001_faildToEnterWithRrgisteredEmailAndNewUserNme() throws Exception {

		initParams();
		
		report.startLevel("Step 1 - browse to fisheye");
		FisheyeEnteryPage fisheyeEnteryPage = doLogin();
		fisheyeEnteryPage.clickOnRegistareButton();
		fisheyeEnteryPage.inputMoviePageSearchBox(movieName);
		//fisheyeEnteryPage.writeTobox(text);
		report.endLevel();
	}

	private void initParams() throws Exception {

		//InputStream input = new FileInputStream("src/main/resources/_001_FaildToEnterWithRrgisteredEmailAndNewUserNmeTest.properties", "UTF8");
		InputStreamReader input = new InputStreamReader(new FileInputStream("src/main/resources/_001_FaildToEnterWithRrgisteredEmailAndNewUserNmeTest.properties"), "UTF8");
		Properties prop = new Properties();
		prop.load(input);

		movieName = prop.getProperty("movieName");
	}
}







