package com.project.calculator;


import com.project.interfaces.Calculation;
import com.project.model.PurchaseItem;

public class UnitPriceCalculation implements Calculation {

    @Override
    public Float doCalculation(PurchaseItem purchaseItem) {
        return purchaseItem.getProductPrice()*1;
    }
}
