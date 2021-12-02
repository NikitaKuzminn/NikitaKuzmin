package home.epam.hw9.steps;

import static home.epam.hw9.service.CommonService.okResponseSpec;
import static home.epam.hw9.service.ListService.extractListFromJson;
import static home.epam.hw9.service.ListService.listApiBuilder;
import static home.epam.hw9.util.Values.NEW_LIST_NAME;

import home.epam.hw9.entities.ListDto;
import home.epam.hw9.service.ListService;
import io.qameta.allure.Step;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.ResponseSpecification;

public class ListSteps {

    public ListDto sendRequestAndGetResponse(ListService.ListApiBuilder api, ResponseSpecification resp) {
        Response response = api
            .buildListApiRequest()
            .sendRequest();
        response.then()
                .assertThat()
                .spec(resp);
        return extractListFromJson(response);
    }

    @Step("Create new list")
    public String createList(String boardId, ListDto listDto) {
        ListService.ListApiBuilder apiBuilder = listApiBuilder()
            .setMethod(Method.POST)
            .setName(listDto.getName())
            .setIdBoard(boardId);
        return sendRequestAndGetResponse(apiBuilder, okResponseSpec()).getId();
    }

    @Step("Get list")
    public ListDto getList(String listId) {
        ListService.ListApiBuilder apiBuilder = listApiBuilder()
            .setMethod(Method.GET)
            .setId(listId);
        return sendRequestAndGetResponse(apiBuilder, okResponseSpec());
    }

    @Step("Update list name by id")
    public ListDto updateListName(String listId) {
        ListService.ListApiBuilder builder = listApiBuilder()
            .setMethod(Method.PUT)
            .setId(listId);
        builder.setName(NEW_LIST_NAME);
        return sendRequestAndGetResponse(builder, okResponseSpec());
    }
}

