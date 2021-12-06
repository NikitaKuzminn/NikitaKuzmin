package home.epam.hw9.tests;

import static home.epam.hw9.util.Values.LIST_NAME;
import static home.epam.hw9.util.Values.NEW_LIST_NAME;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

import home.epam.hw9.data.DataProviders;
import home.epam.hw9.entities.BoardDto;
import home.epam.hw9.entities.ListDto;
import org.testng.annotations.Test;

public class ListDtoTest extends BaseTest {

    @Test(dataProvider = "listData", dataProviderClass = DataProviders.class)
    public void createListTest(String boardName, String listName) {
        boardId = boardSteps.createNewBoard(boardName);
        listId = listSteps.createList(boardId, listName);
        ListDto createdListDto = listSteps.getList(listId);
        assertThat(createdListDto.getName(), equalTo(LIST_NAME));
    }

    @Test(dataProvider = "listData", dataProviderClass = DataProviders.class)
    public void modifyListTest(String boardName, String listName) {
        boardId = boardSteps.createNewBoard(boardName);
        listId = listSteps.createList(boardId, listName);
        ListDto listToUpdate = listSteps.updateListName(listId);
        assertThat(listToUpdate.getName(), equalTo(NEW_LIST_NAME));
    }
}
