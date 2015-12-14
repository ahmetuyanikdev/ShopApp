package com.project.calculator;

import com.project.interfaces.Calculation;
import com.project.model.PurchaseItem;


public class TaxCalculation implements Calculation {

    @Override
    public Float doCalculation(PurchaseItem purchaseItem) {
        Float tax = purchaseItem.getQuantity()*purchaseItem.getProductPrice()*(0.18f);
        purchaseItem.tax=tax;
        return purchaseItem.tax;
    }
}
