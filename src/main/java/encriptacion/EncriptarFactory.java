package encriptacion;

import java.io.InputStream;
import java.util.Properties;

public class EncriptarFactory {
    public static InterfaceEncriptar createEncriptar() throws Exception {
        Properties properties = new Properties();
        try (InputStream input = EncriptarFactory.class.getClassLoader().getResourceAsStream("config.properties")) {
            if (input == null) {
                throw new Exception("Sorry, unable to find config.properties");
            }
            properties.load(input);
        }

        String className = properties.getProperty("encryption.class");
        if (className == null) {
            throw new Exception("encryption.class not specified in the config.properties file");
        }

        System.out.println("Tipo de encriptación: " + className);

        Class<?> clazz = Class.forName(className);
        return (InterfaceEncriptar) clazz.getDeclaredConstructor().newInstance();
    }
}