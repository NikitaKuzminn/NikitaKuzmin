package home.epam.hw2.pages;

import home.epam.hw2.config.ConfProperties;
import java.util.ArrayList;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class FirstPage {
    public WebDriver driver;

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

    public FirstPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    public void clickLoginIcon() {
        loginIcon.click();
    }

    public void inputLogin(String login) {
        loginField.sendKeys(ConfProperties.getProperty("login"));
    }

    public void inputPassword(String password) {
        passField.sendKeys(ConfProperties.getProperty("password"));
    }

    public void clickLoginBtn() {
        loginButton.click();
    }

    public String getUserName() {
        WebDriverWait wait = new WebDriverWait(driver, 10L);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("user-name")));
        return this.userName.getText();
    }

    public void logout() {
        this.logoutButton.click();
    }

    public List<WebElement> headElements() {
        ArrayList<WebElement> headElements = new ArrayList<>();
        headElements.add(homeButton);
        headElements.add(contactFormButton);
        headElements.add(serviceButton);
        headElements.add(metalsButton);
        return headElements;
    }

    public List<WebElement> rightMenuElements() {
        List<WebElement> rightMenuElements = new ArrayList<>();
        rightMenuElements.add(rightHomeBtn);
        rightMenuElements.add(rightContactBtn);
        rightMenuElements.add(rightServiceBtn);
        rightMenuElements.add(rightMetalBtn);
        rightMenuElements.add(elementsBtn);

        return rightMenuElements;
    }

    public List<String> textElements() {
        List<String> textElements = new ArrayList<>();
        textElements.add("Home");
        textElements.add("Contact form");
        textElements.add("Service");
        textElements.add("Metals & Colors");
        textElements.add("Elements packs");
        return textElements;
    }

    public List<WebElement> getIcons() {
        return benefitIcons;
    }

    public List<WebElement> getTxt() {
        return benefitTxt;
    }

    public void switchToIframe(WebDriver driver) {
        driver.switchTo().frame(buttonFrame);
    }

    public void switchBack(WebDriver driver) {
        driver.switchTo().parentFrame();
    }

    public void clickServiceBtn() {
        serviceButton.click();
    }


}
