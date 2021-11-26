package home.epam.hw7.entities;

import com.epam.jdi.tools.DataClass;
import home.epam.hw7.site.components.util.Color;
import home.epam.hw7.site.components.util.Element;
import home.epam.hw7.site.components.util.Metal;
import home.epam.hw7.site.components.util.Vegetable;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MetalsAndColorsData extends DataClass<MetalsAndColorsData> {

    private Color color;
    private Metal metals;
    private Vegetable[] vegetables;
    private Element[] elements;
    private int[] summary;

    public List<String> getExpectedResult() {
        List<String> expectedResult = new LinkedList<>();
        expectedResult.add(String.format("Summary: %d", summary[0] + summary[1]));
        expectedResult.add(String.format("Elements: %s",
            Arrays.stream(elements).map(Enum::name).collect(Collectors.joining(", "))));
        expectedResult.add(String.format("Color: %s", color.name()));
        expectedResult.add(String.format("Metal: %s", metals.name()));
        expectedResult.add(String.format("Vegetables: %s",
            Arrays.stream(vegetables).map(Enum::name).collect(Collectors.joining(", "))));
        return expectedResult;
    }
}
