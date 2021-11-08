package home.epam.hw5.pages;

import home.epam.hw5.config.ConfProperties;
import io.qameta.allure.Step;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

@EqualsAndHashCode(callSuper = false)
@Data
public class HeaderMenu extends BasePage {

    protected static String LOGIN = ConfProperties.getProperty("login");
    protected static String PASSWORD = ConfProperties.getProperty("password");

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

    @FindBy(className = "dropdown")
    private WebElement serviceButton;

    @FindBy(linkText = "DIFFERENT ELEMENTS")
    private WebElement diffBtn;

    @FindBy(linkText = "USER TABLE")
    private WebElement userTableBtn;

    @FindBy(className = "uui-navigation")
    private WebElement headerMenu;

    public HeaderMenu(WebDriver webDriver) {
        super(webDriver);
        PageFactory.initElements(webDriver, this);
    }

    @Step("Login")
    public void login() {
        loginIcon.click();
        loginField.sendKeys(LOGIN);
        passField.sendKeys(PASSWORD);
        loginButton.click();
    }

    @Step("Open Different Elements Page")
    public void goToDiffPage() {
        serviceButton.click();
        diffBtn.click();
    }

    @Step("Get user name")
    public String getUserNameText() {
        return userName.getText();
    }
}
