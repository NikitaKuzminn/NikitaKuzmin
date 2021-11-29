package home.epam.hw7.site.components.forms;

import com.epam.jdi.light.elements.composite.Form;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.UI;
import com.epam.jdi.light.ui.html.elements.common.Button;
import com.epam.jdi.light.ui.html.elements.common.TextField;
import home.epam.hw7.entities.User;

@UI("#login-form")
public class LoginForm extends Form<User> {

    @UI("#name")
    public TextField login;
    @UI("#password")
    public TextField password;
    @UI("#login-button")
    public Button submit;
}
