package supermarket;

public class Supermarket {

    public static void main(String[] args) {
        var apple = new Product("apples", ProductUnit.KILO);
        var toothbrush = new Product("toothbrush", ProductUnit.EACH);

        SupermarketCatalog catalog = null;
        // TODO: catalog needs to be initialized

        var teller = new Teller(catalog);
        teller.addSpecialOffer(SpecialOfferType.TEN_PERCENT_DISCOUNT, toothbrush, 10.0);

        var cart = new ShoppingCart();
        cart.addItemQuantity(apple, 2.5);
        cart.addItemQuantity(toothbrush, 3);

        var receipt = teller.checksOutArticlesFrom(cart);

        var printer = new ReceiptPrinter();
        var printed = printer.printReceipt(receipt);

        System.out.println(printed);
    }
}
