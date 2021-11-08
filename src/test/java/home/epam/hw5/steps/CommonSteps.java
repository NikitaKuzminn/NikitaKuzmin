package home.epam.hw5.steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;

public class CommonSteps extends BaseSteps {

    @Given("I open JDI GitHub site")
    public void openSite() {
        headerMenu.open();
    }

    @And("I login as user \"Roman Iovlev\"")
    public void login() {
        headerMenu.login();
    }
}
