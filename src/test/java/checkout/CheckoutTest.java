package checkout;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class CheckoutWithOffersTest {

    @Test
    void apples_are_buy_one_get_one_free() {
        Checkout checkout = new Checkout();

        BigDecimal total = checkout.calculateTotal(
                List.of("Apple", "Apple", "Apple")
        );

        assertThat(total).isEqualByComparingTo("1.20");
    }

    @Test
    void oranges_are_three_for_two() {
        Checkout checkout = new Checkout();

        BigDecimal total = checkout.calculateTotal(
                List.of("Orange", "Orange", "Orange")
        );

        assertThat(total).isEqualByComparingTo("0.50");
    }

    @Test
    void mixed_basket_with_offers() {
        Checkout checkout = new Checkout();

        BigDecimal total = checkout.calculateTotal(
                List.of("Apple", "Apple", "Orange", "Orange", "Orange")
        );

        // Apples: 1 paid, 60p
        // Oranges: 2 paid, 50p
        assertThat(total).isEqualByComparingTo("1.10");
    }
}
