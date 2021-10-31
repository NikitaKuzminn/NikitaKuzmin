package home.epam.hw3.pages;

import java.util.ArrayList;
import java.util.List;
import lombok.Data;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

@Data
public class DifferentElementsPage extends BasePage {

    private List<String> logsText = new ArrayList<>();

    @FindBy(xpath = "//label[@class=\"label-checkbox\"]")
    private List<WebElement> checkboxes;

    @FindBy(xpath = "//label[@class=\"label-radio\"]")
    private List<WebElement> radio;

    @FindBy(className = "colors")
    private WebElement colors;

    @FindBy(xpath = "//option[text()=\"Yellow\"]")
    private WebElement color;

    @FindBy(css = ".info-panel-body-log .panel-body-list > li")
    private List<WebElement> log;

    public DifferentElementsPage(WebDriver webDriver) {
        super(webDriver);
        PageFactory.initElements(webDriver, this);
    }

    public void addConfig() {
        checkboxes.get(0).click();
        checkboxes.get(2).click();
        radio.get(3).click();
        colors.click();
        color.click();
    }

    public DifferentElementsPage collectLogs() {
        for (WebElement element : log) {
            System.out.println(element.getText());
            logsText.add(element.getText().substring(9));
        }
        return this;
    }
}

