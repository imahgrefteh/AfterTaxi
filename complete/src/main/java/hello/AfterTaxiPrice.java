package hello;

public class AfterTaxiPrice {
    private String currency;
    private String rideType;
    private String displayName;
    private String primetimeConfirmationToken;
    private String costToken;
    private String priceQuoteId;
    private String priceGroupId;
    private String isValidEstimate;
    private Long estimatedDurationSeconds;
    private Float estimatedDistanceMiles;
    private Long aftEstimatedCostCentsMin;
    private Long aftEstimatedCostCentsMax;
    private Boolean canRequestRide;


    public AfterTaxiPrice calculatePrice(final CostResponse cost, final int percentage) {
        this.currency = cost.getCurrency();
        this.rideType = cost.getRideType();
        this.displayName = cost.getDisplayName();
        this.primetimeConfirmationToken = cost.getPrimetimeConfirmationToken();
        this.costToken = cost.getCostToken();
        this.priceQuoteId = cost.getPriceQuoteId();
        this.priceGroupId = cost.getPriceGroupId();
        this.isValidEstimate = cost.getIsValidEstimate();
        this.estimatedDurationSeconds = cost.getEstimatedDurationSeconds();
        this.estimatedDistanceMiles = cost.getEstimatedDistanceMiles();
        this.aftEstimatedCostCentsMin = cost.getEstimatedCostCentsMin() - (cost.getEstimatedCostCentsMin() * percentage) / 100L;
        this.aftEstimatedCostCentsMax = cost.getEstimatedCostCentsMax() - (cost.getEstimatedCostCentsMax() * percentage) / 100L;
        this.canRequestRide = cost.canRequestRide();
        return this;
    }

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

    public Long getAftEstimatedCostCentsMin() {
        return aftEstimatedCostCentsMin;
    }

    public void setAftEstimatedCostCentsMin(Long aftEstimatedCostCentsMin) {
        this.aftEstimatedCostCentsMin = aftEstimatedCostCentsMin;
    }

    public Long getAftEstimatedCostCentsMax() {
        return aftEstimatedCostCentsMax;
    }

    public void setAftEstimatedCostCentsMax(Long aftEstimatedCostCentsMax) {
        this.aftEstimatedCostCentsMax = aftEstimatedCostCentsMax;
    }

    public Boolean getCanRequestRide() {
        return canRequestRide;
    }

    public void setCanRequestRide(Boolean canRequestRide) {
        this.canRequestRide = canRequestRide;
    }
}
