package hello;

import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;

import java.util.List;

@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
public class Cost {

    List<CostResponse> costEstimates;

    public List<CostResponse> getCostEstimates() {
        return costEstimates;
    }

    public void setCostEstimates(List<CostResponse> costEstimates) {
        this.costEstimates = costEstimates;
    }
}
