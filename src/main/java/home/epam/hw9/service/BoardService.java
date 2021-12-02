package home.epam.hw9.service;

import static home.epam.hw9.util.Parameters.ID;
import static home.epam.hw9.util.Parameters.NAME;
import static home.epam.hw9.util.Values.URL_BOARD;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import home.epam.hw9.entities.BoardDto;
import io.restassured.http.Method;
import io.restassured.response.Response;
import java.net.URI;
import java.util.HashMap;
import java.util.Map;

public class BoardService extends CommonService {
    public static final URI BOARD_URL = URI.create(URL_BOARD);

    public static BoardApiBuilder apiBoardBuilder() {
        return new BoardApiBuilder();
    }

    public static class BoardApiBuilder {
        private final Map<String, String> queryParameters = new HashMap<>();
        private final Map<String, String> pathParameters = new HashMap<>();
        private Method requestedMethod = Method.GET;

        public BoardApiBuilder setMethod(Method method) {
            requestedMethod = method;
            return this;
        }

        public BoardApiBuilder setId(String id) {
            pathParameters.put(ID, id);
            return this;
        }

        public BoardApiBuilder setName(String name) {
            queryParameters.put(NAME, name);
            return this;
        }

        public BoardService buildBoardApiRequest() {
            return new BoardService(requestedMethod, queryParameters, pathParameters);
        }
    }

    public BoardService(Method method, Map<String, String> queryPar, Map<String, String> pathPar) {
        super(method, queryPar, pathPar);
    }

    public Response sendRequest() {
        return super.sendRequest(requestSpec(BOARD_URL));
    }

    public static BoardDto extractBoardFromJson(Response response) {
        return new Gson().fromJson(response.asString().trim(), new TypeToken<BoardDto>() {
        }.getType());
    }
}
