package il.co.fisheye.infra.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import il.co.fisheye.infra.web.By2;




public class FisheyeEnteryPage extends AbstractPage {
	private static final By2 clickOnRegistareButton = new By2("click on button: ",By.xpath("//il//a[@href='https://www.fisheye.co.il/login/?action=register']"));

	
	
	public FisheyeEnteryPage(WebDriver driver) {
		super(driver);

	}
	public void clickOnRegistareButton() {
		bot.click(clickOnRegistareButton);
		
	}




}












