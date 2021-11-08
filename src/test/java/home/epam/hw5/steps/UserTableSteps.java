package home.epam.hw5.steps;

import static org.assertj.core.api.Assertions.assertThat;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import java.util.ArrayList;
import java.util.List;

public class UserTableSteps extends BaseSteps {

    @Then("{string} page should be opened")
    public void titleAssert(String title) {
        assertThat(userTablePage.getPageTitle()).isEqualTo(title);
    }

    @When("I click on \"Service\" button in Header")
    public void clickService() {
        headerMenu.getServiceButton().click();
    }

    @And("I click on \"User Table\" button in Service dropdown")
    public void clickUserTable() {
        headerMenu.getUserTableBtn().click();
    }

    @And("{int} Number Type Dropdowns should be displayed on Users Table on User Table Page")
    public void dropdownsCountAssert(int count) {
        assertThat(userTablePage.countDropdownNumber()).isEqualTo(count);
    }

    @And("{int} Usernames should be displayed on Users Table on User Table Page")
    public void usersCountAssert(int count) {
        assertThat(userTablePage.countUsersNumber()).isEqualTo(count);
    }

    @And("{int} Description texts under images should be displayed on Users Table on User Table Page")
    public void userDescriptionsAssert(int count) {
        assertThat(userTablePage.countDescriptionNumber()).isEqualTo(count);
    }

    @And("{int} checkboxes should be displayed on Users Table on User Table Page")
    public void checkboxesCountAssert(int count) {
        assertThat(userTablePage.countCheckboxesNumber()).isEqualTo(count);
    }

    @And("User table should contain following values:")
    public void rowAssert(DataTable dataTable) {
        List<List<String>> listFromFeatureFile = dataTable.asLists(String.class);
        List<List<String>> listWithHeaderSkipped = new ArrayList<>(listFromFeatureFile);
        listWithHeaderSkipped.remove(0);
        assertThat(userTablePage.getUsersPage()).isEqualTo(listWithHeaderSkipped);
    }

    @And("Droplist should contain values in column Type for user Roman")
    public void dropdownOptionsAssert(DataTable dataTable) {
        List<List<String>> listFromFeatureFile = dataTable.asLists(String.class);
        List<List<String>> listWithHeaderSkipped = new ArrayList<>(listFromFeatureFile);
        listWithHeaderSkipped.remove(0);
        List<String> result = new ArrayList<>();
        listWithHeaderSkipped.forEach(result::addAll);
        assertThat(userTablePage.dropdownValues()).isEqualTo(result);
    }

    @When("I select 'vip' checkbox for \"Sergey Ivan\"")
    public void selectCheckbox() {
        userTablePage.selectCheckBoxForSergeyIvan();
    }

    @Then("1 log row has {string} text in log section")
    public void logAssert(String logText) {
        assertThat(userTablePage.logsForVipCheckBox()).isEqualTo(logText);
    }
}
