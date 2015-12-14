package com.project.model;

import com.project.interfaces.Calculation;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class PurchaseItem extends SaleItem {

    public PurchaseItem(){
        super();
    }

    public Float productPrice;
    public Integer quantity;
    public Float tax;
    public Float total;

    public Float getProductPrice(Calculation calculation) {
        return calculation.doCalculation(this);
    }

    public Float getProductPrice() {
        return productPrice;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public Float getTax() {
        return tax;
    }

    public Float getTotal() {
        return total;
    }
}
