package home.epam.hw3.pages;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;
import lombok.Data;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

@Data
public class HomePage extends BasePage {

    @FindBy(css = "div.row .col-sm-3")
    private List<WebElement> benefitIcons;

    @FindBy(xpath = "//span[@class=\"benefit-txt\"]")
    private List<WebElement> benefitTxt;

    @FindBy(id = "frame")
    private WebElement buttonFrame;

    @FindBy(id = "frame-button")
    private WebElement frameButton;

    public HomePage(WebDriver webDriver) {
        super(webDriver);
        PageFactory.initElements(webDriver, this);
    }

    public void open(String url) {
        webDriver.navigate().to(url);
    }

    public String getPageTitle() {
        return webDriver.getTitle();
    }

    public void switchOn(boolean flag) {
        webDriver = (flag) ? this.webDriver.switchTo().frame(buttonFrame) : this.webDriver.switchTo().defaultContent();
    }

    public String getValueOfFrameButton() {
        return frameButton.getAttribute("value");
    }

    public List<String> getBenefitTxt() {
        List<String> benefit = new ArrayList<>();
        for (int i = 0; i < benefitTxt.toArray().length; i++) {
            if (i == 3) {
                String encod = (benefitTxt.get(i)).getText();
                String decod = null;
                try {
                    decod = new String(encod.getBytes("ISO-8859-1"), "UTF-8");
                } catch (UnsupportedEncodingException e) {
                    e.printStackTrace();
                }
                benefit.add(decod);
            } else {
                benefit.add(benefitTxt.get(i).getText());
            }
        }
        return benefit;
    }
}
