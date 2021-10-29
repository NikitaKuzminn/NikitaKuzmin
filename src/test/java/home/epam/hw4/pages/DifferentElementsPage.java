package home.epam.hw4.pages;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.asserts.SoftAssert;

public class DifferentElementsPage {
    SoftAssert softAssert = new SoftAssert();
    public WebDriver driver;

    @FindBy(xpath = "//label[@class=\"label-checkbox\"]")
    private List<WebElement> checkboxes;

    @FindBy(xpath = "//label[@class=\"label-radio\"]")
    private List<WebElement> radio;

    @FindBy(className = "colors")
    private WebElement colors;

    @FindBy(xpath = "//option[text()=\"Yellow\"]")
    private WebElement color;

    @FindBy(xpath = "//ul[@class=\"panel-body-list logs\"]")
    private WebElement log;

    public DifferentElementsPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    public void addConfig() {
        checkboxes.get(0).click();
        checkboxes.get(2).click();
        radio.get(3).click();
        colors.click();
        color.click();
    }

    public void logTxtAssert() {
        List<WebElement> logTxt = log.findElements(By.tagName("li"));
        softAssert.assertTrue(logTxt.get(0).getText().contains("Colors: value changed to Yellow"));
        softAssert.assertTrue(logTxt.get(1).getText().contains("metal: value changed to Selen"));
        softAssert.assertTrue(logTxt.get(2).getText().contains("Wind: condition changed to true"));
        softAssert.assertTrue(logTxt.get(3).getText().contains("Water: condition changed to true"));
        softAssert.assertAll();
    }

}

