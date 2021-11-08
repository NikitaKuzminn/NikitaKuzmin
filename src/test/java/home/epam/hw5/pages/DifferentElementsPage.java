package home.epam.hw5.pages;

import home.epam.hw5.config.Values;
import io.qameta.allure.Step;
import java.util.ArrayList;
import java.util.List;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

@EqualsAndHashCode(callSuper = false)
@Data
public class DifferentElementsPage extends BasePage {

    private List<String> logsText = new ArrayList<>();

    @FindBy(xpath = "//ul[@class='panel-body-list logs']/li")
    private List<WebElement> log;

    @FindBy(css = ".label-checkbox > input")
    private List<WebElement> checkboxes;

    @FindBy(css = ".checkbox-row .label-radio")
    private List<WebElement> radio;

    @FindBy(css = ".colors .uui-form-element")
    private WebElement colors;

    @FindBy(css = ".uui-form-element > option")
    private List<WebElement> color;

    public DifferentElementsPage(WebDriver webDriver) {
        super(webDriver);
        PageFactory.initElements(webDriver, this);
    }

    @Step("Get logs text")
    public DifferentElementsPage collectLogs() {
        for (WebElement element : log) {
            System.out.println(element.getText());
            logsText.add(element.getText().substring(9));
        }
        return this;
    }

    @Step("Select checkbox {name}")
    public DifferentElementsPage selectCheckboxes(String name) {
        checkboxes.get(Values.CHECKBOXES.get(name)).click();
        return this;
    }

    @Step("Select radio {name}")
    public DifferentElementsPage selectRadio(String name) {
        radio.get(Values.RADIO.get(name)).click();
        return this;
    }

    @Step("Select dropdown {name}")
    public DifferentElementsPage selectColors(String name) {
        colors.click();
        color.get(Values.COLORS.get(name)).click();
        return this;
    }

    @Step("Is checkbox {name} selected")
    public boolean isCheckboxSelected(String name) {
        return checkboxes.get(Values.CHECKBOXES.get(name)).isSelected();
    }

    @Step("Is radio {name} enabled")
    public boolean isRadioEnabled(String name) {
        return radio.get(Values.RADIO.get(name)).isEnabled();
    }

    @Step("Is dropdown {name} selected")
    public boolean isDropDownSelected(String name) {
        return color.get(Values.COLORS.get(name)).isSelected();
    }
}
