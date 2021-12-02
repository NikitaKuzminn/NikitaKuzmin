package home.epam.hw7.site.components.forms;

import static home.epam.hw7.site.components.util.Vegetable.VEGETABLES;

import com.epam.jdi.light.elements.complex.Checklist;
import com.epam.jdi.light.elements.complex.dropdown.Dropdown;
import com.epam.jdi.light.elements.composite.Form;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.JDropdown;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.UI;
import com.epam.jdi.light.ui.html.elements.common.Button;
import home.epam.hw7.entities.MetalsAndColorsData;
import home.epam.hw7.site.components.Summary;
import home.epam.hw7.site.components.util.Element;
import home.epam.hw7.site.components.util.Vegetable;

@UI(".main-content")
public class MetalsAndColorsForm extends Form<MetalsAndColorsData> {

    @UI("#summary-block")
    public Summary summaryBlock;
    @UI("#elements-checklist p")
    public Checklist elements;
    @UI("#submit-button")
    public Button submit;

    @JDropdown(
        root = "#colors",
        value = ".filter-option pull-left",
        expand = ".caret",
        list = "li")
    public Dropdown colors;

    @JDropdown(
        root = "#metals",
        value = ".filter-option.pull-left",
        expand = ".caret",
        list = "li")
    public Dropdown metals;

    @JDropdown(
        root = "#vegetables",
        value = ".filter-option.pull-left",
        expand = ".dropdown-toggle",
        list = "label")
    public Dropdown vegetables;

    private void selectElements(Element[] elementsToSelect) {
        for (Element element : elementsToSelect) {
            elements.check(element.index());
        }
    }

    private void selectVegetables(Vegetable[] vegetablesToSelect) {
        vegetables.select(VEGETABLES.name());
        for (Vegetable vegetable : vegetablesToSelect) {
            vegetables.select(vegetable.name());
        }
    }

    public void fill(MetalsAndColorsData data) {
        summaryBlock.calculateSummary(data.getSummary());
        selectElements(data.getElements());
        colors.select(data.getColor().name());
        metals.select(data.getMetals().name());
        selectVegetables(data.getVegetables());
    }

    public void submit() {
        submit.click();
    }
}
