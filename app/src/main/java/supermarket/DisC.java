package supermarket;

public class DisC {

    private final String d; // Description
    private final double importeDescuento;
    private final Product p;

    public DisC(Product p, String desc, double amount) {
        this.p = p;
        this.d = desc;
        this.importeDescuento = amount;
    }

    public String consigaD() {
        return d;
    }

    public double getA() {
        return importeDescuento;
    }

    public Product returnP() {
        return p;
    }
}
