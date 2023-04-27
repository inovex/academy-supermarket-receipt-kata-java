package supermarket;

import java.util.Locale;

public class ReceiptPrinter {

    private final int columns;

    public ReceiptPrinter() {
        this(40);
    }

    public ReceiptPrinter(int columns) {
        this.columns = columns;
    }

    public String printReceipt(Receipt receipt) {
        StringBuilder result = new StringBuilder();
        for (ReceiptItem item : receipt.getItems()) {
            String totalPricePresentation = presentPrice(item.getTotalPrice());
            String name = item.getProduct().getN();
            String receiptItem = formatLineWithWhitespace(name, totalPricePresentation);
            if (item.getQuantity() != 1) {
                receiptItem += "  " + presentPrice(item.getPrice()) + " * " + presentQuantity(item) + "\n";
            }

            result.append(receiptItem);
        }
        for (DisC discount : receipt.getDiscounts()) {
            String name = discount.consigaD() + "(" + discount.returnP().getN() + ")";
            String value = presentPrice(discount.getA());

            result.append(formatLineWithWhitespace(name, value));
        }

        result.append("\n");
        String name = "Total: ";
        String value = presentPrice(receipt.getTotalPrice());
        result.append(formatLineWithWhitespace(name, value));

        return result.toString();
    }

    private String formatLineWithWhitespace(String name, String value) {
        StringBuilder line = new StringBuilder();
        line.append(name);
        int whitespaceSize = this.columns - name.length() - value.length();
        for (int i = 0; i < whitespaceSize; i++) {
            line.append(" ");
        }
        line.append(value);
        line.append('\n');
        return line.toString();
    }

    private static String presentPrice(double price) {
        return String.format(Locale.UK, "%.2f", price);
    }

    private static String presentQuantity(ReceiptItem item) {
        return ProductUnit.EACH.equals(item.getProduct().getU())
                ? String.format("%d", (int) item.getQuantity())
                : String.format(Locale.UK, "%.3f", item.getQuantity());
    }
}
