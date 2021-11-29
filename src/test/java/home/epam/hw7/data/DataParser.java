package home.epam.hw7.data;

import com.google.common.reflect.TypeToken;
import com.google.gson.Gson;
import home.epam.hw7.entities.MetalsAndColorsData;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.lang.reflect.Type;
import java.util.Map;

public class DataParser {

    public static Object[][] getMetalsAndColorsTestData() throws IOException {
        ClassLoader classloader = Thread.currentThread().getContextClassLoader();
        String testDataPath = System.getProperty("test.data");
        InputStream is = testDataPath == null
            ? classloader.getResourceAsStream("JDI_ex8_metalsColorsDataSet.json")
            : new FileInputStream(testDataPath);
        if (is == null) {
            throw new IOException("File with test data was not found.");
        }
        InputStreamReader streamReader = new InputStreamReader(is);
        BufferedReader reader = new BufferedReader(streamReader);
        StringBuilder file = new StringBuilder();
        for (String line; (line = reader.readLine()) != null; ) {
            file.append(line).append('\n');
        }
        Type listType = new TypeToken<Map<String, MetalsAndColorsData>>() {
        }.getType();
        Map<String, MetalsAndColorsData> testData = new Gson().fromJson(file.toString(), listType);
        Object[][] result = new Object[testData.size()][1];
        int i = 0;
        for (MetalsAndColorsData metalsAndColorsData : testData.values()) {
            result[i++][0] = metalsAndColorsData;
        }
        return result;
    }
}
