package home.epam.hw3.pages;

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
public class LeftMenu extends BasePage {

    @FindBy(css = "#mCSB_1_container > ul > li > a > span")
    private List<WebElement> leftMenu;

    public LeftMenu(WebDriver webDriver) {
        super(webDriver);
        PageFactory.initElements(webDriver, this);
    }

    public List<String> getMenuTxt(List<WebElement> webElements) {
        List<String> leftMenu = new ArrayList<>();
        for (WebElement element : webElements) {
            leftMenu.add(element.getText());
        }
        return leftMenu;
    }
}
