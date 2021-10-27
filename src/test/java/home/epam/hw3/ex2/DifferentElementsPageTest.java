package home.epam.hw3.ex2;

import home.epam.hw3.confing.BaseTest;
import org.testng.annotations.Test;

public class DifferentElementsPageTest extends BaseTest {

    @Test
    public void differentPageTest() {
        //2.Browser title assert
        homePage.homePageAssert(webDriver);
        //3.Login steps 4.Login assert
        homePage.login();
        //5(6, 7, 8). Check steps
        homePage.goToDiffPage();
        differentElementsPage.addConfig();
        //9.Log assert
        differentElementsPage.logTxtAssert();

    }
}
