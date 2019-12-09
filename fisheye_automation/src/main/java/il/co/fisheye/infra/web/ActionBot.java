package il.co.fisheye.infra.web;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import il.co.topq.difido.ReportDispatcher;
import il.co.topq.difido.ReportManager;

public class ActionBot {

	private WebDriver driver;
	protected ReportDispatcher report = ReportManager.getInstance();
	

	public ActionBot(WebDriver driver) {
		this.driver = driver;
	}

	public void click(By2 by2) {
		report.log("Click: " + by2);
		driver.findElement(by2.by).click();
	
	}

	public void writeToElement(By2 by2, String text) {
		report.log("Write '" + text + "' to: " + by2);
		driver.findElement(by2.by).sendKeys(text);
	}

	public String getElementText(By2 by2) {
		String text = driver.findElement(by2.by).getText();
		report.log("Element " + by2 + " inner text: '" + text + "'");
		return text;
	}
	
	public String getAttributeText(By2 by2, String name) {
		String text = driver.findElement(by2.by).getAttribute(name);
		report.log("Element " + by2 + " inner attribute text: '" + name + "'");
		return text;
	}
	
		public void selectByText(By2 by2, String text) {
			WebElement selectElement = driver.findElement(by2.by);
			Select select = new Select(selectElement);
			select.selectByVisibleText(text);
	}
	}
