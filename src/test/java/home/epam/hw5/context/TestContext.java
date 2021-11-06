package home.epam.hw5.context;

import java.util.HashMap;
import java.util.Map;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class TestContext {

    private static TestContext instance;
    private Map<String, Object> context = new HashMap<>();

    public <T> T getObject(String key) {
        return (T) context.get(key);
    }

    public void addObject(String key, Object object) {
        context.put(key, object);
    }

    public static TestContext getInstance() {
        if (instance == null) {
            instance = new TestContext();
        }
        return instance;
    }
}
