package hello;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;
import org.junit.*;


public class CostResponseMapperTest {

    ///TODO: put string in seperate file
    final private String lyftLuxEstimate = "{\"cost_estimates\":[{\"currency\":\"USD\",\"ride_type\":\"lyft_lux\",\"display_name\":\"Lux Black\",\"primetime_percentage\":\"0%\",\"primetime_confirmation_token\":null,\"cost_token\":null,\"price_quote_id\":\"EL6ymq/wLA==::CgNsdXg=\",\"price_group_id\":\"EL6ymq/wLA==\",\"is_valid_estimate\":true,\"estimated_duration_seconds\":1331,\"estimated_distance_miles\":5.19,\"estimated_cost_cents_min\":4200,\"estimated_cost_cents_max\":4900,\"can_request_ride\":true}]}";
    final private String lyftAllEstimates = "{\"cost_estimates\":[{\"currency\":\"USD\",\"ride_type\":\"lyft_line\",\"display_name\":\"Shared\",\"primetime_percentage\":\"0%\",\"primetime_confirmation_token\":null,\"cost_token\":null,\"price_quote_id\":\"EM702a/wLA==::Cgdjb3VyaWVy\",\"price_group_id\":\"EM702a/wLA==\",\"is_valid_estimate\":true,\"estimated_duration_seconds\":1340,\"estimated_distance_miles\":5.2,\"estimated_cost_cents_min\":900,\"estimated_cost_cents_max\":1200,\"can_request_ride\":true},{\"currency\":\"USD\",\"ride_type\":\"lyft\",\"display_name\":\"Lyft\",\"primetime_percentage\":\"0%\",\"primetime_confirmation_token\":null,\"cost_token\":null,\"price_quote_id\":\"EM702a/wLA==::CghzdGFuZGFyZA==\",\"price_group_id\":\"EM702a/wLA==\",\"is_valid_estimate\":true,\"estimated_duration_seconds\":1340,\"estimated_distance_miles\":5.2,\"estimated_cost_cents_min\":1500,\"estimated_cost_cents_max\":1800,\"can_request_ride\":true},{\"currency\":\"USD\",\"ride_type\":\"lyft_plus\",\"display_name\":\"Lyft XL\",\"primetime_percentage\":\"0%\",\"primetime_confirmation_token\":null,\"cost_token\":null,\"price_quote_id\":\"EM702a/wLA==::CgRwbHVz\",\"price_group_id\":\"EM702a/wLA==\",\"is_valid_estimate\":true,\"estimated_duration_seconds\":1340,\"estimated_distance_miles\":5.2,\"estimated_cost_cents_min\":2000,\"estimated_cost_cents_max\":2500,\"can_request_ride\":true},{\"currency\":\"USD\",\"ride_type\":\"lyft_premier\",\"display_name\":\"Lux\",\"primetime_percentage\":\"0%\",\"primetime_confirmation_token\":null,\"cost_token\":null,\"price_quote_id\":\"EM702a/wLA==::CgdwcmVtaXVt\",\"price_group_id\":\"EM702a/wLA==\",\"is_valid_estimate\":true,\"estimated_duration_seconds\":1340,\"estimated_distance_miles\":5.2,\"estimated_cost_cents_min\":3000,\"estimated_cost_cents_max\":3500,\"can_request_ride\":true},{\"currency\":\"USD\",\"ride_type\":\"lyft_lux\",\"display_name\":\"Lux Black\",\"primetime_percentage\":\"0%\",\"primetime_confirmation_token\":null,\"cost_token\":null,\"price_quote_id\":\"EM702a/wLA==::CgNsdXg=\",\"price_group_id\":\"EM702a/wLA==\",\"is_valid_estimate\":true,\"estimated_duration_seconds\":1340,\"estimated_distance_miles\":5.2,\"estimated_cost_cents_min\":4200,\"estimated_cost_cents_max\":4900,\"can_request_ride\":true},{\"currency\":\"USD\",\"ride_type\":\"lyft_luxsuv\",\"display_name\":\"Lux Black XL\",\"primetime_percentage\":\"0%\",\"primetime_confirmation_token\":null,\"cost_token\":null,\"price_quote_id\":\"EM702a/wLA==::CgZsdXhzdXY=\",\"price_group_id\":\"EM702a/wLA==\",\"is_valid_estimate\":true,\"estimated_duration_seconds\":1340,\"estimated_distance_miles\":5.2,\"estimated_cost_cents_min\":5000,\"estimated_cost_cents_max\":6000,\"can_request_ride\":true}]}";

    @Test
    public void whenReadJsonToJava_thanCorrect() throws Exception {
        final ObjectMapper objectMapper = new ObjectMapper();
        final Cost costs = objectMapper.readValue(lyftLuxEstimate, Cost.class);
        Assert.assertEquals(1, costs.getCostEstimates().size());
        Assert.assertEquals(Long.valueOf(4900), costs.getCostEstimates().get(0).getEstimatedCostCentsMax());
    }

    @Test
    public void whenReadAllRideTypesJsonToJava_thanCorrect() throws Exception {
        final ObjectMapper objectMapper = new ObjectMapper();
        final Cost costs = objectMapper.readValue(lyftAllEstimates, Cost.class);
        Assert.assertEquals(6, costs.getCostEstimates().size());
        Assert.assertEquals(true, costs.getCostEstimates().get(3).canRequestRide());
    }
}
