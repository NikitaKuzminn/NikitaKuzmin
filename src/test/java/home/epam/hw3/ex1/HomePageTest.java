package home.epam.hw3.ex1;

import home.epam.hw3.confing.BaseTest;
import org.testng.annotations.Test;

public class HomePageTest extends BaseTest {

    @Test
    public void homePageTest() {
        //2.Browser title assert
        homePage.homePageAssert(webDriver);
        //3.Login steps 4.Login assert
        homePage.login();
        //5.Head menu assert
        homePage.headMenuAssert();
        //6(7).Index img & text assert
        homePage.benefitAssert();
        //8(9).iFrame assert
        homePage.frameSwitch(webDriver);
        //10.Switch back
        homePage.switchBack(webDriver);
        //11.Left menu assert
        homePage.leftMenuAssert();



        homePage.assertAll();
    }
}
