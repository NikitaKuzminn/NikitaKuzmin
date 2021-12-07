package home.epam.hw9.data;

import static home.epam.hw9.util.Values.BOARD_NAME;
import static home.epam.hw9.util.Values.LIST_NAME;

import org.testng.annotations.DataProvider;

public class DataProviders {

    @DataProvider
    public static Object[][] boardData() {
        return new Object[][] {
            {BOARD_NAME}
        };
    }

    @DataProvider
    public static Object[][] listData() {
        return new Object[][] {
            {BOARD_NAME, LIST_NAME}
        };
    }
}
