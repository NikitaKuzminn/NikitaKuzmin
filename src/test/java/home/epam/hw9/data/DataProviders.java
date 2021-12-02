package home.epam.hw9.data;

import static home.epam.hw9.util.Values.BOARD_NAME;
import static home.epam.hw9.util.Values.LIST_NAME;

import home.epam.hw9.entities.BoardDto;
import home.epam.hw9.entities.ListDto;
import org.testng.annotations.DataProvider;

public class DataProviders {

    @DataProvider
    public static Object[][] boardData() {
        BoardDto boardDto = new BoardDto();
        boardDto.setName(BOARD_NAME);
        return new Object[][] {
            {boardDto}
        };
    }

    @DataProvider
    public static Object[][] listData() {
        BoardDto boardDto = new BoardDto();
        boardDto.setName(BOARD_NAME);
        ListDto listDto = new ListDto();
        listDto.setName(LIST_NAME);
        return new Object[][] {
            {boardDto, listDto}
        };
    }
}
