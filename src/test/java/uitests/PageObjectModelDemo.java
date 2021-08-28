package uitests;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.AllOrdersPage;
import pages.LoginPage;
import pages.OrderPage;
import utilities.ConfigReader;
import utilities.Driver;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class PageObjectModelDemo {

    WebDriver driver;

    @BeforeMethod
    public void setupMethod() throws IOException {

        driver = Driver.getDriver();
        driver.manage().timeouts().implicitlyWait(Long.parseLong(ConfigReader.readProperty("implicitTimeout")), TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get(ConfigReader.readProperty("url"));


    }

    @AfterMethod
    public void tearDownMethod(){

        Driver.quit();
    }


    @Test()
    public void positiveLoginTest()  {

        driver.findElement(By.id("ctl00_MainContent_user")).sendKeys(ConfigReader.readProperty("username"));
        driver.findElement(By.id("ctl00_MainContent_password")).sendKeys(ConfigReader.readProperty("password"));
        driver.findElement(By.id("ctl00_MainContent_login_button")).click();

        Assert.assertTrue(driver.getTitle().equals("Web Orders"));
    }


    @Test()
    public void positiveLoginTestusingPageObjectModel()  {  // Method class is used to get the name of the method programmatically

        LoginPage loginPage = new LoginPage();
        loginPage.usernameField.sendKeys(ConfigReader.readProperty("username"));
        loginPage.passwordField.sendKeys(ConfigReader.readProperty("password"));
        loginPage.loginButton.click();

        Assert.assertTrue(driver.getTitle().equals("Web Orders"));
    }

    @Test()
    public void verifyCheckAllUncheckAllButtonsUsingPageClassMethods()  {


        new LoginPage().login();

        AllOrdersPage allOrdersPage = new AllOrdersPage();

        Assert.assertTrue( allOrdersPage.checkAllButtonIsEnabled());
        Assert.assertTrue( allOrdersPage.uncheckAllButtonIsEnabled());
    }


    @Test()
    public void verifyCheckboxesSize()  {


        new LoginPage().login();

        AllOrdersPage allOrdersPage = new AllOrdersPage();

        int size = allOrdersPage.checkboxes.size();

        Assert.assertTrue( size == 8);

    }



    @Test()
    public void placeOrderAndVerifyDetails()  {

        new LoginPage().login();

        AllOrdersPage allOrdersPage = new AllOrdersPage();

        allOrdersPage.orderLink.click();

        OrderPage orderPage = new OrderPage();

        orderPage.quantityField.sendKeys(Keys.BACK_SPACE, "8", Keys.ENTER);

        String name = "John Doe";
        String address = "123 Main st";
        String city = "Fairfax";
        String state = "VA";
        String zip = "22302";
        String cardNo = "31453614545231321";
        String expiry = "12/23";

        orderPage.customerNameField. sendKeys(name,
                        Keys.TAB, address,
                        Keys.TAB, city,
                        Keys.TAB, state,
                        Keys.TAB, ""+zip);

       orderPage.visaCheckbox.click();
       orderPage.cardNoField.sendKeys(cardNo);
       orderPage.expiry.sendKeys(expiry);
       orderPage.processButton.click();

        Assert.assertTrue(driver.getPageSource().contains("New order has been successfully added."));

    }




}
