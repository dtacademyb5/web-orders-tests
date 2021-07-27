package dbtests;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

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
