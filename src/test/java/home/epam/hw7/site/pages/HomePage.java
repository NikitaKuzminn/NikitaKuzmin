package home.epam.hw7.site.pages;

import com.epam.jdi.light.elements.pageobjects.annotations.Title;
import com.epam.jdi.light.elements.pageobjects.annotations.Url;
import home.epam.hw7.entities.User;

@Url("/index.html")
@Title("Home Page")
public class HomePage extends AbstractPage {

    public void loginAs(User user) {
        header.loginAs(user);
    }
}
