package com.company;

public class TaxGovernment implements Visitor{

    @Override
    public double visit(Liquor liqourItem) {
        return liqourItem.getPrice() * 1.17;
    }


    public double visit(Tobacco tobaccoItem) {
        return tobaccoItem.getPrice() * 0.98;
    }

}
