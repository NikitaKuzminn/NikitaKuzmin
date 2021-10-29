package home.epam.hw4.confing;

import home.epam.hw4.pages.DifferentElementsPage;
import home.epam.hw4.pages.HomePage;
import io.github.bonigarcia.wdm.WebDriverManager;
import io.qameta.allure.Description;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public abstract class BaseConfing {
    public WebDriver webDriver;
    public HomePage homePage;
    public DifferentElementsPage differentElementsPage;

    public BaseConfing() {
    }

    @BeforeClass(alwaysRun = true)
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        webDriver = new ChromeDriver();
        homePage = new HomePage(webDriver);
        differentElementsPage = new DifferentElementsPage(webDriver);
        webDriver.manage().window().maximize();
        webDriver.manage().timeouts().implicitlyWait(10L, TimeUnit.SECONDS);
        webDriver.get(ConfProperties.getProperty("page"));
    }

    @AfterClass(alwaysRun = true, description = "Logout and tear down test environment")
    public void tearDown() {
        homePage.logout();
        webDriver.quit();
    }
}
