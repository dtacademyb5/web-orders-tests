package uitests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.*;
import utilities.ConfigReader;
import utilities.Driver;

import java.io.IOException;
import java.lang.reflect.Method;
import java.util.concurrent.TimeUnit;

public class SpreadSheetTests {
    private WebDriver driver;

    @BeforeSuite
    public void setupSuite(){
        // The logic for setup that must be done before the entire test suite
        System.out.println("Before Suite");
    }

    @AfterSuite
    public void tearDownSuite(){
        // The logic for cleanup that must be done after the entire test suite is done
        System.out.println("After Suite");
    }

    @BeforeTest
    public void setupTestSubcategory(){

        System.out.println("Before Test");
    }

    @AfterTest
    public void cleanupTestSubcategory(){

        System.out.println("After Test");
    }

    @BeforeClass
    public void setupClass(){
        System.out.println("Before Class");
        WebDriverManager.chromedriver().setup();
    }




    @AfterClass
    public void cleanupClass(){
        System.out.println("After Class");

    }

    @BeforeMethod
    public void setupMethod() throws IOException {









        driver = Driver.getDriver();
        driver.manage().timeouts().implicitlyWait(Long.parseLong(ConfigReader.readProperty("implicitTimeout")), TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get(ConfigReader.readProperty("url"));


    }

    @AfterMethod
    public void tearDownMethod(){
        System.out.println("After Method");
        driver.quit();
    }


    @Test (priority = 5, groups = {"smoke", "uitests"})
    public void positiveLoginTest(Method m){  // Method class is used to get the name of the method programmatically
        System.out.println(m.getName());
        driver.findElement(By.id("ctl00_MainContent_username")).sendKeys(ConfigReader.readProperty("username"), Keys.TAB, ConfigReader.readProperty("password"), Keys.ENTER);
        Assert.assertTrue(driver.getTitle().equals("Web Orders"));
    }

    @Test (priority = -1000,enabled = false)
    public void negativeLoginTestWithWrongCredentials(Method m){
        System.out.println(m.getName());
        driver.findElement(By.id("ctl00_MainContent_username")).sendKeys("SDET", Keys.TAB, "Tester", Keys.ENTER);
        Assert.assertFalse(driver.getTitle().equals("Web Orders"));
    }

    @Test (priority = 3, groups = {"smoke"})
    public void negativeLoginTestWithNoCredentials(Method m){
        System.out.println(m.getName());
        driver.findElement(By.id("ctl00_MainContent_username")).sendKeys("", Keys.TAB, "", Keys.ENTER);
        Assert.assertFalse(driver.getTitle().equals("Web Orders"));
    }

    @Test (priority = 3)
    public void n(Method m){

    }

    @Test ( )
    public void m(Method m){

    }
    @Test ()
    public void x(Method m){

    }








}
