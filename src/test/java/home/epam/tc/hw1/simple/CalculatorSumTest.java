package home.epam.tc.hw1.simple;

import static org.assertj.core.api.Assertions.assertThat;

import home.epam.tc.hw1.CalculatorBaseTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class CalculatorSumTest extends CalculatorBaseTest {

    @DataProvider
    public Object[][] sumDoubleDataProvider() {
        return new Object[][] {
            {1.0, 1.2, 2.2},
            {5.3, 5.4, 10.7},
            {12.64, 22.3, 34.94}
        };
    }

    @Test(dataProvider = "sumDoubleDataProvider", groups = "subSum")
    public void sumDoubleTest(double a, double b, double expected) {
        double actual = calculator.sum(a, b);
        assertThat(actual).isEqualTo(expected);
    }

    @DataProvider(name = "sumLongDataProvider")
    public Object[][] sumLongDataProvider() {
        return new Object[][] {
            {1, 2, 3},
            {25, 25, 50},
            {300, 300, 600}
        };
    }

    @Test(dataProvider = "sumLongDataProvider", groups = "subSum")
    public void sumLongTest(long a, long b, long expected) {
        double actual = calculator.sum(a, b);
        assertThat(actual).isEqualTo(expected);
    }
}

