package home.epam.hw7.site;

import com.epam.jdi.light.elements.pageobjects.annotations.JSite;
import com.epam.jdi.light.elements.pageobjects.annotations.Url;
import home.epam.hw7.entities.User;
import home.epam.hw7.site.pages.HomePage;
import home.epam.hw7.site.pages.MetalsAndColorsPage;

@JSite("https://jdi-testing.github.io/jdi-light/")
public class JdiTestSite {

    @Url("/index.html")
    public static HomePage homePage;

    @Url("/metals-colors.html")
    public static MetalsAndColorsPage metalsAndColorsPage;

    public static void loginAsUser(User user) {
        homePage.loginAs(user);
    }

    public static void shouldBeLoggedOut(HomePage page) {
        if (page.isLoggedIn()) {
            page.logout();
        }
    }
}
