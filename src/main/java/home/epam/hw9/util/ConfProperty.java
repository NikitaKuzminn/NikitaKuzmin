package home.epam.hw9.util;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfProperty {

    public static String getProperty(String name) {
        FileInputStream fis;
        String properties = null;
        Properties property = new Properties();
        try {
            fis = new FileInputStream("src/test/resources/home.epam.hw9/test.properties");
            property.load(fis);
            properties = property.getProperty(name);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return properties;
    }
}
