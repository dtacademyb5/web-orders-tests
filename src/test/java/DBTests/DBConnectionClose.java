package DBTests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class DBConnectionClose {

    @Test
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
}
