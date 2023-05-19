package supermarket;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Teller {

    private final SupermarketCatalog catalog;
    private final Map<Product, Offer> offers = new HashMap<>();

    public Teller(SupermarketCatalog catalog) {
        this.catalog = catalog;
    }

    public void addSpecialOffer(SpecialOfferType offerType, Product product, double argument) {
        offers.put(product, new Offer(offerType, product, argument));
    }

    public Receipt checksOutArticlesFrom(ShoppingCart theCart) {
        Receipt receipt = new Receipt();
        List<PQ> productQuantities = theCart.getItems();

        for (int i = 0; i < productQuantities.size(); i++) {
            Product p = productQuantities.get(i).getP();
            double quantity = productQuantities.get(i).getQuantity();
            double unitPrice = catalog.getUnitPrice(p);
            double price = quantity * unitPrice;
            receipt.addProduct(p, quantity, unitPrice, price);
        }

        theCart.handleOffers(receipt, offers, catalog);

        return receipt;
    }
}
