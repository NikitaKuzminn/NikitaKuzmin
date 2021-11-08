package home.epam.hw5.config;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Values {
    public static final List<String> LOGS = List.of(ConfProperties.getProperty("log1"),
        ConfProperties.getProperty("log2"), ConfProperties.getProperty("log3"), ConfProperties.getProperty("log4"));
    public static final Map<String, Integer> CHECKBOXES = new HashMap<>() {{
            put("Water", 0);
            put("Earth", 1);
            put("Wind", 2);
            put("Fire", 3);
            }};
    public static final Map<String, Integer> RADIO = new HashMap<>() {{
            put("Gold", 0);
            put("Silver", 1);
            put("Bronze", 2);
            put("Selen", 3);
            }};
    public static final Map<String, Integer> COLORS = new HashMap<>() {{
            put("Red", 0);
            put("Green", 1);
            put("Blue", 2);
            put("Yellow", 3);
            }};
}
