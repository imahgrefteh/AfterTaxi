package hello;

import org.springframework.stereotype.Component;

import java.util.List;

//TOOD: add generic call out.
@Component
public class PriceRepository {

    public PriceRepository() {

    }


    public List<CostResponse> requestPrice(final Position position) {
        return null;
    }
}
