package il.co.fisheye.infra.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import il.co.fisheye.infra.web.By2;

public class FisheyeLoginPage extends AbstractPage {

	private static final By2 insertLogingUserName=new By2("insert login user name :",By.xpath("//input[@id='log-tml-page']"));
	private static final By2 insertLogingPassword=new By2("insert login password :",By.xpath("//input[@id='pwd-tml-page']"));
	private static final By2 clickOnloginSumbitButton=new By2("click on login sumbit button ",By.xpath("//input[@id=\"wp-submit-tml-page\"]"));
	private static final By2 confiermtWrongUserName=new By2("confirm error message שגיאה", By.xpath("//p[@class=\"error\"]"));
	private static final By2 insertWrongLogingUserName=new By2("insert login user name :",By.xpath("//input[@id='log-tml-page']"));
	private static final By2 confirmErorrMessage=new By2("confirm error message: ",By.xpath("//p[@class=\"error\"]"));
	

	public FisheyeLoginPage(WebDriver driver) {
		super(driver);

	}
	// get user name from the user and insert it to the user name's field
	public void insertLogingUserName(String correctUserName) {
		bot.click(insertLogingUserName);
		bot.writeToElement(insertLogingUserName, correctUserName);
	}
	// get user password from the user and insert it to the user password's field
	public void insertLogingPassword(String correctPassword) {
		bot.click(insertLogingPassword);
		bot.writeToElement(insertLogingPassword,correctPassword );
	}
	//click on submit button
	public void clickOnloginSumbitButton() {
		bot.click(clickOnloginSumbitButton);
	}
	//when insert wrong user nama should be error message 
	public String confiermtWrongUserName() {
		return bot.getElementText(confiermtWrongUserName);
	}
	// insert wrong user name from the user and insert it to the user name's field
	public void insertWrongLogingUserName(String wrongUserName) {
		bot.click(insertWrongLogingUserName);
		bot.writeToElement(insertWrongLogingUserName, wrongUserName);
	}
	public String confirmErorrMessage() {
		return bot.getElementText(confirmErorrMessage);
	}
	



}
