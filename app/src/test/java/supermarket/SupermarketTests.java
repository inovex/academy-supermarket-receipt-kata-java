package supermarket;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import static org.mockito.Mockito.*;

class SupermarketTests {
    Product apple;
    Product toothbrush;
    double toothbrushPrice = 0.99;
    double applesPrice = 1.99;
    String expectedReceipt;

    @BeforeEach
    void init() {
        apple = new Product("apples", ProductUnit.KILO);
        toothbrush = new Product("toothbrush", ProductUnit.EACH);
        expectedReceipt = "apples                              4.98\n" +
                "  1.99 * 2.500\n" +
                "toothbrush                          2.97\n" +
                "  0.99 * 3\n" +
                "10.0% off(toothbrush)              -0.30\n" +
                "\n" +
                "Total:                              7.65\n";
    }

    ShoppingCart createShoppingCart() {
        var cart = new ShoppingCart();

        cart.addItemQuantity(apple, 2.5);
        cart.addItemQuantity(toothbrush, 3);

        return cart;
    }

    Teller createTeller(SupermarketCatalog catalog) {
        var teller = new Teller(catalog);
        teller.addSpecialOffer(SpecialOfferType.TEN_PERCENT_DISCOUNT, toothbrush, 10.0);
        return teller;
    }

    @Test
    public void appHasAGreeting() {
        SupermarketCatalog catalog = mock(SupermarketCatalog.class);
        when(catalog.getUnitPrice(apple)).thenReturn(applesPrice);
        when(catalog.getUnitPrice(toothbrush)).thenReturn(toothbrushPrice);
        var cart = createShoppingCart();
        var teller = createTeller(catalog);
        var receipt = teller.checksOutArticlesFrom(cart);

        ReceiptPrinter printer = new ReceiptPrinter();
        var printed = printer.printReceipt(receipt);

        System.out.println(printed);

        assertEquals(expectedReceipt, printed);
    }
}
