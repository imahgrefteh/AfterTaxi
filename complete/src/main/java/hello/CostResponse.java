package hello;

import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;

@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
public class CostResponse {
    private String currency;
    private String rideType;
    private String displayName;
    private String primetime_percentage;
    private String primetimeConfirmationToken;
    private String costToken;
    private String priceQuoteId;
    private String priceGroupId;
    private String isValidEstimate;
    private Long estimatedDurationSeconds;
    private Float estimatedDistanceMiles;
    private Long estimatedCostCentsMin;
    private Long estimatedCostCentsMax;
    private Boolean canRequestRide;

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public String getRideType() {
        return rideType;
    }

    public void setRideType(String rideType) {
        this.rideType = rideType;
    }

    public String getDisplayName() {
        return displayName;
    }

    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }

    public String getPrimetime_percentage() {
        return primetime_percentage;
    }

    public void setPrimetime_percentage(String primetime_percentage) {
        this.primetime_percentage = primetime_percentage;
    }

    public String getPrimetimeConfirmationToken() {
        return primetimeConfirmationToken;
    }

    public void setPrimetimeConfirmationToken(String primetimeConfirmationToken) {
        this.primetimeConfirmationToken = primetimeConfirmationToken;
    }

    public String getCostToken() {
        return costToken;
    }

    public void setCostToken(String costToken) {
        this.costToken = costToken;
    }

    public String getPriceQuoteId() {
        return priceQuoteId;
    }

    public void setPriceQuoteId(String priceQuoteId) {
        this.priceQuoteId = priceQuoteId;
    }

    public String getPriceGroupId() {
        return priceGroupId;
    }

    public void setPriceGroupId(String priceGroupId) {
        this.priceGroupId = priceGroupId;
    }

    public String getIsValidEstimate() {
        return isValidEstimate;
    }

    public void setIsValidEstimate(String isValidEstimate) {
        this.isValidEstimate = isValidEstimate;
    }

    public Long getEstimatedDurationSeconds() {
        return estimatedDurationSeconds;
    }

    public void setEstimatedDurationSeconds(Long estimatedDurationSeconds) {
        this.estimatedDurationSeconds = estimatedDurationSeconds;
    }

    public Float getEstimatedDistanceMiles() {
        return estimatedDistanceMiles;
    }

    public void setEstimatedDistanceMiles(Float estimatedDistanceMiles) {
        this.estimatedDistanceMiles = estimatedDistanceMiles;
    }

    public Long getEstimatedCostCentsMin() {
        return estimatedCostCentsMin;
    }

    public void setEstimatedCostCentsMin(Long estimatedCostCentsMin) {
        this.estimatedCostCentsMin = estimatedCostCentsMin;
    }

    public Long getEstimatedCostCentsMax() {
        return estimatedCostCentsMax;
    }

    public void setEstimatedCostCentsMax(Long estimatedCostCentsMax) {
        this.estimatedCostCentsMax = estimatedCostCentsMax;
    }

    public Boolean canRequestRide() {
        return canRequestRide;
    }

    public void setCanRequestRide(Boolean canRequestRide) {
        this.canRequestRide = canRequestRide;
    }
}
