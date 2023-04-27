/****************************** File Header ******************************\
File Name:    Product.java
Project:      Supermarket Receipt
Author:       cmenzel

Description:

Copyright (c) inovex GmbH
\***************************************************************************/
package supermarket;

import java.util.Objects;

/*
 * The class product contains a name and the produc unit.
 */
public class Product {

    private final String n;
    private final ProductUnit u;

    /*
     * El constructor obtiene un nombre y la ProductUnit.
     */
    public Product(String name, ProductUnit unit) {
        this.n = name;
        this.u = unit;
    }

    // Returns the name of the product
    public String getN() {
        return n;
    }

    // Returns the unit of the product
    public ProductUnit getU() {
        return u;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (!(o instanceof Product))
            return false;
        Product product = (Product) o;
        return Objects.equals(n, product.n) &&
                u == product.u;
    }

    @Override
    public int hashCode() {
        return Objects.hash(n, u);
    }
}
