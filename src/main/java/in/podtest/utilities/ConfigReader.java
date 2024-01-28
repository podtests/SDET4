package in.podtest.utilities;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {

    public static Properties property = new Properties();

    public static String configFilePath = "src\\main\\resources\\masterdata.properties";


    public static Properties readConfigFile() throws IOException {

        FileReader file = new FileReader(configFilePath);

        BufferedReader reader = new BufferedReader(file);

        property.load(reader);

        //String browserName = property.getProperty("browseName");

        //System.out.println(browserName);

        return property;

    }

    public static void main(String[] args) throws IOException {
        ConfigReader.readConfigFile();
    }
}
