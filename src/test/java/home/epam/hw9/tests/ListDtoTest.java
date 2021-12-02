package home.epam.hw9.tests;

import static home.epam.hw9.util.Values.NEW_LIST_NAME;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

import home.epam.hw9.data.DataProviders;
import home.epam.hw9.entities.BoardDto;
import home.epam.hw9.entities.ListDto;
import home.epam.hw9.steps.ListSteps;
import org.testng.annotations.Test;

public class ListDtoTest extends BaseTest {

    @Test(dataProvider = "listData", dataProviderClass = DataProviders.class)
    public void createListTest(BoardDto boardDto, ListDto listDto) {
        listSteps = new ListSteps();
        boardId = boardSteps.createNewBoard(boardDto);
        listId = listSteps.createList(boardId, listDto);
        ListDto createdListDto = listSteps.getList(listId);
        assertThat(createdListDto.getName(), equalTo(listDto.getName()));
    }

    @Test(dataProvider = "listData", dataProviderClass = DataProviders.class)
    public void modifyListTest(BoardDto boardDto, ListDto listDto) {
        listSteps = new ListSteps();
        boardId = boardSteps.createNewBoard(boardDto);
        listId = listSteps.createList(boardId, listDto);
        ListDto listDtoToUpdate = listSteps.updateListName(listId);
        assertThat(listDtoToUpdate.getName(), equalTo(NEW_LIST_NAME));
    }
}
