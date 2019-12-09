package il.co.fisheye.infra.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import il.co.fisheye.infra.web.By2;

public class FisheyeLoginUserPage extends AbstractPage{
	
	private static final By2 logOutUesrMode=new By2("click on the נתק button ",By.xpath("//ul[@class=\"quick-nav clearfix\"]//a[contains(text(),\"נתק\")]"));
	private static final By2 vervyUserName=new By2("the user name of the log on user should be deadmouse",By.xpath("//ul[@class=\"quick-nav clearfix\"]//li[contains(text(),\"deadmouse\")]"));
	private static final By2 clickOnEditProfile=new By2("click on ערוך פרופיל from the high bar ",By.xpath("//ul[@class=\"quick-nav clearfix\"]//a[contains(text(),\"ערוך פרופיל\")]"));
	

	public FisheyeLoginUserPage(WebDriver driver) {
		super(driver);
		
	}
	//click on יציאה from login mode
	public void logOutUesrMode() {
		bot.click(logOutUesrMode);
	}
	//confirm user name after successfully login 
	public String vervyUserName() {
		return bot.getElementText(vervyUserName);
	}
	/// click on ערוך פרופיל 
	public void clickOnEditProfile() {
		bot.click(clickOnEditProfile);
	}

}
