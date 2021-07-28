package uitests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.Random;
import java.util.concurrent.TimeUnit;

public class DataProviderDemo {
    WebDriver wd;

    @Test (dataProvider = "getData")    //(dataProvider = "socks")
    public  void testGoogle(String searchTerm){


        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get("https://www.google.com/");
        driver.findElement(By.name("q")).sendKeys(searchTerm, Keys.ENTER);
        Assert.assertTrue(driver.getTitle().contains(searchTerm));
        driver.quit();

    }


    @Test (dataProvider = "customers")
                         //{"John Doe", "123 main st", "Fairfax",       "VA",        22032, 125332516533124L, "12/23"},
    public void placeOrder(String name, String address, String city, String state, int zip, long cardNo, String expiry ){

        WebDriverManager.chromedriver().setup();
       wd = new ChromeDriver();
        wd.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        wd.manage().window().maximize();


        wd.navigate().to("http://secure.smartbearsoftware.com/samples/TestComplete12/WebOrders/Login.aspx");
//
        wd.findElement(By.id("ctl00_MainContent_username")).sendKeys("Tester", Keys.TAB, "test", Keys.ENTER);
//
        wd.findElement(By.linkText("Order")).click();
        int randomQuantity = (int) (Math.random() * 99) + 1;
        wd.findElement(By.id("ctl00_MainContent_fmwOrder_txtQuantity"))
                .sendKeys(Keys.BACK_SPACE, String.valueOf(randomQuantity), Keys.ENTER);
//

        wd.findElement(By.id("ctl00_MainContent_fmwOrder_txtName")).
                sendKeys(name,
                        Keys.TAB, address,
                        Keys.TAB, city,
                        Keys.TAB, state,
                        Keys.TAB, ""+zip);
//

        wd.findElement(By.id("ctl00_MainContent_fmwOrder_cardList_0")).click();
//


       wd.findElement(By.id("ctl00_MainContent_fmwOrder_TextBox6")).sendKeys(""+cardNo);

        wd.findElement(By.id("ctl00_MainContent_fmwOrder_TextBox1")).sendKeys(expiry);
//
        wd.findElement(By.id("ctl00_MainContent_fmwOrder_InsertButton")).click();
//
        Assert.assertTrue(wd.getPageSource().contains("New order has been successfully added."));
//



    }

    @AfterMethod
    public void teardown(){
        wd.quit();
    }









    @DataProvider    // @DataProvider (name = "socks")
    public Object[][] getData(){
        return new Object[][] {
                {"cheap socks"},
                {"expensive socks"},
                {"靴下"},
                {"javaproqramlaşdirmaetdirəbildiklərimizdənsinizmi"},
                {"шұлықтар"},
                {"носок"}

        };

    }


    @DataProvider    (name = "customers")
    public Object[][] getCustomerData(){
        return new Object[][] {
                {"John Doe", "123 main st", "Fairfax", "VA", 22032, 125332516533124L, "12/23"},
                {"Vladimir Putin", "123 Kremlin palace", "Moscow", "Moscow", 20010, 1253325165331L, "12/34"},
                {"Joe Biden", "1600 Pennsylvania Ave", "Washington", "DC", 20000, 4567890345671234L, "12/90"},
                {"恩多伊" ,"矿山街23号" ,  "东京", "雅盘", 23456 , 7864590432123456L, "05/2"},
                {"Əli Əliyev", "Torqovı küçəsi", "Bakı", "Səbayıl rayonu", 1011, 4561234573214568L, "06/24"},
                {"Нұрсұлтан Назарбаев" ,"Абай көшесі" , "Нұрсұлтан","KZ", 20002, 1234560098123L, "05/25"}

        };

    }



}
