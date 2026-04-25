package lt.viko.eif.jkulbokas;

import jakarta.xml.ws.Endpoint;
import lt.viko.eif.jkulbokas.Services.LibraryServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class WebServiceConfig {

    @Bean
    public Endpoint endpoint(LibraryServiceImpl service) {
        return Endpoint.publish( "http://localhost:8081/library", service ); //http://localhost:8081/library?wsdl
    }
}
