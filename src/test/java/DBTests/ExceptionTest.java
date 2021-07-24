package DBTests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class ExceptionTest {

    WebDriver driver;

    @Test (expectedExceptions = {NullPointerException.class})
    public void test1(){

         throw new NullPointerException();
    }

    @Test (expectedExceptions = {ArithmeticException.class, ClassCastException.class})
    public void test3(){

//        throw new NullPointerException();
        System.out.println(9/0);

    }






}
