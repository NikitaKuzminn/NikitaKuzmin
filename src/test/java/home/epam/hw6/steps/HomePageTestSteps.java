package home.epam.hw6.steps;

import home.epam.hw6.confing.ConfProperties;
import home.epam.hw6.confing.Values;
import home.epam.hw6.pages.HeaderMenu;
import home.epam.hw6.pages.HomePage;
import home.epam.hw6.pages.LeftMenu;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.testng.asserts.SoftAssert;

public class HomePageTestSteps {

    SoftAssert softAssert = new SoftAssert();
    protected HeaderMenu headerMenu;
    protected HomePage homePage;
    protected LeftMenu leftMenu;

    public HomePageTestSteps(WebDriver webDriver) {
        headerMenu = new HeaderMenu(webDriver);
        homePage = new HomePage(webDriver);
        leftMenu = new LeftMenu(webDriver);
    }

    @Step("Open page")
    public void openPage(String page) {
        homePage.open(page);
    }

    @Step("Assert Browser title")
    public void assertTitle() {
        softAssert.assertEquals(homePage.getPageTitle(), ConfProperties.getProperty("title"));
    }

    @Step("Wrong assert Browser title")
    public void wrongAssertTitle() {
        softAssert.assertEquals(homePage.getPageTitle(), ConfProperties.getProperty("mistake"));
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

    @Step("Header section assert")
    public void headerSection() {
        softAssert.assertTrue(headerMenu.getHeaderMenu().isDisplayed());
        softAssert.assertEquals(headerMenu.getHeaderMenuText(),
            Values.HEAD_MENU_TEXT);
    }

    @Step("Benefit img assert")
    public void assertImages() {
        softAssert.assertEquals(homePage.getBenefitIcons().size(), 4);
    }

    @Step("Benefit text assert")
    public void assertImagesTxt() {
        softAssert.assertEquals(homePage.getBenefitTxt(), home.epam.hw3.confing.Values.IMG_TXT);
    }

    @Step("iFrame assert")
    public void assertIframe() {
        softAssert.assertTrue(homePage.getButtonFrame().isDisplayed());
    }

    @Step("Switch to iFrame and check button")
    public void checkIframe() {
        homePage.switchToFrame();
        softAssert.assertEquals(homePage.getValueOfFrameButton(), ConfProperties.getProperty("frameButton"));
    }

    @Step("Switch back to default window")
    public void switchBack() {
        homePage.switchToDefault();
    }

    @Step("Left menu assert")
    public void assertLeftMenu() {
        softAssert.assertEquals(leftMenu.getMenuTxt(leftMenu.getLeftMenu()), Values.LEFT_MENU_TEXT);
    }

    @Step("Logout")
    public void logoutStep() {
        headerMenu.logout();
    }

    public void assertAllAssertions() {
        softAssert.assertAll();
    }
}
