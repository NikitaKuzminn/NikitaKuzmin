package home.epam.tc.hw1.simple;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

import home.epam.tc.hw1.CalculatorBaseTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class CalculatorDivTest extends CalculatorBaseTest {

    @DataProvider
    public Object[][] divDoubleDataProvider() {
        return new Object[][] {
            {2, 1.2, 1.6666666666666667},
            {5.3, 5.4, 0.9814814814814814},
            {0.4, 0.2, 2}
        };
    }

    @Test(dataProvider = "divDoubleDataProvider", groups = "multDiv")
    public void divDoubleTest(double a, double b, double expected) {
        double actual = calculator.div(a, b);
        assertThat(actual).isEqualTo(expected);
    }

    @DataProvider(name = "divLongDataProvider")
    public Object[][] divLongDataProvider() {
        return new Object[][] {
            {2, 2, 1},
            {6, 3, 2},
            {6, 2, 3}
        };
    }

    @Test(dataProvider = "divLongDataProvider", groups = "multDiv")
    public void divLongTest(long a, long b, long expected) {
        double actual = calculator.div(a, b);
        assertThat(actual).isEqualTo(expected);
    }

    @DataProvider(name = "divExceptionLongDataProvider")
    public Object[][] divExceptionLongDataProvider() {
        return new Object[][] {
            {2, 0},
            {6, 0},
            {4, 0}
        };
    }

    @Test(dataProvider = "divExceptionLongDataProvider", groups = "multDiv")
    public void divExceptionLongTest(long a, long b) {
        assertThatThrownBy(() -> {
            calculator.div(a, b);
        }).isInstanceOf(NumberFormatException.class)
          .hasMessageContaining("Attempt to divide by zero");
    }
}

