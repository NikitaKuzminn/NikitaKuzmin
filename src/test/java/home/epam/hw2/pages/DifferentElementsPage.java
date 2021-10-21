package home.epam.hw2.pages;

import java.util.List;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DifferentElementsPage {
    public WebDriver driver;

    @FindBy(xpath = "//label[@class=\"label-checkbox\"]")
    private List<WebElement> checkboxes;

    @FindBy(xpath = "//label[@class=\"label-radio\"]")
    private List<WebElement> radio;


    public DifferentElementsPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    public List<WebElement> getCheckboxes() {

        return checkboxes;
    }

    public List<WebElement> getRadio() {

        return radio;
    }
}

