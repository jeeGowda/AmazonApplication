package amazon;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class GetTheFifthElementFromSearch {
	public static void main(String[] args) {
		ChromeOptions options = new ChromeOptions();
		options.addArguments("remote-allow-origins=*");
		options.addArguments("--disable-notifications");
		// Instatiate the browser specific class
		WebDriver driver = new ChromeDriver(options);
		// pre condition - maximize the browser
		driver.manage().window().maximize();
		// Synchronization - Implicit wait
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		// Synchronization - Explicit wait
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		// Trigger the main URL of amazon application
		driver.get("https://www.amazon.in/");
		// identifying the search webelement
		driver.findElement(By.id("twotabsearchtextbox"))
				.sendKeys("Wrist Watches,Analogue,Leather,Titan,discount 25% Off or more", Keys.ENTER);
		Actions actions = new Actions(driver);
		// Identifying Fifth Element after the search
		WebElement fifthElement = driver.findElement(By.xpath("(//a[@class=\"a-link-normal s-no-outline\"])[5]"));
		wait.until(ExpectedConditions.visibilityOf(fifthElement));
		// Scroll cursor to specific webelement and click on it
		actions.scrollToElement(fifthElement).moveToElement(fifthElement).click().perform();
		driver.manage().window().minimize();
		driver.quit();
	}
}
