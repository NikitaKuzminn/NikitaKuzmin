package home.epam.hw9.tests;

import static home.epam.hw9.util.Values.NEW_LIST_NAME;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

import home.epam.hw9.data.DataProviders;
import home.epam.hw9.entities.BoardDto;
import home.epam.hw9.entities.ListDto;
import org.testng.annotations.Test;

public class ListDtoTest extends BaseTest {

    @Test(dataProvider = "listData", dataProviderClass = DataProviders.class)
    public void createListTest(BoardDto board, ListDto list) {
        boardId = boardSteps.createNewBoard(board);
        listId = listSteps.createList(boardId, list);
        ListDto createdListDto = listSteps.getList(listId);
        assertThat(createdListDto.getName(), equalTo(list.getName()));
    }

    @Test(dataProvider = "listData", dataProviderClass = DataProviders.class)
    public void modifyListTest(BoardDto board, ListDto list) {
        boardId = boardSteps.createNewBoard(board);
        listId = listSteps.createList(boardId, list);
        ListDto listToUpdate = listSteps.updateListName(listId);
        assertThat(listToUpdate.getName(), equalTo(NEW_LIST_NAME));
    }
}
