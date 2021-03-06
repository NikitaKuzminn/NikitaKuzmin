package home.epam.hw9.tests;

import static home.epam.hw9.util.Parameters.NOT_FOUND_MESSAGE;
import static home.epam.hw9.util.Parameters.NOT_FOUND_STATUS;
import static home.epam.hw9.util.Values.BOARD_NAME;
import static home.epam.hw9.util.Values.NEW_BOARD_NAME;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsStringIgnoringCase;
import static org.hamcrest.Matchers.equalTo;

import home.epam.hw9.data.DataProviders;
import home.epam.hw9.entities.BoardDto;
import io.restassured.response.Response;
import org.testng.annotations.Test;

public class BoardDtoTest extends BaseTest {

    @Test(dataProvider = "boardData", dataProviderClass = DataProviders.class)
    public void createBoardTest(String name) {
        boardId = boardSteps.createNewBoard(name);
        BoardDto createdBoardDto = boardSteps.getBoard(boardId);
        assertThat(createdBoardDto.getName(), equalTo(BOARD_NAME));
    }

    @Test(dataProvider = "boardData", dataProviderClass = DataProviders.class)
    public void deleteBoardTest(String name) {
        boardId = boardSteps.createNewBoard(name);
        boardSteps.deleteBoard(boardId);
        Response response = boardSteps.getDeletedBoard(boardId);
        assertThat(response.getStatusCode(), equalTo(NOT_FOUND_STATUS));
        assertThat(response.getStatusLine(), containsStringIgnoringCase(NOT_FOUND_MESSAGE));
        boardId = null;
    }

    @Test(dataProvider = "boardData", dataProviderClass = DataProviders.class)
    public void updateBoardTest(String name) {
        boardId = boardSteps.createNewBoard(name);
        BoardDto boardToUpdate = boardSteps.updateBoardName(boardId);
        assertThat(boardToUpdate.getName(), equalTo(NEW_BOARD_NAME));
    }
}
