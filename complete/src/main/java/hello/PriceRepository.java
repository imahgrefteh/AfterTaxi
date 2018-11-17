package hello;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

//TOOD: add generic call out.
@Component
public class PriceRepository {
    private static final String url = Constants.URL;
    // TODO: figure out what I will need to do about this. 

    //    private RestTemplate restTemplate;
    private RestTemplateBuilder restTemplateBuilder;

    @Autowired
    public PriceRepository(RestTemplateBuilder restTemplateBuilder) {
        this.restTemplateBuilder = restTemplateBuilder;
    }

    @Autowired
    public RestTemplate restTemplate(RestTemplateBuilder builder) {
        return builder.build();
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
        
        System.out.println("sfsdf ::: "+builder.toUriString());

        HttpEntity<?> entity = new HttpEntity<>(headers);
        RestTemplate restTemplate = restTemplate(restTemplateBuilder);
        HttpEntity<Cost> response = restTemplate.exchange(
                builder.toUriString(),
                HttpMethod.GET,
                entity,
                Cost.class);
        return response.getBody();
    }
}
