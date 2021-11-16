package home.epam.hw7.site.pages;

import com.epam.jdi.light.elements.common.UIElement;
import com.epam.jdi.light.elements.complex.WebList;
import com.epam.jdi.light.elements.pageobjects.annotations.Title;
import com.epam.jdi.light.elements.pageobjects.annotations.Url;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.UI;
import home.epam.hw7.entities.MetalsAndColorsData;
import home.epam.hw7.site.components.forms.MetalsAndColorsForm;
import java.util.List;
import java.util.stream.Collectors;

@Url("/metals-colors")
@Title("Metal and Colors")
public class MetalsAndColorsPage extends AbstractPage {

    @UI(".main-content")
    public MetalsAndColorsForm metalsAndColorsForm;
    @UI("ul.panel-body-list.results li")
    public WebList resultSectionValues;

    public List<String> getResult() {
        return resultSectionValues.stream()
                                  .map(UIElement::getText)
                                  .collect(Collectors.toList());
    }

    public void fillMetalsAndColorsForm(MetalsAndColorsData testData) {
        metalsAndColorsForm.fill(testData);
    }

    public void submit() {
        metalsAndColorsForm.submit();
    }
}
