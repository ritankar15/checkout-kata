package checkout;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

public class Checkout {

    private static final int APPLE_PRICE = 60;
    private static final int ORANGE_PRICE = 25;

    public BigDecimal calculateTotal(List<String> items) {
        int countApples = (int) items.stream().filter("Apple"::equals).count();
        int countOranges = (int) items.stream().filter("Orange"::equals).count();

        int appleOfferredCost = (int) ((countApples / 2 + countApples % 2) * APPLE_PRICE);
        // took help from AI to build the below formula
        int orangeOfferredCost = (int) ((countOranges / 3 * 2 + countOranges % 3) * ORANGE_PRICE);

        int totalInPence = appleOfferredCost + orangeOfferredCost;

        return BigDecimal.valueOf(totalInPence)
                .divide(BigDecimal.valueOf(100));
    }
}
