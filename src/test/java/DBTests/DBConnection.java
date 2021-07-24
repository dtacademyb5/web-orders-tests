package DBTests;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.lang.reflect.Method;

@Test (groups = {"db"})
public class DBConnection {

    @Test (groups = {"smoke"})
    public void connectToDb1(){
        System.out.println("Db connection test 1");
               Assert.assertTrue(true);
    }

    @Test
    public void connectToDb2(){
        System.out.println("Db connection test 2");
        Assert.assertTrue(true);
    }

    @Test
    public void connectToDb3(){
        System.out.println("Db connection test 3");
        Assert.assertTrue(true);
    }

    @Test
    public void connectToDb4(){
        System.out.println("Db connection test 4");
        Assert.assertTrue(true);
    }

    @Test
    public void TC001_DB(){
        System.out.println("Db connection test 4");
        Assert.assertTrue(true);
    }
}
