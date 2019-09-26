package il.co.fisheye.infra.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import il.co.fisheye.infra.web.By2;




public class FisheyeEnteryPage extends AbstractPage {
	private static final By2 clickOnRegistareButton = new By2("click on button: ",By.xpath("//div[@id='nav-content']//a[contains(text(),'הרשמה')]"));
	private static final By2 clickOnLoginButton = new By2("click on login button: ",By.xpath("//div[@id='nav-content']//a[contains(text(),'כניסה')]"));
	private static final By2 inputMoviePageSearchBox=new By2("reach input movie page search bar:",By.xpath("//input[@id=\"movie_page_search\"]"));
	private static final By2 clickonSearchButtonForMoviePage=new By2("reach input movie page search bar:",By.xpath("//div[@id=\"fishey_search_movie_button\"]//span[contains(text(),\"חפש\")]"));
	private static final By2 inputMovieSearchBox=new By2("reach input movie search bar: ",By.xpath("//input[@type=\"text\"]"));
	private static final By2 clickOnbuttonMovieSearchBox=new By2("click on search box bar:",By.partialLinkText("//input[@type=\"submit\"]"));
	private static final By2 radioButtonForginLangigge=new By2("switch to forgin langugge radio button :",By.xpath("//input[@id=\"searchType_forin\"]"));
	private static final By2 clickOnFilemImage=new By2("click on film image :",By.xpath("//div[@class='post-list-row'] //span[@class='ui-icon ui-icon-video']"));




	public FisheyeEnteryPage(WebDriver driver) {
		super(driver);

	}
	public void clickOnRegistareButton() {
		bot.click(clickOnRegistareButton);

	}
	public void clickOnLoginButton() {
		bot.click(clickOnLoginButton);
	}
	public void inputMoviePageSearchBox(String text) {
		bot.click(inputMoviePageSearchBox);
		bot.writeToElement(inputMoviePageSearchBox, text);
		
		
	}
	public void inputMovieSearchBox() {
		bot.click(inputMovieSearchBox);
	}
	public void clickonSearchButtonForMoviePage() {
		bot.click(clickonSearchButtonForMoviePage);
		
	}
	//public void writeTobox(String text) {
		//bot.writeToElement(inputMoviePageSearchBox, text);
		
	//}
	public void clickOnbuttonMovieSearchBox() {
		bot.click(clickOnbuttonMovieSearchBox);
	}
	public void radioButtonForginLangigge() {
		bot.click(radioButtonForginLangigge);
	}
	public void clickOnFilemImage() {
		bot.click(clickOnFilemImage);
	}




}












