package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class OrderPage {

    public OrderPage(){
        PageFactory.initElements(Driver.getDriver(), this);

    }


    @FindBy(id = "ctl00_MainContent_fmwOrder_txtQuantity")
    public WebElement quantityField;

    @FindBy(id = "ctl00_MainContent_fmwOrder_txtName")
    public WebElement customerNameField;

    @FindBy(id = "ctl00_MainContent_fmwOrder_cardList_0")
    public WebElement visaCheckbox;

    @FindBy(id = "ctl00_MainContent_fmwOrder_TextBox6")
    public WebElement cardNoField;

    @FindBy(id = "ctl00_MainContent_fmwOrder_TextBox1")
    public WebElement expiry;

    @FindBy(id = "ctl00_MainContent_fmwOrder_InsertButton")
    public WebElement processButton;











}
