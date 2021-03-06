package properties;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class SystemProperties {
    FileInputStream propertiesFile;
    Properties properties;

    public SystemProperties (){
        try {
            this.propertiesFile = new FileInputStream("src/test/resources/data.properties");
            this.properties = new Properties();
            this.properties.load(propertiesFile);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String getBaseUrl(){
        return properties.getProperty("baseUrl");
    }

    public String getChromeDriver(){
        return properties.getProperty("chromeWebDriverPath");
    }

    public String getBrowser(){
        return properties.getProperty("browser");
    }

}
