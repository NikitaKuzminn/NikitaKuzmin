package home.epam.hw7.site.components;

import com.epam.jdi.light.elements.common.Label;
import com.epam.jdi.light.elements.composite.Section;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.UI;
import com.epam.jdi.light.ui.html.elements.common.Button;
import com.epam.jdi.light.ui.html.elements.common.Icon;
import home.epam.hw7.entities.User;
import home.epam.hw7.site.components.forms.LoginForm;

@UI("ul.uui-navigation.navbar-nav.navbar-right")
public class UserMenu extends Section {

    @UI("#user-icon")
    public Icon userIcon;
    @UI("#user-name")
    public Label userName;
    @UI(".logout span")
    public Button logoutBtn;
    @UI("#login-form")
    public LoginForm loginForm;

    public String getUsername() {
        return userName.getValue();
    }

    public boolean isUserNameDisplayed() {
        return userName.isDisplayed();
    }

    public void clickUserIcon() {
        userIcon.click();
    }

    public void login(User user) {
        clickUserIcon();
        loginForm.login(user);
    }

    public void logout() {
        clickUserIcon();
        logoutBtn.click();
    }
}
