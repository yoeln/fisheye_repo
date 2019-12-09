package il.co.fisheye.infra.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import il.co.fisheye.infra.web.By2;

public class FisheyeRegistrationPage extends AbstractPage{
	
			
	private static final By2 registrationformTitle=new By2("this is the title of registration form: ",By.xpath("//h1[@class='entry-title']//a[contains(text(),'הרשמה')]"));
	private static final By2 insertUserName=new By2("enter username ",By.xpath("//input[@id=\"user_login-tml-page\"]"));
	private static final By2 insertEmail=new By2("enter email ",By.xpath("//input[@id=\"user_email-tml-page\"]"));
	private static final By2 clickOnRegistratinSubmitButton=new By2("click on submit button",By.xpath("//input[@id=\"wp-submit-tml-page\"]"));
	private static final By2 confirmErorrMessage=new By2("confirm error message: ",By.cssSelector("p.error"));
	


	public FisheyeRegistrationPage(WebDriver driver) {
		super(driver);

		
		
	}
	public String registrationformTitle() {
		return bot.getElementText(registrationformTitle);
	}
	public void insertuserName(String userName) {
		bot.click(insertUserName);
		bot.writeToElement(insertUserName,userName);
	}
	public void insertEmail(String email) {
		bot.click(insertEmail);
		bot.writeToElement(insertEmail, email);


	}
	public void clickOnRegistratinSubmitButton() {
		bot.click(clickOnRegistratinSubmitButton);
	}
	public String confirmErorrMessage() {
		return bot.getElementText(confirmErorrMessage);
	}

}
