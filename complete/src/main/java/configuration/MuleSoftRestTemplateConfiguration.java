package configuration;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

//TODO: fix naming eventually. 
@Configuration
public class MuleSoftRestTemplateConfiguration {
    
    
    
    @Bean("muleSoftRestTemplate")
    @Qualifier("muleSoftRestTemplate")
    public RestTemplate restTemplateWithCertificate() {
        return new RestTemplate();
    }
}
