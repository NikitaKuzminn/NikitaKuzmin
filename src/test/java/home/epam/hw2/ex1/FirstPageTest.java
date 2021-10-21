package home.epam.hw2.ex1;

import home.epam.hw2.config.BaseTest;
import home.epam.hw2.config.ConfProperties;
import java.io.UnsupportedEncodingException;
import java.util.Locale;
import org.openqa.selenium.By;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class FirstPageTest extends BaseTest {

    @Test
    public void firstPageTest() throws UnsupportedEncodingException {
        SoftAssert softAssert = new SoftAssert();

        //2.Browser title assert
        softAssert.assertTrue(webDriver.getTitle().contains("Home Page"));

        firstPage.clickLoginIcon();
        firstPage.inputLogin(ConfProperties.getProperty("login"));
        firstPage.inputPassword(ConfProperties.getProperty("password"));
        firstPage.clickLoginBtn();

        //4.Login assert
        softAssert.assertEquals(firstPage.getUserName(), ConfProperties.getProperty("user"));

        //5.Head elements menu assert
        for (int i = 0; i < firstPage.headElements().toArray().length; ++i) {
            if (i == 3) {
                softAssert.assertEquals((firstPage.headElements().get(i)).getText(), firstPage.textElements().get(i));
            } else {
                softAssert.assertEquals((firstPage.headElements().get(i)).getText(),
                    firstPage.textElements().get(i).toUpperCase(Locale.ROOT));
            }
            softAssert.assertTrue(firstPage.headElements().get(i).isDisplayed());
        }

        //6.Index page img assert
        for (int i = 0; i < firstPage.getIcons().toArray().length; ++i) {
            softAssert.assertTrue((firstPage.getIcons().get(i)).isDisplayed());
        }

        //7.Index page txt assert
        softAssert.assertEquals((firstPage.getTxt().get(0)).getText(), ConfProperties.getProperty("txt1"));
        softAssert.assertEquals((firstPage.getTxt().get(1)).getText(), ConfProperties.getProperty("txt2"));
        softAssert.assertEquals((firstPage.getTxt().get(2)).getText(), ConfProperties.getProperty("txt3"));
        String encod = (firstPage.getTxt().get(3)).getText();
        String decod = new String(encod.getBytes("ISO-8859-1"), "UTF-8");
        softAssert.assertEquals(decod, ConfProperties.getProperty("txt4"));

        //8.iFrame assert
        softAssert.assertTrue(webDriver.findElement(By.id("frame")).isDisplayed());
        firstPage.switchToIframe(webDriver);
        softAssert.assertTrue(webDriver.findElement(By.id("frame-button")).isDisplayed());
        firstPage.switchBack(webDriver);

        //9.Right menu assert
        for (int i = 0; i < firstPage.rightMenuElements().toArray().length; ++i) {
            softAssert.assertEquals((firstPage.rightMenuElements().get(i)).getText(),
                firstPage.textElements().get(i));
            softAssert.assertTrue(firstPage.rightMenuElements().get(i).isDisplayed());
        }

        softAssert.assertAll();
    }
}
