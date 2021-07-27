package dbtests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.util.concurrent.TimeUnit;

public class HardvsSoftAssertions {

    WebDriver driver;


    @Test
    public void negativeLoginTest(){

        SoftAssert softAssert = new SoftAssert();

        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get("http://secure.smartbearsoftware.com/samples/TestComplete12/WebOrders/Login.aspx");
        driver.findElement(By.id("ctl00_MainContent_username")).sendKeys("Teste", Keys.TAB, "test", Keys.ENTER);
        softAssert.assertTrue(driver.getTitle().equals("Web Order Login"), "The title was not Web Order Login");
        System.out.println("Verifying the message is displayed");
        // Verify that the error message is displayed

        WebElement errorMessage = driver.findElement(By.id("ctl00_MainContent_status"));

        softAssert.assertTrue(errorMessage.isDisplayed());

        // Verify the error message is red
        System.out.println("Verifying the message color");
        String rgba = errorMessage.getCssValue("color");

        softAssert.assertEquals(rgba, "rgba(255, 0, 0, 1)");

        softAssert.assertAll();

    }
}
