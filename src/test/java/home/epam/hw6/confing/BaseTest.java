package home.epam.hw6.confing;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

import io.github.bonigarcia.wdm.WebDriverManager;
import io.qameta.allure.Step;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.NoSuchSessionException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestContext;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class BaseTest {
    protected WebDriver webDriver;
    public static final String PAGE = ConfProperties.getProperty("page");

    @BeforeMethod(description = "Setup browser and maximize window")
    public void setUp(ITestContext testContext) {
        WebDriverManager.chromedriver().setup();
        webDriver = new ChromeDriver();
        webDriver.manage().window().maximize();
        webDriver.manage().timeouts()
                 .implicitlyWait(10, TimeUnit.SECONDS);
        testContext.setAttribute("driver", webDriver);
    }

    @AfterMethod(description = "Quit browser")
    @Step("Close browser")
    public void tearDown() {
        System.out.println("after method");
        webDriver.quit();
        assertThatThrownBy(webDriver::getTitle).isInstanceOf(NoSuchSessionException.class);
    }

}
