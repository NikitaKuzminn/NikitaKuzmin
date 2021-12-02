package home.epam.hw9.util;

import static home.epam.hw9.util.ConfProperty.getProperty;

public class Values {

    public static final String USER_KEY = getProperty("key");
    public static final String USER_TOKEN = getProperty("token");
    public static final String URL_BOARD = getProperty("boardUrl");
    public static final String BOARD_NAME = getProperty("boardName");
    public static final String NEW_BOARD_NAME = getProperty("newBoardName");
    public static final String LISTS_URL = getProperty("listUrl");
    public static final String LIST_NAME = getProperty("listName");
    public static final String NEW_LIST_NAME = getProperty("newListName");
}
