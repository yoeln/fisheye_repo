package il.co.fisheye.tests;

import org.testng.annotations.Test;

import il.co.fisheye.infra.pages.FisheyeEnteryPage;

public class _oo1_FaildToEnterWithRrgisteredEmailAndNewUserNmeTest extends AbstractTestFisheye {


	@Test
	public _oo1_FaildToEnterWithRrgisteredEmailAndNewUserNmeTest() {
		
		

		report.startLevel("Step 1 - Perform login");
		FisheyeEnteryPage fisheyeEnteryPage=doLogin();
		//fisheyeEnteryPage.clickOnRegistareButton();
		report.endLevel();




	}
 }







