package uitests;

import org.testng.ITestListener;
import org.testng.ITestResult;

import java.time.LocalDateTime;

public class CustomListener2 implements ITestListener {

    public void onTestStart(ITestResult result) {
        System.out.println("TEST: " + result.getName()+ " has started at " + LocalDateTime.now());

    }

    public void onTestSuccess(ITestResult result) {
        System.out.println("TEST: " + result.getName()+ " passed at " + LocalDateTime.now());

    }

    public void onTestFailure(ITestResult result) {
        System.out.println("TEST: " + result.getName()+ " failed at " + LocalDateTime.now());
    }

    public void onTestSkipped(ITestResult result) {
        System.out.println("TEST: " + result.getName()+ " skipped at " + LocalDateTime.now());
    }




}
