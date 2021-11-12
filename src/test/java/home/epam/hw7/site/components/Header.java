package home.epam.hw7.site.components;

import com.epam.jdi.light.elements.complex.Menu;
import com.epam.jdi.light.elements.composite.Section;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.UI;
import home.epam.hw7.entities.User;
import home.epam.hw7.site.components.util.HeaderItem;

@UI(".uui-header.dark-gray")
public class Header extends Section {

    @UI("ul.uui-navigation.nav.navbar-nav.m-l8 li a")
    public Menu headerMenu;
    @UI("ul.uui-navigation.navbar-nav.navbar-right")
    public UserMenu userMenu;

    public void navigateTo(HeaderItem item) {
        headerMenu.select(item.getValue());
    }

    public void loginAs(User user) {
        userMenu.login(user);
    }

    public void logout() {
        userMenu.logout();
    }

    public boolean isLoggedIn() {
        return userMenu.isUserNameDisplayed();
    }

    public boolean isUserLoggedIn(User user) {
        if (userMenu.isUserNameDisplayed()) {
            return userMenu.getUsername().equalsIgnoreCase(user.fullName);
        }
        return false;
    }
}
