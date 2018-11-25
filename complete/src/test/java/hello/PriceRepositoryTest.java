package hello;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.client.RestClientTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.client.MockRestServiceServer;
import org.springframework.web.client.RestTemplate;

import static org.springframework.test.web.client.match.MockRestRequestMatchers.*;
import static org.springframework.test.web.client.response.MockRestResponseCreators.withSuccess;

@RunWith(SpringRunner.class)
@SpringBootTest
@RestClientTest
public class PriceRepositoryTest {
    final private String lyftLuxEstimate = "{\"cost_estimates\":[{\"currency\":\"USD\",\"ride_type\":\"lyft_lux\",\"display_name\":\"Lux Black\",\"primetime_percentage\":\"0%\",\"primetime_confirmation_token\":null,\"cost_token\":null,\"price_quote_id\":\"EL6ymq/wLA==::CgNsdXg=\",\"price_group_id\":\"EL6ymq/wLA==\",\"is_valid_estimate\":true,\"estimated_duration_seconds\":1331,\"estimated_distance_miles\":5.19,\"estimated_cost_cents_min\":4200,\"estimated_cost_cents_max\":4900,\"can_request_ride\":true}]}";
    final ObjectMapper objectMapper = new ObjectMapper();

    @Autowired
    private RestTemplate restTemplate;
    @Autowired
    private PriceRepository priceRepository;

    @Autowired
    private RestTemplateBuilder restTemplateBuilder;


    @Before
    public void setUp() throws Exception {
    }


    @Test
    public void randomTest() throws Exception {
        MockRestServiceServer mockServer = MockRestServiceServer.bindTo(restTemplate).build();
        mockServer.reset();
        mockServer.expect(requestTo("https://api.lyft.com/v1/cost?start_lat=37.7763&start_lng=-122.3918&end_lat=37.7972&end_lng=-122.4533"))
                .andExpect(method(HttpMethod.GET))
                .andExpect(header("Accept", MediaType.APPLICATION_JSON_VALUE))
                .andRespond(withSuccess("{fsfsf}", MediaType.APPLICATION_JSON));


        Cost result = priceRepository.requestPrice(new Position(37.7763, -122.3918, 37.7972, -122.4533));


        mockServer.verify();
    }

    @Autowired
    public RestTemplate restTemplate(RestTemplateBuilder builder) {
        return builder.build();
    }

}
