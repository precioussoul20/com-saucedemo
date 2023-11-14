package saucedemo;
/*Project-4 - ProjectName : com-saucedemo
BaseUrl = https://www.saucedemo.com/
1. Setup chrome browser.
2. Open URL.
3. Print the title of the page.
4. Print the current url.
5. Print the page source.
6. Enter the email to email field.
7. Enter the password to password field.
8. Click on Login Button.
9. Print the current url.
10. Navigate to baseUrl
11. Refresh the page.
12. Close the browser.
* */

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.time.Duration;

public class SauceDemoTest {
    static WebDriver driver;
    static String baseUrl = "https://www.saucedemo.com/";
    static String browser = "Chrome";                                                                                                                            

    public static void main(String[] args) throws InterruptedException {
        if (browser.equalsIgnoreCase("Chrome")) {
            driver = new ChromeDriver();
        } else if (browser.equalsIgnoreCase("Edge")) {
            driver = new EdgeDriver();
        } else if (browser.equalsIgnoreCase("Firefox")) {
            driver= new FirefoxDriver();
        } else {
            System.out.println("Wrong Browser name");
        }
        //Open Url into browser
        driver.get(baseUrl);
        Thread.sleep(5000);
        //maximise the browser
        driver.manage().window().maximize();
        //We give imlpicit wait to driver
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        //Get the title of the page
        String title = driver.getTitle();
        System.out.println(title);
        Thread.sleep(5000);

        // Get the current Url
        System.out.println("The current Url " + driver.getCurrentUrl());

        //Get page source
        System.out.println(driver.getPageSource());

        //Enter the Email to the email field
        WebElement emailField = driver.findElement(By.id("user-name"));
        emailField.sendKeys("standard_user");
        Thread.sleep(5000);

        //Enter the Password to the password field
        WebElement passwordField = driver.findElement(By.id("password"));
        passwordField.sendKeys("secret_sauce");
        Thread.sleep(5000);

        //Click login button
        WebElement loginButton = driver.findElement(By.id("login-button"));
        loginButton.click();

        // Get the current Url
        System.out.println(driver.getCurrentUrl());
        Thread.sleep(5000);

        // Navigate to base Url
        driver.navigate().to(baseUrl);
        Thread.sleep(5000);

        //Refresh the Page
        driver.navigate().refresh();
        Thread.sleep(5000);

        //Close the browser
        driver.quit();

    }

}
