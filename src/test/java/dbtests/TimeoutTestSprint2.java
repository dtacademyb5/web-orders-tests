package dbtests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class TimeoutTestSprint2 {

    WebDriver driver;

    @Test
    public void test1() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get("http://secure.smartbearsoftware.com/samples/TestComplete12/WebOrders/Login.aspx");
        driver.findElement(By.id("ctl00_MainContent_username")).sendKeys("Teste", Keys.TAB, "test", Keys.ENTER);
        Assert.assertTrue(driver.getTitle().equals("Web Order"));

    }

    @Test (timeOut = 2000, groups = {"smoke"})
    public void test3() throws InterruptedException {

     Thread.sleep(1000);

    }






}
