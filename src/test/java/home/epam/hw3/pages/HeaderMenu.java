package home.epam.hw3.pages;

import home.epam.hw3.confing.ConfProperties;
import lombok.Data;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

@Data
public class HeaderMenu extends BasePage {

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
        loginField.sendKeys(ConfProperties.getProperty("login"));
        passField.sendKeys(ConfProperties.getProperty("password"));
        loginButton.click();
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
