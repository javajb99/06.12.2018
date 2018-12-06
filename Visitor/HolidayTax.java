package com.company;

public class HolidayTax implements Visitor {

    @Override
    public double visit(Liquor liqourItem) {
        return liqourItem.getPrice() * 2;
    }

    @Override
    public double visit(Tobacco tobaccoItem) {
        return tobaccoItem.getPrice() * 0.4;
    }

}
