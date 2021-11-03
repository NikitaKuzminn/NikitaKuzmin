package home.epam.hw4.ex1;

import home.epam.hw4.confing.BaseTest;
import home.epam.hw4.confing.ConfProperties;
import home.epam.hw4.confing.Listener;
import home.epam.hw4.steps.HomePageTestSteps;
import io.qameta.allure.Description;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

@Feature("Home page functionality")
@Story("Checking basic verification and displaying items on the home page")
@Listeners(Listener.class)
public class HomePageTest extends BaseTest {
    SoftAssert softAssert = new SoftAssert();

    @Test()
    @Description("Home Page test")
    public void homePageTest() {
        HomePageTestSteps homePageTestSteps = new HomePageTestSteps(webDriver);
        homePageTestSteps.openPage(PAGE);
        softAssert.assertEquals(webDriver.getCurrentUrl(), PAGE);

        //2.Assert Browser title
        homePageTestSteps.assertTitle();
        //3.Login steps
        homePageTestSteps.loginPerform();
        //4.Login assert
        homePageTestSteps.assertUserName(ConfProperties.getProperty("user"));
        //5.Header section assert
        homePageTestSteps.headerSection();
        //6.Benefit img assert
        homePageTestSteps.assertImages();
        //7.Benefit text assert
        homePageTestSteps.assertImagesTxt();
        //8.iFrame assert
        homePageTestSteps.assertIframe();
        //9.IFrame button assert
        homePageTestSteps.checkIframe();
        //10.Switch back
        homePageTestSteps.switchBack();
        //11.Left menu assert
        homePageTestSteps.assertLeftMenu();

        homePageTestSteps.logoutStep();

        softAssert.assertAll();
        homePageTestSteps.assertAllAssertions();
    }
}
