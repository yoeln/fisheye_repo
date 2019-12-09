package il.co.fisheye.infra.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import il.co.fisheye.infra.web.By2;

public class FisheyeMoviePage extends AbstractPage {
	
	private static final By2 assertMovieName=new By2("make sure it is the same name",By.cssSelector("div.search-results-content input.s"));
	
	

	public FisheyeMoviePage(WebDriver driver) {
		super(driver);
		
	}
	public String assertMovieName(String attribute) {
		return bot.getAttributeText(assertMovieName, attribute);
	}

}
