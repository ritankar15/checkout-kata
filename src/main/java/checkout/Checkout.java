package checkout;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

public class Checkout {

    private static final Map<String, Integer> pricesInPence = Map.of(
            "Apple", 60,
            "Orange", 25
    );

    public BigDecimal calculateTotal(List<String> items) {
        int totalInPence = items.stream()
                .mapToInt(item -> pricesInPence.get(item))
                .sum();

        return BigDecimal.valueOf(totalInPence)
                .divide(BigDecimal.valueOf(100));
    }
}
