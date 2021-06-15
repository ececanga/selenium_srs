package selenium;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;


import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class Test {
	public static void main(String[] args) throws InterruptedException { 
		
		String chromeDriverPath = "C:\\Users\\ececa\\Desktop\\SUMMER 21\\CS 458\\Project 1\\SeleniumTest\\chromedriver.exe";

		// setting the driver executable
		System.setProperty("webdriver.chrome.driver", chromeDriverPath);

		// Initiating your chromedriver
		WebDriver driver=new ChromeDriver();

		// Applied wait time
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		// maximize window
		driver.manage().window().maximize();

		// open browser with desired URL
		///driver.get("https://stars.bilkent.edu.tr/srs");
		driver.get("https://cs458-p1.web.app");
		
		System.out.println("3333333333333333333333");

		driver.findElement(By.cssSelector("a[href*='signin']")).click();


		
		WebElement emailElement = driver.findElement(By.name("email"));
		WebElement pwElement = driver.findElement(By.name("password"));
		WebElement submitButtonElement = driver.findElement(By.cssSelector("button[type='submit']"));

		//driver.findElement(By.xpath("//a[@href='/signin']")).click();
		
		System.out.println("1111111111111111111");
		//formElement.click();

		emailElement.sendKeys("ece@gmail.com");
		pwElement.sendKeys("123456");
		submitButtonElement.click();
		
		
/////////////////////////////////////////////////////////////////////
		/*
		WebElement username = driver.findElement(By.id("LoginForm_username"));
		//WebElement name = driver.findElement(By.name("LoginForm[username]"));
		WebElement formElement = driver.findElement(By.cssSelector("button[class='btn btn-bilkent']"));
		
		//WebElement passwordField = driver.findElement(By.cssSelector("input[name='LoginForm[p5c1280bdbf]']"));
		//WebElement passwordField = driver.findElement(By.name("LoginForm[p5c1280bdbf]"));
		//System.out.println(passwordField.getAttribute("eee"));
		
		//WebElement passwordField = driver.findElement(By.id("LoginForm_password"));
		WebElement passwordField = driver.findElement(By.name("LoginForm[password]"));
		
		

		//username.sendKeys("212345");
//		passwordField.clear();
//		passwordField.click();
		//driver.wait(50);
		
		
		*/
		///////////////////////////////////////////////////////////////////////////////
		



		//new WebDriverWait(driver, 20).until(ExpectedConditions.elementToBeClickable(By.cssSelector("input[id='LoginForm_password']"))).click();
	


		
		
        //WebElement userPassword = driver.findElement(By.xpath("//input[@id='LoginForm_password']"));

//		username.sendKeys("221600851");

        
	//	userPassword.sendKeys("randomPassword");
		//System.out.println("Username is: " + username.toString());

		//System.out.println("Name is: " + name);

		//System.out.println("Pw is: " + passwordField);

		
		//formElement.click();
		
		
		
		//closing the browser
		//driver.close();

		}
}






