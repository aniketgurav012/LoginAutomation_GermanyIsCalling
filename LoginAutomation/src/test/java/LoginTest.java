package test.java;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import io.github.bonigarcia.wdm.WebDriverManager;
import java.util.concurrent.TimeUnit;

public class LoginTest {
    WebDriver driver;

    @BeforeMethod
    public void setup() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("http://www.germanyiscalling.com/login");
    }

    @Test
    public void testSuccessfulLogin() {
        WebElement username = driver.findElement(By.id("username"));  
        WebElement password = driver.findElement(By.id("password"));
        WebElement loginBtn = driver.findElement(By.id("loginBtn"));

        username.sendKeys("aniketgurav012@gmail.com");  
        password.sendKeys("Pass@123");
        loginBtn.click();

        Assert.assertEquals(driver.getCurrentUrl(), "http://www.germanyiscalling.com/dashboard");  
    }

    @Test
    public void testUnsuccessfulLogin() {
        WebElement username = driver.findElement(By.id("username"));
        WebElement password = driver.findElement(By.id("password"));
        WebElement loginBtn = driver.findElement(By.id("loginBtn"));

        username.sendKeys("qwe@2222");
        password.sendKeys("12334456");
        loginBtn.click();

        WebElement errorMsg = driver.findElement(By.id("errorMsg"));  
        Assert.assertTrue(errorMsg.isDisplayed());
        Assert.assertEquals(errorMsg.getText(), "Invalid username or password."); 
    }

    @AfterMethod
    public void teardown() {
        driver.quit();
    }
}
