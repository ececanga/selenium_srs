package selenium;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Test {
	public static void main(String[] args) {
		
		String chromeDriverPath = "";

		// setting the driver executable
		System.setProperty("webdriver.chrome.driver", chromeDriverPath);

		// Initiating your chromedriver
		WebDriver driver=new ChromeDriver();

		// Applied wait time
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		// maximize window
		driver.manage().window().maximize();

		// open browser with desired URL
		driver.get("https://stars.bilkent.edu.tr/srs");

		WebElement username = driver.findElement(By.id("LoginForm_username"));
		//WebElement name = driver.findElement(By.name("LoginForm[username]"));
		WebElement formElement = driver.findElement(By.cssSelector("button[class='btn btn-bilkent']"));
		
		//WebElement passwordField = driver.findElement(By.cssSelector("input[name='LoginForm[p5c1280bdbf]']"));
		//WebElement passwordField = driver.findElement(By.name("LoginForm[p5c1280bdbf]"));
		//System.out.println(passwordField.getAttribute("eee"));
		
		WebElement passwordField = driver.findElement(By.id("LoginForm_password"));

		username.sendKeys("212345");
		//passwordField.click();
		passwordField.sendKeys("randomPassword");
		System.out.println("Username is: " + username.toString());
		
		//System.out.println("Name is: " + name);

		//System.out.println("Pw is: " + passwordField);

		//username.sendKeys("221600851");
		
		formElement.click();
		
		
		
		//closing the browser
		//driver.close();

		}
}






