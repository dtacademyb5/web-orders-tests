package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import utilities.ConfigReader;
import utilities.Driver;

public class LoginPage {


    public LoginPage(){
        PageFactory.initElements(Driver.getDriver(), this);
        // PageFactory class's initelements method is responsible for initializing all the variables with @FindBy annotation in this class with
    }



    @FindBy (id = "ctl00_MainContent_username")
    public WebElement usernameField;

    @FindBy (id = "ctl00_MainContent_password")
    public WebElement passwordField ;

    @FindBy (id = "ctl00_MainContent_login_button")
    public WebElement loginButton;

    //Page Classes can have variables and also methods that simulate interactions with the page

    public void login(){
       usernameField.sendKeys(ConfigReader.readProperty("username"));
        passwordField.sendKeys(ConfigReader.readProperty("password"));
        loginButton.click();

    }


}
