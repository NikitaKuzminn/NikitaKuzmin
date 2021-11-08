package home.epam.hw5.steps;

import home.epam.hw5.context.TestContext;
import home.epam.hw5.pages.DifferentElementsPage;
import home.epam.hw5.pages.HeaderMenu;
import home.epam.hw5.pages.UserTablePage;
import org.openqa.selenium.WebDriver;

public abstract class BaseSteps {

    protected DifferentElementsPage differentElementsPage;
    protected HeaderMenu headerMenu;
    protected UserTablePage userTablePage;

    public BaseSteps() {
        WebDriver webDriver = TestContext.getInstance().getObject("driver");
        differentElementsPage = new DifferentElementsPage(webDriver);
        headerMenu = new HeaderMenu(webDriver);
        userTablePage = new UserTablePage(webDriver);
    }
}
