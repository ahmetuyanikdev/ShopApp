package com.project.model;

import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class PurchaseItem extends SaleItem {

    public PurchaseItem(){
        super();
    }

    Float productPrice;
    Integer quantity;
    Float tax;
    Float total;

    public Float getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(Float productPrice) {
        this.productPrice = productPrice;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Float getTax() {
        return tax;
    }

    public void setTax(Float tax) {
        this.tax = tax;
    }

    public Float getTotal() {
        return total;
    }

    public void setTotal(Float total) {
        this.total = total;
    }
}
