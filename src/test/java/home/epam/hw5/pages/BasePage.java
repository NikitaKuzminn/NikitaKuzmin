package home.epam.hw5.pages;

import home.epam.hw5.config.ConfProperties;
import io.qameta.allure.Step;
import lombok.NoArgsConstructor;
import org.openqa.selenium.WebDriver;

@NoArgsConstructor
public abstract class BasePage {

    protected static String PAGE = ConfProperties.getProperty("page");

    protected WebDriver webDriver;

    public BasePage(WebDriver webDriver) {
        this.webDriver = webDriver;
    }

    @Step("Get page title")
    public String getPageTitle() {
        return webDriver.getTitle();
    }

    @Step("Open site")
    public void open() {
        webDriver.navigate().to(PAGE);
    }
}
