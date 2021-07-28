package uitests;

import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;


@Listeners(CustomListener.class)
public class ListenerClassImplementationTests {


    @Test
    public void test1(){
        Assert.assertTrue(true);
    }

    @Test
    public void test2(){
        Assert.assertTrue(false);
    }

    @Test ()
    public void test3(){
       throw new SkipException("skipped");  // to explicitly skip your tests
    }
}
