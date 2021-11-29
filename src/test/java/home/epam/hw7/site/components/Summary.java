package home.epam.hw7.site.components;

import com.epam.jdi.light.elements.common.UIElement;
import com.epam.jdi.light.elements.complex.WebList;
import com.epam.jdi.light.elements.composite.Section;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.UI;
import com.epam.jdi.light.ui.html.elements.common.Button;
import java.util.Optional;
import org.openqa.selenium.By;

@UI("#summary-block")
public class Summary extends Section {

    @UI("#odds-selector p")
    public WebList oddsRadio;
    @UI("#even-selector p")
    public WebList evenRadio;
    @UI("#calculate-button")
    public Button calculate;

    public void selectRadio(int[] numbers) {
        for (int number : numbers) {
            String value = Integer.toString(number);
            Optional<UIElement> optionalRadio;
            if (number % 2 == 0) {
                optionalRadio = evenRadio.stream()
                                         .filter(element -> element.find(By.tagName("label")).getText().contains(value))
                                         .findFirst();
            } else {
                optionalRadio = oddsRadio.stream()
                                         .filter(element -> element.find(By.tagName("label")).getText().contains(value))
                                         .findFirst();
            }
            optionalRadio.ifPresent(UIElement::click);
        }
    }

    public void calculateSummary(int[] summary) {
        selectRadio(summary);
        calculate.click();
    }
}
