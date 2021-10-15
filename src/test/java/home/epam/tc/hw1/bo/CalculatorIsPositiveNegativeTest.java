package home.epam.tc.hw1.bo;

import static org.assertj.core.api.Assertions.assertThat;

import home.epam.tc.hw1.CalculatorBaseTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class CalculatorIsPositiveNegativeTest extends CalculatorBaseTest {
    @DataProvider
    public Object[][] isPositiveDataProvider() {
        return new Object[][] {
            {2},
            {5},
            {4},
            {6}
        };
    }

    @Test(dataProvider = "isPositiveDataProvider")
    public void isPositiveTest(long a) {
        assertThat(calculator.isPositive(a)).isTrue();

    }

    @DataProvider(name = "isNegativeDataProvider")
    public Object[][] isNegativeDataProvider() {
        return new Object[][] {
            {-2},
            {-5},
            {-4},
            {-6}
        };
    }

    @Test(dataProvider = "isNegativeDataProvider")
    public void isNegativeDoubleTest(long a) {
        assertThat(calculator.isNegative(a)).isTrue();

    }
}
