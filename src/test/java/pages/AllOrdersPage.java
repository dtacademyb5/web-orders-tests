package pages;

import com.google.common.io.ByteSource;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

import java.util.List;

public class AllOrdersPage {



    public AllOrdersPage(){
        PageFactory.initElements(Driver.getDriver(), this);

    }


    @FindBy(xpath = "//a[@id='ctl00_MainContent_btnCheckAll']")
    public WebElement checkAllButton;

    @FindBy(xpath = "//a[@id='ctl00_MainContent_btnUncheckAll']")
    public WebElement uncheckAllButton;


    @FindBy(xpath = "//input[@type='checkbox']")
    public List<WebElement> allCheckBoxes;


    @FindBy(xpath = "//a[.='Order']")
    public WebElement orderLink;

    public boolean checkAllButtonIsEnabled(){
       return checkAllButton.isEnabled();
    }

    public boolean uncheckAllButtonIsEnabled(){
        return uncheckAllButton.isEnabled();
    }


}
