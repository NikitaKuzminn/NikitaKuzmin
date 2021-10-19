package home.epam.tc.hw1.complex;

import static org.assertj.core.api.Assertions.assertThat;

import home.epam.tc.hw1.CalculatorBaseTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class CalculatorPowTest extends CalculatorBaseTest {

    @DataProvider
    public Object[][] powDoubleDataProvider() {
        return new Object[][] {
            {2, 1.2, 2.0},
            {5.3, 5.4, 4181.954929999999},
            {0.4, 0.2, 1.0}
        };
    }

    @Test(dataProvider = "powDoubleDataProvider")
    public void powDoubleTest(double a, double b, double expected) {
        double actual = calculator.pow(a, b);
        assertThat(actual).isEqualTo(expected);
    }
}

