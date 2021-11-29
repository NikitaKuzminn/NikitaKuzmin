package home.epam.hw7.site.pages;

import com.epam.jdi.light.elements.composite.WebPage;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.UI;
import home.epam.hw7.entities.User;
import home.epam.hw7.site.components.Header;
import home.epam.hw7.site.components.util.HeaderItem;

public abstract class AbstractPage extends WebPage {

    @UI(".uui-header.dark-gray")
    public Header header;

    public void logout() {
        header.logout();
    }

    public void navigateToItemInHeaderMenu(HeaderItem item) {
        header.navigateTo(item);
    }

    public boolean isUserLoggedIn(User user) {
        return header.isUserLoggedIn(user);
    }

    public boolean isLoggedIn() {
        return header.isLoggedIn();
    }
}
