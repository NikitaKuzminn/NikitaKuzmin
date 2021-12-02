package home.epam.hw9.steps;

import static home.epam.hw9.service.BoardService.apiBoardBuilder;
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

    public Response sendRequestAndGetResponse(BoardService.BoardApiBuilder api, ResponseSpecification resp) {
        Response response = api
            .buildBoardApiRequest()
            .sendRequest();
        response.then()
                .assertThat()
                .spec(resp);
        return response;
    }

    @Step("Create new board")
    public String createNewBoard(BoardDto boardDto) {
        BoardService.BoardApiBuilder api = apiBoardBuilder()
            .setMethod(Method.POST)
            .setName(boardDto.getName());
        return extractBoardFromJson(sendRequestAndGetResponse(api, okResponseSpec())).getId();
    }

    @Step("Get board by id")
    public BoardDto getBoard(String boardId) {
        BoardService.BoardApiBuilder api = apiBoardBuilder()
            .setMethod(Method.GET)
            .setId(boardId);
        return extractBoardFromJson(sendRequestAndGetResponse(api, okResponseSpec()));
    }

    @Step("Delete board by id")
    public void deleteBoard(String boardId) {
        BoardService.BoardApiBuilder api = apiBoardBuilder()
            .setMethod(Method.DELETE)
            .setId(boardId);
        sendRequestAndGetResponse(api, okResponseSpec());
    }

    @Step("Get deleted board by id")
    public Response getDeletedBoard(String boardId) {
        BoardService.BoardApiBuilder builder = apiBoardBuilder()
            .setMethod(Method.GET)
            .setId(boardId);
        return sendRequestAndGetResponse(builder, notFoundResponseSpec());
    }

    @Step("Update board name by id")
    public BoardDto updateBoardName(String boardId) {
        BoardService.BoardApiBuilder api = apiBoardBuilder()
            .setMethod(Method.PUT)
            .setId(boardId);
        api.setName(NEW_BOARD_NAME);
        return extractBoardFromJson(sendRequestAndGetResponse(api, okResponseSpec()));
    }
}
