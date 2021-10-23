package home.epam.hw3.ex1;

import home.epam.hw3.confing.BaseTest;
import org.testng.annotations.Test;

public class HomePageTest extends BaseTest {

    @Test
    public void homePageTest(){
        //2.Browser title assert
        homePage.homePageAssert(webDriver);
        //3.Login steps 4.Login assert
        homePage.login();
        homePage.assertAll();

    }

}
