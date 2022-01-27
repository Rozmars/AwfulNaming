package Utils;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class PropertyHelper {

    public static File getPropertyFile(String classpath) {
        return new File(classpath);
    }

    public static Properties getPropertyObject(String classpath) throws IOException {
        Properties properties = new Properties();
        properties.load(new FileReader(getPropertyFile(classpath)));
        return properties;
    }
}
