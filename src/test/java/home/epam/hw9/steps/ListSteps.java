package home.epam.hw9.steps;

import static home.epam.hw9.service.CommonService.okResponseSpec;
import static home.epam.hw9.service.ListService.extractListFromJson;
import static home.epam.hw9.service.ListService.listServiceBuilder;
import static home.epam.hw9.util.Values.NEW_LIST_NAME;

import home.epam.hw9.entities.ListDto;
import home.epam.hw9.service.ListService;
import io.qameta.allure.Step;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.ResponseSpecification;

public class ListSteps {

    public ListDto getResponse(ListService.ListServiceBuilder requestBuilder,
                                             ResponseSpecification resp) {
        Response response = requestBuilder
            .build()
            .sendRequest();
        response.then()
                .assertThat()
                .spec(resp);
        return extractListFromJson(response);
    }

    @Step("Create new list")
    public String createList(String boardId, String name) {
        ListService.ListServiceBuilder requestBuilder = listServiceBuilder()
            .setMethod(Method.POST)
            .setName(name)
            .setIdBoard(boardId);
        return getResponse(requestBuilder, okResponseSpec()).getId();
    }

    @Step("Get list")
    public ListDto getList(String id) {
        ListService.ListServiceBuilder requestBuilder = listServiceBuilder()
            .setMethod(Method.GET)
            .setId(id);
        return getResponse(requestBuilder, okResponseSpec());
    }

    @Step("Update list name by id")
    public ListDto updateListName(String id) {
        ListService.ListServiceBuilder requestBuilder = listServiceBuilder()
            .setMethod(Method.PUT)
            .setId(id);
        requestBuilder.setName(NEW_LIST_NAME);
        return getResponse(requestBuilder, okResponseSpec());
    }
}

