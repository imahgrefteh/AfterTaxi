package hello;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.util.LinkedList;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class PriceServiceTest {
    final private String lyftLuxEstimate = "{\"cost_estimates\":[{\"currency\":\"USD\",\"ride_type\":\"lyft_lux\",\"display_name\":\"Lux Black\",\"primetime_percentage\":\"0%\",\"primetime_confirmation_token\":null,\"cost_token\":null,\"price_quote_id\":\"EL6ymq/wLA==::CgNsdXg=\",\"price_group_id\":\"EL6ymq/wLA==\",\"is_valid_estimate\":true,\"estimated_duration_seconds\":1331,\"estimated_distance_miles\":5.19,\"estimated_cost_cents_min\":4200,\"estimated_cost_cents_max\":4900,\"can_request_ride\":true}]}";
    final ObjectMapper objectMapper = new ObjectMapper();

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    PriceService priceService;

    @Test
    public void noPriceChangWithZeroPercentageDiscount() throws Exception {
        Cost cost = objectMapper.readValue(lyftLuxEstimate, Cost.class);
        List<AfterTaxiPrice> prices = priceService.setAfterTaxiPrice(0, cost.getCostEstimates());
        Assert.assertEquals(Long.valueOf(4900), prices.get(0).getAftEstimatedCostCentsMax());
        Assert.assertEquals(Long.valueOf(4200), prices.get(0).getAftEstimatedCostCentsMin());
    }

    @Test
    public void baseDiscountOfTwentyFivePercent() throws Exception {
        Cost cost = objectMapper.readValue(lyftLuxEstimate, Cost.class);
        List<AfterTaxiPrice> prices = priceService.setAfterTaxiPrice(25, cost.getCostEstimates());
        Assert.assertEquals(Long.valueOf(3675), prices.get(0).getAftEstimatedCostCentsMax());
        Assert.assertEquals(Long.valueOf(3150), prices.get(0).getAftEstimatedCostCentsMin());
    }


}
