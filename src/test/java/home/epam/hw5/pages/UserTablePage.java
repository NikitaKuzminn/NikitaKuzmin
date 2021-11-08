package home.epam.hw5.pages;

import io.qameta.allure.Step;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

@EqualsAndHashCode(callSuper = false)
@Data
public class UserTablePage extends BasePage {

    @FindBy(css = "tr > td > select")
    private List<WebElement> dropdown;
    @FindBy(css = "#user-table > tbody > tr > td > a")
    private List<WebElement> users;
    @FindBy(className = "user-descr")
    private List<WebElement> descriptions;
    @FindBy(css = ".user-descr > input")
    private List<WebElement> checkBoxes;
    @FindBy(css = "tbody tr")
    private List<WebElement> userTable;
    @FindBy(tagName = "option")
    private List<WebElement> dropList;
    @FindBy(id = "ivan")
    private WebElement checkBoxSergeyIvan;
    @FindBy(xpath = "//ul[@class='panel-body-list logs']/li")
    private List<WebElement> logs;

    public UserTablePage(WebDriver webDriver) {
        super(webDriver);
        PageFactory.initElements(webDriver, this);
    }

    @Step("Count dropdowns")
    public int countDropdownNumber() {
        return dropdown.size();
    }

    @Step("Count users")
    public int countUsersNumber() {
        return users.size();
    }

    @Step("Count descriptions")
    public int countDescriptionNumber() {
        return descriptions.size();
    }

    @Step("Count checkboxes")
    public int countCheckboxesNumber() {
        return checkBoxes.size();
    }

    @Step("Get table")
    public List<List<String>> getUsersPage() {
        List<List<String>> personInfo = new ArrayList<>();
        for (WebElement row : userTable) {
            List<String> innerList = new ArrayList<>();
            String number = row.findElement(By.tagName("td")).getText();
            String name = row.findElement(By.tagName("a")).getText();
            String description = row.findElement(By.tagName("span"))
                                    .getText().replaceAll("[\\n]",
                    " ");
            Collections.addAll(innerList, number, name, description);
            personInfo.add(innerList);
        }
        return personInfo;
    }

    @Step("Get dropdown values")
    public List<String> dropdownValues() {
        List<String> dropdownValues = new ArrayList<>();
        dropdownValues.add(dropList.get(0).getText());
        dropdownValues.add(dropList.get(1).getText());
        dropdownValues.add(dropList.get(2).getText());

        return dropdownValues;
    }

    @Step("Select 'vip' checkbox")
    public void selectCheckBoxForSergeyIvan() {
        checkBoxSergeyIvan.click();
    }

    @Step("Check logs")
    public String logsForVipCheckBox() {
        return logs.get(0).getText().substring(9);
    }
}
