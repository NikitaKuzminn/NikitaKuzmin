package home.epam.tc.hw1.complex;

import static org.assertj.core.api.Assertions.assertThat;

import home.epam.tc.hw1.CalculatorBaseTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class CalculatorSqrtTest extends CalculatorBaseTest {
    @DataProvider
    public Object[][] sqrtDoubleDataProvider() {
        return new Object[][] {

            {36, 6.0},
            {22.2, 4.711687595755898},
            {46.1, 6.789698078707183}
        };
    }

    @Test(dataProvider = "sqrtDoubleDataProvider")
    public void sqrtDoubleTest(double a, double expected) {
        double actual = calculator.sqrt(a);
        assertThat(actual).isEqualTo(expected);
    }
}
