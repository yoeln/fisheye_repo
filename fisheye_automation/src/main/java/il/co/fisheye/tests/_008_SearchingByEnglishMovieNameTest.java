package il.co.fisheye.tests;

import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Properties;

import org.testng.annotations.Test;

import il.co.fisheye.infra.pages.FisheyeEnteryPage;
import il.co.fisheye.infra.pages.FisheyeMovieResultPage;
import il.co.fisheye.infra.utils.AssertUtils;

public class _008_SearchingByEnglishMovieNameTest extends AbstractTestFisheye{

	private String englishMovieName;


	@Test(groups = {"Group1"})
	public void _008_SearchingByEnglishMovieName() throws Exception {

		initParams3();

		report.startLevel("Step 1 - browse to fisheye");
		//enter to fisheye.co.il
		FisheyeEnteryPage fisheyeEnteryPage = doEntry();
		report.endLevel();

		report.startLevel("step 2-insert english's movie name into the filem search page");
		//insert batmen begins into the lower movie page bar
		fisheyeEnteryPage.inputMoviePageSearchBox(englishMovieName);
		report.endLevel();

		report.startLevel("step 3- click on לועזי button");
		//click לועזי
		fisheyeEnteryPage.radioButtonForginLangigge();
		report.endLevel();

		report.startLevel("step 4- click on חפש button");
		//click חפש
		fisheyeEnteryPage.clickonSearchButtonForMoviePage();
		report.endLevel();

		report.startLevel("step 5-click filem image ");
		// click film image
		fisheyeEnteryPage.clickOnFilemImage();
		report.endLevel();

		report.startLevel("step 6-assert movie name page");
		//assert page name :batmen begins
		FisheyeMovieResultPage fisheyeMovieResultPage=new FisheyeMovieResultPage(driver);
		fisheyeMovieResultPage.assertMovieName();
		AssertUtils.assertEquals(englishMovieName,fisheyeMovieResultPage.assertEnglishMovieName(),"it is batmen begins" );
		report.endLevel();
	}

	private void initParams3() throws Exception {

		//InputStream input = new FileInputStream("src/main/resources/_001_FaildToEnterWithRrgisteredEmailAndNewUserNmeTest.properties", "UTF8");
		InputStreamReader input = new InputStreamReader(new FileInputStream("src/main/resources/_008_SearchingByEnglishMovieNameTest.properties"), "UTF8");
		Properties prop = new Properties();
		prop.load(input);

		englishMovieName = prop.getProperty("englishMovieName");
	}

}
