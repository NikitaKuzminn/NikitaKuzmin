package home.epam.hw6.util.webdriver;

import java.util.Locale;
import java.util.Objects;
import org.openqa.selenium.WebDriver;

public class WebDriverProvider {

    private static WebDriver driver;

    private WebDriverProvider() {
    }

    public static WebDriver getDriver() {
        if (Objects.isNull(driver)) {
            String launchType = System.getProperty("launch.type", "local");
            String browserName = System.getProperty("browser.name", "opera");
            driver = WebDriverFactory.createWebDriver(launchType,
                Browser.valueOf(browserName.toUpperCase(Locale.ROOT)));
        }
        return driver;
    }

    public static void closeDriver() {
        driver.quit();
        driver = null;
    }
}
