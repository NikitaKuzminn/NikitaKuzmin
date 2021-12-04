package home.epam.hw9.steps;

import static home.epam.hw9.service.BoardService.boardServiceBuilder;
import static home.epam.hw9.service.BoardService.extractBoardFromJson;
import static home.epam.hw9.service.CommonService.notFoundResponseSpec;
import static home.epam.hw9.service.CommonService.okResponseSpec;
import static home.epam.hw9.util.Values.NEW_BOARD_NAME;

import home.epam.hw9.entities.BoardDto;
import home.epam.hw9.service.BoardService;
import io.qameta.allure.Step;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.ResponseSpecification;

public class BoardSteps {

    public Response getResponse(BoardService.BoardServiceBuilder requestBuilder, ResponseSpecification resp) {
        Response response = requestBuilder
            .buildBoardApiRequest()
            .sendRequest();
        response.then()
                .assertThat()
                .spec(resp);
        return response;
    }

    @Step("Create new board")
    public String createNewBoard(BoardDto board) {
        BoardService.BoardServiceBuilder requestBuilder = boardServiceBuilder()
            .setMethod(Method.POST)
            .setName(board.getName());
        return extractBoardFromJson(getResponse(requestBuilder, okResponseSpec())).getId();
    }

    @Step("Get board by id")
    public BoardDto getBoard(String id) {
        BoardService.BoardServiceBuilder requestBuilder = boardServiceBuilder()
            .setMethod(Method.GET)
            .setId(id);
        return extractBoardFromJson(getResponse(requestBuilder, okResponseSpec()));
    }

    @Step("Delete board by id")
    public void deleteBoard(String id) {
        BoardService.BoardServiceBuilder requestBuilder = boardServiceBuilder()
            .setMethod(Method.DELETE)
            .setId(id);
        getResponse(requestBuilder, okResponseSpec());
    }

    @Step("Get deleted board by id")
    public Response getDeletedBoard(String id) {
        BoardService.BoardServiceBuilder requestBuilder = boardServiceBuilder()
            .setMethod(Method.GET)
            .setId(id);
        return getResponse(requestBuilder, notFoundResponseSpec());
    }

    @Step("Update board name by id")
    public BoardDto updateBoardName(String id) {
        BoardService.BoardServiceBuilder requestBuilder = boardServiceBuilder()
            .setMethod(Method.PUT)
            .setId(id);
        requestBuilder.setName(NEW_BOARD_NAME);
        return extractBoardFromJson(getResponse(requestBuilder, okResponseSpec()));
    }
}
