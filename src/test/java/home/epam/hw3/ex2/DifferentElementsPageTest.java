package home.epam.hw3.ex2;

import home.epam.hw3.confing.BaseTest;
import org.testng.annotations.Test;

public class DifferentElementsPageTest extends BaseTest {

    @Test
    public void differentPageTest() {

        HomePage homePage = new HomePage(webDriver);

        homePage.open(PAGE);
        assertThat(webDriver.getCurrentUrl()).isEqualTo(PAGE);

        // 2. Assert Browser title
        assertThat(webDriver.getTitle()).isEqualTo(ConfProperties.getProperty("title"));

        //3.Login steps
        HeaderMenu headerMenu = new HeaderMenu(webDriver);
        headerMenu.login();

        //4.Login assert
        assertThat(headerMenu.getUserName().isDisplayed()).isTrue();
        assertThat(headerMenu.getUserNameText()).isEqualTo(ConfProperties.getProperty("user"));

        //5.(6, 7, 8) Check steps
        DifferentElementsPage differentElementsPage = new DifferentElementsPage(webDriver);
        headerMenu.goToDiffPage();
        differentElementsPage.addConfig();
        //9.Log assert
        differentElementsPage.logTxtAssert();

        //9. Log assert
        assertThat(differentElementsPage
            .collectLogs()
            .getLogsText())
            .isEqualTo(Values.LOGS);
    }
}
