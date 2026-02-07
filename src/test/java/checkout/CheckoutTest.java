package checkout;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class CheckoutTest {

    @Test
    void calculates_total_cost_without_offers() {
        Checkout checkout = new Checkout();

        BigDecimal total = checkout.calculateTotal(
                List.of("Apple", "Apple", "Orange", "Apple")
        );

        assertThat(total).isEqualByComparingTo("2.05");
    }
}
