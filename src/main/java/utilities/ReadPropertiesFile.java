package utilities;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Properties;

public class ReadPropertiesFile {
    public static void main(String[] args) {
        readProperties(Constant.PROPERTIES_FILE, "db.host");
        readProperties(Constant.PROPERTIES_FILE, "db.name");
        readProperties(Constant.PROPERTIES_FILE, "db.user");
        readProperties(Constant.PROPERTIES_FILE, "db.password");
        readProperties(Constant.PROPERTIES_FILE, "db.port");
    }

    public static String readProperties(String fileName, String key) {
        String value = "";
        try {
            InputStream input = new FileInputStream(fileName);
            Properties prop = new Properties();
            prop.load(input);
            value = prop.getProperty(key);
        } catch (Exception exception) {
            System.out.println(exception.getMessage());
        }
        return value;
    }
}
