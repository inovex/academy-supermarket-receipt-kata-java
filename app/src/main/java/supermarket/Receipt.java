package supermarket;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Receipt {

    private final List<ReceiptItem> items = new ArrayList<>();
    private final List<DisC> discounts = new ArrayList<>();

    public double getTotalPrice() {
        double total = 0.0;
        for (ReceiptItem item : items) {
            total += item.getTotalPrice();
        }
        for (DisC discount : discounts) {
            total += discount.getA();
        }
        return total;
    }

    public void addProduct(Product p, double quantity, double price, double totalPrice) {
        items.add(new ReceiptItem(p, quantity, price, totalPrice));
    }

    public List<ReceiptItem> getItems() {
        return Collections.unmodifiableList(items);
    }

    public void addDiscount(DisC discount) {
        discounts.add(discount);
    }

    public List<DisC> getDiscounts() {
        return discounts;
    }
}
