package il.co.fisheye.infra.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import il.co.fisheye.infra.web.By2;

public class FisheyeMovieResultPage extends AbstractPage {
	
	String moviePageName="באטמן מתחיל";
	String englishMovieName="Batman Begins";
	
	private static final By2 assertMovieName=new By2("assert the movie page is באטמן מתחיל: ",By.xpath("//div[@class=\"movie-titleheb\"]"));
	private static final By2 assertEnglishMovieName=new By2("assert english movie page is Batman Begins ",By.xpath("//div[@class=\"movie-titleeng\"]"));
	

	public FisheyeMovieResultPage(WebDriver driver) {
		super(driver);
		
	}
	
	public String getMovieNameText() {
		return bot.getElementText(assertMovieName);
	}
	
	
	public String assertMovieName() {
		bot.equals(assertMovieName);
		return moviePageName;
	}
	public String assertEnglishMovieName() {
		bot.equals(assertEnglishMovieName);
		return englishMovieName;
		
	}
	
	
	

}
