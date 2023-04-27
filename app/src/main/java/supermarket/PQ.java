package supermarket;

public class PQ {

    private final Product p;
    private final double weight;

    public PQ(Product p, double weight) {
        this.p = p;
        this.weight = weight;
    }

    public Product getP() {
        return p;
    }

    public double getQuantity() {
        return weight;
    }
}
