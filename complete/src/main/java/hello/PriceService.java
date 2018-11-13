package hello;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PriceService {
    private final PriceRepository priceRepository;

    @Autowired
    public PriceService(final PriceRepository priceRepository) {
        this.priceRepository = priceRepository;
    }


    public List<CostResponse> calculatePrice(final Position postion) {
        List<CostResponse> costs = priceRepository.requestPrice(postion);

        return null;
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
