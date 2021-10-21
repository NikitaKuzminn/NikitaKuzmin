package home.epam.hw2.ex2;

import home.epam.hw2.config.BaseTest;
import home.epam.hw2.config.ConfProperties;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class DifferentElementsTest extends BaseTest {

    @Test
    public void differentElementsTest() {
        SoftAssert softAssert = new SoftAssert();

        //2.Browser title assert
        softAssert.assertTrue(webDriver.getTitle().contains("Home Page"));

        firstPage.clickLoginIcon();
        firstPage.inputLogin(ConfProperties.getProperty("login"));
        firstPage.inputPassword(ConfProperties.getProperty("password"));
        firstPage.clickLoginBtn();

        //4.Login assert
        softAssert.assertEquals(firstPage.getUserName(), ConfProperties.getProperty("user"));

        firstPage.clickServiceBtn();
        webDriver.findElement(By.linkText("DIFFERENT ELEMENTS")).click();
        differentElementsPage.getCheckboxes().get(0).click();
        differentElementsPage.getCheckboxes().get(2).click();
        differentElementsPage.getRadio().get(3).click();
        webDriver.findElement(By.className("colors")).click();
        webDriver.findElement(By.xpath("//option[text()=\"Yellow\"]")).click();

        //9.Log assert
        WebElement log = webDriver.findElement(By.xpath("//ul[@class=\"panel-body-list logs\"]"));
        List<WebElement> logTxt = log.findElements(By.tagName("li"));
        softAssert.assertTrue(logTxt.get(0).getText().contains("Colors: value changed to Yellow"));
        softAssert.assertTrue(logTxt.get(1).getText().contains("metal: value changed to Selen"));
        softAssert.assertTrue(logTxt.get(2).getText().contains("Wind: condition changed to true"));
        softAssert.assertTrue(logTxt.get(3).getText().contains("Water: condition changed to true"));

        firstPage.clickLoginIcon();
    }
}
