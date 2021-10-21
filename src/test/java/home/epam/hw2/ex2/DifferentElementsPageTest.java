package home.epam.hw2.ex2;

import home.epam.hw2.config.BaseTest;
import home.epam.hw2.config.ConfProperties;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class DifferentElementsPageTest extends BaseTest {

    @Test
    public void differentElementsTest() {
        SoftAssert softAssert = new SoftAssert();

        //2.Browser title assert
        softAssert.assertTrue(webDriver.getTitle().contains("Home Page"));

        //3.Login steps
        webDriver.findElement(By.id("user-icon")).click();
        webDriver.findElement(By.id("name")).sendKeys(ConfProperties.getProperty("login"));
        webDriver.findElement(By.id("password")).sendKeys(ConfProperties.getProperty("password"));
        webDriver.findElement(By.id("login-button")).click();

        //4.Login assert
        softAssert.assertEquals(webDriver.findElement(By.id("user-name")).getText(),
            ConfProperties.getProperty("user"));

        //5.(6,7,8) Check Steps
        webDriver.findElement(By.linkText("SERVICE")).click();
        webDriver.findElement(By.linkText("DIFFERENT ELEMENTS")).click();

        List<WebElement> checkBoxes = webDriver.findElements(By.xpath("//label[@class=\"label-checkbox\"]"));
        checkBoxes.get(0).click();
        checkBoxes.get(2).click();

        List<WebElement> radio = webDriver.findElements(By.xpath("//label[@class=\"label-radio\"]"));
        radio.get(3).click();

        webDriver.findElement(By.className("colors")).click();
        webDriver.findElement(By.xpath("//option[text()=\"Yellow\"]")).click();

        //9.Log assert
        WebElement log = webDriver.findElement(By.xpath("//ul[@class=\"panel-body-list logs\"]"));
        List<WebElement> logTxt = log.findElements(By.tagName("li"));
        softAssert.assertTrue(logTxt.get(0).getText().contains("Colors: value changed to Yellow"));
        softAssert.assertTrue(logTxt.get(1).getText().contains("metal: value changed to Selen"));
        softAssert.assertTrue(logTxt.get(2).getText().contains("Wind: condition changed to true"));
        softAssert.assertTrue(logTxt.get(3).getText().contains("Water: condition changed to true"));

        softAssert.assertAll();
    }
}
