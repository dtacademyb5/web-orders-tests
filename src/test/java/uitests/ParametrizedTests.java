package uitests;


import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;

import java.util.concurrent.TimeUnit;

public class ParametrizedTests {
    private WebDriver driver;








    @BeforeMethod
    public void setupMethod(){

        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.manage().window().maximize();



    }

    @AfterMethod
    public void tearDownMethod(){
               driver.quit();
    }


    @Test (enabled = false)
    @Parameters ({"url"})
    public void positiveLoginTest(@Optional String address){
        driver.get(address);
        driver.findElement(By.id("ctl00_MainContent_username")).sendKeys("Tester", Keys.TAB, "test", Keys.ENTER);
        Assert.assertTrue(driver.getTitle().equals("Web Orders"));
    }

    @Test (enabled = false)
    public void negativeLoginTestWithWrongCredentials(){
        driver.get("http://secure.smartbearsoftware.com/samples/TestComplete12/WebOrders/Login.aspx");
        driver.findElement(By.id("ctl00_MainContent_username")).sendKeys("SDET", Keys.TAB, "Tester", Keys.ENTER);
        Assert.assertFalse(driver.getTitle().equals("Web Orders"));
    }

    @Test
    @Parameters({"url", "user", "pass"})
    public void positiveLoginWithParameters(String URL, String username, String password){
        driver.get(URL);
        driver.findElement(By.id("ctl00_MainContent_username")).sendKeys(username, Keys.TAB, password, Keys.ENTER);
        Assert.assertTrue(driver.getTitle().equals("Web Orders"));
    }


    @Test (enabled = false)
    @Parameters ({"firstName", "lastName", "age"})
    public void methodWithParameters(String first, String last, int age){
        System.out.println(first);
        System.out.println(last);
        System.out.println(age);
    }










}
