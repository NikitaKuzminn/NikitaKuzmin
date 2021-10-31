package home.epam.hw3.pages;

import lombok.NoArgsConstructor;
import org.openqa.selenium.WebDriver;

@NoArgsConstructor
public abstract class BasePage {
    protected WebDriver webDriver;

    public BasePage(WebDriver webDriver) {
        this.webDriver = webDriver;
    }
}
