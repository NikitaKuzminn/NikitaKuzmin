package home.epam.hw9.data;

import static home.epam.hw9.util.Values.BOARD_NAME;
import static home.epam.hw9.util.Values.LIST_NAME;

import home.epam.hw9.entities.BoardDto;
import home.epam.hw9.entities.ListDto;
import org.testng.annotations.DataProvider;

public class DataProviders {

    @DataProvider
    public static Object[][] boardData() {
        BoardDto board = new BoardDto();
        board.setName(BOARD_NAME);
        return new Object[][] {
            {board}
        };
    }

    @DataProvider
    public static Object[][] listData() {
        BoardDto board = new BoardDto();
        board.setName(BOARD_NAME);
        ListDto list = new ListDto();
        list.setName(LIST_NAME);
        return new Object[][] {
            {board, list}
        };
    }
}
