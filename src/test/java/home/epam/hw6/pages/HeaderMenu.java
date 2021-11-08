package home.epam.hw6.pages;

import home.epam.hw6.confing.ConfProperties;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.openqa.selenium.NoSuchElementException;
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

    @FindBy(className = "uui-navigation")
    private WebElement headerMenu;

    public HeaderMenu(WebDriver webDriver) {
        super(webDriver);
        PageFactory.initElements(webDriver, this);
    }

    public void login() {
        loginIcon.click();
        loginField.sendKeys(LOGIN);
        passField.sendKeys(PASSWORD);
        loginButton.click();
    }

    public void logout() {
        try {
            logoutButton.click();
        } catch (NoSuchElementException e) {
            loginIcon.click();
            logoutButton.click();
        }
    }

    public void goToDiffPage() {
        serviceButton.click();
        diffBtn.click();
    }

    public String getUserNameText() {
        return userName.getText();
    }

    public String getSiteTitle() {
        return webDriver.getTitle();
    }

    public String getHeaderMenuText() {
        return headerMenu.getText();
    }
}
