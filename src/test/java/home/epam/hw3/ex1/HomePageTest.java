package home.epam.hw3.ex1;

import home.epam.hw3.confing.BaseTest;
import home.epam.hw3.confing.ConfProperties;
import home.epam.hw3.confing.Values;
import home.epam.hw3.pages.HeaderMenu;
import home.epam.hw3.pages.HomePage;
import home.epam.hw3.pages.LeftMenu;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class HomePageTest extends BaseTest {

    SoftAssert softAssert = new SoftAssert();

    @Test
    public void homePageTest() {

        HomePage homePage = new HomePage(webDriver);

        homePage.open(PAGE);
        softAssert.assertEquals(webDriver.getCurrentUrl(), PAGE);

        //2.Assert Browser title
        softAssert.assertEquals(homePage.getPageTitle(), ConfProperties.getProperty("title"));

        HeaderMenu headerMenu = new HeaderMenu(webDriver);

        //3.Login steps
        headerMenu.login();

        //4.Login assert
        softAssert.assertTrue(headerMenu.getUserName().isDisplayed());
        softAssert.assertEquals(headerMenu.getUserNameText(), ConfProperties.getProperty("user"));

        //5.Header section assert
        softAssert.assertTrue(headerMenu.getHeaderMenu().isDisplayed());
        softAssert.assertEquals(headerMenu.getHeaderMenuText(), Values.HEAD_MENU_TEXT);

        //6.Benefit img assert
        softAssert.assertEquals(homePage.getBenefitIcons().size(), 4);

        //7.Benefit text assert
        softAssert.assertEquals(homePage.getBenefitTxt(), Values.IMG_TXT);

        //8.(9, 10)iFrame assert
        softAssert.assertTrue(homePage.getButtonFrame().isDisplayed());
        homePage.switchToFrame();
        softAssert.assertEquals(homePage.getValueOfFrameButton(), ConfProperties.getProperty("frameButton"));
        homePage.switchToDefault();

        //11.Left menu assert
        LeftMenu leftMenu = new LeftMenu(webDriver);

        softAssert.assertEquals(leftMenu.getMenuTxt(leftMenu.getLeftMenu()), Values.LEFT_MENU_TEXT);

        headerMenu.logout();

        softAssert.assertAll();
    }
}
