package hello;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PriceService {
    private static final int DISCOUNT_PERCENTAGE = 25;
    private final PriceRepository priceRepository;

    @Autowired
    public PriceService(final PriceRepository priceRepository) {
        this.priceRepository = priceRepository;
    }


    public List<AfterTaxiPrice> calculatePrice(final Position postion) {
        Cost cost = priceRepository.requestPrice(postion);
        return setAfterTaxiPrice(DISCOUNT_PERCENTAGE, cost.getCostEstimates());
    }

    //TODO: make private 
    public List<AfterTaxiPrice> setAfterTaxiPrice(final int discountPercentage, final List<CostResponse> costs) {
        List<AfterTaxiPrice> prices = new ArrayList<>();
        AfterTaxiPrice afterTaxiPrice = new AfterTaxiPrice();
        for (CostResponse cost : costs) {
            prices.add(afterTaxiPrice.calculatePrice(cost, discountPercentage));
        }
        return prices;
    }
}
