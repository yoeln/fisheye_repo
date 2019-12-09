package il.co.fisheye.tests;

import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Properties;

import org.testng.annotations.Test;

import il.co.fisheye.infra.pages.FisheyeEnteryPage;
import il.co.fisheye.infra.utils.AssertUtils;

public class _010_choseFirstInstancTest extends AbstractTestFisheye {
	private String word;


	@Test
	public void _010_choseFirstInstanc() throws Exception{
		initParams();
		report.startLevel("Step 1 - browse to fisheye");
		//enter to fisheye.co.il
		doEntry();
		report.endLevel();

		report.startLevel("step 2-click on the first pic from the right");
		// choose the first instance from the right cube
		FisheyeEnteryPage fisheyeEnteryPage =new FisheyeEnteryPage(driver);
		fisheyeEnteryPage.clickFirstPic();
		report.endLevel();

		report.startLevel("step 3-valida partiel text of the writer permanent text:מאת ");
		//validate text :מאת
		String permanenText = fisheyeEnteryPage.writerByName();
		AssertUtils.assertTrue(permanenText.contains(word), "it tests partiel text so if there is מאת");
		report.endLevel();

	}
	private void initParams() throws Exception {

		InputStreamReader input = new InputStreamReader(new FileInputStream("src/main/resources/_010_choseFirstInstancTest.properties"), "UTF8");
		Properties prop = new Properties();
		prop.load(input);


		word=prop.getProperty("word");

	}





}
