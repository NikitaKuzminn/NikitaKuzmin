package home.epam.hw3.confing;

import home.epam.hw3.pages.HomePage;
import io.github.bonigarcia.wdm.WebDriverManager;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public class BaseTest {
    public WebDriver webDriver;
    public HomePage homePage;

    public BaseTest() {
    }

    @BeforeClass(alwaysRun = true)
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        webDriver = new ChromeDriver();
        homePage = new HomePage(webDriver);
        webDriver.manage().window().maximize();
        webDriver.manage().timeouts().implicitlyWait(10L, TimeUnit.SECONDS);
        webDriver.get(ConfProperties.getProperty("page"));
    }

    @AfterClass(alwaysRun = true)
    public void tearDown() {
        webDriver.quit();
    }
}