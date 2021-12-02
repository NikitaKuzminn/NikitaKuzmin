package home.epam.hw9.service;

import static home.epam.hw9.util.Parameters.BOARD_ID;
import static home.epam.hw9.util.Parameters.ID;
import static home.epam.hw9.util.Parameters.NAME;
import static home.epam.hw9.util.Values.LISTS_URL;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import home.epam.hw9.entities.ListDto;
import io.restassured.http.Method;
import io.restassured.response.Response;
import java.net.URI;
import java.util.HashMap;
import java.util.Map;

public class ListService extends CommonService {
    public static final URI LIST_URL = URI.create(LISTS_URL);

    public static ListApiBuilder listApiBuilder() {
        return new ListApiBuilder();
    }

    public static class ListApiBuilder {
        private final Map<String, String> queryParameters = new HashMap<>();
        private final Map<String, String> pathParameters = new HashMap<>();
        private Method requestedMethod = Method.GET;

        public ListApiBuilder setMethod(Method method) {
            requestedMethod = method;
            return this;
        }

        public ListApiBuilder setId(String id) {
            pathParameters.put(ID, id);
            return this;
        }

        public ListApiBuilder setIdBoard(String idBoard) {
            queryParameters.put(BOARD_ID, idBoard);
            return this;
        }

        public ListApiBuilder setName(String name) {
            queryParameters.put(NAME, name);
            return this;
        }

        public ListService buildListApiRequest() {
            return new ListService(requestedMethod, queryParameters, pathParameters);
        }
    }

    public ListService(Method method, Map<String, String> queryPar, Map<String, String> pathPar) {
        super(method, queryPar, pathPar);
    }

    public Response sendRequest() {
        return super.sendRequest(requestSpec(LIST_URL));
    }

    public static ListDto extractListFromJson(Response response) {
        return new Gson().fromJson(response.asString().trim(), new TypeToken<ListDto>() {
        }.getType());
    }
}

