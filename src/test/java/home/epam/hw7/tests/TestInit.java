package home.epam.hw7.tests;

import static com.epam.jdi.light.driver.WebDriverUtils.killAllSeleniumDrivers;
import static com.epam.jdi.light.elements.init.PageFactory.initElements;

import home.epam.hw7.site.JdiTestSite;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

public interface TestInit {

    @BeforeSuite(alwaysRun = true)
    static void setUp() {
        initElements(JdiTestSite.class);
    }

    @AfterSuite(alwaysRun = true)
    static void teardown() {
        killAllSeleniumDrivers();
    }
}
