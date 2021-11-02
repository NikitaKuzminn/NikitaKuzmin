package home.epam.hw4.steps;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import home.epam.hw4.confing.ConfProperties;
import home.epam.hw4.confing.Values;
import home.epam.hw4.pages.DifferentElementsPage;
import home.epam.hw4.pages.HeaderMenu;
import home.epam.hw4.pages.HomePage;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.testng.asserts.SoftAssert;

public class DifferentElementsPageSteps {

    SoftAssert softAssert = new SoftAssert();
    protected HeaderMenu headerMenu;
    protected DifferentElementsPage differentElementsPage;
    protected HomePage homePage;

    public DifferentElementsPageSteps(WebDriver webDriver) {
        headerMenu = new HeaderMenu(webDriver);
        differentElementsPage = new DifferentElementsPage(webDriver);
        homePage = new HomePage(webDriver);
    }

    @Step("Open page")
    public void openPage(String page) {
        homePage.open(page);
    }

    @Step("Assert Browser title")
    public void assertTitle() {
        softAssert.assertEquals(homePage.getPageTitle(), ConfProperties.getProperty("title"));
    }

    @Step("Login perform")
    public void loginPerform() {
        headerMenu.login();
    }

    @Step("Assert username {username} loggined")
    public void assertUserName(String username) {
        softAssert.assertTrue(headerMenu.getUserName().isDisplayed());
        softAssert.assertEquals(headerMenu.getUserNameText(), username);
    }

    @Step("Open differentElements page")
    public void openDiffPage() {
        headerMenu.goToDiffPage();
    }

    @Step("Set config")
    public void setConfig() {
        differentElementsPage.addConfig();
    }

    @Step("Logs check")
    public void logsCheck() {
        assertThat(differentElementsPage
            .collectLogs()
            .getLogsText())
            .isEqualTo(Values.LOGS);
    }
}
