package home.epam.hw4.steps;

import home.epam.hw4.confing.BaseConfing;
import home.epam.hw4.pages.HomePage;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;

public class HomePageTestSteps {

    HomePage homePage;

    @Step("Browser title assert")
    public void browserTitleAssertStep(WebDriver webDriver) {
        homePage.homePageAssert(webDriver);
    }

    @Step("Login assert")
    public void loginAssertStep() {
        homePage.login();
    }

    @Step("Head menu assert")
    public void headMenuAssertStep() {
        homePage.headMenuAssert();
    }

    @Step("Index img and text assert")
    public void indexImgAndTextAssertStep() {
        homePage.benefitAssert();
    }

    @Step("Switch to iFrame")
    public void frameAssertStep(WebDriver webDriver) {
        homePage.frameSwitch(webDriver);
    }

    @Step("Switch back to Home Page")
    public void switchBackStep(WebDriver webDriver) {
        homePage.switchBack(webDriver);
    }

    @Step("Left menu assert")
    public void leftMenuAssertStep() {
        homePage.leftMenuAssert();
    }
}
