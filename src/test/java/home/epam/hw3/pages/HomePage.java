package home.epam.hw3.pages;

import home.epam.hw3.confing.ConfProperties;
import java.io.UnsupportedEncodingException;
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

    @FindBy(linkText = "DIFFERENT ELEMENTS")
    private WebElement diffBtn;

    @FindBy(xpath = "//div[@class = \"benefit-icon\"]")
    private List<WebElement> benefitIcons;

    @FindBy(xpath = "//span[@class=\"benefit-txt\"]")
    private List<WebElement> benefitTxt;

    @FindBy(id = "frame")
    private WebElement buttonFrame;

    @FindBy(id = "frame-button")
    private WebElement frameButton;

    @FindBy(xpath = "//span[text() = \"Home\"]")
    private WebElement leftHomeBtn;

    @FindBy(xpath = "//span[text() = \"Contact form\"]")
    private WebElement leftContactBtn;

    @FindBy(xpath = "//span[text() = \"Service\"]")
    private WebElement leftServiceBtn;

    @FindBy(xpath = "//span[text() = \"Metals & Colors\"]")
    private WebElement leftMetalBtn;

    @FindBy(xpath = "//span[text() = \"Elements packs\"]")
    private WebElement elementsBtn;

    public HomePage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    public void login() {
        loginIcon.click();
        loginField.sendKeys(ConfProperties.getProperty("login"));
        passField.sendKeys(ConfProperties.getProperty("password"));
        loginButton.click();
        softAssert.assertEquals(userName.getText(), ConfProperties.getProperty("user"));
        softAssert.assertTrue(userName.isDisplayed());
    }

    public void logout() {
        try {
            logoutButton.click();
        } catch (Exception e) {
            loginIcon.click();
            logoutButton.click();
        }
    }

    public void goToDiffPage() {
        serviceButton.click();
        diffBtn.click();
    }

    public void frameSwitch(WebDriver driver) {
        softAssert.assertTrue(buttonFrame.isDisplayed());
        driver.switchTo().frame(buttonFrame);
        softAssert.assertTrue(frameButton.isDisplayed());
    }

    public void switchBack(WebDriver driver) {
        driver.switchTo().parentFrame();
    }

    public void homePageAssert(WebDriver driver) {
        softAssert.assertTrue(driver.getTitle().contains("Home Page"));
    }

    public void headMenuAssert() {
        softAssert.assertEquals(homeButton.getText(), ConfProperties.getProperty("buttonTxt").toUpperCase());
        softAssert.assertEquals(contactFormButton.getText(), ConfProperties.getProperty("buttonTxt2").toUpperCase());
        softAssert.assertEquals(serviceButton.getText(), ConfProperties.getProperty("buttonTxt3").toUpperCase());
        softAssert.assertEquals(metalsButton.getText(), ConfProperties.getProperty("buttonTxt4"));
    }

    public void benefitAssert() {
        for (int i = 0; i < benefitIcons.toArray().length; i++) {
            if (i == 3) {
                softAssert.assertTrue(benefitIcons.get(i).isDisplayed());
                String encod = (benefitTxt.get(i)).getText();
                String decod = null;
                try {
                    decod = new String(encod.getBytes("ISO-8859-1"), "UTF-8");
                } catch (UnsupportedEncodingException e) {
                    e.printStackTrace();
                }
                softAssert.assertEquals(decod, ConfProperties.getProperty("txt4"));
            } else {
                softAssert.assertTrue(benefitIcons.get(i).isDisplayed());
                softAssert.assertEquals(benefitTxt.get(i).getText(), ConfProperties.getProperty("txt" + (1 + i)));
            }
        }
    }

    public void leftMenuAssert() {
        softAssert.assertEquals(leftHomeBtn.getText(), ConfProperties.getProperty("buttonTxt"));
        softAssert.assertTrue(leftHomeBtn.isDisplayed());

        softAssert.assertEquals(leftContactBtn.getText(), ConfProperties.getProperty("buttonTxt2"));
        softAssert.assertTrue(leftContactBtn.isDisplayed());

        softAssert.assertEquals(leftServiceBtn.getText(), ConfProperties.getProperty("buttonTxt3"));
        softAssert.assertTrue(leftServiceBtn.isDisplayed());

        softAssert.assertEquals(leftMetalBtn.getText(), ConfProperties.getProperty("buttonTxt4"));
        softAssert.assertTrue(leftMetalBtn.isDisplayed());

        softAssert.assertEquals(elementsBtn.getText(), ConfProperties.getProperty("buttonTxt5"));
        softAssert.assertTrue(elementsBtn.isDisplayed());
    }

    public void assertAll() {
        softAssert.assertAll();
    }
}
