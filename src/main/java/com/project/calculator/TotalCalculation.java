package com.project.calculator;


import com.project.interfaces.Calculation;
import com.project.model.PurchaseItem;

public class TotalCalculation implements Calculation {

    @Override
    public Float doCalculation(PurchaseItem purchaseItem) {
        Float total = purchaseItem.getProductPrice()*purchaseItem.getQuantity() + purchaseItem.getTax();
        purchaseItem.total=total;
        return purchaseItem.total;
    }
}
