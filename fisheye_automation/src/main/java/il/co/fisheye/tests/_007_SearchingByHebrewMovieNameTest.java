package il.co.fisheye.tests;

import java.io.FileInputStream;

import java.io.InputStreamReader;
import java.util.Properties;


import org.testng.annotations.Test;

import il.co.fisheye.infra.pages.FisheyeEnteryPage;
import il.co.fisheye.infra.pages.FisheyeMovieResultPage;
import il.co.fisheye.infra.utils.AssertUtils;


public class _007_SearchingByHebrewMovieNameTest extends AbstractTestFisheye {

	private String movieName;

	@Test(groups = {"Group1"})
	public void _007_SearchingByHebrewMovieName() throws Exception {

		initParams();

		report.startLevel("Step 1 - browse to fisheye");
		//enter fisheye web page
		 doEntry();
		report.endLevel();

		report.startLevel("step 2-insert movie name into the filem search page");
		// insert hebrew movie's name in the  movie search result bar-unsert:באטמן מתחיל 
		FisheyeEnteryPage fisheyeEnteryPage =new FisheyeEnteryPage(driver);
		fisheyeEnteryPage.inputMoviePageSearchBox(movieName);
		report.endLevel();

		report.startLevel("step 3- click on חפש button");
		//click חפש
		fisheyeEnteryPage.clickonSearchButtonForMoviePage();
		report.endLevel();

		report.startLevel("step 4-click filem image ");
		// click film image 
		fisheyeEnteryPage.clickOnFilemImage();
		report.endLevel();

		report.startLevel("step 5-assert movie name page");
		//assert page name :באטמן מתחיל
		FisheyeMovieResultPage fisheyeMovieResultPage=new FisheyeMovieResultPage(driver);		
		AssertUtils.assertEquals(movieName, fisheyeMovieResultPage.getMovieNameText(), "it should be: באטמן מתחיל" );
		report.endLevel();
	}

	private void initParams() throws Exception {

		
		InputStreamReader input = new InputStreamReader(new FileInputStream("src/main/resources/_007_SearchingByHebrewMovieNameTest.properties"), "UTF8");
		Properties prop = new Properties();
		prop.load(input);

		movieName = prop.getProperty("movieName");
	}
}







