package hello;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

public class PriceController {

    final PriceService priceService;

    @Autowired
    public PriceController(final PriceService priceService) {
        this.priceService = priceService;
    }

    ///TODO: add version one prefix.
    @RequestMapping("/cost")
    public Greeting greeting(@RequestParam() Double startLat, @RequestParam() Double startLag,
                             @RequestParam() Double endLat, @RequestParam() Double endLag) {
        priceService.calculatePrice(new Position(startLat, startLag, endLat, endLag));
        //TODO: transform dto object. 
        return null;
    }
}
