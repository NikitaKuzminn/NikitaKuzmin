package home.epam.hw6.confing;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfProperties {
    protected static FileInputStream fileInputStream;
    protected static Properties PROPERTIES;
    protected static String PATH = "src/test/resources/home.epam.hw6/conf.properties";

    public ConfProperties() {
    }

    public static String getProperty(String key) {
        return PROPERTIES.getProperty(key);
    }

    static {
        try {
            fileInputStream = new FileInputStream(PATH);
            PROPERTIES = new Properties();
            PROPERTIES.load(fileInputStream);
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
