package home.epam.hw2.ex1;

import home.epam.hw2.config.BaseTest;
import home.epam.hw2.config.ConfProperties;
import java.io.UnsupportedEncodingException;
import java.util.List;
import java.util.Locale;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class FirstPageTest extends BaseTest {

    @Test
    public void firstPageTest() {
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

        //5.Head elements menu assert
        softAssert.assertEquals(webDriver.findElement(By.linkText("HOME")).getText(),
            ConfProperties.getProperty("buttonTxt").toUpperCase(Locale.ROOT));
        softAssert.assertTrue(webDriver.findElement(By.linkText("HOME")).isDisplayed());

        softAssert.assertEquals(webDriver.findElement(By.linkText("CONTACT FORM")).getText(),
            ConfProperties.getProperty("buttonTxt2").toUpperCase(Locale.ROOT));
        softAssert.assertTrue(webDriver.findElement(By.linkText("CONTACT FORM")).isDisplayed());

        softAssert.assertEquals(webDriver.findElement(By.linkText("SERVICE")).getText(),
            ConfProperties.getProperty("buttonTxt3").toUpperCase(Locale.ROOT));
        softAssert.assertTrue(webDriver.findElement(By.linkText("SERVICE")).isDisplayed());

        softAssert.assertEquals(webDriver.findElement(By.linkText("Metals & Colors")).getText(),
            ConfProperties.getProperty("buttonTxt4"));
        softAssert.assertTrue(webDriver.findElement(By.linkText("Metals & Colors")).isDisplayed());

        //6.Index page img assert
        List<WebElement> indexImg = webDriver.findElements(By.xpath("//div[@class = \"benefit-icon\"]"));
        for (int i = 0; i < indexImg.toArray().length; i++) {
            softAssert.assertTrue(indexImg.get(i).isDisplayed());
        }

        //7.Index page txt assert
        List<WebElement> imgTxt = webDriver.findElements(By.xpath("//span[@class=\"benefit-txt\"]"));
        softAssert.assertEquals(imgTxt.get(0).getText(), ConfProperties.getProperty("txt1"));
        softAssert.assertEquals(imgTxt.get(1).getText(), ConfProperties.getProperty("txt2"));
        softAssert.assertEquals(imgTxt.get(2).getText(), ConfProperties.getProperty("txt3"));
        String encod = (imgTxt.get(3)).getText();
        String decod = null;
        try {
            decod = new String(encod.getBytes("ISO-8859-1"), "UTF-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        softAssert.assertEquals(decod, ConfProperties.getProperty("txt4"));

        //8.iFrame assert
        WebElement frame = webDriver.findElement(By.id("frame"));
        softAssert.assertTrue(frame.isDisplayed());
        webDriver.switchTo().frame(frame);
        softAssert.assertTrue(webDriver.findElement(By.id("frame-button")).isDisplayed());
        webDriver.switchTo().parentFrame();

        //9.Left menu assert
        WebElement homeBtn = webDriver.findElement(By.xpath("//span[text() = \"Home\"]"));
        softAssert.assertEquals(homeBtn.getText(), ConfProperties.getProperty("buttonTxt"));
        softAssert.assertTrue(homeBtn.isDisplayed());

        WebElement contactBtn = webDriver.findElement(By.xpath("//span[text() = \"Contact form\"]"));
        softAssert.assertEquals(contactBtn.getText(), ConfProperties.getProperty("buttonTxt2"));
        softAssert.assertTrue(contactBtn.isDisplayed());

        WebElement serviceBtn = webDriver.findElement(By.xpath("//span[text() = \"Service\"]"));
        softAssert.assertEquals(serviceBtn.getText(), ConfProperties.getProperty("buttonTxt3"));
        softAssert.assertTrue(serviceBtn.isDisplayed());

        WebElement metalBtn = webDriver.findElement(By.xpath("//span[text() = \"Metals & Colors\"]"));
        softAssert.assertEquals(metalBtn.getText(), ConfProperties.getProperty("buttonTxt4"));
        softAssert.assertTrue(metalBtn.isDisplayed());

        WebElement elementBtn = webDriver.findElement(By.xpath("//span[text() = \"Elements packs\"]"));
        softAssert.assertEquals(elementBtn.getText(), ConfProperties.getProperty("buttonTxt5"));
        softAssert.assertTrue(elementBtn.isDisplayed());

        softAssert.assertAll();

    }
}
