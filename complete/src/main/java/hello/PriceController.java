package hello;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.concurrent.atomic.AtomicLong;

public class PriceController {

    ///TODO: add version one prefix.
    @RequestMapping("/cost")
    public Greeting greeting(@RequestParam() Double start_lat, @RequestParam() Double start_lag,
                             @RequestParam() Double end_lat, @RequestParam() Double end_lag) {
        return new Greeting(counter.incrementAndGet(),
                String.format(template, name));
    }
}
