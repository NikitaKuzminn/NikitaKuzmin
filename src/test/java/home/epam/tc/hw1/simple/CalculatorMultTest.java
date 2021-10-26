package home.epam.tc.hw1.simple;

import static org.assertj.core.api.Assertions.assertThat;

import home.epam.tc.hw1.CalculatorBaseTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class CalculatorMultTest extends CalculatorBaseTest {
    @DataProvider
    public Object[][] multDoubleDataProvider() {
        return new Object[][] {
            {1.0, 1.2, 1.0},
            {5.3, 5.4, 28.0},
            {0.4, 0.2, 0}
        };
    }

    @Test(dataProvider = "multDoubleDataProvider", groups = "multDiv")
    public void multDoubleTest(double a, double b, double expected) {
        double actual = calculator.mult(a, b);
        assertThat(actual).isEqualTo(expected);
    }

    @DataProvider(name = "multLongDataProvider")
    public Object[][] multLongDataProvider() {
        return new Object[][] {
            {2, 2, 4},
            {3, 3, 9},
            {6, 6, 36}
        };
    }

    @Test(dataProvider = "multLongDataProvider", groups = "multDiv")
    public void multLongTest(long a, long b, long expected) {
        double actual = calculator.mult(a, b);
        assertThat(actual).isEqualTo(expected);
    }
}

