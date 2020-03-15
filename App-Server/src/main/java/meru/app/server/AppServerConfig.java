package meru.app.server;

import java.io.InputStream;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

import meru.app.config.AppConfig;
import meru.sys.IOSystem;


public class AppServerConfig extends AppConfig {
    
    
    public static AppConfig readAppConfig(InputStream inputStream) {
        AppConfig appConfig = null;

        try {
            JAXBContext jc = JAXBContext.newInstance(AppServerConfig.class);
            Unmarshaller u = jc.createUnmarshaller();

            appConfig = (AppConfig) u.unmarshal(inputStream);

        } catch (JAXBException e) {
            throw new RuntimeException(e);
        } finally {
            IOSystem.close(inputStream);
        }

        return appConfig;
    }

}
