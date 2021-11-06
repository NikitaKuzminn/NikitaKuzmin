package home.epam.hw6.tests;

import home.epam.hw4.confing.BaseTest;
import home.epam.hw4.confing.ConfProperties;
import home.epam.hw4.confing.Listener;
import home.epam.hw4.steps.DifferentElementsPageSteps;
import io.qameta.allure.Description;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

@Feature("Different elements page functionality")
@Story("Checking the validation and functionality of interface elements")
@Listeners(Listener.class)
public class DifferentElementsPageTest extends BaseTest {
    SoftAssert softAssert = new SoftAssert();

    @Test()
    @Description("Different Elements Page assertion")
    public void differentPageTest() {

        DifferentElementsPageSteps differentElementsPageSteps = new DifferentElementsPageSteps(webDriver);
        differentElementsPageSteps.openPage(PAGE);
        softAssert.assertEquals(webDriver.getCurrentUrl(), PAGE);

        //2.Assert Browser title
        differentElementsPageSteps.assertTitle();
        //3.Login steps
        differentElementsPageSteps.loginPerform();
        //4.Login assert
        differentElementsPageSteps.assertUserName(ConfProperties.getProperty("user"));
        //5.(6, 7, 8) Check steps
        differentElementsPageSteps.openDiffPage();
        differentElementsPageSteps.setConfig();
        //9.Log assert
        differentElementsPageSteps.logsCheck();
    }
}

