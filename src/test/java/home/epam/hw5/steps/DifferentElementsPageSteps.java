package home.epam.hw5.steps;

import static org.assertj.core.api.Assertions.assertThat;

import home.epam.hw5.config.ConfProperties;
import home.epam.hw5.config.Values;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class DifferentElementsPageSteps extends BaseSteps {

    @Then("I expect username to be \"ROMAN IOVLEV\"")
    public void userAssert() {
        assertThat(headerMenu.getUserName().isDisplayed()).isTrue();
        assertThat(headerMenu.getUserNameText()).isEqualTo(ConfProperties.getProperty("user"));
    }

    @And("I Open through the header menu Service and select Different Elements Page")
    public void openDifPage() {
        headerMenu.goToDiffPage();
    }

    @Then("Log rows are displayed for each selected web elements containing selected items")
    public void logAssert() {
        assertThat(differentElementsPage
            .collectLogs()
            .getLogsText())
            .isEqualTo(Values.LOGS);
    }

    @When("I select {string} in checkboxes on Different Element Page")
    public void selectCheckboxes(String name) {
        differentElementsPage.selectCheckboxes(name);
    }

    @And("I select radio {string}")
    public void selectSelen(String name) {
        differentElementsPage.selectRadio(name);
    }

    @And("I select {string} in dropdown")
    public void selectColor(String name) {
        differentElementsPage.selectColors(name);
    }

    @Then("{string} checkbox is selected")
    public void checkboxesAssert(String name) {
        assertThat(differentElementsPage.isCheckboxSelected(name)).isTrue();
    }

    @Then("{string} radio is selected")
    public void radioAssert(String name) {
        assertThat(differentElementsPage.isRadioEnabled(name)).isTrue();
    }

    @Then("{string} is selected in dropdown")
    public void dropdownAssert(String name) {
        assertThat(differentElementsPage.isDropDownSelected(name)).isTrue();
    }
}
