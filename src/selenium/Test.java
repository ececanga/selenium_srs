package selenium;
//package selenium;
//import java.util.concurrent.TimeUnit;
//
//import org.openqa.selenium.By;
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.WebElement;
//import org.openqa.selenium.chrome.ChromeDriver;
//
//
//import org.openqa.selenium.support.ui.WebDriverWait;
//import org.openqa.selenium.support.ui.ExpectedConditions;
//
//public class Test {
//	public static void main(String[] args) throws InterruptedException { 
//		
//		String chromeDriverPath = "C:\\Users\\ececa\\Desktop\\SUMMER 21\\CS 458\\Project 1\\SeleniumTest\\chromedriver.exe";
//
//		// setting the driver executable
//		System.setProperty("webdriver.chrome.driver", chromeDriverPath);
//
//		// Initiating your chromedriver
//		WebDriver driver=new ChromeDriver();
//
//		// Applied wait time
//		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
//		// maximize window
//		driver.manage().window().maximize();
//
//		// open browser with desired URL
//		///driver.get("https://stars.bilkent.edu.tr/srs");
//		driver.get("https://cs458-p1.web.app");
//		
//		System.out.println("3333333333333333333333");
//
//		driver.findElement(By.cssSelector("a[href*='signin']")).click();
//
//
//		
//		WebElement emailElement = driver.findElement(By.name("email"));
//		WebElement pwElement = driver.findElement(By.name("password"));
//		WebElement submitButtonElement = driver.findElement(By.cssSelector("button[type='submit']"));
//
//		//driver.findElement(By.xpath("//a[@href='/signin']")).click();
//		
//		System.out.println("1111111111111111111");
//		//formElement.click();
//
//		emailElement.sendKeys("ece@gmail.com");
//		pwElement.sendKeys("123456");
//		submitButtonElement.click();
//		
//		
///////////////////////////////////////////////////////////////////////
//		/*
//		WebElement username = driver.findElement(By.id("LoginForm_username"));
//		//WebElement name = driver.findElement(By.name("LoginForm[username]"));
//		WebElement formElement = driver.findElement(By.cssSelector("button[class='btn btn-bilkent']"));
//		
//		//WebElement passwordField = driver.findElement(By.cssSelector("input[name='LoginForm[p5c1280bdbf]']"));
//		//WebElement passwordField = driver.findElement(By.name("LoginForm[p5c1280bdbf]"));
//		//System.out.println(passwordField.getAttribute("eee"));
//		
//		//WebElement passwordField = driver.findElement(By.id("LoginForm_password"));
//		WebElement passwordField = driver.findElement(By.name("LoginForm[password]"));
//		
//		
//
//		//username.sendKeys("212345");
////		passwordField.clear();
////		passwordField.click();
//		//driver.wait(50);
//		
//		
//		*/
//		///////////////////////////////////////////////////////////////////////////////
//		
//
//
//
//		//new WebDriverWait(driver, 20).until(ExpectedConditions.elementToBeClickable(By.cssSelector("input[id='LoginForm_password']"))).click();
//	
//
//
//		
//		
//        //WebElement userPassword = driver.findElement(By.xpath("//input[@id='LoginForm_password']"));
//
////		username.sendKeys("221600851");
//
//        
//	//	userPassword.sendKeys("randomPassword");
//		//System.out.println("Username is: " + username.toString());
//
//		//System.out.println("Name is: " + name);
//
//		//System.out.println("Pw is: " + passwordField);
//
//		
//		//formElement.click();
//		
//		
//		
//		//closing the browser
//		//driver.close();
//
//		}
//}
//
//


import java.util.concurrent.TimeUnit;
import java.util.UUID;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class Test {
    public static void main(String[] args) throws Exception {

        //Creating driver object and setting needed variables
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\ececa\\Desktop\\SUMMER 21\\CS 458\\Project 1\\SeleniumTest\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        // maximize window
     	driver.manage().window().maximize();
        
        WebDriverWait wait = new WebDriverWait(driver, 5);
        
     

        String validEmail  = "abcd@hotmail.com";
        String newValidEmail = UUID.randomUUID().toString().replaceAll("-", "") + "@hotmail.com";
        String validPw = "123456";
        String loginPageUrl = "https://cs458-p1.web.app/accounts/login";
        String validUserName = "Hazal Aksu";
        String invalidEmail  = "namegmail.com";
        String invalidPw = "1";

        //Deletes the cookies
        driver.manage().deleteAllCookies();

        //This line is to test logging in with valid values
        //login(driver, validEmail, validPw, loginPageUrl, wait);

        //This line is to test logging in with invalid password
        //login(driver, validEmail, invalidPw, loginPageUrl, wait);

        //This line is to test logging in with invalid email
        //login(driver, invalidEmail, validPw, loginPageUrl, wait);

        //This line is to test signing out after a successful login
        //signOut(driver, validEmail, validPw, loginPageUrl, wait);

        //This line is to test the signing up page with correct values
        //signUpPage(driver, loginPageUrl,wait, validEmail, validPw, validUserName);

        //This line is to test the signing up page with invalid email 
        //signUpPage(driver, loginPageUrl,wait, invalidEmail, validPw, validUserName);

        //This line is to test the signing up page with invalid password
        //signUpPage(driver, loginPageUrl,wait, validEmail, invalidPw, validUserName);

        //This line is to test logging in with the new account created in the sign up page
        //loginWithNewAccount(driver, loginPageUrl,wait, newValidEmail, validPw, validUserName);
        
        loginWithoutMouse(driver, loginPageUrl);

        //driver.quit(); 
    }
    //Tests login with valid/invalid email or password
    static void login( WebDriver driver,String validEmail, String validPw, String loginPageUrl,WebDriverWait wait )
    {
        driver.get(loginPageUrl);

        WebElement emailElement = driver.findElement(By.cssSelector("input[name='email']"));
        WebElement pwElement = driver.findElement(By.cssSelector("input[name='password']"));
        WebElement submitButtonElement = driver.findElement(By.cssSelector("button[type='submit']"));

        emailElement.sendKeys(validEmail);
        pwElement.sendKeys(validPw);
        submitButtonElement.click();

        try
        {
            wait.until(ExpectedConditions.urlToBe("https://cs458-p1.web.app/home")); 
            System.out.println("Logged in successfully");
        }
        catch(Exception e)
        {
            System.out.println("Login unsuccessful"); 
        }
    }

    //Tests if the Sign Out function works after logging in
    static void signOut( WebDriver driver,String validEmail, String validPw, String loginPageUrl,WebDriverWait wait)
    {
        login(driver, validEmail, validPw, loginPageUrl, wait);
            
        WebElement signoutWebElement  = driver.findElement(By.cssSelector("button[type='button']"));
        signoutWebElement.click();

        try
        {
            wait.until(ExpectedConditions.urlToBe("https://cs458-p1.web.app/accounts/login")); 
            System.out.println("Signed out successfully");
        }
        catch(Exception e)
        {
            System.out.println("Sign out unsuccessful"); 
        }
    }

    //Tests Sign Up page for valid/invalid sign up values
    static boolean signUpPage( WebDriver driver, String loginPageUrl, WebDriverWait wait, String validEmail, String validPw, String validUserName)
    {
        driver.get(loginPageUrl);
        WebElement signUpBtn = driver.findElement(By.linkText("Sign Up"));
        signUpBtn.click();
        
        wait.until(ExpectedConditions.urlToBe("https://cs458-p1.web.app/signup"));

        WebElement usernmElement = driver.findElement(By.cssSelector("input[name='username']"));
        WebElement emailSUElement = driver.findElement(By.cssSelector("input[name='email']"));
        WebElement pwOne = driver.findElement(By.cssSelector("input[name='passwordOne']"));
        WebElement pwTwo = driver.findElement(By.cssSelector("input[name='passwordTwo']"));
        WebElement signUpBtnInPage = driver.findElement(By.cssSelector("button[type='submit']"));

        usernmElement.sendKeys(validUserName);
        emailSUElement.sendKeys(validEmail);
        pwOne.sendKeys(validPw);
        pwTwo.sendKeys(validPw);
        signUpBtnInPage.click();
        
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

        if(!driver.findElements(By.tagName("p")).isEmpty())
        {
            if((driver.findElement(By.tagName("p")).getText()).equals("The Home Page is accessible by every signed in user.") )
            {
                System.out.println("Sign up successful");
                return true;
            }
            else
            {
                System.out.println(driver.findElement(By.tagName("p")).getText());
                return false;  
            }
        }
        else
        {
            return false;
        }
    }

    //Tests logging in with new account after Signing up with correct values
    static void loginWithNewAccount(WebDriver driver, String loginPageUrl, WebDriverWait wait, String newValidEmail, String validPw, String validUserName)
    {
        if(signUpPage(driver, loginPageUrl,wait, newValidEmail, validPw, validUserName))
        {
            login(driver, newValidEmail, validPw, loginPageUrl, wait);
        }    
    }

    //Tests if login page works without using the mouse
    static void loginWithoutMouse(WebDriver driver, String loginPageUrl)
    {
        driver.get(loginPageUrl);
        //WebElement current = driver.findElement(By.linkText("Bilkent University Online Services"));
        
        Actions builder = new Actions(driver);
        for (int i = 0; i < 5; i++) {
        	builder = builder.sendKeys(Keys.TAB);
        }
        builder.sendKeys("abcd@hotmail.com");
        builder.sendKeys(Keys.TAB);
        builder.sendKeys("123456");
        builder.sendKeys(Keys.ENTER);
        builder.perform();
       
        //WebElement current = driver.switchTo().activeElement();
        
//        current.sendKeys(Keys.TAB);
//        for (int i = 0; i < 3; i++)
//        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
//        current.sendKeys(Keys.TAB);
        
        
//        for(int i = 0; i < 3; i++) {
//            current.sendKeys(Keys.TAB);
//            System.out.println("tab done");
//            //driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
//        }
//        current = driver.switchTo().activeElement();
//        System.out.println(current.getAttribute(""));
//        current.sendKeys("abcd@hotmail.com");
//        current.sendKeys(Keys.TAB);
//        current.sendKeys("123456");
        //current.sendKeys(Keys.ENTER);
        //driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        
//        current.sendKeys(Keys.TAB);
//        current.sendKeys(Keys.TAB);
//        current.sendKeys("trythis");
        

    }


        //static void 
          //Thread.sleep(2000);

            //driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
        //System.out.println("Hello, World!");
        //Specifiying pageLoadTimeout and Implicit wait
        //driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
        //Thread.sleep(200);
   
}
