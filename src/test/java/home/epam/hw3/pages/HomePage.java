package home.epam.hw3.pages;

import home.epam.hw3.confing.ConfProperties;
import java.util.List;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.asserts.SoftAssert;

public class HomePage {
    public WebDriver driver;
    SoftAssert softAssert = new SoftAssert();

    @FindBy(id = "user-icon")
    private WebElement loginIcon;

    @FindBy(id = "name")
    private WebElement loginField;

    @FindBy(id = "password")
    private WebElement passField;

    @FindBy(id = "login-button")
    private WebElement loginButton;

    @FindBy(id = "user-name")
    private WebElement userName;

    @FindBy(className = "logout")
    private WebElement logoutButton;

    @FindBy(linkText = "HOME")
    private WebElement homeButton;

    @FindBy(linkText = "CONTACT FORM")
    private WebElement contactFormButton;

    @FindBy(className = "dropdown")
    private WebElement serviceButton;

    @FindBy(linkText = "Metals & Colors")
    private WebElement metalsButton;

    @FindBy(xpath = "//div[@class = \"benefit-icon\"]")
    private List<WebElement> benefitIcons;

    @FindBy(xpath = "//span[@class=\"benefit-txt\"]")
    private List<WebElement> benefitTxt;

    @FindBy(id = "frame")
    private WebElement buttonFrame;

    @FindBy(xpath = "//span[text() = \"Home\"]")
    private WebElement rightHomeBtn;

    @FindBy(xpath = "//span[text() = \"Contact form\"]")
    private WebElement rightContactBtn;

    @FindBy(xpath = "//span[text() = \"Service\"]")
    private WebElement rightServiceBtn;

    @FindBy(xpath = "//span[text() = \"Metals & Colors\"]")
    private WebElement rightMetalBtn;

    @FindBy(xpath = "//span[text() = \"Elements packs\"]")
    private WebElement elementsBtn;

    public HomePage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    public void homePageAssert(WebDriver driver){
        softAssert.assertTrue(driver.getTitle().contains("Писка"));
    }

    public void login(){
        loginIcon.click();
        loginField.sendKeys(ConfProperties.getProperty("login"));
        passField.sendKeys(ConfProperties.getProperty("password"));
        loginButton.click();
    }

    public void assertAll(){
        softAssert.assertAll();
    }



}