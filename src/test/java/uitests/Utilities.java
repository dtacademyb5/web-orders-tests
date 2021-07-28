package uitests;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Utilities {


    public static List<String> getElementsText(List<WebElement> list) {
        List<String> elemTexts = new ArrayList<>();
        for (WebElement el : list) {
            if (!el.getText().isEmpty()) {
                elemTexts.add(el.getText());
            }
        }
        return elemTexts;
    }


    public static void switchToWindow(String title, WebDriver driver){

        for (String windowHandle : driver.getWindowHandles()) {
            driver.switchTo().window(windowHandle);
            if(driver.getTitle().equals(title)){
                break;
            }
        }
    }



    public static void takeScreenshot(WebDriver driver , String fileName) throws IOException {

        File file = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

        FileInputStream fis = new FileInputStream(file);

        FileOutputStream fos = new FileOutputStream(fileName);
        int data;
        while((data = fis.read()) != -1  ){
            fos.write(data);
        }
        fis.close();
        fos.close();

    }
}
