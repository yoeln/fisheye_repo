package il.co.fisheye.infra.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import il.co.fisheye.infra.web.By2;

public class FisheyeeditProfilePage extends AbstractPage{

	public FisheyeeditProfilePage(WebDriver driver) {
		super(driver);

	}

	private static final By2 profileTitle=new By2("vervy edit profile title",By.xpath("//h1[@class=\"entry-title\"]//a[contains(text(),\"הפרופיל שלך\")]"));
	private static final By2 updateProfileButton=new By2("click on update profile button ",By.xpath("//input[@class=\"button-primary\"]"));
	private static final By2 selectOldUeserNane=new By2("select old name: deadmouse",By.xpath("//select[@name=\"display_name\"]"));
	private static final By2 selectNewUeserNane1=new By2("select first name: יואל",By.xpath("//select[@name=\"display_name\"]"));
	private static final By2 vervyNewUserName=new By2("vervy new user name is יואל",By.xpath("//ul[@class=\"quick-nav clearfix\"]//li[contains(text(),\"יואל\")]"));



	//confirm prifle name: הפרופיל שלך 
	public String confirmprofileTitle() {
		return bot.getElementText(profileTitle);
	}
	// chose differnt user name:יואל 
	public void selectNewUeserName() {
		bot.click(selectNewUeserNane1);
		bot.selectByText(selectNewUeserNane1, "יואל");

	}
	// click on update button
	public void clickupdateProfileButton() {
		bot.click(updateProfileButton);
	}
	//select again old user name :deadmouse
	public void selectOldUeserNane() {
		bot.click(selectOldUeserNane);
		bot.selectByText(selectOldUeserNane, "deadmouse");


	}
	public String vervyNewUserName() {
		return bot.getElementText(vervyNewUserName);
	}

}
