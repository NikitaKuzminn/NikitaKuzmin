package home.epam.tc.hw1.simple;

import static org.assertj.core.api.Assertions.assertThat;

import home.epam.tc.hw1.CalculatorBaseTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class CalculatorSubTest extends CalculatorBaseTest {

    @DataProvider
    public Object[][] subDoubleDataProvider() {
        return new Object[][] {
            {1.0, 1.2, -0.19999999999999996},
            {5.3, 5.4, -0.10000000000000053},
            {12.64, 22.3, -9.66}
        };
    }

    @Test(dataProvider = "subDoubleDataProvider", groups = {"subSum"})
    public void subDoubleTest(double a, double b, double expected) {
        double actual = calculator.sub(a, b);
        assertThat(actual).isEqualTo(expected);
    }

    @DataProvider(name = "subLongDataProvider")
    public Object[][] subLongDataProvider() {
        return new Object[][] {
            {1, 2, -1},
            {25, 25, 0},
            {300, 300, 0}
        };
    }

    @Test(dataProvider = "subLongDataProvider", groups = {"subSum"})
    public void subLongTest(long a, long b, long expected) {
        double actual = calculator.sub(a, b);
        assertThat(actual).isEqualTo(expected);
    }
}
