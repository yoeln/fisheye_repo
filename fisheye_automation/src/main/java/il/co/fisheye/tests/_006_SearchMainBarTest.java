package il.co.fisheye.tests;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import il.co.fisheye.infra.pages.FisheyeEnteryPage;
import il.co.fisheye.infra.pages.FisheyeMoviePage;
import il.co.fisheye.infra.utils.AssertUtils;

public class _006_SearchMainBarTest extends AbstractTestFisheye {

	@Test(dataProvider="differntMovieName")
	public void _006_SearchMainBar(String movieName) throws Exception {

		report.startLevel("Step 1 - browse to fisheye");
		//enter fisheye web page
		doEntry();
		report.endLevel();

		report.startLevel("step 2-click on movie searchBox");
		//insert movie's name in the above movie search 
		FisheyeEnteryPage fisheyeEnteryPage=new FisheyeEnteryPage(driver);
		fisheyeEnteryPage.inputMovieSearchBox(movieName);
		report.endLevel();

		report.startLevel("step 3-click on looking glass image bar");
		//click on the looking glass image in order to reach movie page result
		fisheyeEnteryPage.clickOnSearchSubmitButton();
		report.endLevel();

		report.startLevel("step 4-assert movie name value");
		//validate that the right input in the movie's page result
		FisheyeMoviePage fisheyeMoviePage=new FisheyeMoviePage(driver);
		AssertUtils.assertEquals(fisheyeMoviePage.assertMovieName("value"), movieName, "it should be deadmouse ");
		report.endLevel();
		takeScreenshot("Movie name");


	}

	@DataProvider
	public Object[][] differntMovieName(){
		return new Object[][] {
			new Object[] {"באטמן"},
			new Object[] {"השומרים"},
		};
	}


}
