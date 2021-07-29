package uitests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;
import utilities.ConfigReader;

import java.io.IOException;
import java.lang.reflect.Method;
import java.util.concurrent.TimeUnit;

public class LoginTestsMultipleDrivers {

    private WebDriver driver;




    @BeforeMethod
    public void setupMethod() throws IOException {


        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Long.parseLong(ConfigReader.readProperty("implicitTimeout")), TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get(ConfigReader.readProperty("url"));


    }

    @AfterMethod
    public void tearDownMethod(){
        System.out.println("After Method");
        driver.quit();
    }


    @Test ()
    public void positiveLoginTest(){  // Method class is used to get the name of the method programmatically

        driver.findElement(By.id("ctl00_MainContent_username")).sendKeys(ConfigReader.readProperty("username"), Keys.TAB, ConfigReader.readProperty("password"), Keys.ENTER);
        Assert.assertTrue(driver.getTitle().equals("Web Orders"));
    }

    @Test ()
    public void negativeLoginTestWithWrongCredentials(){

        driver.findElement(By.id("ctl00_MainContent_username")).sendKeys("SDET", Keys.TAB, "Tester", Keys.ENTER);
        Assert.assertFalse(driver.getTitle().equals("Web Orders"));
    }

    @Test ()
    public void negativeLoginTestWithNoCredentials(){

        driver.findElement(By.id("ctl00_MainContent_username")).sendKeys("", Keys.TAB, "", Keys.ENTER);
        Assert.assertFalse(driver.getTitle().equals("Web Orders"));
    }

    @Test ()
    public void aTest(){  // Method class is used to get the name of the method programmatically
        WebDriver driver = new ChromeDriver();
        driver.get(ConfigReader.readProperty("url"));
        driver.findElement(By.id("ctl00_MainContent_username")).sendKeys(ConfigReader.readProperty("username"), Keys.TAB, ConfigReader.readProperty("password"), Keys.ENTER);
        Assert.assertTrue(driver.getTitle().equals("Web Orders"));
    }









}
