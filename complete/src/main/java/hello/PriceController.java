package hello;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class PriceController {

    final private PriceService priceService;

    @Autowired
    public PriceController(final PriceService priceService) {
        this.priceService = priceService;
    }

    ///TODO: add version one prefix.
    @RequestMapping("/cost")
    public List<AfterTaxiPrice> greeting(@RequestParam() Double startLat, @RequestParam() Double startLag,
                                         @RequestParam() Double endLat, @RequestParam() Double endLag) {
        return priceService.calculatePrice(new Position(startLat, startLag, endLat, endLag));
    }
}
