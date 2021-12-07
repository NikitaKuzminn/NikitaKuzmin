package home.epam.hw9.tests;

import home.epam.hw9.steps.BoardSteps;
import home.epam.hw9.steps.ListSteps;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class BaseTest {
    BoardSteps boardSteps;
    ListSteps listSteps;
    String boardId;
    String listId;

    @BeforeMethod
    public void setUp() {
        boardSteps = new BoardSteps();
        listSteps = new ListSteps();
    }

    @AfterMethod
    public void deleteBoardAfterMethod() {
        if (boardId != null) {
            boardSteps.deleteBoard(boardId);
        }
    }
}
