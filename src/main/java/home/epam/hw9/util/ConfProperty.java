package home.epam.hw9.util;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfProperty {

    protected static FileInputStream fileInputStream;
    protected static Properties properties;
    protected static String path = "src/test/resources/home.epam.hw9/test.properties";

    public ConfProperty() {
    }

    public static String getProperty(String name) {
        return properties.getProperty(name);
    }

    static {
        try {
            fileInputStream = new FileInputStream(path);
            properties = new Properties();
            properties.load(fileInputStream);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (fileInputStream != null) {
                try {
                    fileInputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
