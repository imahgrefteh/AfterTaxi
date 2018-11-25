package hello;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;
import configuration.MuleSoftRestTemplateConfiguration;

//TOOD: add generic call out.
@Repository
public class PriceRepository {
    private static final String url = Constants.URL;
    private RestTemplate restTemplate;

    @Autowired
    public PriceRepository(@Qualifier("muleSoftRestTemplate")
                                       RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public Cost requestPrice(final Position position) {
        HttpHeaders headers = new HttpHeaders();
        headers.set("Accept", MediaType.APPLICATION_JSON_VALUE);
        //https://api.lyft.com/v1/cost?start_lat=37.7763&start_lng=-122.3918&end_lat=37.7972&end_lng=-122.4533
        UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(url)
                .queryParam("start_lat", position.getStartLat())
                .queryParam("start_lng", position.getStartLag())
                .queryParam("end_lat", position.getEndLat())
                .queryParam("end_lng", position.getEndLag());

        System.out.println(builder.toString());
        System.out.println("sfsdf ::: " + builder.toUriString());

        HttpEntity<?> entity = new HttpEntity<>(headers);
        HttpEntity<Cost> response = restTemplate.exchange(
                builder.toUriString(),
                HttpMethod.GET,
                entity,
                Cost.class);
        return response.getBody();
    }
}
