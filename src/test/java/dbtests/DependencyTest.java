package dbtests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class DependencyTest {

    WebDriver driver;

    @Test (groups = {"smoke"})
    public void test1(){

        System.out.println("test 1");
        Assert.assertTrue(false);
    }

    @Test
    public void test3(){
        System.out.println("test 3");
        Assert.assertTrue(true);
    }
    
     @Test
    public void test445(){
        System.out.println("test 3");
        Assert.assertTrue(true);
    }

    @Test(dependsOnMethods = {"test1", "test3"})
    public void test2(){
        System.out.println("test 2");
        Assert.assertTrue(true);
    }



    @Test (priority = 1)
    public void login(){
        WebDriverManager.chromedriver().setup();
       driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get("http://secure.smartbearsoftware.com/samples/TestComplete12/WebOrders/Login.aspx");
        driver.findElement(By.id("ctl00_MainContent_username")).sendKeys("Teste", Keys.TAB, "test", Keys.ENTER);
        Assert.assertTrue(driver.getTitle().equals("Web Order"));

    }

    @Test (priority = 2, dependsOnMethods = {"login"})
    public void verifyButton(){

       Assert.assertTrue( driver.findElement(By.id("ctl00_MainContent_btnDelete")).isEnabled());
    }

    @Test (priority = 3, dependsOnMethods = {"verifyButton"})
    public void verifyButton2(){

        Assert.assertTrue( driver.findElement(By.id("ctl00_MainContent_btnDelete")).isEnabled());
    }
}
